# Translatable Fools

*“Makes untranslatable Fools translatable.”*

Modifications of Minecraft's April Fools' versions that add missing translation keys for content introduced in these versions.

<details>
<summary>Русское описание</summary>

*«Делает непереводимые шутки переводимыми».*

Модификации первоапрельских версий Minecraft, добавляющие отсутствующие ключи перевода для контента, появившегося в этих версиях.

## Возможности

### Переводы

Проект делает контент первоапрельских версий Minecraft переводимым:

* Добавляет отсутствующие ключи перевода для нового контента.
* Позволяет использовать собственные файлы переводов.
* Исправляет некоторые переводы в соответствии с современным переводом игры.
* Содержит необязательные исправления некоторых известных проблем, связанных с отображением текста.

#### 2.0
* Добавляет ключи перевода для сплэша `APRIL FOOLS!`.
* Добавляет перевод для сообщений в облачках у блоков.

#### 15w14a
* Добавляет ключи перевода для сплэша `Minecraft is love, Minecraft is life`.
* Добавляет ключи перевода для названия создаваемого мира в меню создания мира, меню сброса мира и в файле level.dat мира, видного при загрузки этого мира в другую версию.

### Поддерживаемые версии

* 2.0 Blue
* 2.0 Purple
* 2.0 Red
* 2.0 Preview
* 15w14a

Список поддерживаемых версий будет расширяться по мере добавления новых первоапрельских версий Minecraft.

Не все варианты одной версии 2.0 содержат одинаковый набор изменений, поэтому набор модификаций зависит от конкретного варианта.

## Требования

* Windows
* PowerShell
* **JDK 9 или новее**

Скрипт автоматически скачивает необходимые библиотеки и оригинальные JAR-файлы Minecraft.

## Установка

### 1. Скачайте проект

Скачайте `build.ps1` и папку той версии, которую хотите модифицировать.

Папка `2.0-blue-purple` используется для модификации как **2.0 Blue**, так и **2.0 Purple**.

Для **2.0** также необходимо скачать папку `2.0`, содержащую общие файлы переводов.

Например, для сборки 2.0 Blue нужны:

```text
build.ps1
2.0\lang\
2.0-blue-purple\
```

Для 2.0 Red:

```text
build.ps1
2.0\lang\
2.0-red\
```

Для 15w14a:

```text
build.ps1
15w14a\
```

В будущих версиях структура файлов может отличаться. Если для конкретной версии требуются дополнительные общие файлы, это будет указано в её разделе.

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

Для 2.0 и 15w14a доступно необязательное **исправление выравнивания шрифта MC-23952**.

Оно исправляет выравнивание широких Unicode-символов.

