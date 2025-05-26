package com.dimensionred.glintbegone;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class GlintBegoneClient implements ClientModInitializer {

    public static final String MOD_ID = "glintbegone";
    public static GlintBegoneConfig CONFIG;

    @Override
    public void onInitializeClient() {
        AutoConfig.register(GlintBegoneConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(GlintBegoneConfig.class).getConfig();

        ModelPredicateProviderRegistry.register(new Identifier(MOD_ID, "no_glint"),
                (stack, world, entity, seed) -> CONFIG.disabledItems.stream().anyMatch(item -> item.matches(stack)) ? 1.0F : 0.0F);
    }
}
