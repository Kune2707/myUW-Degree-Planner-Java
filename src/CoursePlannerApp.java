import java.util.Scanner;

public class CoursePlannerApp {
    private CourseCatalog catalog;
    private Student student;
    private DegreeRequirement requirement;
    private AcademicPlan academicPlan;
    private CoursePlanner planner;
    private Scanner scanner;

    public CoursePlannerApp(
            CourseCatalog catalog,
            Student student,
            DegreeRequirement requirement,
            AcademicPlan academicPlan,
            CoursePlanner planner
    ) {
        this.catalog = catalog;
        this.student = student;
        this.requirement = requirement;
        this.academicPlan = academicPlan;
        this.planner = planner;
        this.scanner = new Scanner(System.in);
    }
    public void run() {
        boolean running = true;

        while (running) {
            printMenu();

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                catalog.showAllCourses();
            } else if (choice == 2) {
                student.showCompletedCourses();
            } else if (choice == 3) {
                addCompletedCourseByCode();
            } else if (choice == 4) {
                checkCourseEligibility();
            } else if (choice == 5) {
                addCourseToQuarter();
            } else if (choice == 6) {
                academicPlan.showFullPlan();
            } else if (choice == 7) {
                planner.showDegreeProgress(student, requirement);
                planner.printProgressPercentage(student, requirement);
            } else if (choice == 8) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        }
    }
    private void printMenu(){
        System.out.println("===== myUW Degree Planner =====");
        System.out.println("1. Show all courses");
        System.out.println("2. Show completed courses");
        System.out.println("3. Add completed course by code");
        System.out.println("4. Check if I can take a course");
        System.out.println("5. Add course to quarter");
        System.out.println("6. Show academic plan");
        System.out.println("7. Show degree progress");
        System.out.println("8. Exit");
    }
    private void addCompletedCourseByCode() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

        Course course = catalog.findCourseByCode(courseCode);

        if (course == null) {
            System.out.println("Course not found: " + courseCode);
            return;
        }

        student.addCompletedCourse(course);
        System.out.println(course.getCode() + " added to completed courses.");
    }
    private void checkCourseEligibility() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

        Course course = catalog.findCourseByCode(courseCode);

        if (course == null) {
            System.out.println("Course not found: " + courseCode);
            return;
        }

        planner.printReport(student, course);
    }

    private void addCourseToQuarter() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

        System.out.print("Enter quarter name: ");
        String quarterName = scanner.nextLine();

        planner.addCourseToQuarterByCode(
                student,
                courseCode,
                quarterName,
                catalog,
                academicPlan
        );
    }
}

