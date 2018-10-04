public class Kvadrat {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double diskriminant = b * b - (4*a*c);
        if (diskriminant < 0) {
            System.out.println ("Rovnice nemá žádný reálný koøen");}
        else {
            if (a == 0) {
		double reseni0 = -c / b;
		System.out.printf ("Rovnice má jedno øešení: %f", reseni0);}
	    else {
	    double reseni1 = (-b + Math.sqrt(diskriminant)) / (2 * a);
            double reseni2 = (-b - Math.sqrt(diskriminant)) / (2 * a);
            if (diskriminant == 0){
                System.out.printf ("Rovnice má jedno øešení: %f", reseni1);}
            else {
                System.out.printf ("Rovnice má dvì øešení: %f a %f", reseni1, reseni2);}
            }
            }
	}
    }
