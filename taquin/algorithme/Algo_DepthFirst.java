package taquin.algorithme;

import taquin.arbre.Grille;

public class Algo_DepthFirst extends Algorithme {

	public Algo_DepthFirst(Grille etatInitial) {
		super(etatInitial);
	}

	@Override
	public int nextMove() {
		if (memoire.isEmpty()) {
			System.out.println("Memoire vide");
			return nbCoups;
		}
		//à faire
		return -1;
	}

}
