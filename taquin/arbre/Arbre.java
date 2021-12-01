package taquin.arbre;

import java.util.Arrays;

public class Arbre {	
	private Grille entree;
	
	public static void main(String[]args) {
		Arbre a = new Arbre();
	}
	
	public Arbre() {
		entree = new Grille(0, Arrays.asList(0, 1, 2, 3, 4, 5, 6, 8, 7));
	}
	
	public Grille getEntree() {
		return entree;
	}
}
