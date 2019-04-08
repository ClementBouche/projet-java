package fr.ensg.shifumi.game.model;

public class User {
	
	private String username;
	
	private String password;
	
	private int nbPartie;
	
	private int nbVictoires;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.nbPartie = 0;
		this.nbVictoires = 0;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getNbPartie() {
		return nbPartie;
	}
	
	public void setNbPartie(int nbPartie) {
		this.nbPartie = nbPartie;
	}

	public int getNbVictoires() {
		return nbVictoires;
	}
	
	public void setNbVictoires(int nbVictoires) {
		this.nbVictoires = nbVictoires;
	}

}
