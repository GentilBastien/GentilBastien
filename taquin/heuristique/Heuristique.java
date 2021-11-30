package taquin.heuristique;

import java.util.List;

/**
 * Une Heuristique permet de r�soudre une Grille de Taquin � l'aide d'
 *
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public abstract class Heuristique {
	/**
	 * Nombre d'op�rations faites.
	 */
	protected int nbEtapes;
	
	public Heuristique() {
		this.nbEtapes = 0;
	}
	/**
	 * Recalcule la liste d'entiers qui correspond � l'ordre des cases dans la
	 * grille.
	 * 
	 * @param ordre La liste d'entiers qui correspond � l'ordre des cases dans la
	 *              grille.
	 * @param ordre La liste d'entiers qui correspond � l'ordre des cases de la
	 *              grille � l'�tat final.
	 * @return true si on obtient l'�tat final apr�s avoir recalcul�.
	 */
	public abstract boolean computeNextMove(List<Integer> ordre, List<Integer> etatFinal);
}
