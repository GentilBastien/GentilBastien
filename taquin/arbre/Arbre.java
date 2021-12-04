package taquin.arbre;

import java.util.Arrays;

public class Arbre {
	
	private Grille entree;
	
	public Arbre() {
		entree = new Grille(0, Arrays.asList(0, 1, 2, 3, 7, 4, 6, 8, 5));
		entree.addChildrenToThisNode();
	}
	
	public Grille getEntree() {
		return entree;
	}
}
