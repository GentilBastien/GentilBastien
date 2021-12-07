package taquin.heuristique;

import java.util.List;

import taquin.arbre.Grille;

public class DistanceHamming implements Heuristique {

	@Override
	public int computesWeight(Grille g) {
		List<Integer> ordre = g.getOrdre();

		int score = 0, size = ordre.size();

		for (int i = 0; i < size; i++)
			if (ordre.get(i) != ORDRE_FINAL.get(i))
				score++;

		return score;
	}
}