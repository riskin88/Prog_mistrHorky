public class Pi {
	
	public static void main(String[] args) {
		int polomer = 1;
		int kruh = 0;
		int celkemBodu = Integer.parseInt(args[0]); // uzivatel si urcuje presnost odhadu
		for (int i = 0; i < celkemBodu; i++){
			double a = Math.random(); // vzdalenost od stredu na souradnicich [1,1] v osach x a y
			double b = Math.random();
			if (a*a + b*b <= polomer * polomer){ // vzdalenost (resp. jeji druha mocnina) od stredu musi byt mensi nebo rovna polomeru kruhu; Pythagorova veta
				kruh++;
			}
		}
		double pi = (double)kruh / ((double)celkemBodu / 4); // tento vztah pro pí lze odvodit ze vzorcu pro obsah ctverce a kruhu
		System.out.printf("%f", pi);
	}
}