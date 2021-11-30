package taquin.heuristique;

import java.util.List;

/**
 * Une Heuristique permet de résoudre une Grille de Taquin à l'aide d'
 *
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public abstract class Heuristique {
	/**
	 * Nombre d'opérations faites.
	 */
	protected int nbEtapes;
	
	public Heuristique() {
		this.nbEtapes = 0;
	}
	/**
	 * Recalcule la liste d'entiers qui correspond à l'ordre des cases dans la
	 * grille.
	 * 
	 * @param ordre La liste d'entiers qui correspond à l'ordre des cases dans la
	 *              grille.
	 * @param ordre La liste d'entiers qui correspond à l'ordre des cases de la
	 *              grille à l'état final.
	 * @return true si on obtient l'état final après avoir recalculé.
	 */
	public abstract boolean computeNextMove(List<Integer> ordre, List<Integer> etatFinal);
}
