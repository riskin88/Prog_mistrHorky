public class srafovani {
    public static void main(String[] args) {
        int vyska = 10;
        int pruhy = 5;
        for (int radekcounter = 1; radekcounter <= vyska; radekcounter++){
            for (int odsazeni = 1; odsazeni < radekcounter; odsazeni++){
                System.out.printf(" ");
            }
            if (pruhy > 0)
                System.out.printf("##");
            for (int pruhcounter = 1; pruhcounter < pruhy; pruhcounter++){
                System.out.printf("  ##");
            }
            System.out.println("");
        }
    }
}