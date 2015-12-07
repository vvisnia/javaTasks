import java.io.*;
import java.util.*;

class Student implements Comparable<Student>
{
	int nr;
	String imie;
	ArrayList<Integer> oceny;

	Student( int nr, String imie )
	{
		this.nr = nr;
		this.imie = imie;
		this.oceny = new ArrayList<Integer>();
	}

	public void addMark( int mark )
	{
		this.oceny.add( mark );
	}
	
	public void wypiszOceny()
	{
		System.out.print( imie + "  " + "Oceny Nr. " + this.nr + " : " );
		for( int i = 0 ; i < oceny.size() ; i++ )
		{
			System.out.print( oceny.get(i).toString() + " " );
		}
	}
	public int compareTo(Student s)
	  {
	    return this.imie.compareTo(s.imie);
	  }

	public int getNr(){ return this.nr; }
	
}
class Porownaj implements Comparator<Student>
{    
  public int compare(Student s1, Student s2)
  {
    int i,
        max1 = 0,
        max2 = 0;

    for (i = 0; i < s1.oceny.size(); i++) if (s1.oceny.get(i) > max1) max1 = s1.oceny.get(i);
    for (i = 0; i < s2.oceny.size(); i++) if (s2.oceny.get(i) > max2) max2 = s2.oceny.get(i);

    if (max1 >= max2) return -1;
    else return 1;
  }
}

class WykazS
{
	private ArrayList<Student> wykaz;

	WykazS()
	{
		wykaz = new ArrayList<Student>();
	}

	public void wstawStudenta( int nr, String imie )
	{
		wykaz.add( new Student( nr , imie ) );
	}

	public void wstawOcene( int nr, int ocena )
	{
		Student toAdd = getStudent( nr );
		toAdd.addMark( ocena );
	}

	public void wypisz( int nr )
	{
		Student toPrint = getStudent( nr );
		toPrint.wypiszOceny();
	}

	public void wypisz()
	{
		System.out.println( "\nOCENY WSZYSTKICH" );
		Student obecnyStudent;
		for( int i = 0 ; i < wykaz.size() ; i++ )
		{
			obecnyStudent = wykaz.get(i);
			obecnyStudent.wypiszOceny();
			System.out.println();
		}
	}

	public Student getStudent( int nr )
	{
		Student poprawnyStudent;
		for( int i = 0 ; i < wykaz.size() ; i++ )
                {
                        poprawnyStudent = wykaz.get(i);
                        if( poprawnyStudent.getNr() == nr )
                        {
                        	return poprawnyStudent;
                       	}
               	}
		return null;
	}
	public void sortujA()
	  {
	    Collections.sort(wykaz);
	  }

	  public void sortujS()
	  {
	    Collections.sort(wykaz, new Porownaj());
	  }

}

class TestWykazS{
	 public static void main(String[] a){
	  WykazS ws = new WykazS();

	  ws.wstawStudenta(199200,"Kazik");
	  ws.wstawStudenta(199201,"Marek");
	  ws.wstawStudenta(199204,"Nikodem");
	  ws.wstawStudenta(199205,"Jan");
	  ws.wstawStudenta(189557,"Wiesiek");
	  
	  ws.wstawOcene(199200,5);
	  ws.wstawOcene(199200,4);

	  ws.wstawOcene(199201,6);
	  ws.wstawOcene(199201,6);

	  ws.wstawOcene(199204,3);
	  ws.wstawOcene(199204,3);

	  ws.wstawOcene(199205,1);
	  ws.wstawOcene(199205,1);
	  
	  ws.wstawOcene(189557,2);
	  ws.wstawOcene(189557,2);
	  //ws.wypisz(199200);
	  ws.sortujA();
	  ws.sortujS();
	  ws.wypisz();
	 }
}
