package com.dimensionred.glintbegone;

import com.google.gson.*;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.StringNbtReader;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ItemWithNbt {
    public String itemId;
    public String nbt;

    public boolean matches(ItemStack stack) {
        // Проверка соответствия предмета
        Item item = Registry.ITEM.get(new Identifier(itemId));
        if (stack.getItem() != item) return false;

        // Если NBT не указан в конфиге - подходит любой предмет
        if (nbt == null || nbt.isEmpty()) return true;

        try {
            NbtCompound targetNbt = StringNbtReader.parse(nbt);
            NbtCompound actualNbt = stack.getNbt();

            // Если у предмета нет NBT - не подходит
            if (actualNbt == null) return false;

            // Проверка частичного совпадения NBT
            return containsAllNbt(targetNbt, actualNbt);
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean containsAllNbt(NbtCompound target, NbtCompound actual) {
        for (String key : target.getKeys()) {
            NbtElement targetElement = target.get(key);
            NbtElement actualElement = actual.get(key);

            // Рекурсивная проверка элементов
            if (!elementContains(targetElement, actualElement)) {
                return false;
            }
        }
        return true;
    }

    private static boolean elementContains(NbtElement target, NbtElement actual) {
        if (target.getType() != actual.getType()) return false;

        if (target instanceof NbtCompound) {
            return containsAllNbt((NbtCompound) target, (NbtCompound) actual);
        }
        else if (target instanceof NbtList) {
            return listContains((NbtList) target, (NbtList) actual);
        }
        else {
            return target.equals(actual);
        }
    }

    private static boolean listContains(NbtList targetList, NbtList actualList) {
        // Создаем копию списка для модификации
        List<NbtElement> actualElements = new ArrayList<>(actualList.size());
        for (NbtElement element : actualList) {
            actualElements.add(element);
        }

        // Проверяем все элементы целевого списка
        for (NbtElement targetElement : targetList) {
            boolean found = false;
            Iterator<NbtElement> iterator = actualElements.iterator();

            while (iterator.hasNext()) {
                NbtElement actualElement = iterator.next();
                if (elementContains(targetElement, actualElement)) {
                    iterator.remove();
                    found = true;
                    break;
                }
            }

            if (!found) return false;
        }
        return true;
    }
}
