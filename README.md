# 🎨 Noemi Theme

<!-- Plugin description -->

The ideal colors and contrast for long hours of coding. Your eyes will thank you.

**Key Features:**

- Optimized color palettes for reduced eye strain 👀
- Full support for VSCode and it's based IDEs like Antigravity and Cursor
- Professional and modern design ✨
<!-- Plugin description end -->

![screenshot](https://github.com/stanleygomes/noemi/raw/HEAD/resources/theme.png)

## Available Theme Variations

Noemi Theme for VS Code comes in four variations, each designed for different preferences and accessibility needs:

- **Noemi Dark**: A comfortable dark theme with warm orange accents for long coding sessions.
- **Noemi Red**: A warm dark theme with rich wine accents.
- **Noemi Light**: A clean light theme for bright environments.
- **Noemi High Contrast**: Enhanced contrast for improved accessibility and visibility.

Select your preferred theme in VS Code's theme settings after installation.

## Installation 📥

### From Visual Studio Marketplace

1. Open VS Code
2. Go to `Extensions` (`Ctrl+Shift+X` / `Cmd+Shift+X`)
3. Search for "Noemi Theme"
4. Click `Install`
5. Open `Preferences: Color Theme` and select one of:
   - `Noemi Light`
   - `Noemi Dark`
   - `Noemi Red`
   - `Noemi High Contrast`

### Manual Installation (.vsix)

1. Download the latest `.vsix` from the [Releases](https://github.com/stanleygomes/noemi/releases) page
2. In VS Code, open `Extensions`
3. Click the `...` menu → `Install from VSIX...`
4. Select the downloaded `.vsix` file
5. Open `Preferences: Color Theme` and choose a Noemi theme

## Development 🛠️

### Requirements

- Node.js 20+ (for VS Code extension packaging)
- npm 10+

### Theme Files

- `themes/*.json`: VS Code light, dark, red and high-contrast themes

### Building the Extension

```bash
cd vscode
npm install
npx @vscode/vsce package --no-yarn
```

## 🚀 CI/CD

This project uses GitHub Actions for continuous integration and deployment. The following workflows are configured:

### Build Workflow (`build.yml`)

- **Trigger**: Push to `master` branch or pull requests
- **Actions**:
  - Validates commit messages (Conventional Commits)
  - Installs dependencies and packages the extension as a `.vsix` file
  - Uploads the built extension as a workflow artifact on pushes to `master`

### Release Workflow (`release.yml`)

- **Trigger**: GitHub release publication
- **Actions**:
  - Signs and publishes the plugin to Visual Studio and OpenVSX Marketplaces
  - Updates changelog

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

---

Made with 🔥 by Lumen HQ
