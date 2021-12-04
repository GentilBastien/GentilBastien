package taquin.heuristique;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import taquin.arbre.Grille;

public class DistanceManhattan implements Heuristique {

//	public static void main(String[]args) {
//		DistanceManhattan d = new DistanceManhattan();
//		Grille g = new Grille(0, Arrays.asList(0,1,5,6,2,4,3,7,8));
//		Grille g2 = new Grille(0, Heuristique.ORDRE_FINAL);
//		System.out.println(g2);
//		System.out.println(g);
//		d.chooseBestChildren(Collections.singletonList(g));
//	}
	
	@Override
	public Collection<Grille> chooseBestChildren(Collection<Grille> possibleEnfants) {
		if (possibleEnfants == null || possibleEnfants.size() == 0)
			return Collections.emptyList();

		Collection<Grille> chosen = new ArrayList<>();
		int weight = Integer.MAX_VALUE;
		int dim = (int) Math.sqrt(ORDRE_FINAL.size());

		for(Grille g : possibleEnfants) {
			int distance = 0;
			List<Integer> ordre = g.getOrdre();
			for (int num : ordre) {
				int idx = ordre.indexOf(num);
				distance += Math.abs(num % dim - idx % dim) + Math.abs(num / dim - idx / dim);
			}
			if (distance < weight) {
				weight = distance;
				chosen.clear();
				chosen.add(g);
			}else if (distance == weight) {
				chosen.add(g);
			}
		}
		return chosen;
	}
	
}