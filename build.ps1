$ErrorActionPreference = "Stop"

trap {
    Write-Host ""
    Write-Host "============================================================" -ForegroundColor Red
    Write-Host "UNHANDLED ERROR" -ForegroundColor Red
    Write-Host "============================================================" -ForegroundColor Red
    Write-Host ""
    Write-Host $_ -ForegroundColor Red
    Write-Host ""
    Read-Host "Press Enter to close"
    exit 1
}

# ============================================================
# Translatable Fools - build script
# ============================================================

$Root = Split-Path -Parent $MyInvocation.MyCommand.Path
$BuildDir = Join-Path $Root "build"
$DepsDir = Join-Path $Root ".build-deps"

Add-Type -AssemblyName System.IO.Compression
Add-Type -AssemblyName System.IO.Compression.FileSystem

$JavaJar = "https://libraries.minecraft.net/org/lwjgl/lwjgl/lwjgl/2.9.4-nightly-20150209/lwjgl-2.9.4-nightly-20150209.jar"
$JavaUtilJar = "https://libraries.minecraft.net/org/lwjgl/lwjgl/lwjgl_util/2.9.4-nightly-20150209/lwjgl_util-2.9.4-nightly-20150209.jar"

$LwjglJar = Join-Path $DepsDir "lwjgl-2.9.4-nightly-20150209.jar"
$LwjglUtilJar = Join-Path $DepsDir "lwjgl_util-2.9.4-nightly-20150209.jar"

$CommonsLangJarUrl = "https://libraries.minecraft.net/org/apache/commons/commons-lang3/3.3.2/commons-lang3-3.3.2.jar"
$CommonsLangJar = Join-Path $DepsDir "commons-lang3-3.3.2.jar"

$GuavaJarUrl = "https://libraries.minecraft.net/com/google/guava/guava/17.0/guava-17.0.jar"
$GuavaJar = Join-Path $DepsDir "guava-17.0.jar"

$CommonsIoJarUrl = "https://libraries.minecraft.net/commons-io/commons-io/2.4/commons-io-2.4.jar"
$CommonsIoJar = Join-Path $DepsDir "commons-io-2.4.jar"

$Log4jApiJarUrl = "https://libraries.minecraft.net/org/apache/logging/log4j/log4j-api/2.0-beta9/log4j-api-2.0-beta9.jar"
$Log4jApiJar = Join-Path $DepsDir "log4j-api-2.0-beta9.jar"

$Log4jCoreJarUrl = "https://libraries.minecraft.net/org/apache/logging/log4j/log4j-core/2.0-beta9/log4j-core-2.0-beta9.jar"
$Log4jCoreJar = Join-Path $DepsDir "log4j-core-2.0-beta9.jar"

# ============================================================
# 15w14a language source
# ============================================================

$15w14aLanguageListUrl = "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/15w14a/assets/minecraft/lang/_list.json"
$15w14aLanguageBaseUrl = "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/15w14a/assets/minecraft/lang"

$15w14aLanguageCache = Join-Path $DepsDir "15w14a-lang"

# ============================================================
# Version configuration
# ============================================================

$Versions = @(

    @{
        DisplayName = "2.0 Blue"
        Id          = "2.0-blue"
        JarName     = "2.0-blue.jar"

        TranslationDir     = "2.0\lang"
        TranslationJarPath = "lang"

        HasLanguagesFile = $true
        ExternalLanguageSource = $false

        Sources = @(
            "2.0-blue-purple\bko.java"
            "2.0-blue-purple\bia.java"
        )

        Classes = @(
            "bko.class"
            "bia.class"
        )

        FontFixSource = "2.0-blue-purple\awz.java"
        FontFixClass  = "awz.class"

        Sha256 = "1A8ECA28EFA9B58F5546FD66A5B3BBBBF61F7F1ECB0730B29706217D8AAF0BD9"

        Url = "https://vault.omniarchive.uk/archive/java/client-april-fools/2.0-blue.jar"
    }

    @{
        DisplayName = "2.0 Purple"
        Id          = "2.0-purple"
        JarName     = "2.0-purple.jar"

        TranslationDir     = "2.0\lang"
        TranslationJarPath = "lang"

        HasLanguagesFile = $true
        ExternalLanguageSource = $false

        Sources = @(
            "2.0-blue-purple\bko.java"
            "2.0-blue-purple\bia.java"
        )

        Classes = @(
            "bko.class"
            "bia.class"
        )

        FontFixSource = "2.0-blue-purple\awz.java"
        FontFixClass  = "awz.class"

        Sha256 = "1184BA5E91D2742B89108428778F8590A61704339CF07B4ED84C84CF67D674E3"

        Url = "https://vault.omniarchive.uk/archive/java/client-april-fools/2.0-purple.jar"
    }

    @{
        DisplayName = "2.0 Red"
        Id          = "2.0-red"
        JarName     = "2.0-red.jar"

        TranslationDir     = "2.0\lang"
        TranslationJarPath = "lang"

        HasLanguagesFile = $true
        ExternalLanguageSource = $false

        Sources = @(
            "2.0-red\bkg.java"
        )

        Classes = @(
            "bkg.class"
        )

        FontFixSource = "2.0-red\awv.java"
        FontFixClass  = "awv.class"

        Sha256 = "333A54B6250138D837E17CB049633EFC0D55DE6EDFCCF131D55DEF3F0FCB10D3"

        Url = "https://vault.omniarchive.uk/archive/java/client-april-fools/2.0-red.jar"
    }

    @{
        DisplayName = "2.0 Preview"
        Id          = "2.0-preview"
        JarName     = "2.0-preview.jar"

        TranslationDir     = "2.0\lang"
        TranslationJarPath = "lang"

        HasLanguagesFile = $true
        ExternalLanguageSource = $false

        Sources = @(
            "2.0-preview\bma.java"
        )

        Classes = @(
            "bma.class"
        )

        FontFixSource = "2.0-preview\ayb.java"
        FontFixClass  = "ayb.class"

        Sha256 = "555D0F7A887964CA34676825AB76D0CBA69E52FDA9BACEA0FEBA7921EABD22CB"

        Url = "https://vault.omniarchive.uk/archive/java/client-april-fools/2.0-preview.jar"
    }

    @{
        DisplayName = "15w14a"
        Id          = "15w14a"
        JarName     = "15w14a.jar"

        TranslationDir     = "15w14a\lang"
        TranslationJarPath = "assets/minecraft/lang"

        HasLanguagesFile = $false
        ExternalLanguageSource = $true

        Sources = @(
            "15w14a\axe.java"
            "15w14a\aye.java"
        )

        Classes = @(
            "axe.class"
            "aye.class"
        )

        Sha256 = "82F24F74D7649F0D0E82CC1AB31079C4D5996E6330A9F7B1CF91EEC9EC77522E"

        Url = "https://piston-data.mojang.com/v1/objects/1bea9340956b96f2b5452aa576e0cf460990efc6/client.jar"
    }

)

