![Logo Project](https://i.ibb.co/fvwrP1d/Screenshot-2023-12-22-at-14-31-53.png)



# PregAI: Yoga 🤰🧘‍♀️ 

## Introduction:

Welcome to the PregAI: Yoga repository! This Kotlin-based mobile application is designed to empower pregnant women by providing a personalized yoga experience, ensuring safety and guidance during their practice.

## Table of Contents:

1. [Features](#features)
2. [Libraries](#libraries)
    - [Android Jetpack](#android-jetpack)
    - [JUnit](#junit)
    - [Mockito](#mockito)
    - [Retrofit](#retrofit)
    - [Glide](#glide)
    - [Dagger/RxJava](#dagger/rxjava)
    - [TensorFlow Lite](#tensorflow-lite)
    - [Android KTX](#android-ktx)
    - [CameraX](#camerax)
    - [Room](#room)
    - [ViewModel/LiveData](#viewmodel/livedata)
    - [Compose](#compose)
    - [Paging](#paging)
3. [Project Structure](#project-structure)

## Images:

![Logo Project](https://i.ibb.co/znRbXwb/Screenshot-2023-12-22-at-14-31-57.png)

![Logo Project](https://i.ibb.co/LNQQ7qb/Screenshot-2023-12-22-at-14-32-03.png)

![Logo Project](https://i.ibb.co/8d5BWxc/Screenshot-2023-12-22-at-14-32-11.png)

![Logo Project](https://i.ibb.co/4dCGVjb/Screenshot-2023-12-22-at-14-32-16.png)

![Logo Project](https://i.ibb.co/MRpsdWQ/Screenshot-2023-12-22-at-14-32-21.png)


## Features:

- Real-time pose detection using camera access on smartphones.
- Machine learning model to assess users' yoga poses.
- Guidance on safe yoga poses for pregnant women.
- Progression to the next pose only when the current pose is done correctly and held for a specified time.

## Libraries:

### Android Jetpack:
- Lifecycle & Livedata
- Kotlin Flow
- Navigation Component
- Kotlin Coroutines

### Android Library:
- JUnit (for unit testing framework)
- Mockito (for testing, creating, and using mock objects)
- Glide (for efficient loading and caching of images)
- Dagger/RxJava (for reactive programming)
- TensorFlow Lite (machine learning library for on-device model inference on Android)
- Android KTX (for improved code readability and conciseness in Android development)
- CameraX (Android Jetpack library simplifying camera development with backward compatibility)
- Room (for easier data storage in Android apps)
- ViewModel/LiveData (for managing UI-related data and lifecycle awareness)

## Project Structure:
PregAI-Yoga/
|-- app/
| |-- src/
| |-- main/
| |-- java/
| |-- com/
| |-- pregai/
| |-- yoga/
| |-- MainActivity.kt
|-- screenshots/
| |-- pose_detection.png
| |-- guided_poses.png
|-- README.md

## Architecture:

![Logo Project](https://i.ibb.co/NpGsy1Y/Screenshot-2023-12-22-at-14-32-26.png)

![Logo Project](https://i.ibb.co/9rV1Cbw/Screenshot-2023-12-22-at-14-32-31.png)


## Executive Summary/Abstract:

Maternal mortality is a significant global health concern, especially in developing countries. The PregAI: Yoga app addresses this issue by providing pregnant women with a personal yoga instructor equipped with real-time feedback based on machine learning pose estimation tailored to the user's pregnancy trimester. This application aims to provide comfort and safety during prenatal yoga practice.

## How did your team come up with this project?

Prenatal yoga, tailored for expectant mothers, serves the dual purpose of maintaining health during pregnancy and preparing for a safe delivery. To overcome challenges in accessing suitable yoga classes, the team developed a dedicated Kotlin-based application exclusively for pregnant women. This app offers guidance and recognizes yoga movements demonstrated by a yoga instructor.

## Project Scope & Deliverables:

### Project Scope:

- Detect users' poses using smartphone cameras.
- Build a machine learning model to assess users' yoga poses.
- Provide guidance on safe yoga poses for pregnant women.
- Limit detection to simple yoga poses due to time constraints and model size and complexity.

### Deliverables:

- Users can use the application to practice yoga poses correctly and safely.
- Camera-based pose tracking ensures accurate yoga practice.
- Progress to the next pose only when the current pose is done correctly and held for a specified time.

Feel free to contribute and enhance PregAI: Yoga! 🌟

