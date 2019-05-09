package fr.ensg.shifumi.ui.footer;

import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FooterComponent extends JPanel {

	private static final long serialVersionUID = 6178906771739815955L;

	public FooterComponent() {
		setSize(new Dimension(800, 80));
		
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
		
		setVisible(true);
	}

}
