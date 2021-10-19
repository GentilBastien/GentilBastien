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
import javax.swing.SwingConstants;

/**
 * D�crit une case de Taquin. Une case poss�de une image est doit poss�der un
 * �v�nement lorsque l'on clique dessus.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class Case extends JButton {
	private static final long serialVersionUID = 1L;
	/**
	 * La Font utilis�e pour �crire le num�ro de la case sur celle-ci.
	 */
	public static final Font font = new Font("Tahoma", Font.BOLD, 20);
	/**
	 * L'image de la case.
	 */
	private final ImageIcon img;
	/**
	 * La valeur de la case.
	 */
	private final int value;
	/**
	 * Indique si "this" est une case blanche ou non.
	 */
	private final boolean isBlank;

	/**
	 * Construit une Case avec sa valeur (valeur qui est �gale � son index si elle
	 * est bien plac�e), son image
	 * 
	 * @param value La valeur associ�e � la case.
	 * @param img   L'image associ�e � la case.
	 */
	public Case(int value, ImageIcon img) {
		this.img = img;
		this.isBlank = img.getImageLoadStatus() == MediaTracker.ERRORED;
		this.value = value;

		if (isBlank) {
			setEnabled(false);
			return;
		}
		/**
		 * Ajout du num�ro sur la case
		 */
		final JLabel numero = new JLabel(String.valueOf(value + 1));
		numero.setPreferredSize(getPreferredSize());
		numero.setFont(font);
		numero.setForeground(Color.GREEN);
		numero.setHorizontalAlignment(SwingConstants.CENTER);
		super.add(numero, BorderLayout.CENTER);
	}

	/**
	 * Dessine la case en red�finissant paintComponent(Graphics) de JComponent.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (isBlank) {
			setBackground(Color.WHITE);
			return;
		}
		/**
		 * On cr�� une Image rescale de l'originale � chaque fois qu'on doit repeindre.
		 * On fait �a pour �tre s�r que l'image dessin�e ait toujours la bonne
		 * dimension.
		 */
		Image image = img.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
		new ImageIcon(image).paintIcon(this, g, 0, 0);
	}

	/**
	 * @return Retourne la valeur de cette case.
	 */
	public int getValue() {
		return value;
	}
}