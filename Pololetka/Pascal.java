public class Pascal {
	
	public static void main(String[] args) {
		int pocetRadku = Integer.parseInt(args[0]);
		for (int i = 0; i < pocetRadku; i++){
			TiskniOdsazeni(pocetRadku, i);
			for (int j = 0; j <= i; j++){
				System.out.printf("%3d ", kombinacniCislo(i, j));
			}
			System.out.println("");
		}
	}

    public static void TiskniOdsazeni(int pocetRadku, int radek){
		int mezer = 2*(pocetRadku - radek) - 2;
		for (int i = 0; i < mezer; i++){
			System.out.printf(" ");
		}
	}
	public static int kombinacniCislo(int n, int k) {
			int vysledek = faktorial(n) / (faktorial(n - k) * faktorial(k));
			return vysledek;
	}
	
	public static int faktorial(int cislo){
		int faktorial = 1;
		for(int i = cislo; i > 1; i--){
			faktorial *= i;
		}
		return faktorial;
	}
}