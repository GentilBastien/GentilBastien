package taquin.heuristique;

import taquin.arbre.Grille;

public class DistanceHammatthan implements Heuristique {

	private DistanceHamming hamming;
	private DistanceManhattan manhattan;
	
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