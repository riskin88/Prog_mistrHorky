package sablony;

import java.util.HashMap;

public class Sablonator {

	public static void main(String[] args) {
		HashMap<String, String> variables = new HashMap<String, String>();
		int i = 0;
		while (args.length > i) {
			String argument = args[i];
			if (argument.startsWith("--var=")) {
				String[] mapElement = argument.substring(6).split("=");
				variables.put(mapElement[0], mapElement[1]);
			}
			i++;
		}
		java.util.Scanner sc = new java.util.Scanner(System.in);
		while (sc.hasNextLine()) {
			String lajna = sc.nextLine();
			String[] words = lajna.split(" ");
			for (int j = 0; j < words.length; j++) {
				if (words[j].equals("{{")) {
					if (variables.containsKey(words[j + 1])) {
						words[j + 1] = variables.get(words[j + 1]);
					}
				}
				if (!(words[j].equals("{{")) && !(words[j].equals("}}")))
					System.out.printf("%s ", words[j]);
			}
			System.out.println("");
		}
	}
}
