import java.util.ArrayList;

public class Student {
    private String name;
    private String major;
    private ArrayList<Course> completedCourses;
    public Student(String name, String major){
        this.name = name;
        this.major = major;
        this.completedCourses = new ArrayList<>();
    }
    public String getStudentName() {
        return name;
    }
    public String getMajor(){
        return major;
    }
    public ArrayList<Course> getCompletedCourses(){
        return new ArrayList<>(completedCourses);
    }
    public void addCompletedCourse(Course course){
        if (!hasCompleted(course)){
            completedCourses.add(course);
            return;
        }
        if (hasCompleted(course)) {
            System.out.println("You have completed this!");
        }
    }
    public void showCompletedCourses(){
        if (completedCourses.isEmpty()){
            System.out.println("No course completed");
            return;
        }
        for (int i = 0; i < completedCourses.size(); i++){
            System.out.println(completedCourses.get(i).showInfo());
        }
    }
    public int getCompletedCourseCount(){
        int count = 0;
        for (int i = 0 ; i < completedCourses.size(); i++){
            count++;
        }
        return count;
    }
    public boolean hasCompleted(Course course){
        return hasCompleted(course.getCode());
    }
    public int getTotalCompletedCredits(){
        int total = 0;
        for (int i = 0 ; i < completedCourses.size(); i++){
            total += completedCourses.get(i).getCredits();
        }
        return total;
    }
    public boolean hasCompleted(String courseCode){
        for (int i = 0; i < completedCourses.size(); i++){
            if (completedCourses.get(i).getCode().trim().equalsIgnoreCase(courseCode.trim())){
                return true;
            }
        }
        return false;
    }

}
