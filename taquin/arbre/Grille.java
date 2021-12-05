package taquin.arbre;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.collections.impl.list.Interval;

import taquin.heuristique.DistanceManhattan;
import taquin.heuristique.Heuristique;

public class Grille extends DefaultMutableTreeNode {
	private static final long serialVersionUID = 1L;

	public static final List<Integer> ORDRE_FINAL = new ArrayList<>(Interval.zeroTo(8));

	private List<Integer> ordre;
	private int dim, depth;
	
	private Heuristique heuristique;

	public Grille(int depth, List<Integer> ordre) {
		this.depth = depth;
		this.heuristique = new DistanceManhattan();

		if (ordre == null)
			throw new IllegalArgumentException("Case sans ordre interdite.");
		setUserObject(ordre);
		this.ordre = ordre;
		this.dim = (int) Math.sqrt(ordre.size());
	}

	private Collection<Integer> adjacentCells() {
		int idxWhiteCell = get(dim * dim - 1);
		Collection<Integer> adjacentCells = new ArrayList<>();
		if (col(idxWhiteCell) != 0)
			adjacentCells.add(idxWhiteCell - 1);
		if (col(idxWhiteCell) != dim - 1)
			adjacentCells.add(idxWhiteCell + 1);
		if (row(idxWhiteCell) != 0)
			adjacentCells.add(idxWhiteCell - dim);
		if (row(idxWhiteCell) != dim - 1)
			adjacentCells.add(idxWhiteCell + dim);
		return adjacentCells;
	}

	public void addChildrenToThisNode() {
		if (ordre.equals(ORDRE_FINAL)) {
			System.out.println("trouvé ! A " + depth + " de profondeur !");
			return;
		}
		if (depth == 50)
			return;
		
		int idxWhiteCell = get(dim * dim - 1);
		Collection<Grille> enfants = new ArrayList<>();
		/*
		 * Pour chaque case voisine de la case blanche, il y a une combinaison possible.
		 * Donc on créé une nouvelle Grille "enfant" pour chacune de ces combinaisons.
		 */
		for (int idxCellSwap : adjacentCells()) {
			/*
			 * L'ordre des Grille enfants sont les mêmes que l'ordre de la Grille courante
			 * en swappant une case adjacente avec la case blanche.
			 */
			List<Integer> newOrdre = new ArrayList<Integer>(ordre);
			Collections.swap(newOrdre, idxWhiteCell, idxCellSwap);
			/*
			 * On créé la nouvelle Grille enfant ici, avec cette Grille courante en parent,
			 * une profondeur incrémentée, et l'ordre des cases qui vient d'être construit.
			 */
			Grille newGrille = new Grille(depth + 1, newOrdre);
			/*
			 * Pour éviter les boucles infinies, on n'ajoute pas les grilles qui re-font le
			 * même coup qui a construit la grille courante.
			 */
			Grille papa = (Grille)getParent();
			if (papa != null && newOrdre.equals(papa.ordre))
				continue;
			enfants.add(newGrille);
		}
		/*
		 * Parmi toutes les grilles enfants, c'est l'heuristique qui choisit lesquelles
		 * ajouter à ce noeud.
		 */
		Collection<Grille> chosenEnfants = heuristique.chooseBestChildren(enfants);
		for (Grille g : chosenEnfants) {
			add(g); //on ajoute d'abord dans l'arbre pour avoir une visibilité sur les parents
			g.addChildrenToThisNode();
		}
	}

	public boolean equals(Object o) {
		if (o instanceof Grille)
			return ordre.equals(((Grille) o).ordre);
		return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dim; i++) {
			sb.append("[");
			for (int j = 0; j < dim; j++) {
				sb.append(ordre.get(i * dim + j));
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("]\n");
		}
		return sb.toString();
	}

	int get(int cell) {
		return ordre.indexOf(cell);
	}

	int row(int cellIdx) {
		return cellIdx / dim;
	}

	int col(int cellIdx) {
		return cellIdx % dim;
	}

	public int getDim() {
		return dim;
	}

	public List<Integer> getOrdre() {
		return ordre;
	}
}