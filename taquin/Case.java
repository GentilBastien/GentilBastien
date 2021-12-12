package taquin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Décrit une case de Taquin. Une case possède une image et un chiffre est doit
 * posséder un évènement lorsque l'on clique dessus. Une Case est immutable.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class Case extends JButton {
	private static final long serialVersionUID = 1L;
	/**
	 * La Font utilisée pour écrire le numéro de la case sur celle-ci.
	 */
	public static final Font font = new Font("Tahoma", Font.BOLD, 20);
	/**
	 * La valeur de la case actuelle.
	 */
	private final int value;
	/**
	 * Indique si "this" est une case blanche ou non.
	 */
	private final boolean isBlank;

	private final ImageIcon img;

	/**
	 * Construit une Case avec sa valeur (valeur qui est égale à son index si elle
	 * est bien placée), son image
	 * 
	 * @param value La valeur associée à la case.
	 * @param img   L'image associée à la case.
	 */
	public Case(int value, ImageIcon img) {
		this.img = img;
		this.isBlank = img.getImageLoadStatus() == MediaTracker.ERRORED;
		this.value = value;

		if (isBlank) {
			setEnabled(false);
			setBackground(Color.WHITE);
			return;
		}

		/**
		 * Ajout du numéro sur la case
		 */
		final JLabel numero = new JLabel(String.valueOf(value + 1));
		numero.setFont(font);
		numero.setForeground(Color.GREEN);
		super.add(numero, BorderLayout.CENTER);
		setIcon(img);

	}

	/**
	 * Dessine la case en redéfinissant paintComponent(Graphics) de JComponent.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/**
		 * On créé une Image rescale de l'originale à chaque fois qu'on doit repeindre.
		 * On ré-affecte pour toujours rescale à partir de l'originale (pour pas perdre
		 * en qualité)
		 */
		Image image = img.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
		setIcon(new ImageIcon(image));
	}

	/**
	 * @return Retourne la valeur de cette case.
	 */
	public int getValue() {
		return value;
	}
}