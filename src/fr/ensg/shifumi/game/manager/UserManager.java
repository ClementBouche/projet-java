package fr.ensg.shifumi.game.manager;

import fr.ensg.shifumi.game.model.User;

public class UserManager {

	public static User signin(String username, String password) {
		// TODO se connnecter à la base
		return new User(username, password);
	}

}
