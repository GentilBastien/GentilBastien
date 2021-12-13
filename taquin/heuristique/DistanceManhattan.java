package taquin.heuristique;

import java.util.List;

import taquin.arbre.Arbre;
import taquin.arbre.Grille;

/**
 * D�crit la distance Manhattan (voir rapport).
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

		for (int i = 0; i < Arbre.SIZE; i++) {
			/*
			 * i est l'index dans ORDRE_FINAL et idx est l'index dans ordre. On note que i
			 * == ORDRE_FINAL[i].
			 */
			int idx = ordre.indexOf(i);
			distance += Math.abs(i % Arbre.DIM - idx % Arbre.DIM) + Math.abs(i / Arbre.DIM - idx / Arbre.DIM);
		}

		return distance;
	}

	@Override
	public String toString() {
		return "[Heuristique= Distance de Manhattan]";
	}
}