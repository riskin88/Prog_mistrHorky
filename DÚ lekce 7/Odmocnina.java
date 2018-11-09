public class Odmocnina {
    public static void main(String[] args) {
		double cislo = Double.parseDouble(args[0]);
		double presnost = Double.parseDouble(args[1]);
		double x1 = cislo;
		double x2 = 0;
		while (true){
			x2 = (x1 + cislo/x1) / 2;
			if (Math.abs(x2 - x1) <= presnost){
				break;
			}
			x1 = x2;			
		}
		System.out.printf("%f", x2);
	}
}