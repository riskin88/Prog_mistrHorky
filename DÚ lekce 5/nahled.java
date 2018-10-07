public class nahled {
    public static void main(String args[]) {
		awh.Image obr = awh.Image.loadFromFile(args[0]);
		int sirkanahledu = 150;
		int vyskanahledu = 100;
		int vyska = obr.getHeight();
		int sirka = obr.getWidth();
		awh.Image nahled = awh.Image.createEmpty(sirkanahledu, vyskanahledu, awh.Color.GRAY);
		if (sirka > sirkanahledu || vyska > vyskanahledu){
			if (sirka > vyska){
				double ratio = sirka / sirkanahledu;
				double novasirka = sirkanahledu;
				double novavyska = vyska / ratio;
				obr.rescale((int) novasirka, (int) novavyska);
				nahled.pasteFrom(obr, 0, (vyskanahledu - (int) novavyska)/2);
			}
			else {
				double ratio = (double) vyska / (double) vyskanahledu;
				double novasirka = sirka / ratio;
				double novavyska = vyskanahledu;
				obr.rescale((int) novasirka, (int) novavyska);
				nahled.pasteFrom(obr, (sirkanahledu - (int) novasirka)/2, 0);
			}
		}
		else {
			nahled.pasteFrom(obr, (sirkanahledu - sirka)/2, (vyskanahledu - vyska)/2);
		} 
		nahled.saveToFile(args[1]);
	}
}