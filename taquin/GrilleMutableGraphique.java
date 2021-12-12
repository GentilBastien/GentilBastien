package taquin;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe qui décrit l'interface graphique d'une grille mutable de Taquin.
 * 
 * @author GATTACIECCA Basti1
 * @author POLYDORAS Dimi3
 * @author DESCOTILS Juli8
 *
 */
public class GrilleMutableGraphique extends GrilleMutable {

	public static void main(String[] args) {
		new GrilleMutableGraphique(5 * 5, "img//dimi.png");
	}

	/**
	 * La JFrame utilisée pour le jeu.
	 */
	private JFrame frame;
	/**
	 * Le JPanel contenu par la JFrame, et qui contient les cases du Taquin./
	 */
	private JPanel panel;
	/**
	 * Tableau d'images qui sert à stocker les images pour initialiser les cases. À
	 * noter qu'on utilise ce tableau uniquement pour l'initialisation des cases
	 * avec leur image. Donc ce tableau n'est jamais modifié par le programme, et
	 * les images sont stockées dans l'ordre.
	 */
	private ImageIcon[] imgs;
	/**
	 * Tableau de cases qui sert à initialiser les cases dans l'ordre. Quand on
	 * déplace une case, et pour mettre à jour la grille graphique, on vide le panel
	 * puis on rajoute toutes les cases dans le bon ordre.
	 */
	private Case[] cases;
	/**
	 * Chemin de l'image finale du Taquin.
	 */
	private final String imagePath;

	/**
	 * Construit une GrilleGraphique à partir de la taille totale de cases.
	 * 
	 * @param size Le nombre de cases total.
	 */
	public GrilleMutableGraphique(int size, final String path) {
		super(size);
		imagePath = path;
		imgs = new ImageIcon[size];
		cases = new Case[size];

		initFrame();
	}

	private void initFrame() {
		frame = new JFrame("Jeu du Taquin");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		;
		panel = new JPanel(new GridLayout(dim, dim, 1, 1));
		/*
		 * Initialise les petites images découpées.
		 */
		decouperImage();

		for (int i = 0; i < size; i++) {
			cases[i] = new Case(i, imgs[i]);
			cases[i].addActionListener(moveCase);
		}

		updateGrille();
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

	private final ActionListener moveCase = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Case c = (Case) e.getSource();
			if (deplacerCase(c.getValue()))
				updateGrille();
		}
	};

	/**
	 * Découpe l'image totale originale en fonction de la dimension et stocke chaque
	 * petite image dans le tableau d'image pour initialiser chacune d'elles.
	 */
	private void decouperImage() {
		if (imagePath == null)
			throw new IllegalArgumentException("L'image est null.");

		ImageIcon img = new ImageIcon(imagePath);
		if (img.getIconWidth() != img.getIconHeight())
			throw new IllegalArgumentException("L'image n'est pas carrée.");
		/*
		 * La taille préférée est celle de l'image par défaut telle qu'elle est lue.
		 */
		int preferredSize = img.getIconWidth(), l = preferredSize / dim;
		/*
		 * On créé un contexte graphique dans lequel on dessine notre image.
		 */
		BufferedImage buff = new BufferedImage(preferredSize, preferredSize, BufferedImage.TYPE_INT_RGB);
		Graphics g = buff.createGraphics();
		g.drawImage(img.getImage(), 0, 0, null);

		for (int i = 0; i < dim; i++)
			for (int j = 0; j < dim; j++) {
				int idx = i * dim + j;
				imgs[idx] = idx == size - 1 ? new ImageIcon("") : new ImageIcon(buff.getSubimage(j * l, i * l, l, l));
			}
	}

	/**
	 * Met à jour la grille en replaçant toutes les cases dans le bon ordre, puis
	 * revalide le panel.
	 */
	public void updateGrille() {
		panel.removeAll();
		for (int i = 0; i < size; i++)
			panel.add(cases[ordre.get(i)]);
		panel.revalidate();
	}
}