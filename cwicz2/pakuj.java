import java.util.zip.*; // klasy potrzebne dla zip i gzip
import java.io.*; 

class Pakuj{
    public static void main(String[] args) throws IOException{
        BufferedInputStream wej = new BufferedInputStream( //buforuje strumien wejscia
               			   new FileInputStream("Gzip.java")); //plik wejsciowy
	BufferedOutputStream wy = new BufferedOutputStream( //buforuje strumien wyjscia
               			   new GZIPOutputStream( //wyjsciowy strumien gzip (kompresja)
	       			    new FileOutputStream("Gzip.java.gz"))); //plik wyjsciowy
	int c;
	while ((c = wej.read())!= -1)
	    wy.write(c);//wypisuje strumien wyjsciowy
	wej.close();//zamyka strumien wejsciowy
	wy.close();//zamyka strumien wyjsciowy
    }
}
