//I would commit suicide rn... But i need to know how to commit first
public abstract class NoeudAbstrait {
	protected NoeudAbstrait frere;

	public NoeudAbstrait(NoeudAbstrait frere) {
		this.frere=frere;
	}

	public abstract boolean contient(String s);
	public abstract boolean prefixe(String s);
	public abstract int nbMots(); // nombre d'éléments
	public abstract NoeudAbstrait ajout(String s) throws ModificationImpossibleException;
	public abstract NoeudAbstrait suppr(String s) throws ModificationImpossibleException;
	public abstract String toString(String s); // éléments séparés par \n


	public static void main(String[] args) throws ModificationImpossibleException {
		NoeudAbstrait entree = new Marque(null);
		System.out.println(">>>" + entree.toString("") + "<<<<<<");
		entree = entree.ajout("basti");
		entree = entree.ajout("jul");
		entree = entree.ajout("dimit");
		System.out.println("ajout de bast");
		entree.ajout("bast");
		entree.ajout("bastien");
		System.out.println(">>>" + entree.toString("") + "<<<<<<");

	}

}
