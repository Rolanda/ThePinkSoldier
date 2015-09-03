import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author lopezb
 */
public class Score extends Thread {
    
    private int score;
    int temps;
    private Timer timer;
    
    public Score(){
        super();
        this.score = 0;
        this.temps = 120;
        this.timer = new Timer();
    }
    
    public void run(){
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                temps--;
                showScore();
            }
        }, 0, 1000);
    }
    
    public void showScore(){
        //print((new StringBuilder()).append("\033[").append(5).append(";").append(20).append("H").toString());
        char escCode = 0x1B;
        System.out.print(String.format("%c[%d;%df",escCode,10,50));
        System.out.print("\033[0K");
        System.out.print("Score : " + this.score + "  Temps : " + this.temps);
        System.out.print(String.format("%c[%d;%df",escCode,10,1));
        //System.out.print("\033[2K");
    }
    
    public void addPoints(int ajout){
        this.score += ajout;
    }
    
    public int getScore(){
        return this.score;
    }
    
    
}
