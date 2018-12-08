public class Seq {
	
	public static void main(String[] args) {
		
		String oddelovac = urciOddelovac(args);
		int posunIndexu = 0;
		if (menimeOddelovac(args)){
			posunIndexu = 2;
		}
		if (args.length == 1  + posunIndexu){
			vypisRadu(1, Integer.parseInt(args[0 + posunIndexu]), oddelovac);
		}
		else if (args.length == 2 + posunIndexu){
			vypisRadu (Integer.parseInt(args[0 + posunIndexu]), Integer.parseInt(args[1 + posunIndexu]), oddelovac);
		}
		else{
			vypisRaduSKrokem (Integer.parseInt(args[0 + posunIndexu]), Integer.parseInt(args[1 + posunIndexu]), Integer.parseInt(args[2 + posunIndexu]), oddelovac);
		}
	}
	
	public static boolean menimeOddelovac (String[] args){
		return (args[0].equals("-s"));
	}
	
	public static String urciOddelovac (String[] args){
		String oddelovac = " ";
		if (menimeOddelovac(args)){
			oddelovac = args[1];
		}
		return oddelovac;
	}
	
	public static void vypisRadu (int zacatek, int konec, String oddelovac){
		for (int i = zacatek; i <= konec; i++){
			if (i == konec){
				oddelovac = "";
			}
			System.out.printf ("%d%s", i, oddelovac);
		}
		System.out.println("");
	}
	
	public static void vypisRaduSKrokem (int zacatek, int krok, int konec, String oddelovac){
		if (krok > 0){
			for (int i = zacatek; i <= konec; i += krok){
				if (i + krok > konec){
					oddelovac = "";
				}
				System.out.printf ("%d%s", i, oddelovac);
			}
			System.out.println("");
		}
		else{
			for (int i = zacatek; i >= konec; i += krok){
				if (i + krok < konec){
					oddelovac = "";
				}
				System.out.printf ("%d%s", i, oddelovac);
			}
			System.out.println("");
		}
	}
}