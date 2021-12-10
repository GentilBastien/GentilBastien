package taquin.arbre;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Grille triées de la plus petite à la plus grande.
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
	 * Ajoute une Grille à la liste. Si le poids de la Grille à ajouter est égal au
	 * poids d'une des Grille de la liste, alors la Grille à ajouter sera ajoutée
	 * avant elle.
	 * 
	 * @param g La Grille qui est ajoutée.
	 * 
	 * @return true lorsque la Grille est effectivement ajoutée.
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
	 * Ajoute toutes les Grille en paramètre à la liste courante.
	 * 
	 * @param c Une collection de Grille.
	 * 
	 * @return true si moins une Grille a tenté d'être ajoutée.
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