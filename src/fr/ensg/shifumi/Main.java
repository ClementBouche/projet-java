package fr.ensg.shifumi;

import java.util.Scanner;

import fr.ensg.shifumi.command.Commands;
import fr.ensg.shifumi.command.model.Command;

public class Main {
	
	/**
	 * main executé à l'ouverture du programme
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getWelcomeMessage());

		Scanner scanner = new Scanner(System.in);
		System.out.print("shifumi$>");
		while (scanner.hasNext()) {
			String commandLine = scanner.nextLine();
			if (commandLine.equals("exit")) {
				break;
			}
			Command command = Commands.find(commandLine);
			if (command != null) {
				command.exec(commandLine.split(" "));
			} else {
				System.out.println("Commande inconnue");
			}
			System.out.print("shifumi$>");
		}

		System.out.println("Le programme est terminé");
		scanner.close();
	}

	
	private static String getWelcomeMessage() {
		String str = "======================================================\n"
				+ "Bievenue dans le programme ShiFuMi ! \n"
				+ "Vous pouvez réaliser les commandes suivantes :\n";
		for (Command command : Commands.getRegisterCommands()) {
			str += "  -" + command.toString() + "\n";
		}
		str += "======================================================";
		return str;
	}
	
}
