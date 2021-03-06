import java.util.ArrayList;
import java.util.List;

public class CetnostCisel {
	
	public static void main(String[] args) {
		
		List<int[]> cisla = new ArrayList<>();
		 java.util.Scanner sc = new java.util.Scanner(System.in);
		 int aktualnicislo;
		 cisla.add(new int[2]);
		 cisla.get(0)[0] = sc.nextInt();
		 cisla.get(0)[1] = 1;
		 while (sc.hasNextInt()) {
			 aktualnicislo = sc.nextInt();
			 for (int i = 0; i < cisla.size(); i++){
				 if (aktualnicislo == cisla.get(i)[0]){
					 cisla.get(i)[1]++;
					 break;
				 }
				 else if (i == cisla.size() - 1){   // pokud uz byl vyzkousen cely list a stale nebylo nalezeno shodne cislo, zapis nove cislo nakonec
					 cisla.add(new int[2]);
					 cisla.get(cisla.size() - 1)[0] = aktualnicislo;
					 cisla.get(cisla.size() - 1)[1] = 0;
				 }
			 }
		 }
		 bubbleSort(cisla);
		 for (int i = 0; i < cisla.size(); i++){
			 System.out.printf("%dx %d, ", cisla.get(i)[1], cisla.get(i)[0]);
		 }
	}
	
	public static void bubbleSort(List<int[]> cisla){
		for (int i = 0; i < cisla.size() - 1; i++) {
			for (int j = 0; j < cisla.size() - i - 1; j++) {
				if (cisla.get(j)[1] < cisla.get(j + 1)[1]){
					int[] docasny = cisla.get(j);
					cisla.set(j, cisla.get(j + 1));
					cisla.set(j + 1, docasny);
				}
			}
		}
	}  

}
			