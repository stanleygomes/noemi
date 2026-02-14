# Quick Start Guide

This guide will help you get started with developing the Noemi Theme plugin for JetBrains IDEs.

## Prerequisites

- **Java Development Kit (JDK)**: Version 17 or higher
  - Check your version: `java -version`
  - Download from: https://adoptium.net/

- **Git**: For version control
  - Check your version: `git --version`

## Setup

### 1. Clone the Repository

```bash
git clone https://github.com/stanleygomes/noemi.git
cd noemi
```

### 2. Verify Gradle Wrapper

The project includes a Gradle wrapper, so you don't need to install Gradle separately:

```bash
# On Linux/Mac
./gradlew --version

# On Windows
gradlew.bat --version
```

### 3. Understanding the Project Structure

```
noemi/
├── src/main/resources/
│   ├── META-INF/
│   │   └── plugin.xml              # Plugin metadata and configuration
│   └── themes/
│       ├── noemi_dark.theme.json   # Dark theme (Islands UI)
│       ├── noemi_dark.xml          # Dark theme (Editor colors)
│       ├── noemi_light.theme.json  # Light theme (Islands UI)
│       └── noemi_light.xml         # Light theme (Editor colors)
├── build.gradle.kts                # Build configuration
├── gradle.properties               # Project properties
└── settings.gradle.kts             # Gradle settings
```

## Development Workflow

### Running the Plugin in Development Mode

The `runIde` task launches a sandbox IntelliJ IDEA with your plugin installed:

```bash
./gradlew runIde
```

**What happens:**
1. Downloads IntelliJ IDEA (first time only)
2. Creates a sandbox environment
3. Installs your plugin
4. Launches the IDE

**Note:** The sandbox IDE is completely separate from your main IntelliJ installation.

### Making Changes

1. **Edit Theme Files**: Modify the `.theme.json` or `.xml` files in `src/main/resources/themes/`

2. **Test Changes**: 
   ```bash
   ./gradlew runIde
   ```

3. **Apply Theme in Sandbox IDE**:
   - Go to `Settings` → `Appearance & Behavior` → `Appearance`
   - Select `Noemi Dark` or `Noemi Light` from the Theme dropdown

### Building the Plugin

To create a distributable plugin file:

```bash
./gradlew buildPlugin
```

The plugin will be created at: `build/distributions/noemi-1.0.0.zip`

### Verifying the Plugin

Before publishing, verify the plugin structure and compatibility:

```bash
./gradlew verifyPlugin
```

## Theme File Formats

### .theme.json (Islands UI)

Modern UI theme file that controls:
- Window backgrounds and foregrounds
- Button styles
- Input fields
- Tool windows
- Navigation elements
- Icons color palette

Example structure:
```json
{
  "name": "Noemi Dark",
  "dark": true,
  "author": "Stanley Gomes",
  "ui": {
    "*": {
      "background": "#1e1e2e",
      "foreground": "#cdd6f4"
    }
  }
}
```

### .xml (Editor Color Scheme)

Classic editor color scheme that controls:
- Syntax highlighting
- Editor background
- Line numbers
- Selection colors
- Code elements (keywords, strings, comments, etc.)

Example structure:
```xml
<scheme name="Noemi Dark" version="142" parent_scheme="Darcula">
  <colors>
    <option name="CARET_ROW_COLOR" value="313244" />
  </colors>
  <attributes>
    <option name="DEFAULT_KEYWORD">
      <value>
        <option name="FOREGROUND" value="cba6f7" />
      </value>
    </option>
  </attributes>
</scheme>
```

## Testing Your Changes

### Manual Testing Checklist

After making changes, test the following in the sandbox IDE:

- [ ] Theme applies correctly
- [ ] Editor colors are readable
- [ ] UI elements are properly styled
- [ ] Buttons and inputs look correct
- [ ] Tool windows have proper styling
- [ ] Search dialogs are styled
- [ ] Tabs and navigation work well
- [ ] Both light and dark themes work

### Testing Different IDEs

The theme should work across all JetBrains IDEs. Test with:
- IntelliJ IDEA
- PyCharm
- WebStorm
- PhpStorm
- etc.

## Common Commands

```bash
# Clean build artifacts
./gradlew clean

# Build plugin
./gradlew buildPlugin

# Run in development mode
./gradlew runIde

# Verify plugin
./gradlew verifyPlugin

# List all available tasks
./gradlew tasks
```

## Troubleshooting

### Gradle Issues

If you encounter Gradle issues:

```bash
# Clean Gradle cache
rm -rf .gradle/
./gradlew clean

# Re-download dependencies
./gradlew --refresh-dependencies
```

### IDE Not Launching

- Ensure Java 17+ is installed
- Check `build.gradle.kts` for compatibility settings
- Try: `./gradlew clean runIde`

### Theme Not Appearing

- Verify `plugin.xml` has correct theme provider paths
- Check theme file syntax (JSON/XML)
- Restart the sandbox IDE

## Resources

- [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij/)
- [Theme Guidelines](https://plugins.jetbrains.com/docs/intellij/themes.html)
- [UI Guidelines](https://jetbrains.design/intellij/)
- [Color Scheme Documentation](https://plugins.jetbrains.com/docs/intellij/color-scheme-management.html)

## Getting Help

- **Issues**: https://github.com/stanleygomes/noemi/issues
- **Discussions**: https://github.com/stanleygomes/noemi/discussions
- **Email**: stanley.gomes@gmail.com

## Next Steps

1. Try running `./gradlew runIde` to see the theme in action
2. Experiment with colors in the theme files
3. Read the [README.md](README.md) for more details
4. Check out the [CHANGELOG.md](CHANGELOG.md) for version history
