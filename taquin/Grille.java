package taquin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.collections.impl.list.Interval;

/**
 * Décrit une grille de Taquin. Une grille de Taquin doit être carrée.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class Grille {
	/**
	 * La taille totale de cases dans le jeu.
	 */
	protected final int size;
	/**
	 * La dimension de la grille.
	 */
	protected final int dim;
	/**
	 * Une liste d'entiers qui correspond à l'ordre actuel des cases dans la grille.
	 */
	protected List<Integer> ordre;

	/**
	 * Construit une <code>Grille</code>.
	 * 
	 * @param size La taille totale de la grille.
	 */
	public Grille(int size) {
		if (size < 0)
			throw new IllegalArgumentException("Taille négative.");
		this.size = size;
		dim = (int) Math.sqrt(size);
		constructRandomGrid();
	}

	/**
	 * Initialise la liste d'entier qui correspond à l'ordre actuel des cases dans
	 * la grille. L'ordre initial est aléatoire. À noter que la case blanche se
	 * situe toujours en dernière position au début du jeu.
	 */
	private void constructRandomGrid() {
		ordre = new ArrayList<>(Interval.zeroTo(size - 1));
		Collections.shuffle(ordre);
		Collections.swap(ordre, get(size - 1), size - 1);
	}

	/**
	 * Permute de place la case en paramètre et la case blanche. La méthode retourne
	 * directement si cette case n'est pas déplaçable. Pour être déplaçable, une
	 * case doit être adjacente à la case blanche.
	 * 
	 * @param value La valeur de la case à déplacer.
	 */
	public void deplacerCase(int value) {

	}

	/**
	 * Retourne l'index de la case de <code>value</code> dans la grille.
	 * 
	 * @param value La valeur de la case à tester.
	 * @return L'index de la case <code>value</code>.
	 */
	protected int get(int value) {
		return ordre.indexOf(value);
	}
}
