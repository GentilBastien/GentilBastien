package taquin.algorithme;

import taquin.arbre.Grille;
import taquin.arbre.GrilleList;

public abstract class Algorithme {
	protected GrilleList memoire;
	protected int nbCoups;
	
	public Algorithme(Grille etatInitial) {
		this.memoire = new GrilleList();
		this.memoire.add(etatInitial);
		
		this.nbCoups = 0;
	}
	
	public abstract int nextMove();
}
