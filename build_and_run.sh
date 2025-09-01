#!/bin/bash

# Script to build and run the CMP-Basic-007 app

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