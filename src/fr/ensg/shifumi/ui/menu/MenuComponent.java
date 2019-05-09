package fr.ensg.shifumi.ui.menu;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import fr.ensg.shifumi.ui.FenetrePrincipale;
import fr.ensg.shifumi.ui.game.GameComponent;
import fr.ensg.shifumi.ui.user.UserComponent;

public class MenuComponent extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -5405298173627145664L;

	/**
	 * Pour communiquer avec la fenetre parente
	 */
	private FenetrePrincipale fenetrePrincipale;
	
	/**
	 * Permet de detecter quel item je selectionne
	 */
	private JMenuItem itemNew;
	private JMenuItem itemStat;
	private JMenuItem itemUser;
	private JMenuItem itemQuit;

	
	public MenuComponent(FenetrePrincipale fenetrePrincipale) {
		this.fenetrePrincipale = fenetrePrincipale;
		setSize(new Dimension(800, 80));
		
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		itemNew = new JMenuItem("Nouvelle partie");
		itemNew.addActionListener(this);
		menu.add(itemNew);
		itemStat = new JMenuItem("Statistiques");
		itemStat.addActionListener(this);
		menu.add(itemStat);
		itemUser = new JMenuItem("Connection / Déconnection");
		itemUser.addActionListener(this);
		menu.add(itemUser);
		itemQuit = new JMenuItem("Quitter");
		itemQuit.addActionListener(this);
		menu.add(itemQuit);
		
		bar.add(menu);
		add(bar);
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == itemNew) {
			actionNewPlay();
			return;
		}
		if (event.getSource() == itemUser) {
			actionConnection();
			return;
		}
		// TODO ...
		
	}

	private void actionConnection() {
		System.out.println("action Connection");
		fenetrePrincipale.showComponent(UserComponent.NAME);
	}


	private void actionNewPlay() {
		System.out.println("action play");
		fenetrePrincipale.showComponent(GameComponent.NAME);
	}
	
}
