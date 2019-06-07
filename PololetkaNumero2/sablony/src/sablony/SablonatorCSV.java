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

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;

public class SablonatorCSV {

	public static void main(String[] args) throws IOException {
		String outputName = "bytosti-slozenky-%05d.txt";
		boolean csvProvided = false;
		String csvFileName = "";
		int i = 0;
		while (args.length > i) {
			String argument = args[i];
			if (argument.startsWith("--csv=")) {
				csvFileName = argument.substring(6);
				csvProvided = true;
				break;
			}
			if (argument.startsWith("--template=")) {
				FileReader template = new FileReader(argument.substring(11));
				break;
			}
			if (argument.startsWith("--out=")) {
				outputName = argument.substring(6);
				break;
			}
			i++;
		}
		java.util.Scanner sc = new java.util.Scanner(System.in);
		if (csvProvided) {
			FileReader csvFile = new FileReader(csvFileName);
			sc = new java.util.Scanner(csvFile);
		}
		
	}

}
