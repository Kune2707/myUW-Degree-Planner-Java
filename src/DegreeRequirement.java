import java.util.ArrayList;

public class DegreeRequirement {
    private ArrayList<Course> requiredCourses;
    private String majorName;
    public DegreeRequirement(String majorName){
        this.majorName = majorName;
        this.requiredCourses = new ArrayList<>();
    }
    public void addRequiredCourse(Course course){
        if (hasRequiredCourse(course)){
            System.out.println("Course already been added");
            return;
        }
        requiredCourses.add(course);
    }
    public String getMajorName(){
        return majorName;
    }
    public ArrayList<Course> getRequiredCourses(){
        return new ArrayList<Course>(requiredCourses);
    }
    public boolean hasRequiredCourse(Course course){
       if (course == null){
           return false;
       }
       return hasRequiredCourse(course.getCode());
    }
    public boolean hasRequiredCourse(String courseCode){
        if (requiredCourses.isEmpty()){
            return false;
        }
        if (courseCode == null){
            return false;
        }
        for (int i = 0 ; i  < requiredCourses.size(); i++){
            if (requiredCourses.get(i).getCode().trim().equalsIgnoreCase(courseCode.trim())){
                return true;
            }
        }
        return false;
    }
    public ArrayList<Course> getRemainingCourses(Student student){
        ArrayList<Course> remainingCourses = new ArrayList<>(requiredCourses);
        for (int i = 0; i < student.getCompletedCourses().size(); i++){
            if (hasRequiredCourse(student.getCompletedCourses().get(i))){
                remainingCourses.remove(student.getCompletedCourses().get(i));
            }
        }
        return remainingCourses;
    }
    public void showRemainingRequiredCourses(Student student){
        ArrayList<Course> remainingCourses = getRemainingCourses(student);
        if (remainingCourses.isEmpty()){
            System.out.println(student.getStudentName() + " has completed all requirements for " + getMajorName() + ".");
            return;
        }
        System.out.println( student.getStudentName()+  "'s Remaining course for: " + getMajorName());
        for (int i = 0 ; i < remainingCourses.size(); i++){
            System.out.println(remainingCourses.get(i).showInfo());
        }
    }
    public boolean isCompletedBy(Student student){
        return getRemainingCourses(student).isEmpty();
    }
    public void showRequirements(){
        if (requiredCourses.isEmpty()){
            System.out.println("No requirement for: " + getMajorName());
            return;
        }
        System.out.println("Requirement for " + getMajorName());
        for (int i = 0 ; i < requiredCourses.size(); i++){
            System.out.println(requiredCourses.get(i).showInfo());
        }
    }
}
