/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thepinksoldier;

import java.awt.Color;

/**
 *
 * @author lopezb
 */
public class Forme {
	
	private char image;
	private String nom = "";
	private int x,y;
        private int position_X, position_Y;
        private Color graphiqueColor;
	private String couleur="";
	
	Forme(String nom , int x, int y ){
		this.nom = nom;
		this.y = y;
		this.x = x;
		this.image = representation(nom);
	}
	
	public char representation(String nom){
		if(nom.equals("rond")){
			this.couleur = Constante.ANSI_BLUE;
                        this.graphiqueColor = Color.BLUE;
			return '●';
		}else if(nom.equals("triangle")){
			this.couleur = Constante.ANSI_GREEN;
                        this.graphiqueColor = Color.GREEN;
			return '▲';
		}else if(nom.equals("carre")){
			this.couleur = Constante.ANSI_RED;
                        this.graphiqueColor = Color.RED;
			return '■';
		}else if(nom.equals("losange")){
			this.couleur = Constante.ANSI_PURPLE;
                        this.graphiqueColor = new Color(133, 85, 218);
			return '♦';
		}
		return '★';
		
	}
	
	public String getCouleur(){
		return this.couleur;
	}
        
        public Color getGraphiqueColor(){
            return this.graphiqueColor;
        }
        
	public String getNom(){
		return nom;
	}
	public void setCouleur(String s){
		this.couleur=s;
	}
	
	public int getX(){
		return this.x;
	}
	
	
	public int getY(){
		return this.y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.x = y;
	}
	
	public String toString(){
		return ""+image;
	}
	public boolean equals(Forme f){
		if(this.nom.equals(f.nom)){
			return true;
		}
		return false;
	}

}
