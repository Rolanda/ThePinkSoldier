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
        this.clics = new Forme[2];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        for(Forme[] i : plateau.getGrille())
            for(Forme j : i){
                g.setColor(j.getGraphiqueColor());
                //g.fillOval(j.getX()*getWidth()/plateau.getX(), j.getY()*getHeight()/plateau.getY(), getWidth()/plateau.getX(), getHeight()/plateau.getY());
                switch(j.getNom()){
                    case "rond":
                        g.fillOval(j.getX()*getWidth()/plateau.getX(), j.getY()*getHeight()/plateau.getY(), getWidth()/plateau.getX(), getHeight()/plateau.getY());
                        break;
                    case "carre":
                        g.fillRect(j.getX()*getWidth()/plateau.getX(), j.getY()*getHeight()/plateau.getY(), getWidth()/plateau.getX(), getHeight()/plateau.getY());
                        break;
                    default:
                        g.fillPolygon(new int[]{j.getX()*getWidth()/plateau.getX()+70, j.getX()*getWidth()/plateau.getX()+35, j.getX()*getWidth()/plateau.getX()}, new int[]{j.getY()*getHeight()/plateau.getY()+55, j.getY()*getHeight()/plateau.getY(), j.getY()*getHeight()/plateau.getY()+55}, 3);
                        break;
                    case "losange":
                        g.fillPolygon(new int[]{j.getX()*getWidth()/plateau.getX()+5, j.getX()*getWidth()/plateau.getX()+35, j.getX()*getWidth()/plateau.getX()+65, j.getX()*getWidth()/plateau.getX()+35}, new int[]{j.getY()*getHeight()/plateau.getY()+27, j.getY()*getHeight()/plateau.getY(), j.getY()*getHeight()/plateau.getY()+27, j.getY()*getHeight()/plateau.getY()+55}, 4);
                        break;
                }
            }
    }
    
    public void choixClic(int x, int y){
        if(clics[0] == null){
            clics[0] = plateau.getGrille()[x/plateau.getX()/(getWidth()/100)][y/plateau.getY()/(getHeight()/100)];
        }else  {
            clics[1] = plateau.getGrille()[x/plateau.getX()/(getWidth()/100)][y/plateau.getY()/(getHeight()/100)];
            plateau.deplacer(clics[0], clics[1]);
            clics[0] = null;
            clics[1] = null;
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
        System.out.println(e.getX()/plateau.getX()/(getWidth()/100) + "\t" + e.getY()/plateau.getY()/(getHeight()/100));
        //choixClic(e.getX(), e.getY());
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
