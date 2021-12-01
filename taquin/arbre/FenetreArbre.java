package taquin.arbre;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTree;

public class FenetreArbre extends JFrame {
	private static final long serialVersionUID = 1L;

	private Arbre arbre;
	
	public static void main(String[] args) {
		new FenetreArbre();
	}

	public FenetreArbre() {
		arbre = new Arbre();
		initialize();
		setVisible(true);
	}
	
	private void initialize() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JTree tree = new JTree(arbre.getEntree());
		scrollPane.setViewportView(tree);
	}

}
