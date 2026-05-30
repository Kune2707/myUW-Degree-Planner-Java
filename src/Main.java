public class Main {
    public static void main(String[] args) {
        CourseCatalog catalog = new CourseCatalog();
        CourseDataLoader.loadSampleCourses(catalog);

        Student student = new Student("Loi", "Computer Science");

        DegreeRequirement requirement = new DegreeRequirement("Computer Science");
        CourseDataLoader.loadSampleDegreeRequirement(requirement, catalog);

        AcademicPlan academicPlan = new AcademicPlan();
        academicPlan.addQuarter(new QuarterPlan("Autumn 2026"));
        academicPlan.addQuarter(new QuarterPlan("Winter 2027"));
        academicPlan.addQuarter(new QuarterPlan("Spring 2027"));

        CoursePlanner planner = new CoursePlanner();

        CoursePlannerApp app = new CoursePlannerApp(
                catalog,
                student,
                requirement,
                academicPlan,
                planner
        );

        app.run();
    }
}