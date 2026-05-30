import java.util.ArrayList;

public class CourseCatalog {
    private ArrayList<Course> courses;
    public CourseCatalog(){
        this.courses = new ArrayList<>();
    }
    public void addCourse(Course course){
        if (hasCourse(course)){
            System.out.println("Course already added!");
            return;
        }
            courses.add(course);
    }
    public Course findCourseByCode(String courseCode){
        int index = findCourseIndexByCode(courseCode);
        if (index == -1){
            return null;
        }
        return courses.get(index);
    }
    public boolean hasCourse(Course course){
       return hasCourse(course.getCode());
    }
    public boolean hasCourse(String courseCode){
        for (int i = 0 ; i < courses.size(); i++){
            if (courses.get(i).getCode().trim().equalsIgnoreCase(courseCode.trim())){
                return true;
            }
        }
        return false;
    }
   private int findCourseIndexByCode(String courseCode){
        for (int i = 0; i < courses.size(); i++){
            if (courses.get(i).getCode().trim().equalsIgnoreCase(courseCode.trim())){
                return i;
            }
        }
        return -1;
    }
    public void showAllCourses(){
        if (courses.isEmpty()){
            System.out.println("No courses in catalog.");
            return;
        }
        for (int i = 0; i < courses.size(); i++){
            System.out.println(courses.get(i).showInfo());
        }
    }
    public int getCourseCount(){
        return courses.size();
    }
}
