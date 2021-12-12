package taquin.arbre;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Liste de grilles qui impl�mente quelques options pour : - ajouter une liste
 * directement � la fin - ajouter une liste directement au d�but - ajouter une
 * grille selon son ordre naturel (car grille impl�mente l'interface Comparable)
 * 
 * Cette liste de grille sert principalement � mod�liser la m�moire lors du
 * parcours de l'algorithme. Par exemple, un parcours en profondeur r�cup�rera
 * toujours la grille au premier indice, et ajoutera les enfants toujours au
 * d�but de la liste.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class GrilleList extends LinkedList<Grille> {
	private static final long serialVersionUID = 1L;

	public GrilleList() {
		super();
	}

	/**
	 * Ajoute une Grille � la liste. Si le poids de la Grille � ajouter est �gal au
	 * poids d'une des Grille de la liste, alors la Grille � ajouter sera ajout�e
	 * avant elle.
	 * 
	 * @param g La Grille qui est ajout�e.
	 * 
	 * @return true lorsque la Grille est effectivement ajout�e.
	 */
	public boolean add(Grille g) {
		for (int i = 0; i < size(); i++)
			if (g.compareTo(get(i)) <= 0) {
				super.add(i, g);
				return true;
			}
		super.add(g);
		return true;
	}

	/**
	 * Ajoute toutes les Grille en param�tre � la liste courante <b>en les triant</b>.
	 * 
	 * @param c Une collection de Grille.
	 * 
	 * @return true si moins une Grille a tent� d'�tre ajout�e.
	 */
	public boolean addAll(Collection<? extends Grille> c) {
		for (Grille g : c)
			add(g);
		return c.size() > 0;
	}

	/**
	 * Unsupported operation
	 */
	public void add(int index, Grille g) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Unsupported operation
	 */
	public boolean addAll(int index, Collection<? extends Grille> c) {
		throw new UnsupportedOperationException();
	}
}