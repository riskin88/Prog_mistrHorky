import java.util.ArrayList;
import java.util.List;

public class Graf {
	
	public static int zjistiNejvetsi(List<Integer> cisla){
		int maximum = 0;
		for (int i = 0; i < cisla.size(); i++){
			if (cisla.get(i) >= maximum){
				maximum = cisla.get(i);
			}
		}
		return maximum;
	}
	public static void tisk(List<Integer> cisla){
		int vyskaplatna = zjistiNejvetsi(cisla) + 20;
		int sirkaplatna = cisla.size() * 20 + (cisla.size() - 1) * 5 + 20;
		System.out.printf("<?xml version=\"1.0\"?><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"%d\" height=\"%d\" viewBox=\"0 0 %d %d\">",
		sirkaplatna, vyskaplatna, sirkaplatna, vyskaplatna);
		for (int i = 0; i < cisla.size(); i++){
			System.out.printf("<rect x=\"%d\" y=\"%d\" width=\"20\" height=\"%d\" fill=\"blue\" stroke=\"black\" stroke-width=\"2\"/>",
			10 + 25 * i, vyskaplatna - cisla.get(i) - 10, cisla.get(i));
		}
		System.out.println("</svg>");
	}
	
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		   List<Integer> cisla = new ArrayList<>();
		while (sc.hasNextInt()){
			cisla.add(sc.nextInt());
		}
		if (zjistiNejvetsi(cisla) > 60){ /* pokud je neco vetsi nez 60, menime hodnoty, jinak nechame puvodni cisla */
			double ratio = (double)(zjistiNejvetsi(cisla)) / 60; /* pocita pomer ku 60 */
			for (int i = 0; i < cisla.size(); i++){
				cisla.set(i, (int)(cisla.get(i) / ratio));
			}
		}
		tisk(cisla);
	}
}