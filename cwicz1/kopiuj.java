import java.io.*;

class Kopiuj {
    public static void main(String[] args) throws Exception{
        if (args.length < 2)
            System.out.println(
             "Poprawne Uzycie: Kopiuj PlikWejsciowy PlikWyjsciowy"
            );
        else{
            FileReader wej = new FileReader(args[0]) ;
            FileWriter wy  = new FileWriter(args[1]);
                                
        int c; //pobiera znaki
        int l=0; //liczy linie tekstu
        while ((c = wej.read()) != -1)  { // wej.read czyta znak , jesli koniec pliku to wartosc -1
		if (Character.isLowerCase((char) c)){ 
			c=Character.toUpperCase((char) c);
			}
		else if (Character.isUpperCase((char) c)){
			wy.write(c);
		}
          if (c=='\n') l++; //w przypadku napotkania zmiany wiersza zwieksza linie tekstu o 1
          wy.write(c) ; //wypisuje znak
        }

        wej.close(); 
        wy.close();
        System.out.println("skopiowano " + l + " wierszy");
        }
    }
}
