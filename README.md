# myUW Degree Planner Java

A Java console application for planning courses, checking prerequisites, and tracking degree progress.

I built this project to practice Java Object-Oriented Programming by creating something that feels close to a real academic planning tool. The idea is simple: a student can track completed courses, plan future quarters, check whether they meet prerequisites, and see what requirements are still missing for their degree.

## Project Overview

This project simulates a small version of a university degree planner. It is not connected to real UW data yet, but it uses sample course data to demonstrate the main planning logic.

The app currently supports:

* Viewing a course catalog
* Adding completed courses
* Checking course prerequisites
* Planning courses by quarter
* Viewing a full academic plan
* Tracking remaining degree requirements
* Showing degree progress as a percentage
* Interacting with the program through a console menu

## Why I Built This

I wanted to strengthen my Java OOP skills by building a project that is more practical than a small classroom exercise. This project helped me practice how different classes work together in a larger system and how to separate responsibilities between objects.

Instead of putting all the logic in `Main`, I organized the program into separate classes such as `Course`, `Student`, `CourseCatalog`, `QuarterPlan`, `AcademicPlan`, `DegreeRequirement`, and `CoursePlanner`.

## Features

### Course Catalog

Stores available courses and allows searching by course code.

### Completed Course Tracking

A student can add courses they have already completed. The program can also check whether a course has already been completed.

### Prerequisite Checking

Before adding a course to a quarter, the planner checks whether the student has completed the required prerequisites.

### Quarter Planning

Courses can be added to specific quarters. Each quarter tracks its planned courses and total credits.

### Academic Plan

The academic plan stores multiple quarter plans and can display the full plan across different quarters.

### Degree Requirement Tracking

The program compares completed courses with required courses and shows which requirements are still missing.

### Console Menu

The project includes a simple console interface so the user can interact with the planner through numbered menu options.

## OOP Concepts Practiced

This project uses several Java OOP concepts, including:

* Classes and objects
* Constructors
* Encapsulation
* Getter methods
* Composition
* Method overloading
* `equals()` and `hashCode()`
* `ArrayList` of objects
* Separation of responsibilities
* Basic service/controller logic

## Main Classes

### `Course`

Represents one course. It stores the course code, title, credits, department, and prerequisites.

### `Student`

Represents a student and stores completed courses.

### `CourseCatalog`

Stores all available courses and allows searching for courses by code.

### `CoursePlanner`

Handles the main planning logic, such as checking prerequisites, adding courses to a quarter, and showing degree progress.

### `QuarterPlan`

Represents one academic quarter and stores the courses planned for that quarter.

### `AcademicPlan`

Stores multiple quarter plans and displays the full academic plan.

### `DegreeRequirement`

Stores required courses for a major and checks which courses are still missing.

### `CourseDataLoader`

Loads sample course data into the program.

### `CoursePlannerApp`

Provides the console menu interface.

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/Kune2707/myUW-Degree-Planner-Java.git
```

2. Open the project in IntelliJ IDEA, VS Code, or another Java IDE.

3. Run `Main.java`.

## Example Menu

```text
===== myUW Degree Planner =====
1. Show all courses
2. Show completed courses
3. Add completed course by code
4. Check if I can take a course
5. Add course to quarter
6. Show academic plan
7. Show degree progress
8. Exit
```

## Current Status

The core OOP backend logic and console menu are working.

Completed so far:

* Course model
* Student model
* Course catalog
* Prerequisite checking
* Quarter planning
* Academic planning
* Degree requirement tracking
* Degree progress percentage
* Console menu interface

## Future Improvements

Some features I would like to add later:

* JavaFX GUI
* Loading course data from CSV files
* Saving and loading academic plans
* More realistic UW course data
* Course recommendation logic
* Support for planned prerequisites
* Better input validation
* Unit tests
