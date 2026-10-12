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
# External language sources
# ============================================================

# 15w14a: language list from the InventivetalentDev assets repository
$15w14aLanguageListUrl = "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/15w14a/assets/minecraft/lang/_list.json"
$15w14aLanguageBaseUrl = "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/15w14a/assets/minecraft/lang"

# 1.RV-Pre1: languages are taken from the official Mojang asset index
$MojangVersionManifestUrl = "https://piston-meta.mojang.com/mc/game/version_manifest_v2.json"
$MojangResourcesBaseUrl = "https://resources.download.minecraft.net"

# ============================================================
# Version configuration
# ============================================================
#
# LanguageSourceType:
#   "InventiveTalent" - _list.json + raw files from GitHub
#   "MojangAssets"    - assetIndex from the official version JSON
#
# ApplyVanillaFixes:
#   $false -> skip Fix-Vanilla-SpecialTranslations (2.0 only fix)
#
# TextureDir / TextureJarPath:
#   Files from TextureDir are inserted into the JAR under TextureJarPath
#   (or copied to the output directory in .class mode).
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
        LanguageSourceType     = "InventiveTalent"

        ApplyVanillaFixes = $false

        Sources = @(
            "15w14a\axe.java"
            "15w14a\aye.java"
        )

        Classes = @(
            "axe.class"
            "aye.class"
        )

        # Optional Unicode glyph-width fix for 15w14a
        FontFixSource = "15w14a\avq.java"
        FontFixClass  = "avq.class"

        Sha256 = "82F24F74D7649F0D0E82CC1AB31079C4D5996E6330A9F7B1CF91EEC9EC77522E"

        Url = "https://piston-data.mojang.com/v1/objects/1bea9340956b96f2b5452aa576e0cf460990efc6/client.jar"
    }

    @{
        DisplayName = "1.RV-Pre1"
        Id          = "1.RV-Pre1"
        JarName     = "1.RV-Pre1.jar"

        TranslationDir     = "1.RV-Pre1\lang"
        TranslationJarPath = "assets/minecraft/lang"

        HasLanguagesFile = $false

        # Languages come from the Mojang asset index.
        # Original languages -> patched and put into the JAR.
        # Custom languages   -> additional_languages_resourcepack.zip
        ExternalLanguageSource = $true
        LanguageSourceType     = "MojangAssets"
        MojangVersionId        = "1.RV-Pre1"

        ApplyVanillaFixes = $false

        # Sign textures inserted into the JAR
        TextureDir     = "1.RV-Pre1\textures"
        TextureJarPath = "assets/minecraft/textures"

        Sources = @(
            "1.RV-Pre1\bpq.java"
            "1.RV-Pre1\bvh.java"
        )

        Classes = @(
            "bpq.class"
            "bvh.class"
        )

        Sha1 = "3843FAE71DD283E68897EAD618255FA1DDCF4C8D"

        Url = "https://piston-data.mojang.com/v1/objects/3843fae71dd283e68897ead618255fa1ddcf4c8d/client.jar"
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
# Optional Unicode glyph-width fix (Minecraft 2.0 / 15w14a)
# ============================================================

$HasFontFixVersion = @(
    $SelectedVersions |
    Where-Object {
        $_.ContainsKey("FontFixSource") -and
        -not [string]::IsNullOrWhiteSpace($_["FontFixSource"])
    }
).Count -gt 0

$UseFontFix = $false

if ($HasFontFixVersion) {

    Write-Host ""
    Write-Host "Optional Unicode font alignment fix:"
    Write-Host "MC-23952 - fixes wide Unicode glyph alignment."
    Write-Host ""
    Write-Host "This fix is only needed if you use a font texture pack."
    Write-Host "If you use English or the vanilla Minecraft font, you do NOT need this fix."
    Write-Host ""
    Write-Host "The fix will be included only for selected versions that support it:"
    Write-Host "  2.0 Blue/Purple  -> awz.class"
    Write-Host "  2.0 Red          -> awv.class"
    Write-Host "  2.0 Preview      -> ayb.class"
    Write-Host "  15w14a           -> avq.class"
    Write-Host ""

    $FontFixChoice = Read-Host "Apply the Unicode font alignment fix? [Y/N]"

    if ($FontFixChoice -match "^[Yy12]$") {

        $UseFontFix = $true
        Write-Host "Unicode font alignment fix: ENABLED"

    }
    else {

        $UseFontFix = $false
        Write-Host "Unicode font alignment fix: DISABLED"
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
# Download languages: InventiveTalent source (15w14a)
# ============================================================

function Prepare-InventiveTalentLanguages {

    param(
        [hashtable]$Info,
        [string]$CacheDir
    )

    $ListTemp = Join-Path $DepsDir "$($Info["Id"])-lang-list.json"

    try {

        Write-Host ""
        Write-Host "Downloading $($Info["DisplayName"]) language list..."

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
            throw "Language list does not contain any files."
        }

        $LanguageFiles = @(
            $LanguageList.files |
            Where-Object {
                $_ -like "*.lang"
            }
        )

        Write-Host "Languages found: $($LanguageFiles.Count)"

        foreach ($LanguageName in $LanguageFiles) {

            $Destination = Join-Path $CacheDir $LanguageName
            $Url = "$15w14aLanguageBaseUrl/$LanguageName"

            Download-File $Url $Destination
        }

    }
    finally {

        if (Test-Path $ListTemp) {
            Remove-Item $ListTemp -Force
        }
    }
}

# ============================================================
# Download languages: Mojang asset index source (1.RV-Pre1)
# ============================================================

function Prepare-MojangAssetLanguages {

    param(
        [hashtable]$Info,
        [string]$CacheDir
    )

    $VersionId = [string]$Info["MojangVersionId"]

    Write-Host ""
    Write-Host "Downloading Mojang version manifest..."

    $Manifest = Invoke-RestMethod `
        -Uri $MojangVersionManifestUrl `
        -UseBasicParsing

    $VersionEntry = @(
        $Manifest.versions |
        Where-Object { $_.id -eq $VersionId }
    ) | Select-Object -First 1

    if ($null -eq $VersionEntry) {
        throw "Version $VersionId was not found in the Mojang version manifest."
    }

    Write-Host "Downloading version JSON: $VersionId"

    $VersionJson = Invoke-RestMethod `
        -Uri $VersionEntry.url `
        -UseBasicParsing

    if (-not $VersionJson.assetIndex -or -not $VersionJson.assetIndex.url) {
        throw "Version JSON for $VersionId does not contain assetIndex."
    }

    Write-Host "Downloading asset index: $($VersionJson.assetIndex.id)"

    $AssetIndex = Invoke-RestMethod `
        -Uri $VersionJson.assetIndex.url `
        -UseBasicParsing

    $LanguageObjects = @(
        $AssetIndex.objects.PSObject.Properties |
        Where-Object {
            $_.Name -like "minecraft/lang/*.lang"
        }
    )

    if ($LanguageObjects.Count -eq 0) {
        throw "Asset index does not contain any minecraft/lang/*.lang entries."
    }

    Write-Host "Languages found: $($LanguageObjects.Count)"

    foreach ($Property in $LanguageObjects) {

        $LanguageName = [System.IO.Path]::GetFileName($Property.Name)
        $Hash = [string]$Property.Value.hash
        $Prefix = $Hash.Substring(0, 2)

        $Destination = Join-Path $CacheDir $LanguageName
        $Url = "$MojangResourcesBaseUrl/$Prefix/$Hash"

        Download-File $Url $Destination
    }
}

function Prepare-ExternalLanguages {

    param(
        [hashtable]$Info
    )

    $CacheDir = Join-Path $DepsDir "$($Info["Id"])-lang"

    New-Item `
        -ItemType Directory `
        -Force `
        -Path $CacheDir | Out-Null

    $script:ExternalLanguageCache = $CacheDir

    switch ($Info["LanguageSourceType"]) {

        "InventiveTalent" {
            Prepare-InventiveTalentLanguages $Info $CacheDir
        }

        "MojangAssets" {
            Prepare-MojangAssetLanguages $Info $CacheDir
        }

        default {
            throw "Unknown LanguageSourceType: $($Info["LanguageSourceType"])"
        }
    }

    Write-Host "$($Info["DisplayName"]) language files ready."
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
# Values from <version>\lang\en_US.lang are applied to every
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
    # 3. Special vanilla replacements (Minecraft 2.0 only)
    # --------------------------------------------------------

    if ($script:ApplyVanillaFixes) {

        Write-Host "Fixing special translations: $LanguageName"

        $FinalContent = Fix-Vanilla-SpecialTranslations `
            $FinalContent
    }

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
# Texture helpers
#
# Returns an ordered map:  jar entry name -> full file path
# ============================================================

function Get-TextureEntries {

    param(
        [hashtable]$Info
    )

    $Result = [ordered]@{}

    if (-not $Info.ContainsKey("TextureDir")) {
        return $Result
    }

    $TextureRoot = Join-Path $Root $Info["TextureDir"]

    if (-not (Test-Path $TextureRoot)) {
        Write-Host "Texture directory not found - skipping textures: $TextureRoot"
        return $Result
    }

    $TextureRoot = (Resolve-Path $TextureRoot).Path.TrimEnd('\', '/')

    $JarBase = ([string]$Info["TextureJarPath"]).Trim('/', '\')

    foreach ($File in Get-ChildItem -Path $TextureRoot -Recurse -File) {

        $Relative = $File.FullName.Substring($TextureRoot.Length).TrimStart('\', '/')
        $Relative = $Relative -replace '\\', '/'

        $Result["$JarBase/$Relative"] = $File.FullName
    }

    return $Result
}

# ============================================================
# Create additional language resource pack
#
# Contains only custom languages which are NOT part of the
# original language set of the version.
# ============================================================

function Create-AdditionalLanguagesPack {

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
Resource pack pack.mcmeta was not found:

$PackMetaPath

Create:
$($Info["TranslationDir"])\pack.mcmeta
"@
    }

    $ResourcePackPath = Join-Path `
        $OutputDir `
        "additional_languages_resourcepack.zip"

    if (Test-Path $ResourcePackPath) {
        Remove-Item $ResourcePackPath -Force
    }

    Write-Host ""
    Write-Host "Creating $($Info["DisplayName"]) additional language resource pack..."

    $OutputArchive = $null
    $AddedLanguages = 0

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
        # Languages supplied by the original language set.
        # Everything in this cache belongs in the JAR.
        # ----------------------------------------------------

        $ExternalLanguages = @{}

        foreach ($LanguageFile in Get-ChildItem `
            -Path $script:ExternalLanguageCache `
            -Filter "*.lang" `
            -File) {

            $ExternalLanguages[$LanguageFile.Name] = $true
        }

        Write-Host "Original languages: $($ExternalLanguages.Count)"

        # ----------------------------------------------------
        # Add only custom languages which are NOT part of
        # the original language set.
        # ----------------------------------------------------

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

    if ($Info["ProcessLanguages"] -eq $false) {
        Write-Host "Language processing disabled for $($Info["DisplayName"])."
        return
    }

    # --------------------------------------------------------
    # Versions with an external language source install their
    # additional languages through the resource pack.
    # Do NOT create assets/minecraft/lang in the .class output.
    # --------------------------------------------------------

    if ($Info["ExternalLanguageSource"]) {
        Write-Host ""
        Write-Host "Languages are provided by additional_languages_resourcepack.zip."
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
# Export textures for .class output
# ============================================================

function Export-Textures {

    param(
        [System.Collections.IDictionary]$TextureEntries,
        [string]$OutputDir
    )

    if (-not $TextureEntries -or $TextureEntries.Count -eq 0) {
        return
    }

    Write-Host ""
    Write-Host "Copying textures for manual installation..."

    foreach ($EntryName in $TextureEntries.Keys) {

        $Destination = Join-Path `
            $OutputDir `
            ($EntryName -replace '/', '\')

        $DestinationDir = Split-Path $Destination -Parent

        New-Item `
            -ItemType Directory `
            -Force `
            -Path $DestinationDir | Out-Null

        Copy-Item `
            $TextureEntries[$EntryName] `
            $Destination `
            -Force

        Write-Host "Texture: $EntryName"
    }
}

# ============================================================
# Patch 15w14a's original avq.class without recompiling it.
# This avoids requiring ICU4J, which avq.java imports.
# ============================================================

function Patch-15w14aFontFixClass {
    param(
        [string]$MinecraftJar,
        [string]$OutputClass
    )

    $Archive = $null
    $InputStream = $null

    try {
        $Archive = [System.IO.Compression.ZipFile]::OpenRead($MinecraftJar)
        $Entry = $Archive.GetEntry("avq.class")

        if ($null -eq $Entry) {
            throw "Original avq.class was not found in $MinecraftJar"
        }

        $InputStream = $Entry.Open()
        $Memory = New-Object System.IO.MemoryStream
        try {
            $InputStream.CopyTo($Memory)
            [byte[]]$Bytes = $Memory.ToArray()
        }
        finally {
            $Memory.Dispose()
        }
    }
    finally {
        if ($InputStream) { $InputStream.Dispose() }
        if ($Archive) { $Archive.Dispose() }
    }

    # Exact bytecode sequence in avq.a(char), including surrounding
    # instructions. Keep code length and branch offsets unchanged.
    [byte[]]$Pattern = @(
        0x15, 0x04, 0x10, 0x07, 0xA4, 0x00, 0x09,
        0x10, 0x0F, 0x36, 0x04, 0x03, 0x3E,
        0x84, 0x04, 0x01, 0x15, 0x04, 0x1D, 0x64,
        0x05, 0x6C, 0x04, 0x60, 0xAC
    )

    # Pop the two comparison operands, jump over the obsolete
    # wide-glyph adjustment, and NOP the remaining bytes.
    [byte[]]$Replacement = @(
        0x58, 0xA7, 0x00, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00
    )

    $MatchIndex = -1
    $MatchCount = 0

    for ($i = 0; $i -le ($Bytes.Length - $Pattern.Length); $i++) {
        $Matches = $true
        for ($j = 0; $j -lt $Pattern.Length; $j++) {
            if ($Bytes[$i + $j] -ne $Pattern[$j]) {
                $Matches = $false
                break
            }
        }

        if ($Matches) {
            $MatchIndex = $i
            $MatchCount++
        }
    }

    if ($MatchCount -ne 1) {
        throw "Could not safely patch avq.class: expected one exact bytecode match, found $MatchCount. No class was modified."
    }

    [Array]::Copy($Replacement, 0, $Bytes, ($MatchIndex + 4), $Replacement.Length)

    [System.IO.File]::WriteAllBytes($OutputClass, $Bytes)
    Write-Host "Applied MC-23952 bytecode patch to original avq.class."
}

# ============================================================
# Build one version
# ============================================================

function Build-Version {

    param(
        [hashtable]$Info
    )

    $script:CurrentVersionId = $Info["Id"]

    $script:LangDir = Join-Path `
        $Root `
        $Info["TranslationDir"]

    $script:LanguagesFile = Join-Path `
        $LangDir `
        "languages.txt"

    # Reset per-version state.
    $script:EnglishOverrideMap = @{}
    $script:ExternalLanguageCache = $null
    $script:ApplyVanillaFixes = ($Info["ApplyVanillaFixes"] -ne $false)

    if ($Info["ProcessLanguages"] -ne $false -and -not (Test-Path $LangDir)) {

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
    # External language source (15w14a, 1.RV-Pre1)
    # --------------------------------------------------------

    if ($Info["ExternalLanguageSource"]) {

        Prepare-ExternalLanguages $Info
    }

    # --------------------------------------------------------
    # Find custom language patches
    # --------------------------------------------------------

    if ($Info["ProcessLanguages"] -eq $false) {
        $script:CustomLanguageFiles = @()
    }
    else {
        $script:CustomLanguageFiles = @(
            Get-ChildItem `
                -Path $LangDir `
                -Filter "*.lang" `
                -File
        )
    }

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

    # --------------------------------------------------------
    # Textures
    # --------------------------------------------------------

    $TextureEntries = Get-TextureEntries $Info

    Write-Host ""
    Write-Host "Textures found: $($TextureEntries.Count)"

    foreach ($TextureName in $TextureEntries.Keys) {
        Write-Host "  $TextureName"
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

    if ($Info.ContainsKey("Sha1")) {
        $Hash = (Get-FileHash $MinecraftJar -Algorithm SHA1).Hash
        if ($Hash.ToUpper() -ne $Info["Sha1"].ToUpper()) {
            Remove-Item $MinecraftJar -Force
            throw @"
SHA-1 mismatch for $($Info["DisplayName"])!
Expected:
$($Info["Sha1"])
Got:
$Hash
The downloaded file was deleted.
"@
        }
        Write-Host "SHA-1 OK."
    }
    else {
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
    }

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
    # Prepare additional language resource pack
    #
    # This is created for BOTH output modes.
    # ========================================================

    if ($Info["ExternalLanguageSource"]) {

        Create-AdditionalLanguagesPack `
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

        $ClassesToReplace += $Info["FontFixClass"]

        if ($Info["Id"] -eq "15w14a") {
            Write-Host ""
            Write-Host "Font centering fix enabled:"
            Write-Host "  Source: original avq.class (bytecode patch)"
            Write-Host "  Class:  avq.class"
            Write-Host "  Note: avq.java is not recompiled, so ICU4J is not required."
        }
        else {
            $SourcesToCompile += $Info["FontFixSource"]

            Write-Host ""
            Write-Host "Font centering fix enabled:"
            Write-Host "  Source: $($Info["FontFixSource"])"
            Write-Host "  Class:  $($Info["FontFixClass"])"
        }
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

    $SourcePaths = @()
    foreach ($SourceRelative in $SourcesToCompile) {
        $Source = Join-Path $Root $SourceRelative
        if (-not (Test-Path $Source)) {
            throw "Source file not found: $Source"
        }
        Write-Host "Source: $SourceRelative"
        $SourcePaths += $Source
    }
    Write-Host ""
    Write-Host "Compiling all selected sources together..."
    & $Javac `
        --release 8 `
        -classpath $Classpath `
        -d $OutputDir `
        $SourcePaths
    if ($LASTEXITCODE -ne 0) {
        throw "Compilation failed."
    }
    foreach ($ClassName in $ClassesToReplace) {

        # 15w14a avq.class is created later by the bytecode patch,
        # not by javac.
        if ($UseFontFix -and
            $Info["Id"] -eq "15w14a" -and
            $ClassName -eq "avq.class") {
            continue
        }

        $ClassOutput = Join-Path $OutputDir $ClassName
        if (-not (Test-Path $ClassOutput)) {
            throw "Compilation finished but $ClassOutput was not created."
        }
        Write-Host "Created: $ClassOutput"
    }

    # ========================================================
    # Apply 15w14a font fix to the original class bytecode
    # ========================================================

    if ($UseFontFix -and $Info["Id"] -eq "15w14a") {
        $PatchedFontClass = Join-Path $OutputDir "avq.class"
        Patch-15w14aFontFixClass $MinecraftJar $PatchedFontClass
    }

    # ========================================================
    # Export processed languages + textures for .class files
    # ========================================================

    if ($OutputFormat -eq "classes") {

        Export-ProcessedLanguages `
            $Info `
            $MinecraftJar `
            $OutputDir `
            $Info["HasLanguagesFile"]

        Export-Textures `
            $TextureEntries `
            $OutputDir
    }

    # ========================================================
    # Create modded JAR
    # ========================================================

    if ($OutputFormat -eq "jar") {

        # javac may generate extra top-level class files for anonymous or
        # inner classes (for example, bvh$1.class). Include all generated
        # class files in the JAR, not only the explicitly listed classes.
        $CompiledClassFiles = @(
            Get-ChildItem -Path $OutputDir -Filter "*.class" -File |
            Sort-Object Name
        )
        if ($CompiledClassFiles.Count -eq 0) {
            throw "No compiled .class files were found in $OutputDir"
        }
        $CompiledClassNames = @{}
        foreach ($CompiledClassFile in $CompiledClassFiles) {
            $CompiledClassNames[$CompiledClassFile.Name] = $true
        }

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
                # Skip every class generated by javac, including
                # anonymous/inner classes such as bvh$1.class.
                # -------------------------------------------------
                if ($CompiledClassNames.ContainsKey($EntryName)) {
                    Write-Host "Replacing: $EntryName"
                    continue
                }

                # -------------------------------------------------
                # Skip original files which are replaced by our
                # own textures (they are added below).
                # -------------------------------------------------
                if ($TextureEntries.Contains($EntryName)) {
                    Write-Host "Replacing texture: $EntryName"
                    continue
                }

                # -------------------------------------------------
                # Language files
                #
                # Only language files which already exist in the
                # original JAR are processed here.
                #
                # Additional languages are NOT added here for
                # versions with an external language source.
                # -------------------------------------------------

                if (
                    $Info["ProcessLanguages"] -ne $false -and
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

                    # If the language exists in the external source,
                    # use that version as the source content.
                    if ($Info["ExternalLanguageSource"]) {

                        $ExternalPath = Join-Path `
                            $script:ExternalLanguageCache `
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
            # Add original languages from the external source
            #
            # These are the normal languages of the version and
            # belong in the JAR.
            # =================================================

            if ($Info["ExternalLanguageSource"]) {

                foreach ($LanguageFile in Get-ChildItem `
                    -Path $script:ExternalLanguageCache `
                    -Filter "*.lang" `
                    -File) {

                    $LanguageName = $LanguageFile.Name

                    # Already written from the original JAR entry.
                    if ($ArchiveLanguages.ContainsKey($LanguageName)) {
                        continue
                    }

                    Write-Host "Adding $($Info["DisplayName"]) language to JAR: $LanguageName"

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
            # Versions with an external language source are
            # EXCLUDED here: their additional languages belong
            # in additional_languages_resourcepack.zip.
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
            # Add textures (sign textures etc.)
            # =================================================

            foreach ($TextureName in $TextureEntries.Keys) {

                Write-Host "Adding texture to JAR: $TextureName"

                Add-FileEntry `
                    $OutputArchive `
                    $TextureName `
                    $TextureEntries[$TextureName]
            }

            # =================================================
            # Add modified classes
            # =================================================

            foreach ($CompiledClassFile in $CompiledClassFiles) {
                $ClassName = $CompiledClassFile.Name
                $CompiledClass = $CompiledClassFile.FullName
                Write-Host "Adding modified class: $ClassName"
                $NewEntry = $OutputArchive.CreateEntry(
                    $ClassName,
                    [System.IO.Compression.CompressionLevel]::Optimal
                )
                $InputStream = $null
                $OutputStream = $null
                try {
                    $InputStream = [System.IO.File]::OpenRead($CompiledClass)
                    $OutputStream = $NewEntry.Open()
                    $InputStream.CopyTo($OutputStream)
                }
                finally {
                    if ($OutputStream) { $OutputStream.Dispose() }
                    if ($InputStream) { $InputStream.Dispose() }
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
        # Remove all compiled .class files after adding them to the JAR.
        # Keep the final JAR and any additional resource-pack ZIP.
        # ========================================================

        foreach ($CompiledClassFile in $CompiledClassFiles) {
            if (Test-Path $CompiledClassFile.FullName) {
                Remove-Item $CompiledClassFile.FullName -Force
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

            Write-Host "  build\$($Version.Id)\"
        }

        if ($Version["ExternalLanguageSource"]) {

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