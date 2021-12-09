package taquin.heuristique;

import taquin.arbre.Grille;

/**
 * Une Heuristique est une m�thode de r�solution qui calcule une pond�ration
 * pour chaque enfant et qui d�termine quel chemin emprunter pour arriver �
 * l'�tat final.
 *
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public interface Heuristique {
	/**
	 * 
	 * @param g
	 * @return
	 */
	public int computesWeight(Grille g);
}
