package fr.ensg.shifumi.ui.user;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class UserComponent extends JPanel {
	
	public static final String NAME = "UserComponent";

	private static final long serialVersionUID = -2127373569665595205L;

	public UserComponent() {
		setName(NAME);
		
		setLayout(new GridLayout(0, 1));
		Border border = BorderFactory.createTitledBorder("User");
		setBorder(border);

		ButtonGroup group = new ButtonGroup();
		JRadioButton radio1 = new JRadioButton("Blabla...", true);
		group.add(radio1);
		add(radio1);
	}

}
