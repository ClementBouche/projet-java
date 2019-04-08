package fr.ensg.shifumi.command;

import java.util.List;

import fr.ensg.shifumi.command.model.Command;
import fr.ensg.shifumi.command.model.Parameter;
import fr.ensg.shifumi.game.Play;
import fr.ensg.shifumi.game.Shifumi;
import fr.ensg.shifumi.game.User;

public class PlayCommand extends Command {

	public PlayCommand(String name, String helpMessage, List<Parameter> allowedParameters) {
		super(name, helpMessage, allowedParameters);
	}
	
	@Override
	public String getHelpMessage() {
		return super.getHelpMessage()
				+ "play --signe=Pierre" + "\n";
	}

	@Override
	public void exec(String[] args) {
		String signe = getParameter("signe").getValue(args);
		if (signe == null) {
			System.out.println("Commande play en erreur il manque le paramètre --signe");
			return;
		}
		
		// nouvelle partie
		Play play = new Play();
		boolean win = play.playAgainstComputer(signe);

		// ajout
		User user = Shifumi.getInstance().getLoggedUser();
		if (user == null) {
			System.out.println("Vous n'êtes pas connecté la partie n'est pas enregistré");
			return;
		}
		user.setNbPartie(user.getNbPartie() + 1);
		if (win) {
			user.setNbVictoires(user.getNbVictoires() + 1);
		}
		
		System.out.println(String.format(
				"Vous avez gagné %s / %s parties", user.getNbVictoires(), user.getNbPartie()
		));
	}

}
