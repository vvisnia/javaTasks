import java.util.zip.*;
import java.io.*;

class Rozpakuj 
{
    public static void main(String[] args) throws IOException
    {
        BufferedInputStream wej = new BufferedInputStream(new GZIPInputStream(new FileInputStream("Gzip.java.gz")));
		BufferedOutputStream wyj = new BufferedOutputStream(new FileOutputStream("Gzip.java"));
		
		int c;
		
		while ((c = wej.read())!= -1)
		{ 
			wyj.write(c);
		}
		wej.close(); 
		wyj.close();
    }
}
