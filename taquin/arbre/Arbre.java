package taquin.arbre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.collections.impl.list.Interval;

import taquin.algorithme.*;
import taquin.heuristique.*;

/**
 * Un Arbre est définit par une grille d'état initial, une heuristique et un
 * algorithme.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 * 
 */
public class Arbre {
	/**
	 * Constante de la grille de l'ordre final.
	 */
	public static final List<Integer> ORDRE_FINAL = new ArrayList<>(Interval.zeroTo(8));
	/**
	 * Constante de la dimension de la grille.
	 */
	public static final int DIM = 3;
	/**
	 * Constante de la taille de la grille.
	 */
	public static final int SIZE = DIM * DIM;
	/**
	 * L'heuristique qui va pondérer (de la même manière) toutes les grilles de
	 * l'arbre.
	 */
	private Heuristique heuristique;
	/**
	 * La Grille de l'état initial.
	 */
	private Grille entree;
	/**
	 * L'algorithme de parcours dans l'arbre qui choisit quels enfants ajouter à une
	 * grille parent.
	 */
	private Algorithme algo;

	public Arbre() {

//		int nbErr0 = 0,nbErr1 = 0,nbErr2 = 0,nbErr3 = 0,nbErr4 = 0,nbErr5 = 0,nbErr6 = 0,nbErr7 = 0,nbErr8 = 0,nbErr9 = 0,nbErr10 = 0,nbErr11 = 0;
//		int nbCoup0 = 0,nbCoup1 = 0,nbCoup2 = 0,nbCoup3 = 0,nbCoup4 = 0,nbCoup5 = 0,nbCoup6 = 0,nbCoup7 = 0,nbCoup8 = 0,nbCoup9 = 0,nbCoup10 = 0,nbCoup11 = 0;  
//		double res0 = 0,res1 = 0,res2 = 0,res3 = 0,res4 = 0,res5 = 0,res6 = 0,res7 = 0,res8 = 0,res9 = 0,res10 = 0,res11 = 0;
//		int NBITERATION = 44444;
//		
//		
//		for (int op = 0; op < NBITERATION; op++) {
//			List<Integer> ordre = Arrays.asList(0,1,5,4,7,8,6,3,2);
//			Collections.shuffle(ordre);
//			
//			for (int heuri = 0; heuri < 4; heuri++) {
//				switch (heuri) {
//				case 0: 
//					this.heuristique = new DistanceManhattan();
//					break;
//				case 1: 
//					this.heuristique = new DistanceHamming();
//					break;
//				case 2: 
//					this.heuristique = new HeuristiqueSuite();
//					break;
//				case 3: 
//					this.heuristique = new DistanceHammatthan();
//					break;
//				}				
//				
//				for (int alg = 0; alg < 3; alg++) {
//					this.entree = new Grille(heuristique, null, 0, ordre);
//					switch (alg) {
//					case 0: 
//						this.algo = new Algo_DepthFirst(entree);
//						break;
//					case 1: 
//						this.algo = new Algo_BreadthFirst(entree);
//						break;
//					case 2: 
//						this.algo = new Algo_BestFirst(entree);
//						break;
//					}
//					int n = algo.nextMove();
//					
//					if (heuri == 0 && alg == 0) {
//						if (n == -1)
//							nbErr0++;
//						else
//							nbCoup0 += n;
//					}
//						
//					if (heuri == 0 && alg == 1) {
//						if (n == -1)
//							nbErr1++;
//						else
//							nbCoup1 += n;
//					}
//						
//					if (heuri == 0 && alg == 2) {
//						if (n == -1)
//							nbErr2++;
//						else
//							nbCoup2 += n;
//					}
//						
//					if (heuri == 1 && alg == 0) {
//						if (n == -1)
//							nbErr3++;
//						else
//							nbCoup3 += n;
//					}
//						
//					if (heuri == 1 && alg == 1) {
//						if (n == -1)
//							nbErr4++;
//						else
//							nbCoup4 += n;
//					}
//						
//					if (heuri == 1 && alg == 2) {
//						if (n == -1)
//							nbErr5++;
//						else
//							nbCoup5 += n;
//					}
//						
//					if (heuri == 2 && alg == 0) {
//						if (n == -1)
//							nbErr6++;
//						else
//							nbCoup6 += n;
//					}
//						
//					if (heuri == 2 && alg == 1) {
//						if (n == -1)
//							nbErr7++;
//						else
//							nbCoup7 += n;
//					}
//						
//					if (heuri == 2 && alg == 2) {
//						if (n == -1)
//							nbErr8++;
//						else
//							nbCoup8 += n;
//					}
//						
//					if (heuri == 3 && alg == 0) {
//						if (n == -1)
//							nbErr9++;
//						else
//							nbCoup9 += n;
//					}
//						
//					if (heuri == 3 && alg == 1) {
//						if (n == -1)
//							nbErr10++;
//						else
//							nbCoup10 += n;
//					}
//						
//					if (heuri == 3 && alg == 2) {
//						if (n == -1)
//							nbErr11++;
//						else
//							nbCoup11 += n;
//					}
//						
//				}
//			}
//		}
//		System.out.println("nb erreur= " + nbErr0);
//		System.out.println("nb erreur= " + nbErr1);
//		System.out.println("nb erreur= " + nbErr2);
//		System.out.println("nb erreur= " + nbErr3);
//		System.out.println("nb erreur= " + nbErr4);
//		System.out.println("nb erreur= " + nbErr5);
//		System.out.println("nb erreur= " + nbErr6);
//		System.out.println("nb erreur= " + nbErr7);
//		System.out.println("nb erreur= " + nbErr8);
//		System.out.println("nb erreur= " + nbErr9);
//		System.out.println("nb erreur= " + nbErr10);
//		System.out.println("nb erreur= " + nbErr11);
//		res0 = nbCoup0 / (NBITERATION - nbErr0);
//		res1 = nbCoup1 / (NBITERATION - nbErr1);
//		res2 = nbCoup2 / (NBITERATION - nbErr2);
//		res3 = nbCoup3 / (NBITERATION - nbErr3);
//		res4 = nbCoup4 / (NBITERATION - nbErr4);
//		res5 = nbCoup5 / (NBITERATION - nbErr5);
//		res6 = nbCoup6 / (NBITERATION - nbErr6);
//		res7 = nbCoup7 / (NBITERATION - nbErr7);
//		res8 = nbCoup8 / (NBITERATION - nbErr8);
//		res9 = nbCoup9 / (NBITERATION - nbErr9);
//		res10 = nbCoup10 / (NBITERATION - nbErr10);
//		res11 = nbCoup11 / (NBITERATION - nbErr11);
//		System.out.println(res0);
//		System.out.println(res1);
//		System.out.println(res2);
//		System.out.println(res3);
//		System.out.println(res4);
//		System.out.println(res5);
//		System.out.println(res6);
//		System.out.println(res7);
//		System.out.println(res8);
//		System.out.println(res9);
//		System.out.println(res10);
//		System.out.println(res11);
//		
//		System.out.println("% d'erreur total = "  + (100 * nbErr0/NBITERATION));
		
		
		heuristique = new HeuristiqueSuite();
		List<Integer> ordre = Arrays.asList(0,1,2,3,5,8,6,4,7);
		entree = new Grille(heuristique, null, 0, ordre);
		algo = new Algo_DepthFirst(entree);
		System.out.println("Paramètres: " + heuristique.toString() + " + " + algo.toString());
		System.out.println("Trouvé en " + algo.nextMove() + " coups!");
	}

	public Grille getEntree() {
		return entree;
	}
}
