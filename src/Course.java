import java.util.ArrayList;

public class Course {
    private String code;
    private String title;
    private int credits;
    private String department;
    private ArrayList<String> prerequisites;
    public Course(){
        this.code = "unknown";
        this.title = "unknown";
        this.credits = 0;
        this.department = "unknown";
        this.prerequisites = new ArrayList<>();

    }
    public Course(String code, String title, int credits, String department){
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.department = department;
        this.prerequisites = new ArrayList<>();
    }
    public String getCode(){
        return code;
    }
    public String getTitle(){
        return title;
    }
    public int getCredits(){
        return credits;
    }
    public String getDepartment(){
        return department;
    }
    public String showInfo(){
        return getCode() + " - " + getTitle() + " Department: " + getDepartment() + " Credits: " + getCredits();
    }
    public void addPrerequisite(String courseCode){
        if (hasPrerequisite(courseCode)){
            System.out.println("Already added!");
            return;
        }
        prerequisites.add(courseCode);
    }
    public boolean hasPrerequisite(String courseCode){
        for (int i = 0; i < prerequisites.size(); i++){
            if (prerequisites.get(i).trim().equalsIgnoreCase(courseCode.trim())){
                return true;
            }
        }
        return false;
    }
    public ArrayList<String> getPrerequisites() {
        return new ArrayList<>(prerequisites);
    }
    public boolean hasAnyPrerequisites(){
        return !(prerequisites.isEmpty());
    }
    public void showPrerequisites(){
        if (!(hasAnyPrerequisites())){
            System.out.println("No pre req for " + code);
            return;
        }
        System.out.println("Prerequisites for " + code + ":");
        for (int i = 0; i < prerequisites.size(); i++){
            System.out.println(prerequisites.get(i));
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
        if (!(obj instanceof Course)){
            return false;
        }
        Course other = (Course) obj;
        return this.code.trim().equalsIgnoreCase(other.code.trim());
    }
    @Override
    public int hashCode(){
        return code.trim().toUpperCase().hashCode();
    }


}
