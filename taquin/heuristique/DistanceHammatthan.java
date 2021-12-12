package taquin.heuristique;

import taquin.arbre.Grille;

/**
 * Décrit la distance Hammatthan (voir rapport). Se base sur l'implémentation
 * des distances de Manhattan et de Hamming.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class DistanceHammatthan implements Heuristique {

	private Heuristique hamming;
	private Heuristique manhattan;

	public DistanceHammatthan() {
		hamming = new DistanceHamming();
		manhattan = new DistanceManhattan();
	}

	@Override
	public int computesWeight(Grille g) {
		return hamming.computesWeight(g) + manhattan.computesWeight(g);
	}

	@Override
	public String toString() {
		return "[Heuristique= Distance de Hammatthan]";
	}
}