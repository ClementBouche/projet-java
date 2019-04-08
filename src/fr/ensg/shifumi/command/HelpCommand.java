package fr.ensg.shifumi.command;

import java.util.List;

import fr.ensg.shifumi.command.model.Command;
import fr.ensg.shifumi.command.model.Parameter;

public class HelpCommand extends Command {

	public HelpCommand(String name, String helpMessage, List<Parameter> allowedParameters) {
		super(name, helpMessage, allowedParameters);
	}

	@Override
	public void exec(String[] args) {
		if (args.length < 2) {
			System.out.println(this.getHelpMessage());
			return;
		}

		String cmdToDisplay = getParameter("cmd").getValue(args);
		if (cmdToDisplay == null) {
			System.out.println("La commande 'help' est mal écrite");
			System.out.println(this.toString());
			return;
		}
		
		Command command = Commands.find(cmdToDisplay);
		if (command != null) {
			System.out.println(command.getHelpMessage());
		} else {
			System.out.println("Commande '" + cmdToDisplay + "' inconnue");
		}
	}

}
