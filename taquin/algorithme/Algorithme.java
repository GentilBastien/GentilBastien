package taquin.algorithme;

import taquin.arbre.Grille;
import taquin.arbre.GrilleList;

/**
 * Un algorithme choisit le prochain coup à un moment donné.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public abstract class Algorithme {
	/**
	 * La mémoire des grilles déjà parcourues.
	 */
	protected GrilleList memoire;
	/**
	 * le nombre de coups courant.
	 */
	protected int nbCoups;
	
	public Algorithme(Grille etatInitial) {
		this.memoire = new GrilleList();
		this.memoire.add(etatInitial);
		
		this.nbCoups = 0;
	}
	
	/**
	 * Fonction récursive qui joue le prochain coup.
	 * @return le nombre de coups.
	 */
	public abstract int nextMove();
	
	public abstract String toString();
	
}
