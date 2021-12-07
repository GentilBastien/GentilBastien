package taquin.heuristique;

import java.util.List;

import taquin.arbre.Grille;

public class DistanceManhattan implements Heuristique {

	@Override
	public int computesWeight(Grille g) {
		int dim = g.getDim();
		int distance = 0;
		List<Integer> ordre = g.getOrdre();

		for (int num : ordre) {
			/*
			 * On compare l'index de num dans ordre et l'index de num dans ORDRE_FINAL. On
			 * note que num est égal son index dans ORDRE_FINAL.
			 */
			int idx = ordre.indexOf(num);
			distance += Math.abs(num % dim - idx % dim) + Math.abs(num / dim - idx / dim);
		}

		return distance;
	}

}