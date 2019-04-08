package fr.ensg.shifumi.command;

import java.util.List;

import fr.ensg.shifumi.command.model.Command;
import fr.ensg.shifumi.command.model.Parameter;
import fr.ensg.shifumi.game.Shifumi;
import fr.ensg.shifumi.game.manager.UserManager;
import fr.ensg.shifumi.game.model.User;

public class LoginCommand extends Command {

	public LoginCommand(String name, String helpMessage, List<Parameter> allowedParameters) {
		super(name, helpMessage, allowedParameters);
	}
	
	@Override
	public String getHelpMessage() {
		return super.getHelpMessage()
				+ "login --user=cbouche --password=cbouche" + "\n";
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
		
		User user = UserManager.signin(username, password);
		if (user == null) {
			System.out.println("L'utilisateur est inconnu ou le password invalide");
			return;
		}

		// TODO mettre en place la connection ....
		Shifumi.getInstance().setLoggedUser(user);
		System.out.println("Vous êtes connecté en tant que " + username);
	}

}
