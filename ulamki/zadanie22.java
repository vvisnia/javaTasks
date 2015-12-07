package ulamki;

class Ulamek{
    private int licznik;
    private int mianownik;
    
    
static Ulamek dodaj(Ulamek u1, Ulamek u2){
	
return new Ulamek(u1.licznik*u2.mianownik + u2.licznik*u1.mianownik,u1.mianownik*u2.mianownik);

}
	void plus(Ulamek v)
	{
	licznik=licznik*v.mianownik+v.licznik*mianownik;
	mianownik=mianownik*v.mianownik;
	}
	void plus(int i)
	{
	licznik=licznik+i*mianownik;
	}
	Ulamek (int l,int m)
	{
	licznik=l;
	mianownik=m;
	}
public String toString()
{
return licznik+"/"+mianownik;
}
			int getlicznik(){ return licznik; }
			void setlicznik( int licz ){ licznik = licz; }
			int getmianownik(){ return mianownik; }
			void setmianownik( int mian ){ mianownik = mian; }
}


class LiczbaU {
	private int calosci;
	Ulamek czescU;

	int getcalosci(){ return calosci; }
	void setcalosci( int cal ){ calosci = cal; }
			
	LiczbaU(int c, Ulamek u)
	{
		calosci = c;
		czescU = u;
		checkczescU();
	}
	void plus(LiczbaU l)
	{
		calosci = calosci + l.calosci;
		czescU.setlicznik((czescU.getlicznik()*l.czescU.getmianownik())+(czescU.getmianownik()*l.czescU.getlicznik()));
		czescU.setmianownik((czescU.getmianownik()*l.czescU.getmianownik()));
		checkczescU();
	}
	void plus(int i)
	{
		calosci=calosci+i;
	}
	void plus(Ulamek u)
	{
		czescU.setlicznik((czescU.getlicznik()*u.getmianownik())+(czescU.getmianownik()*u.getlicznik()));
		czescU.setmianownik((czescU.getmianownik()*u.getmianownik()));
		checkczescU();
	}
	void checkczescU()
	{
		if(czescU.getlicznik() >= czescU.getmianownik()){
			setcalosci(getcalosci() + (czescU.getlicznik() / czescU.getmianownik()));
			czescU.setlicznik(czescU.getlicznik() % czescU.getmianownik());
		}
	}
	public String toString()
	{
		return calosci + " i " + czescU;
	}
}
		class Test {
			public static void main(String[] a)
			{
				Ulamek q = new Ulamek(1,2);
				LiczbaU e = new LiczbaU(3,q);
				e.plus(3);
				System.out.println("3 i 1/2 plus 3 to :");
				System.out.println(e);
				System.out.println("///////////////////");
				Ulamek y = new Ulamek(1,3);
				LiczbaU z = new LiczbaU(4,y);
				Ulamek w = new Ulamek(1,4);
				LiczbaU p = new LiczbaU(2,w);
				z.plus(p);
				System.out.println("4 i 1/3 + 2 i 1/4 to :");
				System.out.println(z);
				System.out.println("//////////////////////");
				Ulamek qq = new Ulamek(3,7);
				LiczbaU yy = new LiczbaU(1,qq);
				Ulamek o = new Ulamek(1,3);
				yy.plus(o);
				System.out.println("1 i 3/7 + 1/3 to :");
				System.out.println(yy);
			}
		}