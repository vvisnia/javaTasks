
import java.io.*;
import java.util.*;

class Student
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
		System.out.print( "Oceny Nr. " + this.nr + " : " );
		for( int i = 0 ; i < oceny.size() ; i++ )
		{
			System.out.print( oceny.get(i).toString() + " " );
		}
	}

	public int getNr(){ return this.nr; }
	
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
	
	public void wypisz2(int n)
	{
		for(int i=1;i<wykaz.size();i++){
		Student s = wykaz.get(i);
		for (Iterator<Student> j = wykaz.iterator(); j.hasNext();){
			s=j.next();
				
		for(int k=0;k<s.oceny.size();k++){
		if(s.oceny.get(k) < n ) j.remove();}
		s.wypiszOceny();
		System.out.println();
										  
																	}
	}
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
}

class TestWykazS{
	 public static void main(String[] a){
	  WykazS ws = new WykazS();

	  ws.wstawStudenta(199200,"Kazik");
	  ws.wstawStudenta(199201,"Kazik");
	  ws.wstawStudenta(199204,"Nikodem");
	  ws.wstawStudenta(199205,"Jan");
	  
	  ws.wstawOcene(199200,5);
	  ws.wstawOcene(199200,4);
	  ws.wstawOcene(199200,3);
	  ws.wstawOcene(199200,5);
	  ws.wstawOcene(199200,2);

	  ws.wstawOcene(199201,5);
	  ws.wstawOcene(199201,6);
	  ws.wstawOcene(199201,4);

	  ws.wstawOcene(199204,4);
	  ws.wstawOcene(199204,5);

	  ws.wstawOcene(199205,3);
	  
	  //ws.wypisz(199200);
	  ws.wypisz();
	  ws.wypisz2(3); 
	 }
	};
