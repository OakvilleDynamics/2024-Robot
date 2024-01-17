# Oakville Dynamics FRC Robot Template

A template for FRC robots using GradleRIO and WPILib. Prepackaged with GitHub Actions for CI/CD, Qodana for static analysis, CodeQL for static analysis and security scanning, Spotless for code formatting, and Gradle Validation for validating the Gradle wrapper.

## Build Status

| Action            | Status                                                                                                                                                                                                                                                 |
| ----------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Build             | [![Build](https://github.com/OakvilleDynamics/frc-robot-template/actions/workflows/build.yml/badge.svg)](https://github.com/OakvilleDynamics/frc-robot-template/actions/workflows/build.yml)                                                           |
| Qodana            | [![Qodana](https://github.com/OakvilleDynamics/frc-robot-template/actions/workflows/qodana.yml/badge.svg)](https://github.com/OakvilleDynamics/frc-robot-template/actions/workflows/qodana.yml)                                                        |
| CodeQL            | [![CodeQL Scanning](https://github.com/OakvilleDynamics/frc-robot-template/actions/workflows/codeql.yml/badge.svg)](https://github.com/OakvilleDynamics/frc-robot-template/actions/workflows/codeql.yml)                                               |
| Spotless          | [![Syntax Check](https://github.com/OakvilleDynamics/frc-robot-template/actions/workflows/syntax-check.yml/badge.svg)](https://github.com/OakvilleDynamics/frc-robot-template/actions/workflows/syntax-check.yml)                                      |
| Gradle Validation | [![Validate Gradle Wrapper](https://github.com/OakvilleDynamics/frc-robot-template/actions/workflows/gradle-wrapper-validation.yml/badge.svg)](https://github.com/OakvilleDynamics/frc-robot-template/actions/workflows/gradle-wrapper-validation.yml) |

## How to use

1. Create a template of this repository
2. Follow GitHub prompts for creating a repository
3. Clone newly created repository
4. Open the project in your WPILib Visual Studio Code (VS Code) after cloning
5. Start hacking away!

> [!NOTE]
>
> You should also change the `README.md` file to reflect your project for build statuses and other badges, otherwise the CI jobs listed here will point to the template. Include other changes that are made to help users understand your project.

## Features

- Preconfigured setup for GitHub Actions (helpful for [CI/CD](https://en.wikipedia.org/wiki/CI/CD))
  - Build action for building the robot code (helpful for ensuring code compiles)
  - [Qodana](https://www.jetbrains.com/qodana/) action for static analysis (helpful for finding bugs and code smells)
  - [CodeQL](https://codeql.github.com/) action for static analysis and security scanning (helpful for finding bugs and security vulnerabilities)
  - [Spotless](https://github.com/diffplug/spotless) enforcement action for code formatting (helpful for keeping code cleanly formatted after commits)
  - [Gradle Validation](https://github.com/gradle/wrapper-validation-action/tree/v1/?tab=readme-ov-file#the-gradle-wrapper-problem-in-open-source) action for validating the Gradle wrapper (helpful for ensuring [supply chain](https://en.wikipedia.org/wiki/Supply_chain_attack) security)
- Preconfigured setup for [Command-Based Robot](https://docs.wpilib.org/en/stable/docs/software/commandbased/index.html) projects (helpful for getting started)
- [Dependabot](https://docs.github.com/en/code-security/dependabot) for dependency updates (helpful for keeping dependencies up to date)
- Preconfigured setup for [Spotless](https://github.com/diffplug/spotless) inside of Gradle (helpful for keeping code cleanly formatted during development)

## Requirements

- WPILib 2024.1.1
- Internet connection (for Gradle to download dependencies)
