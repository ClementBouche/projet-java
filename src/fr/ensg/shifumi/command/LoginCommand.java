package fr.ensg.shifumi.command;

import java.util.List;

import fr.ensg.shifumi.command.model.Command;
import fr.ensg.shifumi.command.model.Parameter;

public class LoginCommand extends Command {

	public LoginCommand(String name, String helpMessage, List<Parameter> allowedParameters) {
		super(name, helpMessage, allowedParameters);
	}

	@Override
	public void exec(String[] args) {
		String username = getParameter("user").getValue(args);
		String password = getParameter("pwd").getValue(args);
		
		if (username == null || password == null) {
			System.out.println("La commande 'login' est mal écrite");
			System.out.println(this.toString());
			return;
		}
		
		// TODO mettre en place la connection ....
		
		System.out.println("Vous êtes connecté en tant que " + username);
	}

}
