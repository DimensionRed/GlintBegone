package com.dimensionred.glintbegone;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.StringNbtReader;

import java.util.List;


public class NbtTagMatcher {
    public static boolean matchesAnyNbtTag(ItemStack stack, List<String> tagStrings) {
        if (stack.getNbt() == null) return false;

        for (String tagString : tagStrings) {
            try {
                NbtCompound matchTag = StringNbtReader.parse(tagString);
                if (containsAll(matchTag, stack.getNbt())) {
                    return true;
                }
            } catch (Exception e) {
                System.err.println("[GlintBeGone] Invalid NBT tag in config: " + tagString);
            }
        }

        return false;
    }

    private static boolean containsAll(NbtCompound expected, NbtCompound actual) {
        for (String key : expected.getKeys()) {
            if (!actual.contains(key)) return false;

            NbtElement expectedElement = expected.get(key);
            NbtElement actualElement = actual.get(key);

            if (!elementsMatch(expectedElement, actualElement)) return false;
        }

        return true;
    }

    private static boolean elementsMatch(NbtElement a, NbtElement b) {
        if (a.getType() != b.getType()) return false;

        if (a instanceof NbtCompound) {
            return containsAll((NbtCompound) a, (NbtCompound) b);
        } else if (a instanceof NbtList) {
            return listContains((NbtList) a, (NbtList) b);
        } else {
            return a.equals(b);
        }
    }

    private static boolean listContains(NbtList expected, NbtList actual) {
        for (NbtElement e : expected) {
            boolean found = false;
            for (NbtElement a : actual) {
                if (elementsMatch(e, a)) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}
