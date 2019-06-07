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

import java.util.HashMap;
import java.util.Iterator;


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
					j++;
					String key = words[j];
					j++;
					while (!words[j].equals("}}")) {
						key = key.concat(" " + words[j]);
						j++;
					}
					if (variables.containsKey(key)) {
						String variable = variables.get(key);
						System.out.printf("%s ", variable);
					}
					else {
						System.out.printf("###");
						System.out.printf("%s ", key);
					}
				}
				else
				System.out.printf("%s ", words[j]);
			}
			System.out.println("");
		}
		Iterator iterator = variables.keySet().iterator();
		  
		while (iterator.hasNext()) {
		   String key = iterator.next().toString();
		   String value = variables.get(key).toString();
		  
		   System.out.println(key + " - " + value);
		}
	}
}
