package taquin.heuristique;

import taquin.arbre.Grille;

/**
 * Une Heuristique est une m�thode de r�solution qui calcule une pond�ration
 * pour chaque grille.
 *
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public interface Heuristique {
	/**
	 * Calcule un poids pour la grille en param�tre.
	 * 
	 * @param g La grille qui va mettre � jour son attribut de weight.
	 * @return un entier qui correspond au poids de la grille selon l'heuristique
	 *         choisie.
	 */
	public int computesWeight(Grille g);
}
