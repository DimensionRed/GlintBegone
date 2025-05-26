# ✨ Glint Begone

![](https://img.shields.io/badge/Mod%20Loader-Fabric-blue?style=for-the-badge)
![](https://img.shields.io/badge/Env-Client-green?style=for-the-badge)
[![Curseforge Page](https://img.shields.io/badge/Curseforge-Page-orange?style=for-the-badge&logo=curseforge)](https://www.curseforge.com/minecraft/mc-mods/foul-service)
[![Modrinth Page](https://img.shields.io/badge/Modrinth-Page-1bd96a?style=for-the-badge&logo=modrinth)](https://modrinth.com/project/foul-service)
[![Github](https://img.shields.io/badge/GitHub-Repository-blue?style=for-the-badge&logo=github)](https://github.com/DimensionRed/FoulService)
[![Minecraft Inside](https://img.shields.io/badge/Minecraft--Inside-Page-violet?style=for-the-badge)](https://minecraft-inside.ru/mods/181530-fouls-service.html)

---

## 🌐 Languages:
- [English](https://github.com/DimensionRed/GlintBegone/blob/master/README.md)
- [Русский](https://github.com/DimensionRed/GlintBegone/blob/master/lang/README_ru.md)

---

## 📦 Description
Ever wanted to remove the **enchanted glint** from items? Especially when they **don't even have** any enchantments?
**Glint Begone** is here to wipe that visual noise off your screen.

### 🔧 How it works:
In the config file, you can list item IDs (with optional NBT) for which the glint will be removed.
Use [ModMenu](https://modrinth.com/mod/modmenu) for an easier interface.


### 📊 Examples:

| Config                                                                         | In-game Item	 | Result                                                                 |
|--------------------------------------------------------------------------------|----------------|------------------------------------------------------------------------|
| `ID: "minecraft:written_book"`<br>`NBT: ` _(empty)_                            | Any written book	 | Glint removed from **all** written books                               |
| `ID: "minecraft:written_book"`<br>`NBT: {display:{Name:'{"text":"Memoirs"}'}}` | Book titled "Memoirs"	 | Glint removed **only** from written books titled "Memoirs", not others |

---

### ⚙️ Sample config:

```json
{
  "disabledItems": [
    {
      "itemId": "minecraft:written_book",
      "nbt": "{display:{Name:'{\"text\":\"Мемуары\"}'}}"
    }
  ]
}

```

### Requirements
- [Cloth Config API](https://modrinth.com/mod/cloth-config)