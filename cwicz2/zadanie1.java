import java.io.*;
// Przyklad czytania pliku tekstowego po linijce

class czytaj{
final int ogr = 200 ; // ograniczenie na ilosc danych
String[] tab = new String[ogr] ; // tablica napisow
int ile ; // ilosc danych

// czytanie z pliku do tablicy tab
void czytanie(String plikWe) throws IOException{
BufferedReader br = new BufferedReader(new FileReader(plikWe));
String linia ;
ile = 0 ;
while ((linia = br.readLine()) != null)
if (linia.length() > 0)
tab[ile++] = linia;
br.close() ;
}

// drukowanie tablicy tab[]
void pisz(){
int i;
for (i=0; i<ile ; i++){
String liczba = Integer.toOctalString(
Integer.parseInt(
tab[i]));
if(liczba.length()<2) System.out.print("..");
if(liczba.length()>=2 & liczba.length()<3) System.out.print(".");
System.out.println(liczba) ;
}
}

public static void main(String[] args) throws Exception{
czytaj cz = new czytaj() ;
if (args.length >=1){
cz.czytanie(args[0]) ;
cz.pisz();
}
else
System.err.println("Uzycie: Czyt plik_wejsciowy");
}
}
