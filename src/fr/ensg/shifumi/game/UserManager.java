package fr.ensg.shifumi.game;

public class UserManager {

	public static User signin(String username, String password) {
		// TODO se connnecter à la base
		return new User(username, password);
	}

}
