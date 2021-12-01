package taquin.arbre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class Grille extends DefaultMutableTreeNode {
	private static final long serialVersionUID = 1L;

	public static final List<Integer> ORDRE_FINAL = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);

	private List<Integer> ordre;
	private int dim, depth;

	public Grille(int depth, List<Integer> ordre) {
		this.depth = depth;

		if (ordre == null)
			throw new IllegalArgumentException("Case sans ordre interdite.");
		setUserObject(ordre);
		this.ordre = ordre;
		this.dim = (int) Math.sqrt(ordre.size());

		if (depth == 10 || ordre.equals(ORDRE_FINAL))
			return;
		addChildrenToThisNode();
	}

	private Collection<Integer> adjacentCells() {
		int idxWhiteCell = get(dim * dim - 1);
		Collection<Integer> adjacentCells = new ArrayList<>();
		if (col(idxWhiteCell) != 0)
			adjacentCells.add(getLeft(idxWhiteCell));
		if (col(idxWhiteCell) != dim - 1)
			adjacentCells.add(getRight(idxWhiteCell));
		if (row(idxWhiteCell) != 0)
			adjacentCells.add(getUp(idxWhiteCell));
		if (row(idxWhiteCell) != dim - 1)
			adjacentCells.add(getDown(idxWhiteCell));
		return adjacentCells;
	}

	private void addChildrenToThisNode() {
		int idxWhiteCell = get(dim * dim - 1);
		/*
		 * Pour chaque case voisine de la case blanche, il y a une combinaison possible.
		 * Donc on créé une nouvelle Grille "enfant" pour chacune de ces combinaisons.
		 */
		for (int idxCellSwap : adjacentCells()) {
			List<Integer> newOrdre = new ArrayList<Integer>(ordre);
			Collections.swap(newOrdre, idxWhiteCell, idxCellSwap);

			Grille papa = (Grille)getParent();
			if (papa != null && newOrdre.equals(papa.ordre)) {
				return;
			}
			
			Grille newGrille = new Grille(depth + 1, newOrdre);
			add(newGrille);
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

	int getLeft(int cellIdx) {
		return cellIdx - 1;
	}

	int getRight(int cellIdx) {
		return cellIdx + 1;
	}

	int getUp(int cellIdx) {
		return cellIdx - dim;
	}

	int getDown(int cellIdx) {
		return cellIdx + dim;
	}
}
