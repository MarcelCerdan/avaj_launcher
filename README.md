![Grade](https://img.shields.io/badge/Grade-125%2F100-brightgreen)

# Avaj-Launcher ✈️☁️

**Avaj-Launcher** is the first project in the Java branch at 42 School. It is a flight simulation system based on a weather notification engine, specifically designed to introduce **Object-Oriented Programming (OOP)** and the implementation of specific **Design Patterns**.

## 📌 Project Overview

The simulator reads a scenario file containing a list of aircraft and a number of simulation cycles. It calculates the movement of various aircraft types (Helicopters, JetPlanes, Baloons) based on changing weather conditions and logs every event into a file.

### Key Learning Objectives:
* **Design Patterns:** Singleton, Factory, and Observer.
* **OOP Concepts:** Interfaces, Abstract Classes, Inheritance, and Encapsulation.
* **Strict Architecture:** Adhering to a predefined UML class diagram.
* **Robustness:** Handling scenario file parsing and custom exceptions.

---

## 🏗️ Architecture & Design Patterns

The project is built around three core design patterns:

1. **Observer Pattern**: The `WeatherTower` acts as the *Subject*. Aircraft (`Flyable`) register as *Observers*. When the weather changes, the tower notifies all registered aircraft to update their coordinates.
2. **Factory Pattern**: The `AircraftFactory` class centralizes the instantiation of aircraft types (`Baloon`, `JetPlane`, `Helicopter`).
3. **Singleton Pattern**: The `WeatherProvider` ensures that there is only one global instance managing the weather states.

---

## 🚀 Getting Started

### Prerequisites
* Java JDK (Version 8 or higher)
* A Unix-based terminal (Linux/MacOS)

### Compilation
From the root of the project, use the following commands:
```bash
find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
```

### Execution
Run the simulator with a scenario file:
```bash
java avaj.launcher.Main scenario.txt
```
*The results will be recorded in `simulation.txt`.*

### 📄 Scenario File Format
The input file must follow this structure:
1. First line: Number of simulation cycles (positive integer).
2. Following lines: `TYPE NAME LONGITUDE LATITUDE HEIGHT`

Example `(scenario.txt)`:
```plaintext
20
Baloon B1 10 20 30
JetPlane J1 150 25 75
Helicopter H1 50 50 50
```

### 🛠️ Project Structure
* Interfaces: `Flyable`, `WeatherTower`.
* Core Logic: `WeatherProvider`, `AircraftFactory`.
* Aircraft Classes: `Aircraft` (Abstract), `Baloon`, `JetPlane`, `Helicopter`.
* Main: Handles file I/O, parsing, and simulation loop.

### 💡 Features & Bonuses
* Validation: Strict input validation to prevent crashes on malformed files (coordinates out of bounds, unknown types).
* Custom Exceptions: Implemented specific exception classes for better error tracking.
* Flavor Text: Each aircraft type has unique (and slightly humorous) log messages for different weather conditions.
