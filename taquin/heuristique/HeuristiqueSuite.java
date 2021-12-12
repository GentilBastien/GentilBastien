package taquin.heuristique;

import java.util.List;

import taquin.arbre.Arbre;
import taquin.arbre.Grille;

/**
 * Décrit l'heuristique des suites (voir rapport).
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class HeuristiqueSuite implements Heuristique {
	
	@Override
	public int computesWeight(Grille g) {
		List<Integer> ordre = g.getOrdre();
		int score = 0;
		
		for (int i = 0; i < Arbre.SIZE - 1; i++) {
			if (ordre.get(i) + 1 != ordre.get(i + 1))
				score++;
		}
		return score;
	}

	@Override
	public String toString() {
		return "[Heuristique= Heuristique Suite]";
	}
}