Исправление рекомендуется, если вы используете набор текстур, изменяющий шрифт, например [Minecraft Font (PC)](https://www.curseforge.com/minecraft/texture-packs/minecraft-font-pc).

Если вы используете стандартный шрифт Minecraft или английский язык без набора текстур, изменяющего шрифт, **это исправление вам не нужно**.

Если вместо ввода `Y` просто нажать **Enter**, исправление применено не будет.

Другие версии могут иметь собственные дополнительные исправления.

### 5. Выберите формат результата

Сборщик предоставляет два варианта:

#### `.class`-файлы

Создаёт модифицированные `.class`-файлы и обработанные файлы переводов.

Структура результата зависит от выбранной версии. Например:

```text
build\
└── 2.0-blue\
    ├── bia.class
    ├── bko.class
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

Для **2.0** оригинальные JAR-файлы можно найти на страницах [Java Edition 2.0](https://minecraft.wiki/w/Java_Edition_2.0) и [Java Edition 2.0 (preview)](https://minecraft.wiki/w/Java_Edition_2.0_%28preview%29). Для **15w14a** оригинальные JAR-файлы можно найти на странице [Java Edition 15w14a
](https://minecraft.wiki/w/Java_Edition_15w14a).

Все необходимые ссылки на клиентские и серверные JAR-файлы находятся в инфобоксе в разделе **Downloads** на этих страницах. Также там доступны соответствующие `.json`-файлы.

Откройте оригинальный JAR через WinRAR, 7-Zip или другой архиватор.

Скопируйте созданные `.class`-файлы в JAR с заменой существующих файлов.

Если в результате присутствует директория `lang`, скопируйте её содержимое в директорию `lang/` внутри JAR.

Затем удалите директорию `META-INF` из JAR.

---

### 8. Установите модифицированную версию Minecraft

Добавьте модифицированный JAR в лаунчер как отдельную версию Minecraft.

Для старых версий можно использовать инструкции по ручной установке версий:

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

Для языков, для которых не существует собственного файла перевода в папке версии, сборщик может применять стандартные исправления, необходимые для конкретной версии.

Например, в 2.0 значения следующих ключей заменяются на соответствующие английские названия:

* `options.anaglyph` → `Super HD Graphics`
* `tile.dropper.name` → `Flopper`

В 2.0 эти надписи были переименованы:

* `3D анаглиф` → `Супер HD графика`
* `Выбрасыватель` → `Рыбрасыватель`

Если для языка существует собственный файл перевода в папке версии, вместо стандартных исправлений применяется соответствующий пользовательский языковой патч.

Для старых версий у русского языка добавлен «обновлённый» вариант. В списке языков вы сможете выбрать оригинальный русский язык той версии, с добавленными переводами контента первоапрельской версии, или перевод, основанный на современной русской локализации.

Для 15w14a создаётся набор ресурсов `additional_languages_resourcepack.zip` с дополнительными переводами, для 2.0 эти переводы встроены в .jar-файл.

## Нужно ли модифицировать сервер?
Сервер модифицировать не нужно. Модификация работает полностью со стороны клиента.

## Отказ от ответственности

Большая часть кода `build.ps1` и `README.md` были написаны с помощью ИИ. Возможны ошибки.

Minecraft и его первоапрельские версии являются собственностью Mojang Studios и Microsoft. Этот проект является неофициальной модификацией и не связан с Mojang Studios или Microsoft.

Перевод выполнен обычными игроками Minecraft на платформе [Crowdin](https://ru.crowdin.com/project/translatable-fools), а не профессиональными переводчиками, поэтому может содержать ошибки, неточности и недочёты. Переводы на некоторые языки могут быть идентичны или схожи с переводами из [проекта Minecraft Wiki по переводу первоапрельских версий Minecraft](https://github.com/mc-wiki/mcaf-resourcepack).

</details>

## Features

### Translations

The project makes content introduced in Minecraft's April Fools' versions translatable:

- Adds missing translation keys for new content.
- Allows the use of custom language files.
- Updates some translations to match the modern translation of the game.
- Includes optional fixes for some known text-rendering issues.

#### 2.0

- Adds translation keys for the `APRIL FOOLS!` splash.
- Adds translation support for block speech bubble messages.

#### 15w14a

- Adds translation keys for the `Minecraft is love, Minecraft is life` splash.
- Adds translation keys for the name of the created world in the world creation menu, the world reset menu, and the world's `level.dat` file, where it can be seen when the world is loaded in another version.

### Supported versions

- 2.0 Blue
- 2.0 Purple
- 2.0 Red
- 2.0 Preview
- 15w14a

The list of supported versions will expand as new Minecraft April Fools' versions are added.

Not all variants of a 2.0 version contain the same set of changes, so the set of modifications depends on the specific variant.

## Requirements

- Windows
- PowerShell
- **JDK 9 or newer**

The build script automatically downloads the required libraries and original Minecraft JAR files.

## Installation

### 1. Download the project

Download `build.ps1` and the folder for the version you want to modify.

The `2.0-blue-purple` folder is used to modify both **2.0 Blue** and **2.0 Purple**.

For **2.0**, you also need to download the `2.0` folder, which contains the shared translation files.

For example, to build 2.0 Blue:

```text
build.ps1
2.0\lang\
2.0-blue-purple\
```

For 2.0 Red:

```text
build.ps1
2.0\lang\
2.0-red\
```

For 15w14a:

```text
build.ps1
15w14a\
```

In future versions, the file structure may differ. If a particular version requires additional shared files, this will be specified in its respective section.

Place all required files and folders in the same directory.

### 2. Run the build script

Run `build.ps1` using PowerShell:

**Right-click `build.ps1` → Run with PowerShell**

The script automatically downloads the required dependencies and original Minecraft JAR files.

Downloaded JAR files are verified using their SHA-256 checksums before being used.

### 3. Select the versions

Choose one or more versions you want to modify.

You can also select **All versions** to select all supported variants.

If multiple variants are selected, the corresponding source folders must be present in the project.

### 4. Additional fixes

Some versions may have additional fixes that the build script offers separately.

For 2.0 and 15w14a, the optional **MC-23952 font alignment fix** is available.

It fixes the alignment of wide Unicode characters.

The fix is recommended if you use a font-changing texture pack, such as [Minecraft Font (PC)](https://www.curseforge.com/minecraft/texture-packs/minecraft-font-pc).

If you use the standard Minecraft font or play in English without a font-changing texture pack, **you do not need this fix**.

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
    ├── bia.class
    ├── bko.class
    └── lang\
        ├── languages.txt
        ├── en_US.lang
        ├── en_GB.lang
        └── ...
```

This option is intended for manual installation.

#### Modified `.jar`

Creates a ready-to-use Minecraft JAR containing:

- Modified `.class` files.
- Updated translations.
- New language files.
- Updated language lists.
- Additional fixes, if selected.

The entire `META-INF` directory is removed from the resulting JAR.

### 6. Build the modification

After you select the options, the script will:

1. Download the original Minecraft JAR file.
2. Verify its SHA-256 checksum.
3. Compile the modified Java source files.
4. Apply the translation files.
5. Apply the selected additional fixes.
6. Create the selected output format.

After a successful build, the result will be placed in the `build` directory.

### 7. Install the result

#### Manual installation (`.class` files)

If you selected `.class files`, the `build` directory will contain a folder for each selected variant.

Each folder will contain the modified `.class` files and processed translation files.

Download the corresponding original version of Minecraft.

For **2.0**, the original JAR files can be found on the [Java Edition 2.0](https://minecraft.wiki/w/Java_Edition_2.0) and [Java Edition 2.0 (preview)](https://minecraft.wiki/w/Java_Edition_2.0_%28preview%29) pages. For **15w14a**, the original JAR files can be found on the [Java Edition 15w14a](https://minecraft.wiki/w/Java_Edition_15w14a) page.

All required client and server JAR links are available in the **Downloads** section of the infobox on these pages. The corresponding `.json` files are also available there.

Open the original JAR using WinRAR, 7-Zip, or another archive manager.

Copy the generated `.class` files into the JAR, replacing the existing files.

If the output contains a `lang` directory, copy its contents into the `lang/` directory inside the JAR.

Then remove the `META-INF` directory from the JAR.

### 8. Install the modified version of Minecraft

Add the modified JAR to your launcher as a separate Minecraft version.

For older versions, you can use the following manual installation guides:

- [Minecraft Wiki — Manual version installation](https://minecraft.wiki/w/Tutorial:Installing_a_version#Manual_version_installation)

For example, in Prism Launcher, create an instance of the corresponding version, then open:

**Edit → Version → Replace Minecraft.jar**

Select the JAR created by the build script.

### 9. Build cache

After a successful build, the script will ask whether you want to remove the `.build-deps` directory.

This directory contains downloaded dependencies and original Minecraft JAR files.

It can be safely deleted. If you run the build script again, the required files will be downloaded again.

## Translations

Each supported version may have its own translation changes.

For languages without a custom translation file in the version's folder, the build script may apply standard fixes required for that particular version.

For example, in 2.0, the values of the following keys are replaced with their corresponding English names:

- `options.anaglyph` → `Super HD Graphics`
- `tile.dropper.name` → `Flopper`

In 2.0, these entries were renamed:

- `3D Anaglyph` → `Super HD Graphics`
- `Dropper` → `Flopper`

If a custom translation file exists for a language, the corresponding custom language patch is applied instead of the standard fixes.

For 15w14a, a resource pack `additional_languages_resourcepack.zip` containing additional translations is created. For 2.0, these translations are included directly in the JAR file.

## Do I need to modify the server?

No. The server does not need to be modified. The modification operates entirely on the client side.

## Disclaimer

Most of the `build.ps1` code and `README.md` were written with the assistance of AI. Errors may occur.

Minecraft and its April Fools' versions are the property of Mojang Studios and Microsoft. This project is an unofficial modification and is not affiliated with or endorsed by Mojang Studios or Microsoft.

The translations were contributed by ordinary Minecraft players on [Crowdin](https://ru.crowdin.com/project/translatable-fools), rather than professional translators, and may therefore contain errors, inaccuracies, or other imperfections. Translations into some languages may be identical or similar to those in the [Minecraft Wiki's April Fools' versions translation project](https://github.com/mc-wiki/mcaf-resourcepack).
