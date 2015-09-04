/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.JFrame;

/**
 *
 * @author lopezb
 */
public class MainFrame extends JFrame{
    
    public MainFrame(){
        setSize(700, 600);
        setTitle("The Pink Soldier");
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);
        //getContentPane().setLayout(new BorderLayout());
        
        getContentPane().add(new GamePanel());
        
        setVisible(true);
    }
    
}
