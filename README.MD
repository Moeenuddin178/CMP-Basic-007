# CMP-Basic-007

A Kotlin Multiplatform Mobile (KMM) project showcasing various UI components and examples.

## Project Structure

- `composeApp` - Main application module with shared code for Android and iOS
- `iosApp` - iOS specific code
- `Examples` - Example implementations like Login Form UI

## Scripts

This project includes two helpful scripts for development:

### build_and_run.sh

A simple script that builds, installs, and launches the app on a connected Android device or emulator.

Usage:
```bash
./build_and_run.sh
```

### run_app.sh

A continuous monitoring script that watches for file changes and automatically rebuilds and runs the app.

Usage:
```bash
./run_app.sh
```

To stop the script, press `Ctrl+C`.

## Development

Make sure you have an Android emulator running or an Android device connected before running these scripts.

The scripts will:
1. Build the app using Gradle
2. Install the app on the connected device/emulator
3. Launch the app

The continuous script will monitor for any changes to `.kt` files and automatically rebuild and reinstall the app when changes are detected.