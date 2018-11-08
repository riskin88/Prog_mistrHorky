public class DenVRoce {
    public static void main(String[] args) {
      int rok = Integer.parseInt(args[0]);
      int mesic = Integer.parseInt(args[1]);
      int den = Integer.parseInt(args[2]);
      int celkemdni = 0;
      awh.IntList mesice = awh.IntList.create(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
      if (jePrestupny(rok)){
      awh.Int.List.add(29);
      }
      else{
        awh.Int.List.add(28);
      }
      for (int i = 1; i <= mesic; i++){
        celkemdni += pocetDni (i);           
    }
      celkemdni += den;
      System.out.printf("%d\n", celkemdni);
}
    public static boolean jePrestupny(int rok) {
      return (rok % 4 == 0 && rok % 100 != 0 || rok % 400 == 0);
}
    public static int pocetDni (int mesic, int rok){
      if (mesic % 2 == 0){
        if (!jePrestupny(rok) && mesic == 2){
          return 28;
          }
        else if(jePrestupny(rok) && mesic == 2){
          return 29;
          }
        else {
        return 30;
        }
      }
      else{
        return 31;}
      }
}
      
        
      