# ============================================================
# Version selection
# ============================================================

Write-Host ""
Write-Host "========================================"
Write-Host " Minecraft April Fools Builder"
Write-Host "========================================"
Write-Host ""

for ($i = 0; $i -lt $Versions.Count; $i++) {
    Write-Host "[$($i + 1)] $($Versions[$i].DisplayName)"
}

$AllOption = $Versions.Count + 1

Write-Host "[$AllOption] All versions"
Write-Host ""

$Selection = Read-Host "Select version(s)"

if ($Selection.Trim() -eq $AllOption.ToString()) {

    $SelectedVersions = $Versions

}
else {

    $Numbers = @(
        $Selection -split "," |
        ForEach-Object { $_.Trim() } |
        Where-Object { $_ -ne "" }
    )

    if ($Numbers.Count -eq 0) {
        throw "No version selected."
    }

    $SelectedVersions = @()

    foreach ($Number in $Numbers) {

        $Index = 0

        if (-not [int]::TryParse($Number, [ref]$Index)) {
            throw "Invalid version number: $Number"
        }

        if ($Index -lt 1 -or $Index -gt $Versions.Count) {
            throw "Invalid version number: $Number"
        }

        $SelectedVersions += $Versions[$Index - 1]
    }

    $SelectedVersions = @(
        $SelectedVersions |
        Group-Object Id |
        ForEach-Object { $_.Group[0] }
    )
}

Write-Host ""
Write-Host "Selected versions:"

foreach ($Version in $SelectedVersions) {
    Write-Host "  - $($Version.DisplayName)"
}

# ============================================================
# 2.0 font centering fix
# ============================================================

$Has2Point0 = @(
    $SelectedVersions |
    Where-Object {
        $_.DisplayName -like "2.0 *"
    }
).Count -gt 0

$UseFontFix = $false

if ($Has2Point0) {

    Write-Host ""
    Write-Host "Optional fix for Minecraft 2.0:"
    Write-Host "MC-23952 - fixes wide Unicode glyph alignment."
    Write-Host ""
    Write-Host "This fix is only needed if you use a font texture pack."
    Write-Host "If you use English or the vanilla Minecraft font, you do NOT need this fix."
    Write-Host ""
    Write-Host "This will use:"
    Write-Host "  2.0 Blue/Purple  -> awz.class"
    Write-Host "  2.0 Red          -> awv.class"
    Write-Host "  2.0 Preview      -> ayb.class"
    Write-Host ""

    $FontFixChoice = Read-Host "Apply the MC-23952 font alignment fix? [Y/N]"

    if ($FontFixChoice -match "^[Yy12]$") {

        $UseFontFix = $true
        Write-Host "MC-23952 font alignment fix: ENABLED"

    }
    else {

        $UseFontFix = $false
        Write-Host "MC-23952 font alignment fix: DISABLED"
    }
}

# ============================================================
# Output format selection
# ============================================================

Write-Host ""
Write-Host "Output format:"
Write-Host "[1] .class files"
Write-Host "[2] Modded .jar files"
Write-Host ""

$OutputChoice = Read-Host "Select output format"

if ($OutputChoice -eq "1") {

    $OutputFormat = "classes"

}
elseif ($OutputChoice -eq "2") {

    $OutputFormat = "jar"

}
else {

    throw "Invalid output format."
}

Write-Host ""
Write-Host "Selected output format: $OutputFormat"

# ============================================================
# Find Java
# ============================================================

function Find-Java {

    if ($env:JAVA_HOME) {

        $javac = Join-Path $env:JAVA_HOME "bin\javac.exe"

        if (Test-Path $javac) {
            return $javac
        }
    }

    $Command = Get-Command javac.exe -ErrorAction SilentlyContinue

    if ($Command) {

        $Candidate = $Command.Source

        if (Test-Path (Join-Path (Split-Path $Candidate -Parent) "jar.exe")) {
            return $Candidate
        }
    }

    $Candidates = @(

        "D:\Program Files\Java\jdk-26.0.1\bin\javac.exe"
        "D:\Program Files\Java\jdk-25\bin\javac.exe"

        "C:\Program Files\Java\jdk-26.0.1\bin\javac.exe"
        "C:\Program Files\Java\jdk-26\bin\javac.exe"
        "C:\Program Files\Java\jdk-25\bin\javac.exe"
        "C:\Program Files\Java\jdk-24\bin\javac.exe"
        "C:\Program Files\Java\jdk-23\bin\javac.exe"
        "C:\Program Files\Java\jdk-22\bin\javac.exe"
        "C:\Program Files\Java\jdk-21\bin\javac.exe"
        "C:\Program Files\Java\jdk-17\bin\javac.exe"
        "C:\Program Files\Java\jdk-11\bin\javac.exe"

        "D:\Program Files\Java\jdk-26\bin\javac.exe"
        "D:\Program Files\Java\jdk-24\bin\javac.exe"
        "D:\Program Files\Java\jdk-23\bin\javac.exe"
        "D:\Program Files\Java\jdk-22\bin\javac.exe"
        "D:\Program Files\Java\jdk-21\bin\javac.exe"
        "D:\Program Files\Java\jdk-17\bin\javac.exe"
        "D:\Program Files\Java\jdk-11\bin\javac.exe"

    )

    foreach ($Candidate in $Candidates) {

        if (Test-Path $Candidate) {

            $CandidateDir = Split-Path $Candidate -Parent
            $JarTool = Join-Path $CandidateDir "jar.exe"

            if (Test-Path $JarTool) {
                return $Candidate
            }
        }
    }

    throw "A complete JDK with javac.exe and jar.exe was not found."
}

