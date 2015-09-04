/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thepinksoldier;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author lopezb
 */
public class Score extends Thread {
    
    int temps;
    private final Timer timer;
    
    public Score(){
        super();
        this.temps = 120;
        this.timer = new Timer();
    }
    
    public void run(){
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                temps--;
                showScore();
            }
        }, 0, 1000);
    }
    
    public void showScore(){
        char escCode = 0x1B;
        System.out.print(String.format("%c[%d;%df",escCode,10,50));
        System.out.print("\033[0K");
        System.out.print("Score : " + Constante.score + "  Temps : " + this.temps);
        System.out.print(String.format("%c[%d;%df",escCode,20,1));
    }
    
    
}
