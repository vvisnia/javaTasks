package ulamki;

class Ulamek{
    int licznik;
    int mianownik;
    
    
static Ulamek dodaj(Ulamek u1, Ulamek u2){
	
return new Ulamek(u1.licznik*u2.mianownik + u2.licznik*u1.mianownik,u1.mianownik*u2.mianownik);

}
void plus(Ulamek v){
licznik=licznik*v.mianownik+v.licznik*mianownik;
mianownik=mianownik*v.mianownik;
}
void plus(int i){
licznik=licznik+i*mianownik;
}
Ulamek (int l,int m){
licznik=l;
mianownik=m;
}
public String toString(){
return licznik+"/"+mianownik;
}
}

class LiczbaU {
	int calosci;
	Ulamek czescU;
	
	LiczbaU(int c, Ulamek u){
		calosci = c;
		czescU = u;
		checkczescU();
	}
	void plus(LiczbaU l){
		calosci = calosci + l.calosci;
		czescU.licznik=(czescU.licznik*l.czescU.mianownik)+(czescU.mianownik*l.czescU.licznik);
		czescU.mianownik=(czescU.mianownik*l.czescU.mianownik);
		checkczescU();
	}
	void plus(int i){
		calosci=calosci+i;
	}
	void plus(Ulamek u){
		czescU.licznik=(czescU.licznik*u.mianownik)+(czescU.mianownik*u.licznik);
		czescU.mianownik=(czescU.mianownik*u.mianownik);
		checkczescU();
	}
	void checkczescU(){
		if(czescU.licznik >= czescU.mianownik){
			calosci = calosci + (czescU.licznik / czescU.mianownik);
			czescU.licznik = czescU.licznik % czescU.mianownik;
		}
	}
	public String toString(){
		return calosci + " i " + czescU;
	}
}
class Test {
	public static void main(String[] a){
		Ulamek j = new Ulamek(2,3);
		LiczbaU k = new LiczbaU(2,j);
		k.plus(6);
		System.out.println("2 i 2/3 plus 6 to :");
		System.out.println(k);
		System.out.println("///////////////////");
		Ulamek y = new Ulamek(3,5);
		LiczbaU z = new LiczbaU(2,y);
		Ulamek aa = new Ulamek(3,4);
		LiczbaU b = new LiczbaU(1,aa);
		z.plus(b);
		System.out.println("2 i 3/5 + 1 i 3/4 to :");
		System.out.println(z);
		System.out.println("//////////////////////");
		Ulamek r = new Ulamek(3,7);
		LiczbaU t = new LiczbaU(1,r);
		Ulamek o = new Ulamek(1,3);
		t.plus(o);
		System.out.println("1 i 3/7 + 1/3 to :");
		System.out.println(t);
	}
}