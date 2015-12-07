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

class LiczbaUD extends Ulamek
{
	private int calosci;
LiczbaUD( int c, int l, int m ){
	super(l, m); //odanie do poprzedniego konstruktora
	calosci = c;
	fixLicznik();
}
void plus(int n)
{
calosci=calosci+n;
}
void plus(Ulamek u)
{
	licznik=(licznik*u.mianownik)+(mianownik*u.licznik);
	mianownik=mianownik*u.mianownik;
	fixLicznik();
}
void plus(LiczbaUD l)
{
	calosci=calosci+l.calosci;
	licznik=(licznik*l.mianownik)+(mianownik*l.licznik);
	mianownik=mianownik*l.mianownik;
	fixLicznik();
}
private void fixLicznik(){
	if( licznik >= mianownik ){
		calosci = calosci + ( licznik / mianownik );
		licznik = licznik % mianownik;
		}
}
public String toString(){
	return calosci+" i "+licznik+"/"+mianownik;
}
}
class Test{
					public static void main(String[] a){
					LiczbaUD pp = new LiczbaUD(2,1,2);
					LiczbaUD oo = new LiczbaUD(3,1,3);
					LiczbaUD uu = new LiczbaUD(3,1,4);
					LiczbaUD yy = new LiczbaUD(2,2,3);
					Ulamek u = new Ulamek(4,7);

	System.out.println("////////////////////////////////////");
	pp.plus(4);
	System.out.println("2 i 1/2 + 4 to :");
	System.out.println(pp);
	System.out.println("////////////////////////////////////");
	

	System.out.println("////////////////////////////////////");
	oo.plus(u);
	System.out.println("3 i 1/3 + 4/7 to :");
	System.out.println(oo);
	System.out.println("////////////////////////////////////");

	
	System.out.println("////////////////////////////////////");
	uu.plus(yy);
	System.out.println("3 i 1/4 + 2 i 2/3 to :");
	System.out.println(uu);
	System.out.println("////////////////////////////////////");

}
}