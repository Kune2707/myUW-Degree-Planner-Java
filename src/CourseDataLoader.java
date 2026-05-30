public class CourseDataLoader {

    public static void loadSampleCourses(CourseCatalog catalog) {
        Course cse142 = new Course("CSE 142", "Computer Programming I", 4, "CSE");
        Course cse143 = new Course("CSE 143", "Computer Programming II", 4, "CSE");
        Course cse331 = new Course("CSE 331", "Software Design and Implementation", 4, "CSE");
        Course cse332 = new Course("CSE 332", "Data Structures and Parallelism", 4, "CSE");

        Course math151 = new Course("MATH 151", "Calculus I", 5, "MATH");
        Course math152 = new Course("MATH 152", "Calculus II", 5, "MATH");

        cse143.addPrerequisite("CSE 142");
        cse331.addPrerequisite("CSE 143");
        cse332.addPrerequisite("CSE 143");
        math152.addPrerequisite("MATH 151");

        catalog.addCourse(cse142);
        catalog.addCourse(cse143);
        catalog.addCourse(cse331);
        catalog.addCourse(cse332);
        catalog.addCourse(math151);
        catalog.addCourse(math152);
    }
    public static void loadSampleDegreeRequirement(DegreeRequirement requirement, CourseCatalog catalog) {
        addRequirementIfFound(requirement, catalog, "CSE 142");
        addRequirementIfFound(requirement, catalog, "CSE 143");
        addRequirementIfFound(requirement, catalog, "CSE 331");
        addRequirementIfFound(requirement, catalog, "CSE 332");
        addRequirementIfFound(requirement, catalog, "MATH 151");
        addRequirementIfFound(requirement, catalog, "MATH 152");
    }
    private static void addRequirementIfFound(
            DegreeRequirement requirement,
            CourseCatalog catalog,
            String courseCode
    ) {
        Course course = catalog.findCourseByCode(courseCode);

        if (course == null) {
            System.out.println("Required course not found: " + courseCode);
            return;
        }

        requirement.addRequiredCourse(course);
    }
}