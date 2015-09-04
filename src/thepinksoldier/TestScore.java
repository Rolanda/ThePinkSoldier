// Peut ne pas fonctionner.

package thepinksoldier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestScore {
	
	Plateau test;
	Forme forme;
	Score score;
	
	
	@Before
	public void initScore(){
		test = new Plateau(10,10);
		for(int i = 0; i < 5; i++){
			if(i < 3)
				test.getGrille()[i][0] = new Forme("carre", i, 0);
			if(i < 4)
				test.getGrille()[5][i] = new Forme("triangle", 5, i);
			test.getGrille()[7][i + 2] = new Forme("rond", 7, i + 2);
		}
	}
	
	@Test
	public void testScore() {
		test.destruction();
		test.glisser();
		assertTrue("Bon score", Constante.getScore() == 6);
	}

}
