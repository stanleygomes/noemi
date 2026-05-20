# Noemi Theme - Project Instructions

## Build & Package
- **Install dependencies**: `npm install`
- **Package extension**: `npx @vscode/vsce package --no-yarn`
- **Publish extension**: `npx @vscode/vsce publish --no-yarn`

## Project Structure
- `themes/`: VS Code theme JSON files (Light, Dark, High Contrast).
- `resources/`: Extension assets, icons, and screenshots.
- `landpage/`: Next.js landing page project.
- `.github/workflows/`: CI/CD pipelines for building and releasing.

## Development Guidelines
- **Conventional Commits**: Use conventional commit messages (e.g., `feat:`, `fix:`, `chore:`).
- **Versioning**: Versions are managed in `package.json`.
- **Packaging**: Ensure `resources/` and `themes/` are updated before creating a `.vsix` package.

## Landing Page
- **Run locally**: `cd landpage && npm install && npm run dev`
- **Build**: `cd landpage && npm run build`
