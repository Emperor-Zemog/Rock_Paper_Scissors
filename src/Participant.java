import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
public class Participant {
    boolean awake;
    String usedStrat="";
    public Participant(boolean awaken){
        this.awake=awaken;
    }
    public Integer getChoice(int userChoice, ArrayList<Integer> userPrevious){
        int choice =0;
        Random rand = new Random();
        if (awake==true){
            double strat = rand.nextDouble(10);
            if(strat<=(1.0)){
                choice=getCheat(userChoice);
                usedStrat="Cheating";
            } else if (strat>1.0 && strat <=3.25) {
                choice=getLeast();
                usedStrat="Least Used";
            } else if (strat>3.25 && strat <=5.5) {
                choice=getMost();
                usedStrat="Most Used";
            } else if (strat>5.5 && strat <=7.75) {
                if(userPrevious.size()==0){
                    choice = rand.nextInt(3);
                    usedStrat="Random";
                }else {
                    choice = getLast(userPrevious);
                    usedStrat="Last Used";
                }
            }else{
                choice = rand.nextInt(3);
                usedStrat="Random";
            }

        }else{
            choice = rand.nextInt(3);
        }
        return choice;
    }
    private Integer getLast(ArrayList<Integer> userPrevious){
        int choice=userPrevious.get(userPrevious.size()-1);
        return choice;
    }
    private Integer getMost(){
        int choice=0;
        return choice;
    }
    private Integer getLeast(){
        int choice=0;
        return choice;
    }
    private Integer getCheat(int userChoice){
        int choice=0;
        return choice;
    }
    public void setAwake(boolean awaken){
        this.awake=awaken;
    }

    public String getUsedStrat() {
        return usedStrat;
    }
}
