# Translatable Fools

*“Makes untranslatable Fools translatable.”*

Modifications of Minecraft's April Fools' versions that add missing translation keys for content introduced in these versions.

<details>
<summary>Русский перевод</summary>

*«Делает непереводимые шутки переводимыми».*

Модификации первоапрельских версий Minecraft, добавляющие отсутствующие ключи перевода для контента, появившегося в этих версиях.

## Возможности

### Minecraft 2.0

* Добавляет ключ перевода для сплэша `APRIL FOOLS!`.
* Добавляет ключи перевода для всех сообщений в облачках у блоков.
* Позволяет использовать собственные файлы переводов.
* Содержит необязательное исправление [MC-23952](https://bugs.mojang.com/browse/MC-23952), исправляющее выравнивание широких Unicode-символов при использовании некоторых наборов текстур со сторонними шрифтами.

### Поддерживаемые версии

* Minecraft 2.0 Blue
* Minecraft 2.0 Purple
* Minecraft 2.0 Red
* Minecraft 2.0 Preview

## Требования

* Windows
* PowerShell
* **JDK 9 или новее**

Скрипт автоматически скачивает необходимые библиотеки LWJGL и оригинальные JAR-файлы Minecraft.

## Установка

### 1. Скачайте проект

Скачайте `build.ps1` и папки, соответствующие версиям, которые хотите модифицировать.

Поместите их все в одну директорию.

Папка `2.0` поддерживает все четыре варианта: **Blue, Purple, Red и Preview**.

### 2. Запустите сборщик

Запустите `build.ps1` с помощью PowerShell:

**ПКМ по `build.ps1` → «Выполнить с помощью PowerShell»**

Скрипт автоматически скачает необходимые зависимости и оригинальные JAR-файлы Minecraft.

Перед использованием скачанные JAR-файлы проверяются по контрольной сумме SHA-256.

### 3. Выберите версии

Выберите одну или несколько версий, которые хотите модифицировать.

Также можно выбрать **All versions**, чтобы выбрать все версии.

### 4. Дополнительное исправление шрифта

Если вы выбрали версию Minecraft 2.0, программа спросит, хотите ли вы применить дополнительное **исправление выравнивания шрифта MC-23952**.

Оно исправляет выравнивание широких Unicode-символов.

Исправление рекомендуется, если вы используете набор текстур, изменяющий шрифт, например [Minecraft Font (PC)](https://www.curseforge.com/minecraft/texture-packs/minecraft-font-pc).

Если вы используете стандартный шрифт Minecraft или английский язык без набора текстур, изменяющего шрифт, **это исправление вам не нужно**.

Используются следующие классы:

* **2.0 Blue / Purple:** `awz.class`
* **2.0 Red:** `awv.class`
* **2.0 Preview:** `ayb.class`

Если вместо `Y` просто нажать **Enter**, исправление применено не будет.

### 5. Выберите формат результата

Сборщик предоставляет два варианта:

#### `.class`-файлы

Создаёт только модифицированные `.class`-файлы.

Этот вариант предназначен для ручной установки.

#### Модифицированный `.jar`

Создаёт готовый JAR Minecraft, содержащий:

* модифицированные `.class`-файлы;
* изменённые переводы;
* новые языковые файлы;
* обновлённый `languages.txt`;
* дополнительное исправление шрифта, если оно было выбрано.

Из готового JAR полностью удаляется директория `META-INF`.

### 6. Сборка модификации

После выбора параметров скрипт:

1. Скачает оригинальный JAR Minecraft.
2. Проверит его контрольную сумму SHA-256.
3. Скомпилирует изменённые исходные файлы Java.
4. Применит файлы переводов.
5. Создаст выбранный формат результата.

После успешной сборки результат будет находиться в директории `build`.

### 7. Установите результат

#### Ручная установка (`.class`-файлы)

Если вы выбрали `.class files`, в директории `build` появится папка каждой выбранной версии.

Внутри неё будут находиться модифицированные `.class`-файлы.

Скачайте соответствующую оригинальную версию Minecraft:

* [Minecraft 2.0 Blue / Purple / Red](https://minecraft.wiki/w/Java_Edition_2.0)
* [Minecraft 2.0 Preview](https://minecraft.wiki/w/Java_Edition_2.0_%28preview%29)

Оригинальные JAR-файлы находятся в разделе **Downloads** на соответствующих страницах Minecraft Wiki.

Откройте оригинальный JAR через WinRAR, 7-Zip или другой архиватор.

Скопируйте созданные `.class`-файлы в JAR с заменой существующих файлов.

Затем удалите директорию `META-INF` из JAR.

##### Ручная установка переводов

Файлы переводов находятся в директории проекта:

```text
2.0\lang\
```

Скопируйте нужные `.lang`-файлы в директорию `lang/` внутри Minecraft JAR.

Также замените `lang/languages.txt` на файл из:

```text
2.0\lang\languages.txt
```

Если вам нужны только модифицированные классы и вы не хотите использовать изменения переводов, этот шаг можно пропустить.

#### Автоматическая установка (`.jar`-файлы)

Если вы выбрали **Modded `.jar files`**, скрипт создаст готовый JAR по пути:

```text
build\<версия>\<версия>-moded.jar
```

Например:

```text
build\2.0-blue\2.0-blue-moded.jar
```

В готовый JAR уже включены модифицированные классы, переводы и дополнительное исправление шрифта, если оно было выбрано.

Директория `META-INF` автоматически удаляется.

### 8. Установите модифицированную версию Minecraft

Добавьте модифицированный JAR в лаунчер как отдельную версию Minecraft.

Подробнее:

* [Minecraft Wiki — Установка версий Minecraft](https://ru.minecraft.wiki/w/Руководство:Установка_версий#Пошаговая_установка)
* [Minecraft Wiki — Manual version installation](https://minecraft.wiki/w/Tutorial:Installing_a_version#Manual_version_installation)

Например, в Prism Launcher создайте новый экземпляр Minecraft 1.5.1, затем откройте:

**Изменить → Версия → Заменить Minecraft.jar**

Выберите JAR, созданный сборщиком.

### 9. Кэш сборки

После успешной сборки скрипт спросит, хотите ли вы удалить директорию `.build-deps`.

В ней находятся скачанные зависимости и оригинальные JAR-файлы Minecraft.

Её можно безопасно удалить. При следующем запуске сборщика необходимые файлы будут скачаны заново.

## Переводы

Для языков, для которых не существует собственного файла перевода, модификация удаляет переопределения `options.anaglyph` и `tile.dropper.name`, благодаря чему эти надписи отображаются так же, как в английской локализации.

В Minecraft 2.0 эти надписи были переименованы в:

* `Super HD Graphics` — на русском: «Супер HD графика»
* `Flopper` — на русском: «Рыбрасыватель»

### Собственные языки

Собственные языковые патчи можно помещать в:

```text
2.0\lang\
```

Каждый `.lang`-файл соответствует языковому файлу внутри Minecraft JAR.

Например:

```text
2.0\lang\ru_RU.lang
2.0\lang\en_US.lang
```

Скрипт автоматически применяет эти патчи к соответствующим языковым файлам.

Таким способом также можно добавлять новые языковые файлы, которых не было в оригинальном JAR.

Файл:

```text
2.0\lang\languages.txt
```

всегда добавляется в готовый JAR.

## Отказ от ответственности

Большая часть кода `build.ps1` была написана с помощью ИИ. Возможны ошибки.

Minecraft и его первоапрельские версии являются собственностью Mojang Studios и Microsoft. Этот проект является неофициальной модификацией и не связан с Mojang Studios или Microsoft.

</details>

## Features

### Minecraft 2.0

* Adds a translation key for the `APRIL FOOLS!` splash text.
* Adds translation keys for all block speech bubbles.
* Allows the use of custom language patches.
* Includes an optional fix for [MC-23952](https://bugs.mojang.com/browse/MC-23952), which fixes the alignment of wide Unicode glyphs when using certain font texture packs.

### Supported versions

* Minecraft 2.0 Blue
* Minecraft 2.0 Purple
* Minecraft 2.0 Red
* Minecraft 2.0 Preview

## Requirements

* Windows
* PowerShell
* **JDK 9 or newer**

The build script automatically downloads the required LWJGL libraries and original Minecraft JARs.

## Installation

### 1. Download the project

Download `build.ps1` and the folders corresponding to the versions you want to modify.

Place them all in the same directory.

The `2.0` folder supports all four variants: **Blue, Purple, Red, and Preview**.

### 2. Run the build script

Run `build.ps1` using PowerShell:

**Right-click `build.ps1` → Run with PowerShell**

The script automatically downloads the required dependencies and original Minecraft JARs.

Before being used, downloaded Minecraft JARs are verified using their SHA-256 checksums.

### 3. Select the versions

Choose one or more versions you want to modify.

You can also select **All versions** to select every supported version.

### 4. Optional font fix

If you selected a Minecraft 2.0 version, the script will ask whether you want to apply the optional **MC-23952 font alignment fix**.

This fixes the alignment of wide Unicode glyphs.

The fix is recommended if you use a font-changing resource pack, such as [Minecraft Font (PC)](https://www.curseforge.com/minecraft/texture-packs/minecraft-font-pc).

If you use the vanilla Minecraft font or English without a font-changing resource pack, **you do not need this fix**.

The fix uses the following classes:

* **2.0 Blue / Purple:** `awz.class`
* **2.0 Red:** `awv.class`
* **2.0 Preview:** `ayb.class`

If you simply press **Enter** instead of entering `Y`, the fix will not be applied.

### 5. Choose the output format

The build script provides two options:

#### `.class` files

Creates only the modified `.class` files.

This option is intended for manual installation.

#### Modded `.jar` files

Creates a ready-to-use Minecraft JAR containing:

* the modified `.class` files;
* modified translations;
* newly added language files;
* the updated `languages.txt`;
* the optional font fix, if selected.

The entire `META-INF` directory is removed from the resulting JAR.

### 6. Build the modification

After you select the options, the script will:

1. Download the original Minecraft JAR.
2. Verify its SHA-256 checksum.
3. Compile the modified Java source files.
4. Apply the translation patches.
5. Create the selected output format.

After a successful build, the result will be placed in the `build` directory.

### 7. Install the result

#### Manual installation (`.class` files)

If you selected `.class files`, the `build` directory will contain a folder for each selected version.

The folder will contain the modified `.class` files.

Download the corresponding original Minecraft version:

* [Minecraft 2.0 Blue / Purple / Red](https://minecraft.wiki/w/Java_Edition_2.0)
* [Minecraft 2.0 Preview](https://minecraft.wiki/w/Java_Edition_2.0_%28preview%29)

The original JAR files can be found in the **Downloads** section of the corresponding Minecraft Wiki page.

Open the original JAR using WinRAR, 7-Zip, or another archive manager.

Copy the generated `.class` files into the JAR and replace the existing files.

Then remove the `META-INF` directory from the JAR.

##### Installing translations manually

Translation files are located in the project's:

```text
2.0\lang\
```

Copy the required `.lang` files into the `lang/` directory inside the Minecraft JAR.

Also replace `lang/languages.txt` with:

```text
2.0\lang\languages.txt
```

If you only want the modified classes and do not want to use the translation changes, you can skip this step.

#### Automatic installation (`.jar` files)

If you selected **Modded `.jar files`**, the script creates a ready-to-use JAR at:

```text
build\<version>\<version>-moded.jar
```

For example:

```text
build\2.0-blue\2.0-blue-moded.jar
```

The resulting JAR already contains the modified classes, translation patches, and the optional font fix, if selected.

The `META-INF` directory is removed automatically.

### 8. Install the modified Minecraft version

Add the modified JAR to your launcher as a separate Minecraft version.

See the installation guides:

* [Minecraft Wiki — Installing Minecraft versions (Russian)](https://ru.minecraft.wiki/w/Руководство:Установка_версий#Пошаговая_установка)
* [Minecraft Wiki — Manual version installation](https://minecraft.wiki/w/Tutorial:Installing_a_version#Manual_version_installation)

For example, in Prism Launcher, create a new Minecraft 1.5.1 instance, then open:

**Edit → Version → Replace Minecraft.jar**

Select the JAR created by the build script.

### 9. Build cache

After a successful build, the script will ask whether you want to remove the `.build-deps` directory.

This directory contains downloaded dependencies and original Minecraft JARs.

It can be safely deleted. If you run the build script again, the required files will be downloaded again.

## Translations

For languages without a custom translation patch, the modification removes the `options.anaglyph` and `tile.dropper.name` overrides so that these entries are displayed the same way as in the English localization.

In Minecraft 2.0, these entries were renamed to:

* `Super HD Graphics` — Russian: «Супер HD графика»
* `Flopper` — Russian: «Рыбрасыватель»

### Custom languages

Custom language patches can be placed in:

```text
2.0\lang\
```

Each `.lang` file corresponds to a language file inside the Minecraft JAR.

For example:

```text
2.0\lang\ru_RU.lang
2.0\lang\en_US.lang
```

The build script automatically applies these patches to the corresponding language files.

New language files that do not exist in the original JAR can also be added this way.

The file:

```text
2.0\lang\languages.txt
```

is always added to the resulting JAR.

## Disclaimer

Most of the `build.ps1` code was written with the assistance of AI. Errors may occur.

Minecraft and its April Fools' versions are property of Mojang Studios and Microsoft. This project is an unofficial modification and is not affiliated with or endorsed by Mojang Studios or Microsoft.