$Javac = Find-Java

$JavaBin = Split-Path $Javac -Parent
$JarTool = Join-Path $JavaBin "jar.exe"

Write-Host ""
Write-Host "Java compiler: $Javac"

& $Javac -version

if ($LASTEXITCODE -ne 0) {
    throw "Failed to run javac."
}

# ============================================================
# Prepare directories
# ============================================================

New-Item -ItemType Directory -Force -Path $BuildDir | Out-Null
New-Item -ItemType Directory -Force -Path $DepsDir | Out-Null

# ============================================================
# Download helper
# ============================================================

function Download-File {

    param(
        [string]$Url,
        [string]$Destination
    )

    if (Test-Path $Destination) {

        Write-Host "Already downloaded: $(Split-Path $Destination -Leaf)"
        return
    }

    Write-Host "Downloading: $Url"

    Invoke-WebRequest `
        -Uri $Url `
        -OutFile $Destination `
        -UseBasicParsing
}

# ============================================================
# Download libraries
# ============================================================

Download-File $JavaJar $LwjglJar
Download-File $JavaUtilJar $LwjglUtilJar
Download-File $CommonsLangJarUrl $CommonsLangJar
Download-File $GuavaJarUrl $GuavaJar
Download-File $CommonsIoJarUrl $CommonsIoJar
Download-File $Log4jApiJarUrl $Log4jApiJar
Download-File $Log4jCoreJarUrl $Log4jCoreJar

# ============================================================
# Download 15w14a languages
# ============================================================

function Prepare-15w14a-Languages {

    New-Item `
        -ItemType Directory `
        -Force `
        -Path $15w14aLanguageCache | Out-Null

    $ListTemp = Join-Path $DepsDir "15w14a-lang-list.json"

    try {

        Write-Host ""
        Write-Host "Downloading 15w14a language list..."

        Invoke-WebRequest `
            -Uri $15w14aLanguageListUrl `
            -OutFile $ListTemp `
            -UseBasicParsing

        $LanguageList = Get-Content `
            -Path $ListTemp `
            -Raw `
            -Encoding UTF8 |
            ConvertFrom-Json

        if (-not $LanguageList.files) {
            throw "15w14a language list does not contain any files."
        }

        $LanguageFiles = @(
            $LanguageList.files |
            Where-Object {
                $_ -like "*.lang"
            }
        )

        Write-Host "15w14a languages found: $($LanguageFiles.Count)"

        foreach ($LanguageName in $LanguageFiles) {

            $Destination = Join-Path `
                $15w14aLanguageCache `
                $LanguageName

            $Url = "$15w14aLanguageBaseUrl/$LanguageName"

            Download-File $Url $Destination
        }

    }
    finally {

        if (Test-Path $ListTemp) {
            Remove-Item $ListTemp -Force
        }
    }

    Write-Host "15w14a language files ready."
}

# ============================================================
# Language helper functions
# ============================================================

function Read-Utf8File {

    param(
        [string]$Path
    )

    return [System.IO.File]::ReadAllText(
        $Path,
        [System.Text.Encoding]::UTF8
    )
}

function Convert-LangToMap {

    param(
        [string]$Content
    )

    $Map = [ordered]@{}

    $Lines = $Content -split "\r?\n"

    foreach ($Line in $Lines) {

        if ([string]::IsNullOrWhiteSpace($Line)) {
            continue
        }

        if ($Line.StartsWith("#")) {
            continue
        }

        $Equals = $Line.IndexOf("=")

        if ($Equals -le 0) {
            continue
        }

        $Key = $Line.Substring(0, $Equals)
        $Value = $Line.Substring($Equals + 1)

        $Map[$Key] = $Value
    }

    return $Map
}

# ============================================================
# Apply English overrides
#
# Values from 15w14a\lang\en_US.lang are applied to every
# language first.
# ============================================================

function Apply-EnglishOverrides {

    param(
        [string]$ArchiveContent,
        [System.Collections.IDictionary]$EnglishOverrideMap
    )

    if (-not $EnglishOverrideMap -or $EnglishOverrideMap.Count -eq 0) {
        return $ArchiveContent
    }

    $Lines = $ArchiveContent -split "\r?\n"

    $Result = New-Object System.Collections.Generic.List[string]

    $UsedKeys = @{}

    foreach ($Line in $Lines) {

        $Equals = $Line.IndexOf("=")

        if ($Equals -gt 0) {

            $Key = $Line.Substring(0, $Equals)

            if ($EnglishOverrideMap.Contains($Key)) {

                $Result.Add(
                    "$Key=$($EnglishOverrideMap[$Key])"
                )

                $UsedKeys[$Key] = $true

                continue
            }
        }

        $Result.Add($Line)
    }

    foreach ($Key in $EnglishOverrideMap.Keys) {

        if (-not $UsedKeys.ContainsKey($Key)) {

            $Result.Add(
                "$Key=$($EnglishOverrideMap[$Key])"
            )
        }
    }

    return ($Result -join "`r`n")
}

