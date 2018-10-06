public class sediva {
    public static void main(String args[]) {
		awh.Image obr = awh.Image.loadFromFile(args[0]);
		int vyska = obr.getHeight();
		int sirka = obr.getWidth();
		for (int y = 0; y < vyska; y++){
			for (int x = 0; x < sirka; x++){
				awh.Color puvodni = obr.getPixel(x, y);
				double puvodnicervena = puvodni.getRed();
				double puvodnizelena = puvodni.getGreen();
				double puvodnimodra = puvodni.getBlue();
				double sediva = 0.299 * puvodnicervena + 0.587 * puvodnizelena + 0.114 * puvodnimodra;
			awh.Color nova = awh.Color.fromRgb((int)sediva, (int)sediva, (int)sediva);
				obr.setPixel(x, y, nova);
			}
		}
		obr.saveToFile(args[1]);
	}
}