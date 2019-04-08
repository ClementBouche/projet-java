package fr.ensg.shifumi.command;

import java.util.ArrayList;
import java.util.List;

import fr.ensg.shifumi.command.model.Command;
import fr.ensg.shifumi.command.model.Parameter;

public class Commands {
	
	private static List<Command> commands;

	public static List<Command> getRegisterCommands() {
		if (commands == null) {
			commands = new ArrayList<Command>();
			// help command
			{
				List<Parameter> params = new ArrayList<Parameter>();
				params.add(new Parameter("commandName", "cmd", "Nom de la commande à afficher, affiche l'aide générale sinon", false));
				Command helpCommand = new HelpCommand("help", "Commande d'aide du programme ShiFuMi", params);
				commands.add(helpCommand);
			}
			// login command
			{
				List<Parameter> params = new ArrayList<Parameter>();
				params.add(new Parameter("user", "u", "username", true));
				params.add(new Parameter("password", "pwd", "mot de passe", true));
				Command loginCommand = new LoginCommand("login", "Connexion au compte utilisateur", params);
				commands.add(loginCommand);
			}
			// play command
			{
				List<Parameter> params = new ArrayList<Parameter>();
				params.add(new Parameter("signe", "s", "le signe à jouer", true));
				Command shifumiCommand = new PlayCommand("play", "Joué à Shifumi", params);
				commands.add(shifumiCommand);
			}

		}
		return commands;
	}

	public static Command find(String commandLine) {
		int index = commandLine.indexOf(" ");
		if (index == -1) {
			index = commandLine.length();
		}
		String cmdName = commandLine.substring(0, index);
		for (Command command : getRegisterCommands()) {
			if (command.getName().equals(cmdName)) {
				return command;
			}
		}
		return null;
	}

}
