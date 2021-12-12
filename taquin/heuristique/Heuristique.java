package taquin.heuristique;

import taquin.arbre.Grille;

/**
 * Une Heuristique est une méthode de résolution qui calcule une pondération
 * pour chaque grille.
 *
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public interface Heuristique {
	/**
	 * Calcule un poids pour la grille en paramètre.
	 * 
	 * @param g La grille qui va mettre à jour son attribut de weight.
	 * @return un entier qui correspond au poids de la grille selon l'heuristique
	 *         choisie.
	 */
	public int computesWeight(Grille g);
}
