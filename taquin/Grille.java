package taquin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.collections.impl.list.Interval;

import taquin.heuristique.DistanceManhattan;
import taquin.heuristique.Heuristique;

/**
 * D�crit une grille de Taquin fonctionnelle. Une grille de Taquin doit �tre
 * carr�e.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class Grille {
	public static void main(String[] args) {
		Grille g = new Grille(3 * 3);
		System.out.println(g.ETAT_FINAL);
		System.out.println(g.ordre);
		//g.resoudreGrille();
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
	 * Une liste d'entiers qui correspond � l'ordre des cases de la grille � l'�tat final.
	 */
	protected List<Integer> ETAT_FINAL;
	/**
	 * L'heuristique utilis�e pour r�soudre cette Grille.
	 */
	protected Heuristique heuristique;

	/**
	 * Construit une <code>Grille</code>.
	 * 
	 * @param size La taille totale de la grille.
	 */
	public Grille(int size) {
		if (size < 0)
			throw new IllegalArgumentException("Taille n�gative.");
		this.size = size;
		dim = (int) Math.sqrt(size);
		constructRandomGrid();

		heuristique = new DistanceManhattan();
	}

	/**
	 * Initialise la liste d'entier qui correspond � l'ordre actuel des cases dans
	 * la grille. L'ordre initial est al�atoire. � noter que la case blanche se
	 * situe toujours en derni�re position au d�but du jeu.
	 */
	private final void constructRandomGrid() {
		ETAT_FINAL = new ArrayList<>(Interval.zeroTo(size - 1));
		ordre = new ArrayList<>(ETAT_FINAL);
		Collections.shuffle(ordre);
		Collections.swap(ordre, get(size - 1), size - 1);
	}

	/**
	 * R�souds la Grille de taquin avec l'heuristique choisie.
	 */
	protected void resoudreGrille() {
		while(!heuristique.computeNextMove(ordre, ETAT_FINAL));
	}

	/**
	 * Permute de place la case en param�tre et la case blanche. La m�thode retourne
	 * directement si cette case n'est pas d�pla�able. Pour �tre d�pla�able, une
	 * case doit �tre adjacente � la case blanche.
	 * 
	 * @param value La valeur de la case � d�placer.
	 */
	protected void deplacerCase(int value) {
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
				|| (col(value) == col(size - 1) && Math.abs(get(value) - get(size - 1)) == dim))
			Collections.swap(ordre, get(value), get(size - 1));
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
