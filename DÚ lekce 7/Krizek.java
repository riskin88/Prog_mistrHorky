public class Krizek {
    public static void main(String[] args) {
		int velikost = Integer.parseInt(args[0]);
		Ctverecek(velikost);
		for (int lajna = 0; lajna < (int)(0.666666667 * velikost); lajna++){
			Opakuj('X', 2 * (int)(1.5 * velikost) + velikost);
			System.out.println("");
		}
		Ctverecek(velikost);
	}
	public static void Opakuj(char znak, int kolikrat){
		for (int i = 0; i < kolikrat; i++){
			System.out.printf("%c", znak);
		}
	}
	public static void Ctverecek(int rozmer){
		for (int i = 0; i < rozmer; i++){
			Opakuj(' ', (int)(1.5 * rozmer));
			Opakuj('X', rozmer);
			System.out.println("");
		}
	}
}