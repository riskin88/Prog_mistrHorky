/*
 * MIT License
 * Copyright (c) 2019 Jenda Hlavacu Industries a.s.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package sablony;

import java.util.Scanner;

import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.io.FileWriter;

public class SablonatorCSV {

	public static void main(String[] args) throws IOException {
		String outputName = "templater-out-%05d.txt";
		Scanner csv = new Scanner(System.in);
		File templateFile = null;
		for (int i = 0; i < args.length; i++) {
			String argument = args[i];
			if (argument.startsWith("--csv=")) {
				File csvFile = new File(argument.substring(6));
				csv = new Scanner(csvFile);
				continue;
			}
			if (argument.startsWith("--template=")) {
				templateFile = new File(argument.substring(11));
				continue;
			}
			if (argument.startsWith("--out=")) {
				outputName = argument.substring(6);
				continue;
			}
		}
		String[] keys;
		String keysString = csv.nextLine();
		keys = keysString.split(",");
		int fileNum = 1;
		while (csv.hasNextLine()) {
			String lajna = csv.nextLine();
			String[] values = lajna.split(",");
			HashMap<String, String> variables = new HashMap<String, String>();
			for (int i = 0; i < keys.length; i++) {
				variables.put(keys[i], values[i]);
			}
			FileWriter outputFile = new FileWriter(String.format(outputName, fileNum));
			Scanner template = new Scanner(templateFile);
			ryplejs(template, variables, outputFile);
			outputFile.close();
			fileNum++;
		}
	}

	public static void ryplejs(Scanner template, HashMap<String, String> variables, FileWriter file)
			throws IOException {
		while (template.hasNextLine()) {
			String lajna = template.nextLine();
			String[] words = lajna.split(" ");
			for (int j = 0; j < words.length; j++) {
				if (words[j].equals("{{")) {
					j++;
					String key = words[j];
					j++;
					while (!words[j].equals("}}")) {
						key = key.concat(" " + words[j]);
						j++;
					}
					if (variables.containsKey(key)) {
						String variable = variables.get(key);
						file.write(variable + " ");

					} else {
						file.write("CHYBA");
					}
				} else
					file.write(words[j] + " ");
			}
			file.write("\n");
		}
	}
}