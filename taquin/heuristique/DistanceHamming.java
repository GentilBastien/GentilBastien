package taquin.heuristique;

import java.util.List;

import taquin.arbre.Grille;

/**
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class DistanceHamming implements Heuristique {

	@Override
	public int computesWeight(Grille g) {
		List<Integer> ordre = g.getOrdre();

		int score = 0;

		for (int i = 0; i < SIZE; i++)
			if (ordre.get(i) != ORDRE_FINAL.get(i))
				score++;

		return score;
	}
}