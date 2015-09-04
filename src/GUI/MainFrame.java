/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
    
    public BasPanel basPanel;
    public GamePanel gamePanel;
    
    public MainFrame(){
        setSize(702, 624);
        setTitle("The Pink Soldier");
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);
        
        getContentPane().setLayout(new BorderLayout());
        
        gamePanel = new GamePanel();
        basPanel = new BasPanel(gamePanel);
        gamePanel.setBasPanel(basPanel);
        
        getContentPane().add(basPanel, BorderLayout.SOUTH);
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
}
