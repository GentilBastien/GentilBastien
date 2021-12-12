package taquin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.collections.impl.list.Interval;

/**
 * D�crit une grille de Taquin fonctionnelle qui peut bouger et d�placer ses
 * cases. Une grille de Taquin doit �tre carr�e.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class GrilleMutable {
	public static void main(String[] args) {
		GrilleMutable g = new GrilleMutable(3 * 3);
		System.out.println(g.ordre);
	}

	/**
	 * La taille totale de cases dans le jeu de Taquin.
	 */
	protected final int size;
	/**
	 * La dimension de la grille.
	 */
	protected final int dim;
	/**
	 * Une liste d'entiers qui correspond � l'ordre actuel des cases dans la grille.
	 */
	protected List<Integer> ordre;

	/**
	 * Construit une <code>Grille</code>.
	 * 
	 * @param size La taille totale de la grille.
	 */
	public GrilleMutable(int size) {
		if (size < 0)
			throw new IllegalArgumentException("Taille n�gative.");
		this.size = size;
		dim = (int) Math.sqrt(size);
		constructRandomGrid();
	}

	/**
	 * Initialise la liste d'entier qui correspond � l'ordre actuel des cases dans
	 * la grille. L'ordre initial est al�atoire. � noter que la case blanche se
	 * situe toujours en derni�re position au d�but du jeu.
	 */
	private final void constructRandomGrid() {
		ordre = new ArrayList<Integer>(Interval.zeroTo(size - 1));
		Collections.shuffle(ordre);
		Collections.swap(ordre, get(size - 1), size - 1);
	}

	/**
	 * Permute de place la case en param�tre et la case blanche. La m�thode retourne
	 * directement si cette case n'est pas d�pla�able. Pour �tre d�pla�able, une
	 * case doit �tre adjacente � la case blanche.
	 * 
	 * @param value La valeur de la case � d�placer.
	 * 
	 * @return true si une case a �t� d�plac�e, false sinon.
	 */
	protected boolean deplacerCase(int value) {
		/**
		 * check si la case en param�tre est valide.
		 */
		if (value < 0 || value > size)
			throw new IllegalArgumentException("Value out of bounds.");
		/**
		 * check si la case en param est d�pla�able (si case blanche est adjacente),
		 * sinon return (ne fait rien).
		 */
		if ((row(value) == row(size - 1) && Math.abs(get(value) - get(size - 1)) == 1)
				|| (col(value) == col(size - 1) && Math.abs(get(value) - get(size - 1)) == dim)) {
			Collections.swap(ordre, get(value), get(size - 1));
			return true;
		}
		return false;
	}

	/**
	 * Retourne la ligne de la case en param�tre.
	 * 
	 * @param value La valeur de la case � tester.
	 * @return La ligne de la case <code>value</code>.
	 */
	private int row(int value) {
		return get(value) / dim;
	}

	/**
	 * Retourne la colonne de la case en param�tre.
	 * 
	 * @param value La valeur de la case � tester.
	 * @return La colonne de la case <code>value</code>.
	 */
	private int col(int value) {
		return get(value) % dim;
	}

	/**
	 * Retourne l'index de la case de <code>value</code> dans la grille.
	 * 
	 * @param value La valeur de la case � tester.
	 * @return L'index de la case <code>value</code>.
	 */
	protected int get(int value) {
		return ordre.indexOf(value);
	}
}
