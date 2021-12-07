package taquin.arbre;

import java.util.Collection;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Grille triées de la plus petite à la plus grande.
 * 
 * @author basti
 *
 */
public class SortedGrilleList extends LinkedList<Grille> {
	private static final long serialVersionUID = 1L;

	public SortedGrilleList() {
		super();
	}

	public boolean add(Grille g) {
		if (isEmpty()) {
			super.add(g);
			return true;
		}
		ListIterator<Grille> itr = this.listIterator();
		while (itr.hasNext())
			if (g.compareTo(itr.next()) < 0) {
				super.add(itr.previousIndex(), g);
				return true;
			}
		return true;
	}

	public boolean addAll(Collection<? extends Grille> c) {
		for (Grille g : c)
			add(g);
		return c.size() > 0;
	}

	/**
	 * Unsupported exceptions...
	 */

	public void add(int index, Grille g) {
		throw new UnsupportedOperationException();
	}

	public void addFirst(Grille g) {
		throw new UnsupportedOperationException();
	}

	public void addLast(Grille g) {
		throw new UnsupportedOperationException();
	}

	public boolean addAll(int index, Collection<? extends Grille> c) {
		throw new UnsupportedOperationException();
	}
}