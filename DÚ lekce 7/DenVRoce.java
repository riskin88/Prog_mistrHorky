public class DenVRoce {
    public static void main(String[] args) {
		int rok = Integer.parseInt(args[0]);
		int mesic = Integer.parseInt(args[1]);
		int den = Integer.parseInt(args[2]);
		int celkemdni = 0;
		int[] mesice = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (jePrestupny(rok)){
		mesice[1]++;
		}
		for (int i = 0; i < mesic - 1; i++){
        celkemdni += mesice[i];           
		}
      celkemdni += den;
      System.out.printf("%d\n", celkemdni);
	}
	public static boolean jePrestupny(int rok) {
		return (rok % 4 == 0 && rok % 100 != 0 || rok % 400 == 0);
	}
}
      
        
      