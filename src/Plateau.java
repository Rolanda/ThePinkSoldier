/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import thepinksoldier.Forme;
import thepinksoldier.Plateau;

/**
 *
 * @author lopezb
 */
public class GamePanel extends JPanel implements MouseListener{
    
    private Plateau plateau;
    private Forme[] clics;
    
    public GamePanel(){
        setFocusable(true);
        addMouseListener(this);
        setBackground(Color.BLACK);
        this.plateau = new Plateau(10,10);
        do {
            plateau.glisser();
        } while (plateau.destruction());
        this.clics = new Forme[2];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
//        for(Forme[] i : plateau.getGrille())
//            for(Forme j : i){
        for(int i = 0 ; i < plateau.getGrille().length ; i++){
            for(int j = 0 ; j < plateau.getGrille()[i].length ; j++){
                g.setColor(plateau.getGrille()[i][j].getGraphiqueColor());
                //g.fillOval(j.getX()*getWidth()/plateau.getX(), j.getY()*getHeight()/plateau.getY(), getWidth()/plateau.getX(), getHeight()/plateau.getY());
                switch(plateau.getGrille()[i][j].getNom()){
                    case "rond":
                        g.fillOval(j*getWidth()/plateau.getX(), i*getHeight()/plateau.getY(), getWidth()/plateau.getX(), getHeight()/plateau.getY());
                        break;
                    case "carre":
                        g.fillRect(j*getWidth()/plateau.getX(), i*getHeight()/plateau.getY(), getWidth()/plateau.getX(), getHeight()/plateau.getY());
                        break;
                    case "triangle":
                        g.fillPolygon(new int[]{j*getWidth()/plateau.getX()+70, j*getWidth()/plateau.getX()+35, j*getWidth()/plateau.getX()}, new int[]{i*getHeight()/plateau.getY()+55, i*getHeight()/plateau.getY(), i*getHeight()/plateau.getY()+55}, 3);
                        break;
                    case "losange":
                        g.fillPolygon(new int[]{j*getWidth()/plateau.getX()+5, j*getWidth()/plateau.getX()+35, j*getWidth()/plateau.getX()+65, j*getWidth()/plateau.getX()+35}, new int[]{i*getHeight()/plateau.getY()+27, i*getHeight()/plateau.getY(), i*getHeight()/plateau.getY()+27, i*getHeight()/plateau.getY()+55}, 4);
                        break;
                    case "Vide":
                        

                    int [] x = new int[]{70,45,35,25,0,15,0,15,0,25,35,45,70,55,70,55};
                    
                    for(int i=0; i<x.length();i++){
                    
                    	x[i]+=j.getX()*getWidth()/plateau.getX();
                    }
                    
                    int [] y = new int[]{70,55,70,55,70,45,35,25,0,15,0,15,0,25,35,45};
                    
                    
                    for(int i=0; i<x.length();i++){
                    
                    	y[i]+=j.getY()*getHeight()/plateau.getY();
                    }
                    
                    
                    g.fillPolygon(x,y, 16);
                                            
                    break;
                }
            }
        }
    }
    
    public void choixClic(int x, int y){
        if(clics[0] == null){
            clics[0] = plateau.getGrille()[y/(getHeight()/plateau.getY())][x/(getWidth()/plateau.getX())];
            //plateau.destruction();
            //repaint();
        }else  {
            clics[1] = plateau.getGrille()[y/(getHeight()/plateau.getY())][x/(getWidth()/plateau.getX())];
            plateau.deplacer(clics[0], clics[1]);
            plateau.destruction();
            //plateau.glisser();
            //repaint();
            clics[0] = null;
            clics[1] = null;
            repaint();
        }
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(e.getX()/(getWidth()/plateau.getX()) + "\t" + e.getY()/(getHeight()/plateau.getY()));
        choixClic(e.getX(), e.getY());
        System.out.println(e.getX() + "\t" + e.getY());
        //System.out.println(e.getX()/getWidth()/plateau.getX());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
