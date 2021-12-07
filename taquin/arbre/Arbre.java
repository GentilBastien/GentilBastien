package taquin.arbre;

import java.util.Arrays;

import taquin.algorithme.Algo_BestFirst;
import taquin.algorithme.Algorithme;
import taquin.heuristique.DistanceManhattan;
import taquin.heuristique.Heuristique;

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
		this.entree = new Grille(heuristique, null, 0, Arrays.asList(3, 0, 2, 1, 8, 5, 6, 4, 7));
		this.algo = new Algo_BestFirst(entree);

		System.out.println("En " + algo.nextMove() + " coups !");
	}

	public Grille getEntree() {
		return entree;
	}
}
