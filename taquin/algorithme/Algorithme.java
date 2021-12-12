package taquin.algorithme;

import taquin.arbre.Grille;
import taquin.arbre.GrilleList;

/**
 * Un algorithme choisit le prochain coup � un moment donn�.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public abstract class Algorithme {
	/**
	 * La m�moire des grilles d�j� parcourues.
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
	 * Fonction r�cursive qui joue le prochain coup.
	 * @return le nombre de coups.
	 */
	public abstract int nextMove();
	
	public abstract String toString();
	
}
