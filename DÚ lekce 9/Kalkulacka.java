public class Kalkulacka {
    public static void main(String[] args) {
      String[] cleny = args[0].split("\\+");
      int vysledek = 0;
      for (int i = 0; i < cleny.length; i++){
        String[] cinitele = cleny[i].split("x");
        int clen = 1;
          for (int j = 0; j < cinitele.length; j++){
            clen *= Integer.parseInt(cinitele[j]);
          }
        vysledek += clen;
      }
      System.out.printf("%d", vysledek);
    }
  }
      