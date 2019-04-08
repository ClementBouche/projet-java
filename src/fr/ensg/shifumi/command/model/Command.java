package fr.ensg.shifumi.command.model;

import java.util.List;

/**
 * Classe d'entrée du programme
 * @author cbouche
 */
public abstract class Command {
	
	private String name;
	
	private List<Parameter> allowedParameters;

	private String helpMessage;

	public Command(String name, String helpMessage, List<Parameter> allowedParameters) {
		this.name = name;
		this.helpMessage = helpMessage;
		this.allowedParameters = allowedParameters;
	}

	@Override
	public String toString() {
	    String commandStr = name + " ";
		for (Parameter parameter : allowedParameters) {
			commandStr += parameter.toString();
		}
		return commandStr.toString();
	}

	public String getHelpMessage() {
	    String commandStr = "  " + name + " ";
		for (Parameter parameter : allowedParameters) {
			commandStr += parameter.toString() + " ";
		}
		commandStr += "\n";
		for (Parameter parameter : allowedParameters) {
			commandStr += "    -" + parameter.getHelpParamater() + "\n";
		}
		return helpMessage + "\n" + commandStr.toString();
	}
	
	public List<Parameter> getAllowedParameters() {
		return allowedParameters;
	}
	
	public Parameter getParameter(String name) {
		for (Parameter parameter : allowedParameters) {
			if (parameter.getShortName().equals(name)) {
				return parameter;
			}
			if (parameter.getName().equals(name)) {
				return parameter;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}


	public abstract void exec(String[] args);
}
