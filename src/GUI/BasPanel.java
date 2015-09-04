/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BasPanel extends JPanel {
    
    public final JLabel scoreLabel = new JLabel("Bienvenue !", JLabel.CENTER);
    public final JButton lancerButton = new JButton("Mélanger !");
    
    private GamePanel gamePanel;

    public BasPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        setLayout(new GridLayout(1, 3));
        
        lancerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resetPlateau();
            }
        });
        
        JButton quitterButton = new JButton("Quitter");
        quitterButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
        add(lancerButton);
        add(scoreLabel);
        add(quitterButton);
    }
    
    public void setScore(){
        this.scoreLabel.setText("Score :" + thepinksoldier.Constante.score);
    }
    
    public void resetPlateau(){
        gamePanel.resetPlateau();
    }
    
    

}
