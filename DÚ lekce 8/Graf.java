import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Graf {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		   List<Integer> cisla = new ArrayList<>();
		while (sc.hasNextInt()){
			cisla.add(sc.nextInt());
		}
		Collections.sort(cisla);
		if (cisla.get(cisla.size() - 1) > 60){
			double ratio = (double)(cisla.get(cisla.size() - 1)) / 60;
			for (int i = 0; i < cisla.size(); i++){
				cisla.set(i, (int)(cisla.get(i) / ratio));
			}
		}
		for (int i = 0; i < cisla.size(); i++){
			for (int j = 0; j < cisla.get(i); j++){
				System.out.printf("#");
			}
			System.out.println("");
		}
	}
}