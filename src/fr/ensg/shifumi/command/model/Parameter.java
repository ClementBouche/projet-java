package fr.ensg.shifumi.command.model;

/**
 * @author formation
 */
public class Parameter {
	
	private String name;
	
	private String shortName;
	
	private String description;
	
	private boolean mandatory;
	
	public Parameter(String name, String shortName, String description, boolean mandatory) {
		this.name = name;
		this.shortName = shortName;
		this.description = description;
		this.mandatory = mandatory;
	}
	
	@Override
	public String toString() {
		return "(--" + name + "|-" + shortName + ")=" + name;
	}

	
	public String getHelpParamater() {
		String str = name + ": " + description;
		return str;
	}

	
	public String getExemple() {
		return "help login";
	}
	
	public String getValue(String[] args) {
		for (String arg : args) {
			String search = "-" + shortName + "=";
			int index = arg.indexOf(search);
			if (index == -1) {
				search = "--" + name + "=";
				index = arg.indexOf(search);
			}
			if (index == -1) {
				continue;
			}
			return arg.substring(search.length(), arg.length());
		}
		return null;
	}
	
	public String getShortName() {
		return shortName;
	}
	
	public String getName() {
		return name;
	}

}
