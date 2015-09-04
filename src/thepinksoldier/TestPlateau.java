// Fonctionne pas très bien !


package thepinksoldier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPlateau {
	
	Plateau test;
	Forme forme;
	
	@Before
	public void initPlateau(){
		test = new Plateau(10,10);
		for(int i = 0; i < 3; i++){
			test.getGrille()[i][0] = new Forme("carre", i, 0);
			test.getGrille()[5][i] = new Forme("triangle", 5, i);
			test.getGrille()[7][i + 2] = new Forme("rond", 7, i + 2);
		}
	}

	
	@Test
	public void testDeplacer(){
		Forme a = test.getGrille()[6][6];
		Forme b = test.getGrille()[6][7];
		test.deplacer(a, b);
		assertTrue("deplacment effectué", test.getGrille()[6][6].getNom().equals(b.getNom()) &&test.getGrille()[6][7].getNom().equals(a.getNom()));
		Forme c = test.getGrille()[2][9];
		Forme d = test.getGrille()[2][2];
		test.deplacer(c, d);
		assertTrue("deplacement non autorisé non effectué", test.getGrille()[2][2].getNom().equals(d.getNom()) && test.getGrille()[2][9].getNom().equals(c.getNom()));
	}
	
	@Test
	public void testTaillePlateau(){
		assertTrue("Plateau de dimension correct", test.getX() >= 3 && test.getX() <= 15 && test.getX() >= 3 && test.getY() <= 15);
	}
	
	@Test
	public void testObjetPlateau(){
		for (int i = 0; i < test.getX(); i++) {
			for (int j = 0; j < test.getY(); j++) {
				//assertTrue("Plateau conforme", test[i][j] == forme.representation(nom));
			}
		}

	}
	
	@Test
	public void testGlisse(){
		Forme[] testForme = new Forme[3];
		Forme[] testFormeGlisser = new Forme[3];
		test.getGrille()[3][8] = new Forme("triangle", 3, 8);
		test.getGrille()[4][8] = new Forme("rond", 4, 8);
		test.getGrille()[5][8] = new Forme("carre", 5, 8);
		for (int i = 0; i < 3; i++) {
			test.getGrille()[i+3][9] = new Forme("rond", i+3, 9);
			testForme[i] = test.getGrille()[i+3][8];
		}
		test.destruction();
		test.glisser();
		for (int i = 0; i < 3; i++) {
			testFormeGlisser[i] = test.getGrille()[i+3][9];
		}
		assertTrue("les formes ont glissé", testForme[0].getNom().equals(testFormeGlisser[0].getNom()));
		assertTrue("les formes ont glissé", testForme[1].getNom().equals(testFormeGlisser[1].getNom()));
		assertTrue("les formes ont glissé", testForme[2].getNom().equals(testFormeGlisser[2].getNom()));
	}
	
	@Test
	public void testDestruction(){
		test.destruction();
		for(int i = 0; i < 3; i++){
			assertTrue(test.getGrille()[i][0].getNom().equals("Vide"));
			assertTrue(test.getGrille()[5][i].getNom().equals("Vide"));
			assertTrue(test.getGrille()[7][i + 2].getNom().equals("Vide"));
		}
	}

}
