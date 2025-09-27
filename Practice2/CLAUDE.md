# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is an Android application built with Jetpack Compose and traditional XML layouts. The project demonstrates a hybrid approach using both modern Compose UI and classic View-based layouts with RecyclerView for displaying post content.

### Technology Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose + XML Views (hybrid approach)
- **Architecture**: Single Activity with ComponentActivity
- **Build System**: Gradle with Kotlin DSL and Version Catalogs
- **Target SDK**: 36, Min SDK: 21
- **Dependencies**: RecyclerView, CardView, Glide for image loading

## Build Commands

### Building the Project
```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Clean build
./gradlew clean
```

### Running Tests
```bash
# Run unit tests
./gradlew test

# Run instrumented tests (requires connected device/emulator)
./gradlew connectedAndroidTest

# Run specific test class
./gradlew test --tests "com.example.myapplication.ExampleUnitTest"
```

### Installing and Running
```bash
# Install debug build
./gradlew installDebug

# Uninstall
./gradlew uninstallDebug
```

## Project Architecture

### Core Structure
- **Package**: `com.example.myapplication`
- **Main Activity**: Uses Jetpack Compose with `MyApplicationTheme`
- **Data Models**: `Post` data class (located in project root as `post.kt`)
- **UI Layouts**: XML layout `item_post.xml` for RecyclerView items using CardView

### Key Components
1. **MainActivity.kt**: Entry point using Compose with Scaffold and basic greeting
2. **Post Data Class**: Represents social media posts with like functionality
3. **XML Layout**: `item_post.xml` defines post item UI with image, title, content, and like button
4. **Theme System**: Compose theming in `ui/theme/` directory

### Dependencies Management
- Uses Gradle Version Catalogs (`gradle/libs.versions.toml`)
- Combines Compose dependencies with traditional Android View libraries
- Includes Glide for image loading and RecyclerView for list display

### Testing Setup
- Unit tests: JUnit 4 framework
- Instrumented tests: AndroidX Test with AndroidJUnitRunner
- Test location follows standard Android structure

## Development Notes

### Hybrid UI Approach
This project uses both Jetpack Compose and XML layouts. The MainActivity uses Compose while post items are defined in XML, indicating this may be a migration project or demonstration of both approaches.

### Package Structure
The main application code is in `com.example.myapplication` while the `Post` data class is in the project root, which is unconventional and may need organization.

### Image Handling
Glide is configured for image loading, particularly for the post images in the RecyclerView items.