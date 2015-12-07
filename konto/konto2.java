import konto.Konto;
import konto.KontoH;

class Konto {
	float stan;
	String wlasciciel;
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
  
  Konto(String w, float stan){ 
	  wlasciciel=w; 
	  this.stan=stan; 
	  } 
  
  
  public String toString(){ 
	  return wlasciciel + "Stan konta :" + stan; 
	  }
}

class KontoH extends Konto{
	float[] tablica = new float[5];
	int i;
	
	KontoH(String w, float stan){
		super(w,stan);
		this.stan=stan;
	}
	void operacja(float ile){
		super.operacja(ile);
		stan=ile;
		tablica[i]=stan;
	}
	
	  public String toString(){ 
		  return "Kwota operacji wynosi :" + tablica[i]; 
		  }
}
class TestKonta2{
	  public static void main(String[] a){

		  
				   Konto  aa = new KontoH("Ktos",350);
				   KontoH bb = new KontoH("Ktosiek",430);    
	   
	   
	   
			   aa.operacja(500);
			   System.out.println(aa);
			   
			   bb.przelej(300,aa);
			   System.out.println(aa);
			   
			   KontoH.przelej(aa,bb,450);
			   System.out.println(bb);
			   
			   aa.przelej(220,bb);
			   System.out.println(bb);
			   
			   bb.operacja(325);
			   System.out.println(bb);
	  }
	}
