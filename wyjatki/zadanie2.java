import java.io.* ;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.* ;

class Czytanie{
   static BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));

   String czytajNP() throws IOException{
   //  pyta o  nazwe pliku
      System.out.print("podaj nazwe pliku ");
      String linia;
      linia = sysin.readLine() ;
      return linia.trim();//pobiera nazwe pliku 
   }

  void czytaj(ArrayList<Double> a) throws IOException, Wyjatek2{
  // czytanie z pliku
    int nr=1 ;                  // numer wiersza
    String nazwa = czytajNP();
    BufferedReader br = new BufferedReader(new FileReader(nazwa));
    String wiersz;
    try {
    while ((wiersz = br.readLine()) != null){
    	
	a.add(new Double(wiersz));
        nr++;
    }
    } catch (NumberFormatException e) {
    	throw new Wyjatek2(nr);
    }
    br.close() ;
  }
}

class Wyjatek2 extends Exception{
    int i;
    Wyjatek2(){ super();} 
    Wyjatek2(String msg){ super(msg);}
    Wyjatek2(int i){ this.i=i; }
    public int getLine() {
    	return i;
    }
}

class Wyjatki{
  static void srednia(ArrayList<Double> a){
      double s=0.0d;
      for (int i=0; i<a.size(); i++) 
	  s+=a.get(i).doubleValue();
      System.out.println("srednia z liczb w tablicy: "+s/a.size());
  }
  public static void main(String[] args)throws IOException{
      ArrayList<Double> a = new ArrayList<Double>();
      Czytanie cz = new Czytanie();
      try{
      cz.czytaj(a);
      srednia(a);
      } catch(Wyjatek2 e){
    	  System.out.println("Blad w linii: " + e.getLine());
      } catch(IOException e) {
    	  System.out.println("Nieprawidlowa nazwa pliku.");
      }
 }
}
