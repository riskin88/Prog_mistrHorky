public class maximum {
    public static void main(String args[]) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int maximum = 0;
		int cislo = 0;
		while (sc.hasNextInt()) {
			cislo = sc.nextInt();
			if (cislo > maximum){
				maximum = cislo;
			}
		}
		System.out.printf("Největší číslo je: \n%d", maximum);
	}
}