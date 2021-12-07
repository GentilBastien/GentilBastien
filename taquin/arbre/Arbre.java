package taquin.arbre;

import java.util.Arrays;
import java.util.Enumeration;

import taquin.heuristique.DistanceManhattan;
import taquin.heuristique.Heuristique;

public class Arbre {
	
	private Grille entree;
	private SortedGrilleList grillesTriees;
	
	public Arbre() {
		Heuristique heuristique = new DistanceManhattan();
		entree = new Grille(heuristique, null, 0, Arrays.asList(0, 1, 2, 3, 7, 4, 6, 8, 5));
		
		grillesTriees = new SortedGrilleList();
		grillesTriees.add(entree);
		nextMove();
	}
	
	public void nextMove() {
		if (grillesTriees.isEmpty())
			return;
		Grille mostRelevant = grillesTriees.removeFirst();
		for (Grille oneChild : mostRelevant.computesChildrenToThisNode()) {
			grillesTriees.add(oneChild);
		}
		nextMove();
	}
	
	public Grille getEntree() {
		return entree;
	}
}
