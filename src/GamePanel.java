/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private final Timer refreshTimer;
    
    public GamePanel(){
        setFocusable(true);
        addMouseListener(this);
        setBackground(Color.BLACK);
        this.plateau = new Plateau(10,10);
        do {
            plateau.glisser();
        } while (plateau.destruction());
        this.clics = new Forme[2];
        
        refreshTimer = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                graphDestruction();
            }
        });

        refreshTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0 ; i < plateau.getGrille().length ; i++){
            for(int j = 0 ; j < plateau.getGrille()[i].length ; j++){
                g.setColor(plateau.getGrille()[i][j].getGraphiqueColor());
                if(plateau.getGrille()[i][j] == clics[0])
                    g.setColor(Color.YELLOW);
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
                        g.setColor(Color.WHITE);
                        g.setFont(new Font(getFont().getName(), getFont().getStyle(), 74));
                        g.drawString("★", j*getWidth()/plateau.getX(), (i+1)*getHeight()/plateau.getY());                   
                    break;
                        
                }
            }
        }
    }
    
    public void choixClic(int x, int y){
        if(clics[0] == null){
            clics[0] = plateau.getGrille()[y/(getHeight()/plateau.getY())][x/(getWidth()/plateau.getX())];
            //plateau.destruction();
            repaint();
        }else  {
            clics[1] = plateau.getGrille()[y/(getHeight()/plateau.getY())][x/(getWidth()/plateau.getX())];
            plateau.deplacer(clics[0], clics[1]);
            graphDestruction();
            clics[0] = null;
            clics[1] = null;
            
        }
    }
    
    public void graphDestruction(){
        if(plateau.destruction()){
                repaint();
                Timer waitDestruction = new Timer(1000, new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        plateau.glisser();
                        repaint();
                        ((Timer)e.getSource()).stop();
                    }
                });
                waitDestruction.start();
        
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
        //System.out.println(e.getX()/(getWidth()/plateau.getX()) + "\t" + e.getY()/(getHeight()/plateau.getY()));
        choixClic(e.getX(), e.getY());
        //System.out.println(e.getX() + "\t" + e.getY());
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
