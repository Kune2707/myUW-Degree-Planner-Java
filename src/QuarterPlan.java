import java.util.ArrayList;

public class QuarterPlan {
    private ArrayList<Course> plannedCourses;
    private String quarterName;
    public QuarterPlan(String quarterName){
        this.quarterName = quarterName;
        this.plannedCourses = new ArrayList<>();
    }
    public String getQuarterName(){
        return quarterName;
    }
    public ArrayList<Course> getPlannedCourses(){
        return new ArrayList<>(plannedCourses);
    }
    public void addCourse(Course course){
        if (hasCourse(course.getCode())){
            System.out.println("Course already added!");
            return;
        }
        plannedCourses.add(course);
    }
    public boolean hasCourse(String courseCode){
        if (plannedCourses.isEmpty()){
            return false;
        }
        for (int i = 0 ; i < plannedCourses.size(); i++){
            if (plannedCourses.get(i).getCode().trim().equalsIgnoreCase(courseCode.trim())){
                return true;
            }
        }
        return false;
    }
    public boolean hasCourse(Course course){
        return hasCourse(course.getCode());
    }
    public int getTotalCredits(){
        int total = 0 ;
        for (int i = 0; i < plannedCourses.size(); i++){
            total += plannedCourses.get(i).getCredits();
        }
        return total;
    }
    public boolean isOverloaded(){
        int total = getTotalCredits();
        if (total > 18){
            return true;
        }
        return false;
    }
    public void showPlan(){
        if (plannedCourses.isEmpty()){
            System.out.println("No course planned for " + getQuarterName());
            return;
        }
        System.out.println("Plan for " + getQuarterName());
        for (int i = 0 ; i < plannedCourses.size(); i++){
            System.out.println(plannedCourses.get(i).showInfo());
        }
        System.out.println("Your total credits: " + getTotalCredits());
        if (isOverloaded()){
            System.out.println("Warning: overloaded");
        }
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof QuarterPlan)){
            return false;
        }
        QuarterPlan other = (QuarterPlan) obj;
        return this.getQuarterName().trim().equalsIgnoreCase(other.getQuarterName().trim());
    }
    @Override
    public int hashCode(){
        return getQuarterName().trim().toUpperCase().hashCode();
    }
}
