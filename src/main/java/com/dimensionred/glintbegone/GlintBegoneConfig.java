package com.dimensionred.glintbegone;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import java.util.ArrayList;
import java.util.List;

@Config(name = "glintbegone")
public class GlintBegoneConfig implements ConfigData {
    public List<ItemWithNbt> disabledItems = new ArrayList<>();
}
