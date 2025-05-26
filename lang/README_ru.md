# ✨ Glint Begone

![](https://img.shields.io/badge/Mod%20Loader-Fabric-blue?style=for-the-badge)
![](https://img.shields.io/badge/Env-Client-green?style=for-the-badge)
[![Curseforge Page](https://img.shields.io/badge/Curseforge-Page-orange?style=for-the-badge&logo=curseforge)](https://www.curseforge.com/minecraft/mc-mods/foul-service)
[![Modrinth Page](https://img.shields.io/badge/Modrinth-Page-1bd96a?style=for-the-badge&logo=modrinth)](https://modrinth.com/project/foul-service)
[![Github](https://img.shields.io/badge/GitHub-Repository-blue?style=for-the-badge&logo=github)](https://github.com/DimensionRed/FoulService)
[![Minecraft Inside](https://img.shields.io/badge/Minecraft--Inside-Page-violet?style=for-the-badge)](https://minecraft-inside.ru/mods/181530-fouls-service.html)

---

## 🌐 Языки:
- [English](https://github.com/DimensionRed/GlintBegone/blob/master/README.md)
- [Русский](https://github.com/DimensionRed/GlintBegone/blob/master/lang/README_ru.md)

---

## 📦 Описание
У вас когда-нибудь появлялось желание избавиться от **эффекта чар** на предметах? Особенно на тех, на которых есть этот эффект, но **нет чар** как таковых. 
**Glint Begone** призван избавить вас от этого визуального мусора.

### 🔧 Принцип работы:
Мод позволяет убирать эффект чар с предметов:
- По `itemId`
- Или по `itemId` **вместе с NBT**

Рекомендуется установить [ModMenu](https://modrinth.com/mod/modmenu) для удобной настройки конфигурации во время игры.

### 📊 Примеры:

| Промпт конфигурации | Предмет в игре | Результат |
|--------------------|----------------|-----------|
| `ID: "minecraft:written_book"`<br>`NBT: ` _(пусто)_ | Завершённая книга | Свечение убрано со **всех** завершённых книг |
| `ID: "minecraft:written_book"`<br>`NBT: {display:{Name:'{"text":"Мемуары"}'}}` | Завершённая книга с названием "Мемуары" | Свечение убрано **только** с книг "Мемуары", остальные не тронуты |

---

### ⚙️ Пример текстового конфига:

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

### Требования
- [Cloth Config API](https://modrinth.com/mod/cloth-config)
