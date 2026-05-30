import java.util.ArrayList;

public class AcademicPlan {
    private ArrayList<QuarterPlan> quarters;
    public AcademicPlan(){
        this.quarters = new ArrayList<>();
    }
    public void addQuarter(QuarterPlan quarter){
        if (hasQuarter(quarter.getQuarterName())){
            System.out.println("This quarter has already added");
            return;
        }
        quarters.add(quarter);
    }
    public boolean hasQuarter(String quarterName){
        for (int i = 0 ; i < quarters.size(); i++){
            if (quarters.get(i).getQuarterName().trim().equalsIgnoreCase(quarterName.trim())){
                return true;
            }
        }
        return false;
    }
    public QuarterPlan findQuarter(String quarterName){
        for (int i = 0 ; i < quarters.size(); i++){
            if (quarters.get(i).getQuarterName().trim().equalsIgnoreCase(quarterName.trim())){
                return quarters.get(i);
            }
        }
        return null;
    }
    public int getTotalPlannedCredits(){
        int total = 0;
        for (int i = 0 ; i < quarters.size(); i++){
            total += quarters.get(i).getTotalCredits();
        }
        return total;
    }
    public void showFullPlan(){
        if (quarters.isEmpty()){
            System.out.println("No quarters in academic plan.");
            return;
        }
        for (int i = 0; i < quarters.size(); i ++){
           quarters.get(i).showPlan();
        }
        System.out.println("Your total credit is: " + getTotalPlannedCredits());
    }
    public int getQuarterCount(){
        return quarters.size();
    }
}
