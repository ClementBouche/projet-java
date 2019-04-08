package fr.ensg.shifumi.game;

import fr.ensg.shifumi.game.model.User;

public class Shifumi {
	
	User loggedUser;
	
	private static Shifumi instance;
	
	public Shifumi() {
	}
	
	public static Shifumi getInstance() {
		if (instance == null) {
			instance = new Shifumi();
		}
		return instance;
	}

	public void loadBdd() {
		// TODO chargé les données utilisateurs ?
	}
	
	
	public User getLoggedUser() {
		return loggedUser;
	}


	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
	
}
