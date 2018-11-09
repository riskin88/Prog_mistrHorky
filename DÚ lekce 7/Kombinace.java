public class Kombinace {
    public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		if (n > 20){
			System.out.println("Error: Zadejte cisla do 20, jinak se to rozbije!");
		}
		else if (k > n){
			System.out.println("Error: k musi byt mensi nez n");
		}
		else{
			long vysledek = faktorial(n) / (faktorial(n - k) * faktorial(k));
			System.out.printf("%d", vysledek);
		}
	}
	public static long faktorial(int cislo){
		long faktorial = 1L;
		for(int i = cislo; i > 1; i--){
			faktorial *= i;
		}
		return faktorial;
	}
}