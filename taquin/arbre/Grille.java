package taquin.arbre;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import taquin.heuristique.Heuristique;

/**
 * Une classe qui d�crit l'�tat d'une grille.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class Grille extends DefaultMutableTreeNode implements Comparable<Grille> {
	private static final long serialVersionUID = 1L;
	/**
	 * L'ordre des cases dans cette grille. Immutable.
	 */
	private List<Integer> ordre;
	/**
	 * Le p�re de cette grille.
	 */
	private Grille papa;
	/**
	 * La profondeur et le poids de cette grille.
	 */
	private int depth, weight;
	/**
	 * L'heuristique utilis�e pour calculer le poids de cette grille. L'heuristique
	 * n'est pas instanci�e ici !
	 */
	private Heuristique heuristique;

	public Grille(Heuristique heuristique, Grille papa, int depth, List<Integer> ordre) {
		this.depth = depth;
		this.heuristique = heuristique;
		this.papa = papa;

		this.ordre = ordre;
		setUserObject(ordre);

		this.weight = heuristique.computesWeight(this);
	}

	/**
	 * Calcule uniquement tous les enfants de cette grille courante MAIS ne les
	 * ajoute pas en tant qu'enfants !
	 * 
	 * @return Une liste de grille qui contient tous les enfants de cette grille
	 *         courante.
	 */
	public List<Grille> computesChildrenToThisNode() {
		/*
		 * Si cette grille repr�sente un �tat final, les enfants ne sont pas calcul�s.
		 */
		if (ordre.equals(Arbre.ORDRE_FINAL)) {
			System.out.println("Solution trouv�e ! Profondeur = " + depth);
			return null;
		}

		GrilleList enfants = new GrilleList();

		/*
		 * Si on atteint une profondeur de 13 on choisit de ne pas ajouter davantage
		 * d'enfants (voir rapport).
		 */
		if (depth == 13)
			return enfants;

		int idxWhiteCell = get(Arbre.SIZE - 1);
		/*
		 * Pour chaque case voisine de la case blanche, il y a une combinaison possible.
		 * Donc on cr�� une nouvelle Grille "enfant" pour chacune de ces combinaisons.
		 */
		for (int idxCellSwap : adjacentCells()) {
			/*
			 * L'ordre des Grille enfants sont les m�mes que l'ordre de la Grille courante
			 * en swappant une case adjacente avec la case blanche.
			 */
			List<Integer> newOrdre = new ArrayList<Integer>(ordre);
			Collections.swap(newOrdre, idxWhiteCell, idxCellSwap);
			/*
			 * On cr�� la nouvelle Grille enfant ici, avec toujours la m�me heuristique,
			 * cette Grille courante en parent, une profondeur incr�ment�e, et l'ordre des
			 * cases qui vient d'�tre construit.
			 */
			Grille newGrille = new Grille(heuristique, this, depth + 1, newOrdre);
			/*
			 * Pour �viter les coups "inutiles", on ne consid�re pas les grilles qui sont
			 * cr�es par le m�me coup qui a engendr� la grille courante.
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

	/**
	 * @return Retourne les indices des cases adjacentes � la case blanche de cette
	 *         grille.
	 */
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

	/**
	 * @param cell Un num�ro de case.
	 * @return L'indice de ce num�ro dans l'ordre de la grille.
	 */
	int get(int cell) {
		return ordre.indexOf(cell);
	}

	/**
	 * @param cellIdx L'index d'une case de la grille
	 * @return l'indice de la ligne
	 */
	int row(int cellIdx) {
		return cellIdx / Arbre.DIM;
	}

	/**
	 * @param cellIdx L'index d'une case de la grille
	 * @return l'indice de la colonne
	 */
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