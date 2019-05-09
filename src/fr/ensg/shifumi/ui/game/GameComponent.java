package fr.ensg.shifumi.ui.game;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class GameComponent extends JPanel {

	private static final long serialVersionUID = -662083897365027688L;
	
	public static final String NAME = "GameComponent";
	
	public GameComponent() {
		setName(NAME);
		
		setLayout(new GridLayout(0, 1));
		Border border = BorderFactory.createTitledBorder("Shifumi");
		setBorder(border);

		ButtonGroup group = new ButtonGroup();
		JRadioButton radio1 = new JRadioButton("Pierre", true);
		JRadioButton radio2 = new JRadioButton("Feuille");
		JRadioButton radio3 = new JRadioButton("Ciseaux 2");
		group.add(radio1);
		add(radio1);
		group.add(radio2);
		add(radio2);
		group.add(radio3);
		add(radio3);
	}
	
}
