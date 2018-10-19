import java.util.ArrayList;
import java.util.List;
public class statistika {
	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		List<Double> cisla = new ArrayList<>();
		double maximum = 0;
		double cislo = 0;
		int pocet = 0;
		double suma = 0;
		double minimum = 0; 
		while (scanner.hasNextDouble()) {
			cislo = scanner.nextDouble();
			cisla.add(pocet, cislo);
			if (pocet == 0){
				minimum = cislo;
			}
			suma += cislo;
			if (cislo > maximum){
				maximum = cislo;
			}
			if (cislo < minimum){
				minimum = cislo;
			}
			pocet++;
		}
		double prumer = suma / pocet;
		double sumactvercu = 0;
		for (int i = 0; i < cisla.size(); i++){
			sumactvercu += (Math.abs((prumer - cisla.get(i))) * Math.abs((prumer - cisla.get(i))));
		}
		double odchylka = Math.sqrt(sumactvercu / pocet);
		System.out.printf("Soucet: %f, Minimum: %f, Maximum: %f, Prumer: %f Odchylka: %f", suma, minimum, maximum, prumer, odchylka);
	}
}