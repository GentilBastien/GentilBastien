package taquin.algorithme;

import java.util.Collections;
import java.util.List;

import taquin.arbre.Grille;

/**
 * Profondeur d'abord. On ajoute les enfants en premier. Le prochain coup est la première
 * grille.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class Algo_DepthFirst extends Algorithme {

	public Algo_DepthFirst(Grille etatInitial) {
		super(etatInitial);
	}

	@Override
	public int nextMove() {
		if (memoire.isEmpty()) {
			System.out.println("Profondeur max atteinte -> mémoire vidée.");
			return -1;
		}

		Grille first = memoire.removeFirst();

		/*
		 * On calcule ses enfants et on les ajoute tous dans la liste triée.
		 */
		List<Grille> firstChildren = first.computesChildrenToThisNode();
		if (firstChildren == null)
			return nbCoups;

		Collections.reverse(firstChildren);
		for (Grille g : firstChildren) {
			first.insert(g, 0);
			memoire.addFirst(g);
		}

		nbCoups++;
		return nextMove();
	}

	@Override
	public String toString() {
		return "[Algo= Depth-first]";
	}
}
