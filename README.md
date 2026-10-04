# Translatable Fools

*“Makes untranslatable Fools translatable.”*

Modifications of Minecraft's April Fools' versions that add missing translation keys for content introduced in these versions.

<details>
<summary>Русский перевод</summary>

*«Делает непереводимые шутки переводимыми».*

Модификации первоапрельских версий Minecraft, добавляющие отсутствующие ключи перевода для контента, появившегося в этих версиях.

## Возможности

### Переводы

Проект делает контент первоапрельских версий Minecraft переводимым:

* Добавляет отсутствующие ключи перевода для нового контента.
* Добавляет ключи перевода для сплэшей и других текстовых элементов, где это необходимо.
* Добавляет ключи перевода для сообщений в облачках у блоков в версиях, где они присутствуют.
* Позволяет использовать собственные файлы переводов.
* Исправляет некоторые переводы, связанные с изменениями конкретных первоапрельских версий.
* Содержит необязательные исправления некоторых известных проблем, связанных с отображением текста.

### Поддерживаемые версии

* Minecraft 2.0 Blue
* Minecraft 2.0 Purple
* Minecraft 2.0 Red
* Minecraft 2.0 Preview

Список поддерживаемых версий будет расширяться по мере добавления новых первоапрельских версий Minecraft.

Не все варианты одной версии Minecraft содержат одинаковый набор изменений, поэтому набор модификаций зависит от конкретного варианта.

## Требования

* Windows
* PowerShell
* **JDK 9 или новее**

Скрипт автоматически скачивает необходимые библиотеки и оригинальные JAR-файлы Minecraft.

## Установка

### 1. Скачайте проект

Скачайте `build.ps1` и папку той версии, которую хотите модифицировать.

Для **Minecraft 2.0** также необходимо скачать папку `2.0`, содержащую общие файлы переводов.

Например, для сборки Minecraft 2.0 Blue нужны:

```text
build.ps1
2.0\
2.0-blue-purple\
```

Для Minecraft 2.0 Red:

```text
build.ps1
2.0\
2.0-red\
```

Для Minecraft 2.0 Preview:

```text
build.ps1
2.0\
2.0-preview\
```

Папка `2.0` содержит общие файлы переводов, используемые вариантами Minecraft 2.0.

В будущих версиях Minecraft структура файлов может отличаться. Если для конкретной версии требуются дополнительные общие файлы, это будет указано в её разделе.

Поместите все необходимые файлы и папки в одну директорию.

### 2. Запустите сборщик

Запустите `build.ps1` с помощью PowerShell:

**ПКМ по `build.ps1` → «Выполнить с помощью PowerShell»**

Скрипт автоматически скачает необходимые зависимости и оригинальные JAR-файлы Minecraft.

Перед использованием скачанные JAR-файлы проверяются по контрольной сумме SHA-256.

### 3. Выберите версии

Выберите одну или несколько версий, которые хотите модифицировать.

Также можно выбрать **All versions**, чтобы выбрать все поддерживаемые варианты.

Если выбрано несколько вариантов, соответствующие им папки исходных файлов должны присутствовать в проекте.

### 4. Дополнительные исправления

Некоторые версии могут иметь дополнительные исправления, которые сборщик предлагает применить отдельно.

Для Minecraft 2.0 доступно необязательное **исправление выравнивания шрифта MC-23952**.

Оно исправляет выравнивание широких Unicode-символов.

