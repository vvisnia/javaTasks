import java.io.* ;
import java.util.* ;

class MojWyjatek extends Exception{}

class Czytanie{
   static BufferedReader sysin = //sysin to wejscie z klawiatury 	
           new BufferedReader(new InputStreamReader(System.in));

   String czytajNP() throws IOException{ 
   //  pyta o  nazwe pliku
      System.out.print("podaj nazwe pliku ");
      String linia;
      linia = sysin.readLine() ; //to co uzytkownik napisze
      if(linia.equals("")) throw new MojWyjatek();
      return linia.trim();
   }

  void czytaj(ArrayList<Double> a) throws IOException{
  // czytanie z pliku
    int nr=1 ;                  // numer wiersza
    String nazwa = czytajNP(); //nazwa pliku ktory mamy otworzyc
    BufferedReader br = new BufferedReader(new FileReader(nazwa)); //proba otwarcia pliku
    String wiersz;
    while ((wiersz = br.readLine()) != null){ //czytanie kolejnych linii i zamienianie ich na double , potem dodanie do listy
	a.add(new Double(wiersz));
        nr++; //aktualny nr wiersza ktory wczytujemy
    }
    br.close() ;
  }

}
class Wyjatki{
  static void srednia(ArrayList<Double> a){ //srednia wartosci w liscie
      double s=0.0d;
      for (int i=0; i<a.size(); i++) 
	  s+=a.get(i).doubleValue();
      System.out.println("srednia z liczb w tablicy: "+s/a.size());
  }
  public static void main(String[] args)throws IOException{
      ArrayList<Double> a = new ArrayList<Double>();
      Czytanie cz = new Czytanie();
      //cz.czytaj(a);
      try{
		  cz.czytaj(a);
	  }
      catch (MojWyjatek e){
          System.out.println("obsluga wyjatku MojWyjatek\n");
	  }
      srednia(a);
  }
}
