import java.io.* ;

class Ulamek{
    int licznik;
    int mianownik;
    
    
static Ulamek dodaj(Ulamek u1, Ulamek u2){
	
return new Ulamek(u1.licznik*u2.licznik,u1.mianownik*u2.mianownik);

}
void plus(Ulamek v){
licznik=licznik*v.licznik;
mianownik=mianownik*v.mianownik;
}
static Ulamek dodajliczbe(Ulamek o, Ulamek i )
{
int c=2;

return new Ulamek(o.licznik*i.licznik,o.mianownik);

}
Ulamek (int l,int m){
licznik=l;
mianownik=m;
}
public String toString(){
return licznik+"/"+mianownik;
}
}
class Test{
public static void main(String[] a){
Ulamek u1= new Ulamek(1,2);
Ulamek u2= new Ulamek(3,4);
Ulamek u= new Ulamek(2,3);
Ulamek v= new Ulamek(1,2);
Ulamek i= new Ulamek(2,1);
Ulamek o= new Ulamek(4,5);

u.plus(v);


System.out.println("1/2 * 2/3 to :");
System.out.println(u);

System.out.println("////////////////////////////////");
System.out.println("1/2 * 3/4 to :");
System.out.println(Ulamek.dodaj(u1,u2));

System.out.println("////////////////////////////////");
System.out.println("4/5 * liczba c to :");
System.out.println(Ulamek.dodajliczbe(o,i));
}
}
