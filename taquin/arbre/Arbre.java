package taquin.arbre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.collections.impl.list.Interval;

import taquin.algorithme.*;
import taquin.heuristique.*;

/**
 * Un Arbre suit l'�volution des coups choisis par une heuristique pour un �tat
 * initial donn�.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 * 
 */
public class Arbre {
	public static final List<Integer> ORDRE_FINAL = new ArrayList<>(Interval.zeroTo(8));
	public static final int DIM = 3;
	public static final int SIZE = DIM * DIM;
	/**
	 * On choisit premi�rement une heuristique.
	 */
	private Heuristique heuristique;
	/**
	 * On d�termine ensuite la Grille de l'�tat initial.
	 */
	private Grille entree;
	/**
	 * Puis l'algorithme de parcours dans l'arbre.
	 */
	private Algorithme algo;

	public Arbre() {
		this.heuristique = new DistanceManhattan();
		this.entree = new Grille(heuristique, null, 0, Arrays.asList(0, 8, 2, 3, 1, 5, 6, 4, 7));
		this.algo = new Algo_BreadthFirst(entree);

		System.out.println("Param�tres = " + heuristique.toString() + " + " + algo.toString());
		System.out.println("En " + algo.nextMove() + " coups !");
	}

	public Grille getEntree() {
		return entree;
	}
}
