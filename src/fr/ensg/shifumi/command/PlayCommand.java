package fr.ensg.shifumi.command;

import java.util.List;

import fr.ensg.shifumi.command.model.Command;
import fr.ensg.shifumi.command.model.Parameter;
import fr.ensg.shifumi.game.Play;

public class PlayCommand extends Command {

	public PlayCommand(String name, String helpMessage, List<Parameter> allowedParameters) {
		super(name, helpMessage, allowedParameters);
	}

	@Override
	public void exec(String[] args) {
		String signe = getParameter("signe").getValue(args);
		if (signe == null) {
			System.out.println("Commande play en erreur il manque le paramètre --signe");
			return;
		}
		Play play = new Play();
		play.playAgainstComputer(signe);	
	}

	
	
}
