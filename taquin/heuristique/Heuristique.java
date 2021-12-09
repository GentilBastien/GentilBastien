package taquin.heuristique;

import taquin.arbre.Grille;

/**
 * Une Heuristique est une méthode de résolution qui calcule une pondération
 * pour chaque enfant et qui détermine quel chemin emprunter pour arriver à
 * l'état final.
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
