package taquin.heuristique;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.collections.impl.list.Interval;

import taquin.arbre.Grille;

/**
 * Une Heuristique est une méthode de résolution qui calcule une pondération
 * pour chaque enfant et qui détermine quel chemin emprunter pour arriver à
 * l'état final.
 *
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public interface Heuristique {

	public static final List<Integer> ORDRE_FINAL = new ArrayList<>(Interval.zeroTo(8));
	public static final int DIM = 3;
	public static final int SIZE = DIM * DIM;
	/**
	 * 
	 * @param g
	 * @return
	 */
	public abstract int computesWeight(Grille g);
}
