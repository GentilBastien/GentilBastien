package taquin.algorithme;

import java.util.Collection;

import taquin.arbre.Grille;

public class Algo_BestFirst extends Algorithme {

	public Algo_BestFirst(Grille etatInitial) {
		super(etatInitial);
	}

	@Override
	public int nextMove() {
		if (memoire.isEmpty()) {
			System.out.println("Memoire vide");
			return nbCoups;
		}
		/*
		 * On prend la Grille la mieux pondérée par l'heuristique.
		 */
		Grille mostRelevant = memoire.removeFirst();

		/*
		 * On calcule ses enfants et on les ajoute tous dans la liste triée.
		 */
		Collection<Grille> mostrelevantChildren = mostRelevant.computesChildrenToThisNode();
		if (mostrelevantChildren == null)
			return nbCoups;

		memoire.addAll(mostrelevantChildren);

		Object[] arr = mostrelevantChildren.toArray();
		for (int i = arr.length - 1; i >= 0; i--)
			mostRelevant.add((Grille) arr[i]);

		nbCoups++;
		return nextMove();
	}

}