# ============================================================
# Apply a translation patch
# ============================================================

function Apply-LanguagePatch {

    param(
        [string]$ArchiveContent,
        [string]$PatchContent
    )

    $PatchMap = Convert-LangToMap $PatchContent

    $Lines = $ArchiveContent -split "\r?\n"

    $Result = New-Object System.Collections.Generic.List[string]

    $UsedKeys = @{}

    foreach ($Line in $Lines) {

        $Equals = $Line.IndexOf("=")

        if ($Equals -gt 0) {

            $Key = $Line.Substring(0, $Equals)

            if ($PatchMap.Contains($Key)) {

                $Result.Add(
                    "$Key=$($PatchMap[$Key])"
                )

                $UsedKeys[$Key] = $true

                continue
            }
        }

        $Result.Add($Line)
    }

    foreach ($Key in $PatchMap.Keys) {

        if (-not $UsedKeys.ContainsKey($Key)) {

            $Result.Add(
                "$Key=$($PatchMap[$Key])"
            )
        }
    }

    return ($Result -join "`r`n")
}

# ============================================================
# Fix special keys
# ============================================================

function Fix-Vanilla-SpecialTranslations {

    param(
        [string]$ArchiveContent
    )

    $Lines = $ArchiveContent -split "\r?\n"

    $Result = New-Object System.Collections.Generic.List[string]

    foreach ($Line in $Lines) {

        $Equals = $Line.IndexOf("=")

        if ($Equals -gt 0) {

            $Key = $Line.Substring(0, $Equals)

            if ($Key -eq "options.anaglyph") {

                $Result.Add(
                    "options.anaglyph=Super HD Graphics"
                )

                continue
            }

            if ($Key -eq "tile.dropper.name") {

                $Result.Add(
                    "tile.dropper.name=Flopper"
                )

                continue
            }
        }

        $Result.Add($Line)
    }

    return ($Result -join "`r`n")
}

# ============================================================
# Process one language file
# ============================================================

function Process-LanguageContent {

    param(
        [string]$LanguageName,
        [string]$ArchiveContent
    )

    $FinalContent = $ArchiveContent

    # --------------------------------------------------------
    # 1. Apply global English overrides
    # --------------------------------------------------------

    if ($script:EnglishOverrideMap -and
        $script:EnglishOverrideMap.Count -gt 0) {

        Write-Host "Applying English overrides: $LanguageName"

        $FinalContent = Apply-EnglishOverrides `
            $FinalContent `
            $script:EnglishOverrideMap
    }

    # --------------------------------------------------------
    # 2. Apply language-specific patch
    # --------------------------------------------------------

    $CustomLanguagePath = Join-Path `
        $LangDir `
        $LanguageName

    if (Test-Path $CustomLanguagePath) {

        Write-Host "Patching language: $LanguageName"

        $PatchContent = Read-Utf8File `
            $CustomLanguagePath

        $FinalContent = Apply-LanguagePatch `
            $FinalContent `
            $PatchContent
    }

    # --------------------------------------------------------
    # 3. Special vanilla replacements
    # --------------------------------------------------------

    Write-Host "Fixing special translations: $LanguageName"

    $FinalContent = Fix-Vanilla-SpecialTranslations `
        $FinalContent

    return $FinalContent
}

# ============================================================
# Read language entry from JAR
# ============================================================

function Read-LanguageEntry {

    param(
        [System.IO.Compression.ZipArchiveEntry]$Entry
    )

    $InputStream = $null
    $Reader = $null

    try {

        $InputStream = $Entry.Open()

        $Reader = New-Object System.IO.StreamReader(
            $InputStream,
            [System.Text.Encoding]::UTF8,
            $true
        )

        return $Reader.ReadToEnd()

    }
    finally {

        if ($Reader) {
            $Reader.Dispose()
        }

        if ($InputStream) {
            $InputStream.Dispose()
        }
    }
}

# ============================================================
# Write text entry to ZIP
# ============================================================

function Add-TextEntry {

    param(
        [System.IO.Compression.ZipArchive]$Archive,
        [string]$EntryName,
        [string]$Content
    )

    $Bytes = [System.Text.Encoding]::UTF8.GetBytes($Content)

    $NewEntry = $Archive.CreateEntry(
        $EntryName,
        [System.IO.Compression.CompressionLevel]::Optimal
    )

    $OutputStream = $null

    try {

        $OutputStream = $NewEntry.Open()

        $OutputStream.Write(
            $Bytes,
            0,
            $Bytes.Length
        )

    }
    finally {

        if ($OutputStream) {
            $OutputStream.Dispose()
        }
    }
}

# ============================================================
# Write binary file entry to ZIP
# ============================================================

function Add-FileEntry {

    param(
        [System.IO.Compression.ZipArchive]$Archive,
        [string]$EntryName,
        [string]$FilePath
    )

    $NewEntry = $Archive.CreateEntry(
        $EntryName,
        [System.IO.Compression.CompressionLevel]::Optimal
    )

    $InputStream = $null
    $OutputStream = $null

    try {

        $InputStream = [System.IO.File]::OpenRead($FilePath)
        $OutputStream = $NewEntry.Open()

        $InputStream.CopyTo($OutputStream)

    }
    finally {

        if ($OutputStream) {
            $OutputStream.Dispose()
        }

        if ($InputStream) {
            $InputStream.Dispose()
        }
    }
}

# ============================================================
# Create 15w14a additional language resource pack
# ============================================================

function Create-15w14aAdditionalLanguagesPack {

    param(
        [hashtable]$Info,
        [string]$OutputDir
    )

    if (-not $Info["ExternalLanguageSource"]) {
        return
    }

    $PackMetaPath = Join-Path `
        $LangDir `
        "pack.mcmeta"

    if (-not (Test-Path $PackMetaPath)) {

        throw @"
15w14a resource pack pack.mcmeta was not found:

$PackMetaPath

Create:
15w14a\lang\pack.mcmeta
"@
    }

    $ResourcePackPath = Join-Path `
        $OutputDir `
        "additional_languages_resourcepack.zip"

    if (Test-Path $ResourcePackPath) {
        Remove-Item $ResourcePackPath -Force
    }

    Write-Host ""
    Write-Host "Creating 15w14a additional language resource pack..."

    $OutputArchive = $null

    try {

        $OutputArchive = [System.IO.Compression.ZipFile]::Open(
            $ResourcePackPath,
            [System.IO.Compression.ZipArchiveMode]::Create
        )

        # ----------------------------------------------------
        # Add pack.mcmeta
        # ----------------------------------------------------

        Write-Host "Adding resource-pack metadata: pack.mcmeta"

        Add-FileEntry `
            $OutputArchive `
            "pack.mcmeta" `
            $PackMetaPath

        # ----------------------------------------------------
        # Find languages supplied by the original 15w14a
        # asset list.
        #
        # Everything in this cache belongs in the JAR.
        # ----------------------------------------------------

        $ExternalLanguages = @{}

        foreach ($LanguageFile in Get-ChildItem `
            -Path $15w14aLanguageCache `
            -Filter "*.lang" `
            -File) {

            $ExternalLanguages[$LanguageFile.Name] = $true
        }

        Write-Host "Languages from 15w14a asset list: $($ExternalLanguages.Count)"

        # ----------------------------------------------------
        # Add only custom languages which are NOT part of
        # the original 15w14a language set.
        #
        # Example:
        #   ru_RU.lang  -> original -> JAR
        #   ru_NEW.lang -> custom   -> resource pack
        # ----------------------------------------------------

        $AddedLanguages = 0

        foreach ($LanguageFile in $script:CustomLanguageFiles) {

            $LanguageName = $LanguageFile.Name

            if ($ExternalLanguages.ContainsKey($LanguageName)) {
                continue
            }

            Write-Host "Adding additional language: $LanguageName"

            $Content = Read-Utf8File `
                $LanguageFile.FullName

            $FinalContent = Process-LanguageContent `
                $LanguageName `
                $Content

            Add-TextEntry `
                $OutputArchive `
                "assets/minecraft/lang/$LanguageName" `
                $FinalContent

            $AddedLanguages++
        }

    }
    finally {

        if ($OutputArchive) {
            $OutputArchive.Dispose()
        }
    }

    Write-Host ""
    Write-Host "Created: $ResourcePackPath"
    Write-Host "Additional languages: $AddedLanguages"
}

