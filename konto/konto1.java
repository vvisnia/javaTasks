package konto;

class Konto {
	
	private float stan;
	private String wlasciciel;
	
  void operacja(float ile){ 
	  	stan=stan+ile;
  }
  
  void przelej(float ile, Konto dokad){
      	dokad.operacja(ile); 
  }
  
  static void przelej(Konto skad, Konto dokad, float ile){
	  	dokad.operacja(ile); 
	  	skad.operacja(-ile);
  }
  
  public String toString(){ 
	  
	  return wlasciciel + " Stan konta wynosi :" + stan; 
  }
  
  Konto(String w, float stan){ 
		  wlasciciel=w; 
		  this.stan=stan; 
  } 
}
class TestKonta{
  public static void main(String[] a){

		   Konto aaa = new Konto("Konto 1",550);
		   Konto bbb = new Konto("Konto 2",5000);
		   Konto ccc = new Konto("Konto 3",2600);
		   Konto ddd = new Konto("Konto 4",3100);
   
   
   System.out.println(" Konto 1 przed operacja ");
   System.out.println(aaa);
   System.out.println(" Konto 1 po operacji ");
   aaa.operacja(-50);
   System.out.println(aaa);
   System.out.println("////////////////////////////////////////");
   
   
   
   System.out.println(" Konto 2 przed przelewem ");
   System.out.println(bbb);
   System.out.println(" Konto 2 po przelewie ");
   bbb.przelej(1000, bbb);
   System.out.println(bbb);
   System.out.println("////////////////////////////////////////");
   
   
   
   System.out.println(" Konto 3 przed przelewem z konta 4 ");
   System.out.println(ccc);
   System.out.println(" Konto 3 po przelewie z konta 4 ");
   Konto.przelej(ddd, ccc, 400);
   System.out.println(ccc);
   System.out.println("////////////////////////////////////////");
  }
}