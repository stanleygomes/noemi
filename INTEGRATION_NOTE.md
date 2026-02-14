# Integration Note

## User's Theme Files

The user mentioned they have existing `themes.json` and `themes.xml` files that they want to integrate into this plugin.

### How to Integrate Your Existing Theme Files

If you have your own `themes.json` and `themes.xml` files:

#### For JSON Theme Files (Islands UI)

1. **Copy your `themes.json` to the themes directory:**
   ```bash
   cp /path/to/your/themes.json src/main/resources/themes/your_theme_name.theme.json
   ```

2. **Update the JSON structure to match JetBrains format:**
   - Ensure it has a `name` field
   - Set `dark` to `true` or `false`
   - Add an `author` field
   - Structure UI elements under the `ui` key
   - Reference your editor scheme: `"editorScheme": "/themes/your_theme_name.xml"`

3. **Register the theme in `plugin.xml`:**
   ```xml
   <themeProvider id="com.stanleygomes.noemi.yourtheme" path="/themes/your_theme_name.theme.json"/>
   ```

#### For XML Theme Files (Editor Colors)

1. **Copy your `themes.xml` to the themes directory:**
   ```bash
   cp /path/to/your/themes.xml src/main/resources/themes/your_theme_name.xml
   ```

2. **Update the XML structure to match JetBrains format:**
   - Should have `<scheme>` as root element
   - Include `name` attribute
   - Specify `parent_scheme` (usually "Darcula" or "Default")
   - Define colors under `<colors>` section
   - Define syntax highlighting under `<attributes>` section

3. **Reference it from your `.theme.json` file:**
   ```json
   {
     "name": "Your Theme Name",
     "editorScheme": "/themes/your_theme_name.xml",
     ...
   }
   ```

### Example Integration Steps

```bash
# 1. Place your files in the themes directory
cp ~/themes.json src/main/resources/themes/custom.theme.json
cp ~/themes.xml src/main/resources/themes/custom.xml

# 2. Edit plugin.xml to register the theme
# Add this line in the <extensions> section:
# <themeProvider id="com.stanleygomes.noemi.custom" path="/themes/custom.theme.json"/>

# 3. Test the plugin
./gradlew runIde
```

### Need Help Converting Your Files?

If your theme files are in a different format, you can:

1. Use the existing `noemi_dark.theme.json` and `noemi_dark.xml` as templates
2. Copy the structure and replace the colors with yours
3. Make sure color values are in hex format (without the `#` for XML files)

### Resources

- [JetBrains Theme Structure](https://plugins.jetbrains.com/docs/intellij/themes.html)
- [Theme Metadata](https://plugins.jetbrains.com/docs/intellij/theme-structure.html)
- [Color Scheme Management](https://plugins.jetbrains.com/docs/intellij/color-scheme-management.html)

## Questions?

If you need help integrating your existing theme files, please:
1. Share your `themes.json` and `themes.xml` files
2. Describe the current format they're in
3. Open an issue or discussion on GitHub

The current themes in this repository (`noemi_dark` and `noemi_light`) can serve as examples or be replaced with your own themes.
