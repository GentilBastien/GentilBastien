package taquin;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Cool taquin
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class GrilleGraphique extends Grille {

	public static void main(String[] args) {
		new GrilleGraphique(3 * 3);
	}

	private JFrame frame;
	private JPanel panel;

	private ImageIcon[] imgs;
	private Case[] cases;
	private final int dim;

	public GrilleGraphique(int size) {
		super(size);
		imgs = new ImageIcon[size];
		cases = new Case[size];
		dim = (int) Math.sqrt(size);
		initFrame();
	}

	private void initFrame() {
		frame = new JFrame("Jeu du Taquin");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

		panel = new JPanel(new GridLayout(dim, dim, 1, 1));
		decouperImage("img//dimi.png");

		for (int i = 0; i < size; i++)
			cases[i] = new Case(i, imgs[ordre[i]]);

		updateGrille();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

	private void decouperImage(String path) {
		if (path == null)
			throw new IllegalArgumentException("L'image est null.");

		ImageIcon img = new ImageIcon(path);
		if (img.getIconWidth() != img.getIconHeight())
			throw new IllegalArgumentException("L'image n'est pas carrée.");

		int preferredSize = 600, l = preferredSize / dim;

		BufferedImage buff = new BufferedImage(preferredSize, preferredSize, BufferedImage.TYPE_INT_RGB);
		Graphics g = buff.createGraphics();
		g.drawImage(img.getImage(), 0, 0, null);

		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++) {
				int idx = i * dim + j;
				imgs[idx] = idx == size - 1 ? new ImageIcon("") : new ImageIcon(buff.getSubimage(i * l, j * l, l, l));
			}
	}

	public void updateGrille() {
		panel.removeAll();
		for (Case c : cases)
			panel.add(c);
	}
}