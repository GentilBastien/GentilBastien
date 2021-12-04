package taquin.heuristique;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.collections.impl.list.Interval;

import taquin.arbre.Grille;

/**
 * Une Heuristique est une m�thode de r�solution qui calcule une pond�ration
 * pour chaque enfant et qui d�termine quel chemin emprunter pour arriver �
 * l'�tat final.
 *
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public interface Heuristique {

	public static final List<Integer> ORDRE_FINAL = new ArrayList<>(Interval.zeroTo(8));

	/**
	 * Parmi les Grille d'enfant propos�es, l'heuristique d�termine la(les)quelle(s)
	 * sont les meilleure(s)
	 * 
	 * @param possibleEnfants les Grilles d'enfants qui sont propos�es par l'arbre
	 *                        des possibilit�s.
	 * @return les Grille enfants choisies.
	 */
	public abstract Collection<Grille> chooseBestChildren(Collection<Grille> possibleEnfants);
}
