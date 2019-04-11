package cz.alisma.alej.text.wrapping;

import java.util.Scanner;

public class Zarovnani {
    static int MAX_WIDTH = 50;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParagraphDetector pd = new ParagraphDetector(input);
        Aligner aligner = new LeftAligner();
        for (int i = 0; i < args.length; i++){
          if (args[i] == "-w"){
            MAX_WIDTH = Integer.ParseInt(args[i+1]);
            break;
          }
          else if(args[i].startsWith("--width="){
            char[] temp = args[i]. toCharArray();
            String numero;
            for(int j = 8; j < temp.length; j++){
              numero = numero.concat(temp[j]);
            }
            MAX_WIDTH = Integer.ParseInt(numero);
          }
          break;
          else if(args[i] == "--right"){
            Aligner aligner = new RightAligner();
          }
          else if(args[i] == "--center" || args[i] == "--centre"){
            Aligner aligner = new CenterAligner();
          }
          else if(args[i] == "--justify"){
            Aligner aligner = new BlokAligner();
          }
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