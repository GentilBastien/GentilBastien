package taquin.algorithme;

import java.util.List;

import taquin.arbre.Grille;

public class Algo_BreadthFirst extends Algorithme {

	public Algo_BreadthFirst(Grille etatInitial) {
		super(etatInitial);
	}

	@Override
	public int nextMove() {		
		if (memoire.isEmpty()) {
			//System.out.println("Profondeur max atteinte -> m�moire vid�e.");
			return -1;
		}
		
		Grille first = memoire.removeFirst();

		/*
		 * On calcule ses enfants et on les ajoute tous dans la liste tri�e.
		 */
		List<Grille> firstChildren = first.computesChildrenToThisNode();
		if (firstChildren == null)
			return nbCoups;

		for (Grille g : firstChildren) {
			first.add(g);
			memoire.addLast(g);
		}

		nbCoups++;
		return nextMove();
	}

	@Override
	public String toString() {
		return "[Algo= Breadth-first]";
	}
}