Исправление рекомендуется, если вы используете набор текстур, изменяющий шрифт, например [Minecraft Font (PC)](https://www.curseforge.com/minecraft/texture-packs/minecraft-font-pc).

Если вы используете стандартный шрифт Minecraft или английский язык без набора текстур, изменяющего шрифт, **это исправление вам не нужно**.

Для Minecraft 2.0 используются следующие классы:

* **2.0 Blue / Purple:** `awz.class`
* **2.0 Red:** `awv.class`
* **2.0 Preview:** `ayb.class`

Если вместо `Y` просто нажать **Enter**, исправление применено не будет.

Другие версии могут иметь собственные дополнительные исправления.

### 5. Выберите формат результата

Сборщик предоставляет два варианта:

#### `.class`-файлы

Создаёт модифицированные `.class`-файлы и обработанные файлы переводов.

Структура результата зависит от выбранной версии. Например:

```text
build\
└── 2.0-blue\
    ├── bko.class
    ├── nm.class
    └── lang\
        ├── languages.txt
        ├── en_US.lang
        ├── ru_RU.lang
        └── ...
```

Этот вариант предназначен для ручной установки.

#### Модифицированный `.jar`

Создаёт готовый JAR Minecraft, содержащий:

* модифицированные `.class`-файлы;
* изменённые переводы;
* новые языковые файлы;
* обновлённые списки языков;
* дополнительные исправления, если они были выбраны.

Из готового JAR полностью удаляется директория `META-INF`.

### 6. Сборка модификации

После выбора параметров скрипт:

1. Скачает оригинальный JAR Minecraft.
2. Проверит его контрольную сумму SHA-256.
3. Скомпилирует изменённые исходные файлы Java.
4. Применит файлы переводов.
5. Применит выбранные дополнительные исправления.
6. Создаст выбранный формат результата.

После успешной сборки результат будет находиться в директории `build`.

### 7. Установите результат

#### Ручная установка (`.class`-файлы)

Если вы выбрали `.class files`, в директории `build` появится папка каждого выбранного варианта.

Внутри неё будут находиться модифицированные `.class`-файлы и обработанные файлы переводов.

Скачайте соответствующую оригинальную версию Minecraft.

Для **Minecraft 2.0** оригинальные JAR-файлы можно найти на страницах [Java Edition 2.0](https://minecraft.wiki/w/Java_Edition_2.0) и [Java Edition 2.0 (preview)](https://minecraft.wiki/w/Java_Edition_2.0_%28preview%29).

Все необходимые ссылки на клиентские и серверные JAR-файлы находятся в инфобоксе в разделе **Downloads** на этих страницах. Также там доступны соответствующие `.json`-файлы.

Откройте оригинальный JAR через WinRAR, 7-Zip или другой архиватор.

Скопируйте созданные `.class`-файлы в JAR с заменой существующих файлов.

Если в результате присутствует директория `lang`, скопируйте её содержимое в директорию `lang/` внутри JAR.

Затем удалите директорию `META-INF` из JAR.

##### Ручная установка переводов

Файлы переводов находятся в общей папке соответствующей версии.

Например, для Minecraft 2.0:

```text
2.0\lang\
```

Скопируйте нужные `.lang`-файлы в директорию `lang/` внутри Minecraft JAR.

Также замените соответствующий файл списка языков, если он присутствует.

Если вам нужны только модифицированные классы и вы не хотите использовать изменения переводов, этот шаг можно пропустить.

---

### 8. Установите модифицированную версию Minecraft

Добавьте модифицированный JAR в лаунчер как отдельную версию Minecraft.

Для старых версий Minecraft можно использовать инструкции по ручной установке версий:

* [Русская Minecraft Wiki — Пошаговая установка](https://ru.minecraft.wiki/w/%D0%A0%D1%83%D0%BA%D0%BE%D0%B2%D0%BE%D0%B4%D1%81%D1%82%D0%B2%D0%BE:%D0%A3%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0_%D0%B2%D0%B5%D1%80%D1%81%D0%B8%D0%B9#%D0%9F%D0%BE%D1%88%D0%B0%D0%B3%D0%BE%D0%B2%D0%B0%D1%8F_%D1%83%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0)
* [Minecraft Wiki — Manual version installation](https://minecraft.wiki/w/Tutorial:Installing_a_version#Manual_version_installation)

Например, в Prism Launcher создайте экземпляр соответствующей версии Minecraft, затем откройте:

**Изменить → Версия → Заменить Minecraft.jar**

Выберите JAR, созданный сборщиком.

### 9. Кэш сборки

После успешной сборки скрипт спросит, хотите ли вы удалить директорию `.build-deps`.

В ней находятся скачанные зависимости и оригинальные JAR-файлы Minecraft.

Её можно безопасно удалить. При следующем запуске сборщика необходимые файлы будут скачаны заново.

## Переводы

Каждая поддерживаемая версия может иметь собственные изменения переводов.

Для языков, для которых не существует собственного файла перевода, сборщик может применять стандартные исправления, необходимые для конкретной версии.

Например, в Minecraft 2.0 значения следующих ключей заменяются на соответствующие английские названия:

* `options.anaglyph` → `Super HD Graphics`
* `tile.dropper.name` → `Flopper`

В Minecraft 2.0 эти надписи были переименованы:

* `Super HD Graphics` — на русском: «Супер HD графика»
* `Flopper` — на русском: «Рыбрасыватель»

Если для языка существует собственный файл перевода, вместо стандартных исправлений применяется соответствующий пользовательский языковой патч.

### Собственные языки

Собственные языковые патчи помещаются в общую папку переводов соответствующей версии.

Например, для Minecraft 2.0:

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

Файл списка языков также может быть заменён или дополнен в соответствии с особенностями конкретной версии.

## Disclaimer

Большая часть кода `build.ps1` и `README.md` была написана с помощью ИИ. Возможны ошибки.

Minecraft и его первоапрельские версии являются собственностью Mojang Studios и Microsoft. Этот проект является неофициальной модификацией и не связан с Mojang Studios или Microsoft.

</details>

## Features

### Translations

The project makes content introduced in Minecraft's April Fools' versions translatable:

* Adds missing translation keys for newly introduced content.
* Adds translation keys for splash texts and other text elements where necessary.
* Adds translation keys for block speech bubbles in versions where they are present.
* Allows the use of custom language patches.
* Fixes translations related to changes introduced in specific April Fools' versions.
* Includes optional fixes for known text-rendering issues.

### Supported versions

* Minecraft 2.0 Blue
* Minecraft 2.0 Purple
* Minecraft 2.0 Red
* Minecraft 2.0 Preview

The list of supported versions will expand as new Minecraft April Fools' versions are added.

Not all variants of a Minecraft version contain the same changes, so the set of modifications depends on the specific variant.

## Requirements

* Windows
* PowerShell
* **JDK 9 or newer**

The build script automatically downloads the required libraries and original Minecraft JARs.

## Installation

### 1. Download the project

Download `build.ps1` and the folder for the Minecraft variant you want to modify.

For **Minecraft 2.0**, you also need to download the `2.0` folder, which contains the shared translation files.

For example, to build Minecraft 2.0 Blue:

```text
build.ps1
2.0\
2.0-blue-purple\
```

For Minecraft 2.0 Red:

```text
build.ps1
2.0\
2.0-red\
```

For Minecraft 2.0 Preview:

```text
build.ps1
2.0\
2.0-preview\
```

The `2.0` folder contains shared translation files used by the different Minecraft 2.0 variants.

In future Minecraft versions, the file structure may differ. If a particular version requires additional shared files, this will be specified in its respective section.

Place all required files and folders in the same directory.

### 2. Run the build script

Run `build.ps1` using PowerShell:

**Right-click `build.ps1` → Run with PowerShell**

The script automatically downloads the required dependencies and original Minecraft JARs.

Before being used, downloaded Minecraft JARs are verified using their SHA-256 checksums.

### 3. Select the versions

Choose one or more versions you want to modify.

You can also select **All versions** to select all supported variants.

If multiple variants are selected, the corresponding source folders must be present in the project.

### 4. Optional fixes

Some versions may have additional fixes that the build script offers separately.

Minecraft 2.0 includes the optional **MC-23952 font alignment fix**.

This fixes the alignment of wide Unicode glyphs.

The fix is recommended if you use a font-changing resource pack, such as [Minecraft Font (PC)](https://www.curseforge.com/minecraft/texture-packs/minecraft-font-pc).

If you use the vanilla Minecraft font or English without a font-changing resource pack, **you do not need this fix**.

For Minecraft 2.0, the fix uses the following classes:

* **2.0 Blue / Purple:** `awz.class`
* **2.0 Red:** `awv.class`
* **2.0 Preview:** `ayb.class`

If you simply press **Enter** instead of entering `Y`, the fix will not be applied.

Other versions may have their own additional fixes.

### 5. Choose the output format

The build script provides two options:

#### `.class` files

Creates the modified `.class` files and processed translation files.

The resulting structure depends on the selected version. For example:

```text
build\
└── 2.0-blue\
    ├── bko.class
    ├── nm.class
    └── lang\
        ├── languages.txt
        ├── en_US.lang
        ├── ru_RU.lang
        └── ...
```

This option is intended for manual installation.

#### Modded `.jar` files

Creates a ready-to-use Minecraft JAR containing:

* the modified `.class` files;
* modified translations;
* newly added language files;
* updated language lists;
* additional fixes, if selected.

The entire `META-INF` directory is removed from the resulting JAR.

### 6. Build the modification

After you select the options, the script will:

1. Download the original Minecraft JAR.
2. Verify its SHA-256 checksum.
3. Compile the modified Java source files.
4. Apply the translation patches.
5. Apply selected additional fixes.
6. Create the selected output format.

After a successful build, the result will be placed in the `build` directory.

### 7. Install the result

#### Manual installation (`.class` files)

If you selected `.class files`, the `build` directory will contain a folder for each selected variant.

The folder will contain the modified `.class` files and processed translation files.

Download the corresponding original Minecraft version.

For **Minecraft 2.0**, the original JAR files can be found on the [Java Edition 2.0](https://minecraft.wiki/w/Java_Edition_2.0) and [Java Edition 2.0 (preview)](https://minecraft.wiki/w/Java_Edition_2.0_%28preview%29) pages.

All required client and server JAR links are available in the **Downloads** section of the infobox on these pages. The corresponding `.json` files are also available there.

Open the original JAR using WinRAR, 7-Zip, or another archive manager.

Copy the generated `.class` files into the JAR and replace the existing files.

If the output contains a `lang` directory, copy its contents into the `lang/` directory inside the JAR.

Then remove the `META-INF` directory from the JAR.

##### Installing translations manually

Translation files are located in the shared version folder.

For example, for Minecraft 2.0:

```text
2.0\lang\
```

Copy the required `.lang` files into the `lang/` directory inside the Minecraft JAR.

Also replace the corresponding language list file, if present.

If you only want the modified classes and do not want to use the translation changes, you can skip this step.

---

### 8. Install the modified Minecraft version

Add the modified JAR to your launcher as a separate Minecraft version.

For older Minecraft versions, see the manual version installation instructions:

* [Minecraft Wiki — Manual version installation](https://minecraft.wiki/w/Tutorial:Installing_a_version#Manual_version_installation)

For example, in Prism Launcher, create an instance of the corresponding Minecraft version, then open:

**Edit → Version → Replace Minecraft.jar**

Select the JAR created by the build script.

### 9. Build cache

After a successful build, the script will ask whether you want to remove the `.build-deps` directory.

This directory contains downloaded dependencies and original Minecraft JARs.

It can be safely deleted. If you run the build script again, the required files will be downloaded again.

## Translations

Each supported version may have its own translation changes.

For languages without a custom translation file, the build script may apply standard fixes required by the specific version.

For example, in Minecraft 2.0, the following keys are replaced with their corresponding English names:

* `options.anaglyph` → `Super HD Graphics`
* `tile.dropper.name` → `Flopper`

In Minecraft 2.0, these entries were renamed to:

* `Super HD Graphics` — Russian: «Супер HD графика»
* `Flopper` — Russian: «Рыбрасыватель»

If a custom translation file exists, the corresponding custom language patch is applied instead of the standard fixes.

### Custom languages

Custom language patches are placed in the shared translation folder for the corresponding version.

For example, for Minecraft 2.0:

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

The language list file can also be replaced or extended according to the requirements of the specific version.

## Disclaimer

Most of the `build.ps1` code and `README.md` was written with the assistance of AI. Errors may occur.

Minecraft and its April Fools' versions are property of Mojang Studios and Microsoft. This project is an unofficial modification and is not affiliated with or endorsed by Mojang Studios or Microsoft.
