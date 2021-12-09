package taquin.heuristique;

import java.util.List;

import taquin.arbre.Arbre;
import taquin.arbre.Grille;

/**
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class DistanceOfTheCotils implements Heuristique {

	@Override
	public int computesWeight(Grille g) {
		int distance = 0;
		List<Integer> ordre = g.getOrdre();

		for (int i = 0; i < Arbre.SIZE; i++) {
			/*
			 * On compare l'index de num dans ordre et l'index de num dans ORDRE_FINAL. On
			 * note que num est égal son index dans ORDRE_FINAL.
			 */
			int idx = ordre.indexOf(i);
			distance += idx % Arbre.DIM + idx / Arbre.DIM + Math.abs(i % Arbre.DIM - idx % Arbre.DIM)
					+ Math.abs(i / Arbre.DIM - idx / Arbre.DIM);
		}

		return distance;
	}

	@Override
	public String toString() {
		return "[Heuristique= Distance of the Cotils]";
	}
	
}