package fr.ensg.shifumi.game;

public class Play {

	public static final String PIERRE = "Pierre";

	public static final String FEUILLE = "Feuille";

	public static final String CISEAUX = "Ciseaux";

	private static final String[] computerChoices = {PIERRE, FEUILLE, CISEAUX};

	public Play() {
	}
	
	/**
	 * 
	 * @param signe le signe de user
	 * @return boolean, vrai si user a gagné
	 */
	public boolean playAgainstComputer(String signe) {
		int random = (int)(Math.floor(Math.random() * 3));
		String choice = computerChoices[random];
		
		if (compare(signe, choice) == 0) {
			System.out.println(String.format(
				"Egalité, vous avez joué %s et l'ordinateur %s", signe, choice
			));
			return false;
		}
		if (compare(signe, choice) == -1) {
			System.out.println(String.format(
				"Perdu, vous avez joué %s et l'ordinateur %s", signe, choice
			));
			return false;
		}
		if (compare(signe, choice) == 1) {
			System.out.println(String.format(
				"Gagné ! vous avez joué %s et l'ordinateur %s", signe, choice
			));
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param signeA
	 * @param signeB
	 * @return 0 en cas d'égalité, 1 si signeA gagne, -1 sinon
	 */
	private int compare(String signeA, String signeB) {
		if (signeA.equals(signeB)) {
			return 0;
		}
		switch (signeA) {
			case PIERRE:
				if (signeB.equals(CISEAUX)) {
					return 1;
				} else {
					return -1;
				}
			case FEUILLE:
				if (signeB.equals(PIERRE)) {
					return 1;
				} else {
					return -1;
				}
			case CISEAUX:
				if (signeB.equals(FEUILLE)) {
					return 1;
				} else {
					return -1;
				}
			default:
				System.err.println("Je ne connais pas le signe : " + signeA);
				break;
		}
		return 0;
	}

}
