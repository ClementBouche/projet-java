package fr.ensg.shifumi.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.ensg.shifumi.ui.footer.FooterComponent;
import fr.ensg.shifumi.ui.game.GameComponent;
import fr.ensg.shifumi.ui.menu.MenuComponent;
import fr.ensg.shifumi.ui.user.UserComponent;

public class FenetrePrincipale extends JFrame {
	
	private static final long serialVersionUID = 6194656098551979937L;
	
	private List<JPanel> panels;
	
	private JPanel currentPanel;

	public FenetrePrincipale() {
		// apparence de la fenetre
		setTitle("Shifumi");
		setSize(new Dimension(800, 600));
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// contenu
		setLayout(new BorderLayout());
		add(new MenuComponent(this), BorderLayout.PAGE_START);
		// page par défault
//		for (JPanel jPanel : getPanels()) {
//			add(jPanel, BorderLayout.CENTER);
//		}
		currentPanel = new UserComponent();
		add(currentPanel, BorderLayout.CENTER);
		add(new FooterComponent(), BorderLayout.PAGE_END);
	}
	
	
	public void showComponent(String name) {
		BorderLayout layout = (BorderLayout)getLayout();
		remove(layout.getLayoutComponent(BorderLayout.CENTER));
		for (JPanel jPanel : getPanels()) {
			if (jPanel.getName().equals(name)) {
				System.out.println("ajout " + name);
				add(jPanel, BorderLayout.CENTER);
				currentPanel = jPanel;
			}
		}
		revalidate();
		repaint();
	}
	
	
	public List<JPanel> getPanels() {
		if (panels == null) {
			panels = new ArrayList<JPanel>();
			panels.add(new GameComponent());
			panels.add(new UserComponent());
		}
		return panels;
	}

}
