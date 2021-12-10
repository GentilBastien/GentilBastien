package taquin.arbre;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import taquin.heuristique.Heuristique;

public class Grille extends DefaultMutableTreeNode implements Comparable<Grille> {
	private static final long serialVersionUID = 1L;

	private List<Integer> ordre;
	private Grille papa;
	private int depth, weight;

	private Heuristique heuristique;

	public Grille(Heuristique heuristique, Grille papa, int depth, List<Integer> ordre) {
		this.depth = depth;
		this.heuristique = heuristique;
		this.papa = papa;

		this.ordre = ordre;
		setUserObject(ordre);

		this.weight = heuristique.computesWeight(this);
	}

	public List<Grille> computesChildrenToThisNode() {
		if (ordre.equals(Arbre.ORDRE_FINAL)) {
			System.out.println("Solution trouvée ! Profondeur = " + depth);
			return null;
		}
		
		GrilleList enfants = new GrilleList();
		
		if (depth == 13)
			return enfants;

		int idxWhiteCell = get(Arbre.SIZE - 1);
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
			Grille newGrille = new Grille(heuristique, this, depth + 1, newOrdre);
			/*
			 * Pour éviter les boucles infinies, on n'ajoute pas les grilles qui re-font le
			 * même coup qui a construit la grille courante.
			 */
			if (papa != null && newOrdre.equals(papa.ordre))
				continue;
			enfants.add(newGrille);
		}
		
		return enfants;
	}

	@Override
	public int compareTo(Grille o) {
		return weight - o.weight;
	}

	public boolean equals(Object o) {
		if (o instanceof Grille)
			return ordre.equals(((Grille) o).ordre);
		return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Arbre.DIM; i++) {
			sb.append("[");
			for (int j = 0; j < Arbre.DIM; j++) {
				sb.append(ordre.get(i * Arbre.DIM + j));
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("]\n");
		}
		return sb.toString();
	}
	
	private Collection<Integer> adjacentCells() {
		int idxWhiteCell = get(Arbre.SIZE - 1);
		Collection<Integer> adjacentCells = new ArrayList<>();
		if (col(idxWhiteCell) != 0)
			adjacentCells.add(idxWhiteCell - 1);
		if (col(idxWhiteCell) != Arbre.DIM - 1)
			adjacentCells.add(idxWhiteCell + 1);
		if (row(idxWhiteCell) != 0)
			adjacentCells.add(idxWhiteCell - Arbre.DIM);
		if (row(idxWhiteCell) != Arbre.DIM - 1)
			adjacentCells.add(idxWhiteCell + Arbre.DIM);
		return adjacentCells;
	}

	int get(int cell) {
		return ordre.indexOf(cell);
	}

	int row(int cellIdx) {
		return cellIdx / Arbre.DIM;
	}

	int col(int cellIdx) {
		return cellIdx % Arbre.DIM;
	}

	public List<Integer> getOrdre() {
		return ordre;
	}

	public Grille getPapa() {
		return papa;
	}

	public int getWeight() {
		return weight;
	}
}