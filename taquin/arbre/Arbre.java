package taquin.arbre;

import java.util.Arrays;

public class Arbre {	
	private Grille entree;
	
	public static void main(String[]args) {
		Arbre a = new Arbre();
	}
	
	public Arbre() {
		entree = new Grille(null, 0, Arrays.asList(0, 1, 2, 3, 7, 4, 6, 8, 5));
	}
	// 0  1  2
	// 3  7  4
	// 6  8  5
	
	// 0  1  2
	// 3  8  4
	// 6  7  5
	
	// 0  1  2
	// 3  4  8
	// 6  7  5
	
	// 0  1  2
	// 3  4  5
	// 6  7  8
	public Grille getEntree() {
		return entree;
	}
}
