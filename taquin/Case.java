package taquin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class Case extends JPanel {
	private static final long serialVersionUID = 1L;
	/**
	 * L'image originale
	 */
	private ImageIcon img;
	private int value;
	private boolean isBlank;

	public Case(int value, ImageIcon img) {
		this.img = img;
		this.isBlank = img.getImageLoadStatus() == MediaTracker.ERRORED;
		this.value = value;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (isBlank) {
			setBackground(Color.WHITE);
			return;
		}
		/**
		 * On créé une Image rescale de l'originale
		 */
		Image image = img.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
		new ImageIcon(image).paintIcon(this, g, 0, 0);
	}
	
	public int getValue() {
		return value;
	}
}