package cz.alisma.alej.text.wrapping;

import java.util.Scanner;

public class Zarovnani {

	public static void main(String[] args) {
		int MAX_WIDTH = 50;
		Scanner input = new Scanner(System.in);
		ParagraphDetector pd = new ParagraphDetector(input);
		Aligner aligner = new LeftAligner();
		int alignerIndex = 0;
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-w")) {
				MAX_WIDTH = Integer.parseInt(args[i + 1]);
			} else if (args[i].startsWith("--width=")) {
				char[] temp = args[i].toCharArray();
				String numero = "";
				for (int j = 8; j < temp.length; j++) {
					numero = numero.concat(Character.toString(temp[j]));
				}
				MAX_WIDTH = Integer.parseInt(numero);
			}

			else if (args[i].equals("--right")) {
				alignerIndex = 1;
			} else if (args[i].equals("--center") || args[i].equals("--centre")) {
				alignerIndex = 2;
			} else if (args[i].equals("--justify")) {
				alignerIndex = 3;
			}
		}
		
		switch (alignerIndex) {
		case 0:
			aligner = new LeftAligner();
			break;
		
		case 1:
			aligner = new RightAligner(MAX_WIDTH);
			break;
		
		case 2:
			aligner = new CenterAligner(MAX_WIDTH);
			break;
			
		case 3:
			aligner = new BlokAligner(MAX_WIDTH);
			break;
		}

		while (pd.hasNextParagraph()) {
			Paragraph para = pd.nextParagraph();
			LinePrinter line = new LinePrinter(System.out, MAX_WIDTH, aligner);
			while (para.hasNextWord()) {
				String word = para.nextWord();
				line.addWord(word);
			}
			line.flush();
			System.out.println();
		}
	}
}