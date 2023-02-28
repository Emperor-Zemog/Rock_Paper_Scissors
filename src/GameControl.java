import java.util.ArrayList;

public class GameControl {
    int userChoice=0;
    int minChoice =0;
    int userWins=0;
    int minervaWins=0;
    int ties=0;
    boolean playerWin= false;
    boolean minervaWin =false;
    boolean tie = false;
    ArrayList<Integer> usePast = new ArrayList<Integer>();
    ArrayList<Integer> minPast = new ArrayList<Integer>();
    ArrayList<String> gamePast = new ArrayList<String>();
    public GameControl(){}
    public void calculateResult(int uChoice, int mChoice){
        this.userChoice=uChoice;
        this.minChoice=mChoice;
        if((uChoice== 0 && mChoice==1)||(uChoice== 1 && mChoice==2)||(uChoice== 2 && mChoice==0) ){
            this.tie=false;
            this.minervaWin=true;
            this.playerWin=false;
            this.minervaWins ++;
        }
        else if((mChoice== 0 && uChoice==1)||(mChoice== 1 && uChoice==2)||(mChoice== 2 && uChoice==0) ){
            this.tie=false;
            this.minervaWin=false;
            this.playerWin=true;
            this.userWins++;

        }
        else if( mChoice == uChoice){
            this.tie=true;
            this.minervaWin=false;
            this.playerWin=false;
            this.ties ++;
        }



    }
    public String getResult(String minervaStrat){
        String outcome = "";
        String winner="";
        String winStrat="";
        if (this.minervaWin==true){
            winner="(Computer Wins "+minervaStrat+")";

        } else if (this.playerWin==true) {
            winner="(Player Wins "+minervaStrat+")";

        } else if (this.tie==true) {
            winner="(Tie"+minervaStrat+")";

        }
        if((this.minChoice==0 && this.userChoice==1)||(this.minChoice==1 && this.userChoice==0)){
            winStrat="Paper covers Rock ";
        } else if ((this.minChoice==1 && this.userChoice==2)||(this.minChoice==2 && this.userChoice==1)) {
            winStrat="Scissors cut Paper ";
        }else if ((this.minChoice==2 && this.userChoice==0)||(this.minChoice==0 && this.userChoice==2)) {
            winStrat="Rock breaks Scissors ";
        } else if (this.minChoice==0 && this.userChoice==0) {
            winStrat="Both chose Rock ";
        }else if (this.minChoice==1 && this.userChoice==1) {
            winStrat="Both chose Paper ";
        }else if (this.minChoice==2 && this.userChoice==2) {
            winStrat="Both chose Scissors ";
        }
        outcome=winStrat+winner;
        return outcome;
    }

    public int getTies() {
        return ties;
    }

    public int getMinervaWins() {
        return minervaWins;
    }

    public int getUserWins() {
        return userWins;
    }
}
