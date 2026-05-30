import java.util.ArrayList;

public class CoursePlanner {
    public boolean canTakeCourse(Student student, Course course){
        if (!course.hasAnyPrerequisites()){
            return true;
        }
        int preReqCount = course.getPrerequisites().size();
        int i = 0;
        while (preReqCount > 0 && i < course.getPrerequisites().size()){
            if (student.hasCompleted(course.getPrerequisites().get(i))){
                preReqCount --;
            }
            i++;
        }
        if (preReqCount == 0){
            return true;
        }
        return false;
    }
    public void showMissingPrerequisites(Student student, Course course){
        if (!course.hasAnyPrerequisites()){
            System.out.println("No prerequisites needed!");
            return;
        }
        ArrayList<String> missingPrereq = getMissingPrerequisites(student,course);
        if (missingPrereq.isEmpty()){
            System.out.println("You have completed all prerequisites for " + course.getCode());
            return;
        }
        System.out.println("Missing prerequisites for: " + course.getCode() + ".");
        for (int i = 0 ; i < missingPrereq.size(); i++){
            System.out.println(missingPrereq.get(i));
        }
    }
    public ArrayList<String> getMissingPrerequisites(Student student, Course course){
        if (!course.hasAnyPrerequisites()){
            return new ArrayList<>();
        }
        ArrayList<String> missingPrerequisites = new ArrayList<>();
        for (int i = 0; i < course.getPrerequisites().size(); i++){
            String classCode = course.getPrerequisites().get(i);
            if (!(student.hasCompleted(classCode))){
                missingPrerequisites.add(classCode);
            }
        }
        return missingPrerequisites;
    }
    public void showDegreeProgress(Student student, DegreeRequirement degreeRequirement){
        if (degreeRequirement.isCompletedBy(student)){
            System.out.println(student.getStudentName() + " has completed all requirements for " + degreeRequirement.getMajorName() + ".");
            return;
        }
        System.out.println("Degree progress for " + degreeRequirement.getMajorName() + ".");
        degreeRequirement.showRemainingRequiredCourses(student);

    }
    public double getProgressPercentage(Student student, DegreeRequirement degreeRequirement){
        ArrayList<Course> remaining = degreeRequirement.getRemainingCourses(student);
        ArrayList<Course> totalCourses = degreeRequirement.getRequiredCourses();
        double progressCheck = totalCourses.size() - remaining.size();
        if (totalCourses.isEmpty()){
            return 0.0;
        }
        double percentageCompleted = (progressCheck / totalCourses.size()) * 100;
        return percentageCompleted;
    }
    public void printProgressPercentage (Student student, DegreeRequirement degreeRequirement){
        double percentageCompleted = getProgressPercentage(student,degreeRequirement);
        System.out.println(percentageCompleted + "% completed for "+ degreeRequirement.getMajorName() );
    }
    public void addCourseToQuarter(Student student, Course course, QuarterPlan quarter){
       if (!canTakeCourse(student, course)){
           System.out.println("Cannot add this class to the quarter!");
           showMissingPrerequisites(student,course);
           return;
       }
        quarter.addCourse(course);
        quarter.showPlan();

    }
    public void addCourseToQuarterByCode(
            Student student,
            String courseCode,
            String quarterName,
            CourseCatalog catalog,
            AcademicPlan academicPlan
    ){
        Course courseCheck = catalog.findCourseByCode(courseCode);
        if (courseCheck == null){
            System.out.println("Course not found for " + courseCode);
            return;
        }
        QuarterPlan quarterCheck = academicPlan.findQuarter(quarterName);
        if (quarterCheck == null){
            System.out.println("Quarter not found: " + quarterName);
            return;
        }
        addCourseToQuarter(student,courseCheck,quarterCheck);

    }
    public void printReport(Student student, Course course){
        if (canTakeCourse(student,course)){
            System.out.println("You can take: " + course.getCode());
            return;
        }
        System.out.println("You cannot take " + course.getCode() +" yet.");
        showMissingPrerequisites(student,course);
    }
}