# ============================================================
# Export processed languages
# ============================================================

function Export-ProcessedLanguages {

    param(
        [hashtable]$Info,
        [string]$MinecraftJar,
        [string]$OutputDir,
        [bool]$HasLanguagesFile
    )

    # --------------------------------------------------------
    # 15w14a languages are installed through the resource pack.
    # Do NOT create assets/minecraft/lang in the .class output.
    # --------------------------------------------------------

    if ($Info["ExternalLanguageSource"]) {
        Write-Host ""
        Write-Host "15w14a languages are provided by additional_languages_resourcepack.zip."
        Write-Host "No language files will be exported to the .class output."
        return
    }

    $OutputLangDir = Join-Path `
        $OutputDir `
        $Info["TranslationJarPath"]

    if (Test-Path $OutputLangDir) {
        Remove-Item $OutputLangDir -Recurse -Force
    }

    New-Item `
        -ItemType Directory `
        -Force `
        -Path $OutputLangDir | Out-Null

    Write-Host ""
    Write-Host "Preparing language files for manual installation..."

    $SourceArchive = $null

    try {

        $SourceArchive = [System.IO.Compression.ZipFile]::OpenRead(
            $MinecraftJar
        )

        foreach ($Entry in $SourceArchive.Entries) {

            $EntryName = $Entry.FullName

            if (
                $EntryName.StartsWith(
                    "$($Info["TranslationJarPath"])/",
                    [System.StringComparison]::OrdinalIgnoreCase
                ) -and
                $EntryName.EndsWith(
                    ".lang",
                    [System.StringComparison]::OrdinalIgnoreCase
                )
            ) {

                $LanguageName = [System.IO.Path]::GetFileName(
                    $EntryName
                )

                $ArchiveContent = Read-LanguageEntry $Entry

                $FinalContent = Process-LanguageContent `
                    $LanguageName `
                    $ArchiveContent

                $OutputLanguagePath = Join-Path `
                    $OutputLangDir `
                    $LanguageName

                [System.IO.File]::WriteAllText(
                    $OutputLanguagePath,
                    $FinalContent,
                    [System.Text.Encoding]::UTF8
                )
            }
        }

        # ----------------------------------------------------
        # Add custom languages which do not exist in the JAR
        # ----------------------------------------------------

        foreach ($LanguageFile in $CustomLanguageFiles) {

            $LanguageName = $LanguageFile.Name

            $OutputLanguagePath = Join-Path `
                $OutputLangDir `
                $LanguageName

            if (Test-Path $OutputLanguagePath) {
                continue
            }

            Write-Host "Adding new language: $LanguageName"

            $Content = Read-Utf8File `
                $LanguageFile.FullName

            $FinalContent = Process-LanguageContent `
                $LanguageName `
                $Content

            [System.IO.File]::WriteAllText(
                $OutputLanguagePath,
                $FinalContent,
                [System.Text.Encoding]::UTF8
            )
        }

        # ----------------------------------------------------
        # languages.txt - only for 2.0
        # ----------------------------------------------------

        if ($HasLanguagesFile) {

            if (Test-Path $LanguagesFile) {

                Write-Host "Adding custom: $($Info["TranslationJarPath"])/languages.txt"

                Copy-Item `
                    $LanguagesFile `
                    (Join-Path $OutputLangDir "languages.txt") `
                    -Force
            }
        }

    }
    finally {

        if ($SourceArchive) {
            $SourceArchive.Dispose()
        }
    }

    Write-Host "Language files prepared: $OutputLangDir"
}

# ============================================================
# Build one version
# ============================================================

function Build-Version {

    param(
        [hashtable]$Info
    )

    $script:LangDir = Join-Path `
        $Root `
        $Info["TranslationDir"]

    $script:LanguagesFile = Join-Path `
        $LangDir `
        "languages.txt"

    # Reset English override map for every version.
    $script:EnglishOverrideMap = @{}

    if (-not (Test-Path $LangDir)) {

        throw @"
Translation directory not found:

$LangDir

Create:

$($Info["TranslationDir"])\
"@
    }

    if ($Info["HasLanguagesFile"]) {

        if (Test-Path $LanguagesFile) {

            Write-Host "languages.txt found: $LanguagesFile"

        }
        else {

            Write-Host "languages.txt not found - it will not be copied."
        }
    }

    # --------------------------------------------------------
    # 15w14a external language source
    # --------------------------------------------------------

    if ($Info["ExternalLanguageSource"]) {

        Prepare-15w14a-Languages
    }

    # --------------------------------------------------------
    # Find custom language patches
    # --------------------------------------------------------

    $script:CustomLanguageFiles = @(
        Get-ChildItem `
            -Path $LangDir `
            -Filter "*.lang" `
            -File
    )

    # --------------------------------------------------------
    # Read en_US.lang as a GLOBAL English override
    # --------------------------------------------------------

    if ($Info["ExternalLanguageSource"]) {

        $EnglishOverridePath = Join-Path `
            $LangDir `
            "en_US.lang"

        if (Test-Path $EnglishOverridePath) {

            Write-Host ""
            Write-Host "Loading global English overrides:"
            Write-Host "  $EnglishOverridePath"

            $EnglishOverrideContent = Read-Utf8File `
                $EnglishOverridePath

            $script:EnglishOverrideMap = Convert-LangToMap `
                $EnglishOverrideContent

            Write-Host "English override keys: $($script:EnglishOverrideMap.Count)"

        }
        else {

            Write-Host ""
            Write-Host "No custom en_US.lang found."
            Write-Host "Global English overrides are disabled."
        }
    }

    Write-Host ""
    Write-Host "Translation directory: $($Info["TranslationDir"])"
    Write-Host "Translation patches found:"

    if ($CustomLanguageFiles.Count -eq 0) {

        Write-Host "  None"

    }
    else {

        foreach ($LanguageFile in $CustomLanguageFiles) {
            Write-Host "  $($LanguageFile.Name)"
        }
    }

    Write-Host ""
    Write-Host "============================================================"
    Write-Host "Building $($Info["DisplayName"])"
    Write-Host "============================================================"

    $JarName = [string]$Info["JarName"]

    $MinecraftJar = Join-Path `
        $DepsDir `
        $JarName

    Write-Host "Minecraft JAR: $MinecraftJar"

    Download-File `
        ([string]$Info["Url"]) `
        $MinecraftJar

    # ========================================================
    # Verify Minecraft JAR
    # ========================================================

    $Hash = (Get-FileHash $MinecraftJar -Algorithm SHA256).Hash

    if ($Hash.ToUpper() -ne $Info["Sha256"].ToUpper()) {

        Remove-Item $MinecraftJar -Force

        throw @"
SHA-256 mismatch for $($Info["DisplayName"])!

Expected:
$($Info["Sha256"])

Got:
$Hash

The downloaded file was deleted.
"@
    }

    Write-Host "SHA-256 OK."

    # ========================================================
    # Prepare output directory
    # ========================================================

    $OutputDir = Join-Path `
        $BuildDir `
        $Info["Id"]

    if (Test-Path $OutputDir) {
        Remove-Item $OutputDir -Recurse -Force
    }

    New-Item `
        -ItemType Directory `
        -Force `
        -Path $OutputDir | Out-Null

    # ========================================================
    # Prepare 15w14a additional language resource pack
    #
    # This is created for BOTH output modes.
    # ========================================================

    if ($Info["ExternalLanguageSource"]) {

        Create-15w14aAdditionalLanguagesPack `
            $Info `
            $OutputDir
    }

    # ========================================================
    # Prepare source/class lists
    # ========================================================

    $SourcesToCompile = @(
        $Info["Sources"]
    )

    $ClassesToReplace = @(
        $Info["Classes"]
    )

    if ($UseFontFix -and $Info["FontFixSource"]) {

        $SourcesToCompile += $Info["FontFixSource"]
        $ClassesToReplace += $Info["FontFixClass"]

        Write-Host ""
        Write-Host "Font centering fix enabled:"
        Write-Host "  Source: $($Info["FontFixSource"])"
        Write-Host "  Class:  $($Info["FontFixClass"])"
    }

    $SourcesToCompile = @(
        $SourcesToCompile |
        Select-Object -Unique
    )

    $ClassesToReplace = @(
        $ClassesToReplace |
        Select-Object -Unique
    )

    # ========================================================
    # Compile sources
    # ========================================================

    $Classpath = @(
        $MinecraftJar
        $LwjglJar
        $LwjglUtilJar
        $CommonsLangJar
        $GuavaJar
        $CommonsIoJar
        $Log4jApiJar
        $Log4jCoreJar
    ) -join [System.IO.Path]::PathSeparator

    foreach ($SourceRelative in $SourcesToCompile) {

        $Source = Join-Path `
            $Root `
            $SourceRelative

        if (-not (Test-Path $Source)) {
            throw "Source file not found: $Source"
        }

        $SourceName = [System.IO.Path]::GetFileNameWithoutExtension(
            $Source
        )

        $ClassOutput = Join-Path `
            $OutputDir `
            "$SourceName.class"

        Write-Host ""
        Write-Host "Compiling $SourceRelative"

        & $Javac `
            --release 8 `
            -classpath $Classpath `
            -d $OutputDir `
            $Source

        if ($LASTEXITCODE -ne 0) {
            throw "Compilation failed: $SourceRelative"
        }

        if (-not (Test-Path $ClassOutput)) {
            throw "Compilation finished but $ClassOutput was not created."
        }

        Write-Host "Created: $ClassOutput"
    }

    # ========================================================
    # Export processed languages for .class files
    # ========================================================

    if ($OutputFormat -eq "classes") {

        Export-ProcessedLanguages `
            $Info `
            $MinecraftJar `
            $OutputDir `
            $Info["HasLanguagesFile"]
    }

    # ========================================================
    # Create modded JAR
    # ========================================================

    if ($OutputFormat -eq "jar") {

        $ModdedJar = Join-Path `
            $OutputDir `
            "$($Info["Id"])-moded.jar"

        $TempJar = Join-Path `
            $OutputDir `
            "$($Info["Id"])-moded-temp.jar"

        Write-Host ""
        Write-Host "Creating modded .jar without extracting..."

        foreach ($ClassName in $ClassesToReplace) {

            $CompiledClass = Join-Path `
                $OutputDir `
                $ClassName

            if (-not (Test-Path $CompiledClass)) {
                throw "Compiled class not found: $ClassName"
            }
        }

        if (Test-Path $TempJar) {
            Remove-Item $TempJar -Force
        }

        if (Test-Path $ModdedJar) {
            Remove-Item $ModdedJar -Force
        }

        $ArchiveLanguages = @{}

        $SourceArchive = $null
        $OutputArchive = $null

        try {

            $SourceArchive = [System.IO.Compression.ZipFile]::OpenRead(
                $MinecraftJar
            )

            $OutputArchive = [System.IO.Compression.ZipFile]::Open(
                $TempJar,
                [System.IO.Compression.ZipArchiveMode]::Create
            )

            # =================================================
            # Copy original JAR entries
            # =================================================

            foreach ($Entry in $SourceArchive.Entries) {

                $EntryName = $Entry.FullName

                # -------------------------------------------------
                # Completely remove META-INF
                # -------------------------------------------------

                if (
                    $EntryName -eq "META-INF" -or
                    $EntryName -eq "META-INF/" -or
                    $EntryName.StartsWith(
                        "META-INF/",
                        [System.StringComparison]::OrdinalIgnoreCase
                    )
                ) {

                    Write-Host "Removed: $EntryName"
                    continue
                }

                # -------------------------------------------------
                # Skip classes that will be replaced
                # -------------------------------------------------

                $ReplaceClass = $false

                foreach ($ClassName in $ClassesToReplace) {

                    if ($EntryName -eq $ClassName) {

                        $ReplaceClass = $true
                        break
                    }
                }

                if ($ReplaceClass) {

                    Write-Host "Replacing: $EntryName"
                    continue
                }

                # -------------------------------------------------
                # Language files
                #
                # Only language files which already exist in the
                # original JAR are processed here.
                #
                # 15w14a additional languages are NOT added here.
                # -------------------------------------------------

                if (
                    $EntryName.StartsWith(
                        "$($Info["TranslationJarPath"])/",
                        [System.StringComparison]::OrdinalIgnoreCase
                    ) -and
                    $EntryName.EndsWith(
                        ".lang",
                        [System.StringComparison]::OrdinalIgnoreCase
                    )
                ) {

                    $LanguageName = [System.IO.Path]::GetFileName(
                        $EntryName
                    )

                    $ArchiveLanguages[$LanguageName] = $true

                    $ArchiveContent = Read-LanguageEntry $Entry

                    # For 15w14a, if the language exists in the
                    # external asset source, use that version as
                    # the source content.
                    if ($Info["ExternalLanguageSource"]) {

                        $ExternalPath = Join-Path `
                            $15w14aLanguageCache `
                            $LanguageName

                        if (Test-Path $ExternalPath) {

                            $ArchiveContent = Read-Utf8File `
                                $ExternalPath
                        }
                    }

                    $FinalContent = Process-LanguageContent `
                        $LanguageName `
                        $ArchiveContent

                    Add-TextEntry `
                        $OutputArchive `
                        $EntryName `
                        $FinalContent

                    continue
                }

                # -------------------------------------------------
                # Normal file
                # -------------------------------------------------

                $NewEntry = $OutputArchive.CreateEntry(
                    $EntryName,
                    [System.IO.Compression.CompressionLevel]::Optimal
                )

                if ($Entry.Length -gt 0) {

                    $InputStream = $null
                    $OutputStream = $null

                    try {

                        $InputStream = $Entry.Open()
                        $OutputStream = $NewEntry.Open()

                        $InputStream.CopyTo($OutputStream)

                    }
                    finally {

                        if ($OutputStream) {
                            $OutputStream.Dispose()
                        }

                        if ($InputStream) {
                            $InputStream.Dispose()
                        }
                    }
                }
            }

            # =================================================
            # Add 15w14a languages from the original asset list
            #
            # These are the normal 15w14a languages and belong
            # in the JAR.
            # =================================================

            if ($Info["ExternalLanguageSource"]) {

                foreach ($LanguageFile in Get-ChildItem `
                    -Path $15w14aLanguageCache `
                    -Filter "*.lang" `
                    -File) {

                    $LanguageName = $LanguageFile.Name

                    Write-Host "Adding 15w14a language to JAR: $LanguageName"

                    $Content = Read-Utf8File `
                        $LanguageFile.FullName

                    $FinalContent = Process-LanguageContent `
                        $LanguageName `
                        $Content

                    Add-TextEntry `
                        $OutputArchive `
                        "$($Info["TranslationJarPath"])/$LanguageName" `
                        $FinalContent

                    $ArchiveLanguages[$LanguageName] = $true
                }
            }

            # =================================================
            # Add custom languages which don't exist yet
            #
            # 15w14a is EXCLUDED here because its additional
            # languages belong in additional_languages_resourcepack.zip.
            # =================================================

            if (-not $Info["ExternalLanguageSource"]) {

                foreach ($LanguageFile in $CustomLanguageFiles) {

                    $LanguageName = $LanguageFile.Name

                    if ($ArchiveLanguages.ContainsKey($LanguageName)) {
                        continue
                    }

                    Write-Host "Adding new language: $LanguageName"

                    $Content = Read-Utf8File `
                        $LanguageFile.FullName

                    $FinalContent = Process-LanguageContent `
                        $LanguageName `
                        $Content

                    Add-TextEntry `
                        $OutputArchive `
                        "$($Info["TranslationJarPath"])/$LanguageName" `
                        $FinalContent

                    $ArchiveLanguages[$LanguageName] = $true
                }
            }

            # =================================================
            # Replace languages.txt
            #
            # ONLY FOR 2.0
            # =================================================

            if ($Info["HasLanguagesFile"]) {

                if (Test-Path $LanguagesFile) {

                    Write-Host "Adding custom: $($Info["TranslationJarPath"])/languages.txt"

                    $LanguagesContent = Read-Utf8File `
                        $LanguagesFile

                    Add-TextEntry `
                        $OutputArchive `
                        "$($Info["TranslationJarPath"])/languages.txt" `
                        $LanguagesContent
                }
                else {

                    Write-Host "languages.txt not found - skipping"
                }
            }

            # =================================================
            # Add modified classes
            # =================================================

            foreach ($ClassName in $ClassesToReplace) {

                $CompiledClass = Join-Path `
                    $OutputDir `
                    $ClassName

                Write-Host "Adding modified class: $ClassName"

                $NewEntry = $OutputArchive.CreateEntry(
                    $ClassName,
                    [System.IO.Compression.CompressionLevel]::Optimal
                )

                $InputStream = $null
                $OutputStream = $null

                try {

                    $InputStream = [System.IO.File]::OpenRead(
                        $CompiledClass
                    )

                    $OutputStream = $NewEntry.Open()

                    $InputStream.CopyTo($OutputStream)

                }
                finally {

                    if ($OutputStream) {
                        $OutputStream.Dispose()
                    }

                    if ($InputStream) {
                        $InputStream.Dispose()
                    }
                }
            }

        }
        finally {

            if ($OutputArchive) {
                $OutputArchive.Dispose()
            }

            if ($SourceArchive) {
                $SourceArchive.Dispose()
            }
        }

        # ========================================================
        # Move temporary JAR to final location
        # ========================================================

        Move-Item `
            $TempJar `
            $ModdedJar `
            -Force

        # ========================================================
        # Remove compiled class files
        # ========================================================

        foreach ($ClassName in $ClassesToReplace) {

            $CompiledClass = Join-Path `
                $OutputDir `
                $ClassName

            if (Test-Path $CompiledClass) {
                Remove-Item $CompiledClass -Force
            }
        }

        Write-Host "Created: $ModdedJar"
    }
}

# ============================================================
# Build selected versions
# ============================================================

try {

    foreach ($Version in $SelectedVersions) {
        Build-Version $Version
    }

    # ========================================================
    # Build successful
    # ========================================================

    Write-Host ""
    Write-Host "============================================================" -ForegroundColor Green
    Write-Host "BUILD SUCCESSFUL" -ForegroundColor Green
    Write-Host "============================================================" -ForegroundColor Green
    Write-Host ""

    Write-Host "Output:"

    foreach ($Version in $SelectedVersions) {

        if ($OutputFormat -eq "jar") {

            Write-Host "  build\$($Version.Id)\$($Version.Id)-moded.jar"

        }
        else {

            if ($Version["ExternalLanguageSource"]) {

                Write-Host "  build\$($Version.Id)\"
                Write-Host "  build\$($Version.Id)\additional_languages_resourcepack.zip"

            }
            else {

                Write-Host "  build\$($Version.Id)\"
            }
        }

        if (
            $OutputFormat -eq "jar" -and
            $Version["ExternalLanguageSource"]
        ) {

            Write-Host "  build\$($Version.Id)\additional_languages_resourcepack.zip"
        }
    }

    # ========================================================
    # Clean build cache
    # ========================================================

    Write-Host ""

    $CleanCache = Read-Host "Clean build cache (.build-deps)? [Y/N]"

    if ($CleanCache -match "^[Yy12]$") {

        if (Test-Path $DepsDir) {

            Remove-Item $DepsDir -Recurse -Force

            Write-Host "Build cache removed."

        }
        else {

            Write-Host "Build cache is already empty."
        }
    }
    else {

        Write-Host "Build cache kept."
    }

}
catch {

    Write-Host ""
    Write-Host "============================================================" -ForegroundColor Red
    Write-Host "BUILD FAILED" -ForegroundColor Red
    Write-Host "============================================================" -ForegroundColor Red
    Write-Host ""
    Write-Host $_.Exception.Message -ForegroundColor Red
}
finally {

    Write-Host ""
    Write-Host "============================================================"
    Write-Host "SCRIPT FINISHED"
    Write-Host "============================================================"
    Write-Host ""

    Read-Host "Press Enter to close"
}
