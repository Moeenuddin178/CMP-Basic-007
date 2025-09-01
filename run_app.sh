#!/bin/bash

# Script to continuously build and run the CMP-Basic-007 app
# This script will watch for file changes and automatically rebuild and run the app

echo "Starting continuous build and run process for CMP-Basic-007 app..."
echo "Press Ctrl+C to stop"

# Function to build and run the app
build_and_run() {
    echo "----------------------------------------"
    echo "Building the app..."
    ./gradlew assembleDebug
    
    if [ $? -eq 0 ]; then
        echo "Installing the app..."
        ./gradlew installDebug
        
        if [ $? -eq 0 ]; then
            echo "Launching the app..."
            adb shell am start -n org.moeen.basics.androidApp/org.moeen.basics.AppActivity
            echo "App launched successfully!"
        else
            echo "Failed to install the app"
        fi
    else
        echo "Build failed!"
    fi
    echo "----------------------------------------"
}

# Initial build and run
build_and_run

# Watch for file changes and rebuild automatically
# Using a simple polling approach since inotify-tools might not be available on all systems
while true; do
    echo "Watching for changes... (Press Ctrl+C to stop)"
    
    # Wait for 5 seconds or until a signal is received
    sleep 5 &
    wait $!
    
    # Check if any Kotlin files have been modified in the last 5 seconds
    if find . -name "*.kt" -mmin -1 2>/dev/null | read dummy; then
        echo "Detected file changes, rebuilding..."
        build_and_run
    fi
done