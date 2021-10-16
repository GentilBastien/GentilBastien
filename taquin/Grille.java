package taquin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.collections.impl.list.Interval;

/**
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class Grille {
	
	protected final int size;
	protected Integer[] ordre;
	
	public Grille(int size) {
		if (size < 0)
			throw new IllegalArgumentException("Taille négative.");
		this.size = size;
		ordre = new Integer[size];
		
		constructRandomGrid();
	}
	
	private void constructRandomGrid() {
		ordre = Interval.toArray(0, size - 1);
		
		List<Integer> list = Arrays.asList(ordre);
		Collections.shuffle(list);
		Collections.swap(list, list.indexOf(size - 1), size - 1);
		
		ordre = list.toArray(ordre);
	}

	public void deplacerCase(int value) {
		//check si la case en param est non null
		
		//check si la case en param appartient à notre tableau de Case
		
		//check si la case en param est déplaçable (si case blanche est adjacente), sinon return (ne fait rien)
		
		//permute la position avec la case blanche
	}
}
