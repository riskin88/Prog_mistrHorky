public class Vlnovka {
	
	public static void main(String[] args) {
		int vyska = Integer.parseInt(args[0]);
		int sirka = 80;
		for (int sloupec = 0; sloupec < vyska; sloupec++){
			for (int radek = 0; radek < sirka; radek++){
				if (cozTakhleDatSiKanal(radek, sloupec, vyska)){
					System.out.printf("#");
				}
				else{
					System.out.printf(" ");
				}
			}
			System.out.println("");
		}
	}
	
	private static boolean cozTakhleDatSiKanal(int radek, int sloupec, int vyska){
		// (2 * vyska - 2) je interval mezi kanaly v jednotlivych radcich
		if ((radek - sloupec) % (2 * vyska - 2) == 0 || (radek + sloupec) % (2 * vyska - 2) == 0){
			return true;
		}
		else {
			return false;
		}
	}
}
