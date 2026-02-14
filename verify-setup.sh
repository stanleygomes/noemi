#!/bin/bash

# Verification script for Noemi Theme Plugin setup
echo "🔍 Verifying Noemi Theme Plugin Setup..."
echo ""

# Color codes
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

check_file() {
    if [ -f "$1" ]; then
        echo -e "${GREEN}✓${NC} $1 exists"
        return 0
    else
        echo -e "${RED}✗${NC} $1 is missing"
        return 1
    fi
}

check_dir() {
    if [ -d "$1" ]; then
        echo -e "${GREEN}✓${NC} $1/ exists"
        return 0
    else
        echo -e "${RED}✗${NC} $1/ is missing"
        return 1
    fi
}

echo "📁 Checking core files..."
check_file "build.gradle.kts"
check_file "settings.gradle.kts"
check_file "gradle.properties"
check_file "gradlew"
check_file ".gitignore"
check_file ".editorconfig"

echo ""
echo "📚 Checking documentation..."
check_file "README.md"
check_file "QUICKSTART.md"
check_file "CHANGELOG.md"
check_file "PROJECT_SUMMARY.md"
check_file "INTEGRATION_NOTE.md"
check_file "LICENSE"

echo ""
echo "📦 Checking project structure..."
check_dir "src/main/resources"
check_dir "src/main/resources/META-INF"
check_dir "src/main/resources/themes"
check_file "src/main/resources/META-INF/plugin.xml"

echo ""
echo "🎨 Checking theme files..."
check_file "src/main/resources/themes/noemi_dark.theme.json"
check_file "src/main/resources/themes/noemi_dark.xml"
check_file "src/main/resources/themes/noemi_light.theme.json"
check_file "src/main/resources/themes/noemi_light.xml"

echo ""
echo "🔧 Checking Gradle wrapper..."
check_dir "gradle/wrapper"
check_file "gradle/wrapper/gradle-wrapper.properties"
check_file "gradle/wrapper/gradle-wrapper.jar"

echo ""
echo "🧪 Validating plugin.xml..."
if grep -q "themeProvider" "src/main/resources/META-INF/plugin.xml"; then
    echo -e "${GREEN}✓${NC} Theme providers found in plugin.xml"
else
    echo -e "${RED}✗${NC} No theme providers in plugin.xml"
fi

echo ""
echo "📊 Project Statistics:"
echo "   Theme files: $(find src/main/resources/themes -type f | wc -l)"
echo "   Documentation files: $(ls -1 *.md 2>/dev/null | wc -l)"
echo "   Total source files: $(find src -type f | wc -l)"

echo ""
echo "🎯 Next Steps:"
echo "   1. Review the theme files in src/main/resources/themes/"
echo "   2. If you have existing themes.json/themes.xml, see INTEGRATION_NOTE.md"
echo "   3. Test the plugin: ./gradlew runIde"
echo "   4. Build the plugin: ./gradlew buildPlugin"

echo ""
echo "✅ Setup verification complete!"
