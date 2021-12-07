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
public class DistanceManhattan implements Heuristique {

	@Override
	public int computesWeight(Grille g) {
		int distance = 0;
		List<Integer> ordre = g.getOrdre();

		for (int num : ordre) {
			/*
			 * On compare l'index de num dans ordre et l'index de num dans ORDRE_FINAL. On
			 * note que num est égal son index dans ORDRE_FINAL.
			 */
			int idx = ordre.indexOf(num);
			distance += Math.abs(num % DIM - idx % DIM) + Math.abs(num / DIM - idx / DIM);
		}

		return distance;
	}

}