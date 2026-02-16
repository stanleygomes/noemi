# Noemi Theme

<!-- Plugin description -->
A beautiful and modern dark theme collection for JetBrains IDEs.

**Noemi July**: A deep dark theme with red accents, perfect for focused coding sessions.

**Noemi November**: A balanced dark theme with vibrant colors, optimized for comfortable long coding sessions.

**Key Features:**
- Two carefully crafted dark theme variants
- Optimized color palettes for reduced eye strain
- Full support for all JetBrains IDEs (IntelliJ IDEA, PyCharm, WebStorm, PhpStorm, etc.)
- Professional and modern design
<!-- Plugin description end -->

## Features

- **Noemi July Theme**: Deep dark theme with red accents for focused coding
- **Noemi November Theme**: Balanced dark theme with vibrant colors
- **Optimized Color Palettes**: Designed for comfortable long coding sessions
- **Full IDE Support**: Compatible with all JetBrains IDEs

## Installation

### From JetBrains Marketplace (Coming Soon)

1. Open your JetBrains IDE
2. Go to `Settings/Preferences` → `Plugins`
3. Search for "Noemi Theme"
4. Click `Install`
5. Restart the IDE
6. Go to `Settings/Preferences` → `Appearance & Behavior` → `Appearance`
7. Select "Noemi July" or "Noemi November" from the Theme dropdown

### Manual Installation

1. Download the latest release from the [Releases](https://github.com/stanleygomes/noemi/releases) page
2. Open your JetBrains IDE
3. Go to `Settings/Preferences` → `Plugins`
4. Click the gear icon → `Install Plugin from Disk...`
5. Select the downloaded `.zip` file
6. Restart the IDE
7. Go to `Settings/Preferences` → `Appearance & Behavior` → `Appearance`
8. Select "Noemi July" or "Noemi November" from the Theme dropdown

## Development

### Requirements

- Java 21 or higher
- Gradle 8.5 (included via wrapper)

### Building the Plugin

```bash
# Build the plugin
./gradlew buildPlugin

# The plugin will be created at: build/distributions/noemi-1.0.0.zip
```

### Running the Plugin Locally

```bash
# Run the plugin in a sandbox IDE
./gradlew runIde
```

This will:
1. Download the IntelliJ IDEA Community Edition
2. Install the plugin in a sandbox environment
3. Launch the IDE with your theme installed
4. Any changes you make will require restarting this command

### Project Structure

```
noemi/
├── src/
│   └── main/
│       └── resources/
│           ├── META-INF/
│           │   └── plugin.xml          # Plugin configuration
│           └── themes/
│               ├── noemi_dark.theme.json    # Dark theme (Islands UI)
│               ├── noemi_dark.xml           # Dark theme (Classic)
│               ├── noemi_light.theme.json   # Light theme (Islands UI)
│               └── noemi_light.xml          # Light theme (Classic)
├── build.gradle.kts                    # Build configuration
├── gradle.properties                   # Project properties
└── settings.gradle.kts                 # Gradle settings
```

### Theme Files

- `.theme.json` files: Modern UI themes with Islands support (JetBrains 2022.1+)
- `.xml` files: Classic color schemes for the editor

## Customizing the Theme

To customize the theme colors:

1. Edit the theme files in `src/main/resources/themes/`
2. For UI colors: Modify the `.theme.json` files
3. For editor colors: Modify the `.xml` files
4. Run `./gradlew runIde` to test your changes

### Color Palette Reference

**Dark Theme Colors:**
- Background: `#1e1e2e`
- Foreground: `#cdd6f4`
- Selection: `#313244`
- Accent (Blue): `#89b4fa`
- Success (Green): `#a6e3a1`
- Error (Red): `#f38ba8`
- Warning (Yellow): `#f9e2af`

**Light Theme Colors:**
- Background: `#eff1f5`
- Foreground: `#4c4f69`
- Selection: `#dce0e8`
- Accent (Blue): `#1e66f5`
- Success (Green): `#40a02b`
- Error (Red): `#d20f39`
- Warning (Yellow): `#df8e1d`

## Publishing

```bash
# Build the plugin for distribution
./gradlew buildPlugin

# Verify the plugin
./gradlew verifyPlugin

# Publish to JetBrains Marketplace (requires token)
./gradlew publishPlugin
```

## Compatibility

- **IDE Build**: 223+ (IntelliJ IDEA 2022.3+)
- **Until Build**: 242.* (IntelliJ IDEA 2024.2)
- Compatible with all JetBrains IDEs (IntelliJ IDEA, PyCharm, WebStorm, etc.)

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🔗 Links

- [Issue Tracker](https://github.com/stanleygomes/noemi/issues)
- [Changelog](CHANGELOG.md)
- [Plugin Configuration File](https://plugins.jetbrains.com/docs/intellij/plugin-configuration-file.html?from=IJPluginTemplate)
- [Marktplace](https://plugins.jetbrains.com/author/me)
- [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij/)
- [Theme Guidelines](https://plugins.jetbrains.com/docs/intellij/themes.html)
- [UI Guidelines](https://jetbrains.design/intellij/)
- [Color Scheme Documentation](https://plugins.jetbrains.com/docs/intellij/color-scheme-management.html)

---

Made with 🔥 by NazarethLabs

[gh:build]: https://github.com/stanleygomes/codex-notes/actions?query=workflow%3ABuild
