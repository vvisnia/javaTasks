import java.awt.* ;
import java.awt.event.* ;
import javax.swing.*;
import java.util.*;

class Konto implements Serializable{
	private int stan; //stan konta
	public ArrayList<Integer> dzialania = new ArrayList<Integer>();
	Konto(){ //konstruktor
		stan=0;
	}
	public void operacjaPowrotu(int ile){
		stan=stan+ile;
	}
	public void operacja(int ile) throws DebetException{
		if(stan+ile>=0){ //jesli stan konta i kwota operacji jest wieksza od 0 zmien stan
			stan=stan+ile;
			dzialania.add(ile); //dodawanie kwoty operacji do listy dzialan
		}
		else{ //w przeciwnym wypadku mamy debet
			throw new DebetException(-1*(stan+ile));
		}
	}
	public int wypiszStan(){
		return stan; //zwracamy stan
	}
}

class DebetException extends Exception{ //definicja wyjatku Debet
	int i;
	DebetException(){ super();}
	DebetException(String msg){ super(msg);}
	DebetException(int i){ this.i=i; }
	public int getLine() { //zwraca kwote ktorej brakuje na koncie
		return i; //zwraca kwote ktorej brakuje na koncie
	}
}

public class KontoG extends JFrame{
	Konto acc = new Konto(); //dodajemy nowe konto
	JLabel stanLabel = new JLabel("-"); //etykieta stan
	JLabel operacjaLabel = new JLabel("Operacja :"); //etykieta operacja
	JTextField operacjaField = new JTextField(); //pole tekstowe operacji
	JButton operacjaButton = new JButton("Wykonaj"); //przycisk wykonania operacji
	JButton odblokujButton = new JButton("Odblokuj"); //przycisk odblokowania
	JLabel rezultatLabel = new JLabel("-"); //etykieta rezultat
	JLabel wrocLabel = new JLabel("-"); //etykieta powrotu
	JButton wrocButton = new JButton("WROC"); //przycisk powrotu
	Boolean blokada = false; // zmienna boolowska dla blokady
	KontoG(){ //definiujemy budowe Konta
		setTitle("Twoje Konto Bankowe"); //tytul
		setSize( 500,300) ; //rozmiar okna
		setLocation( 100,100 ); //lokalizacja okna
		setVisible( true ) ; //widocznosc
		Container cp = getContentPane();
		cp.setLayout( new GridLayout( 4 , 2 , 10 , 10 ) ); //ustawia uklad
		stanLabel.setText("Stan Konta:" + acc.wypiszStan() ); //etykieta stanu konta
		cp.add(stanLabel); //dodajemy to co wczesniej zdefiniowalismy
		cp.add(rezultatLabel); //dodajemy to co wczesniej zdefiniowalismy
		cp.add(operacjaLabel); //dodajemy to co wczesniej zdefiniowalismy
		cp.add(operacjaField); //dodajemy to co wczesniej zdefiniowalismy
		cp.add(operacjaButton); //dodajemy to co wczesniej zdefiniowalismy
		cp.add(odblokujButton); //dodajemy to co wczesniej zdefiniowalismy
		cp.add(wrocButton); //dodajemy to co wczesniej zdefiniowalismy
		cp.add(wrocLabel); //dodajemy to co wczesniej zdefiniowalismy
		operacjaButton.addActionListener(new Operacja() ); //dodajemy sluchacza Operacji
		odblokujButton.addActionListener(new Odblokowane() ); //dodajemy sluchacza Odblokowania
		wrocButton.addActionListener(new Powrot() ); //dodajemy sluchacza Powrotu tj. wycofania operacji
	}
	class Powrot implements ActionListener{ //definicja sluchacza przycisku wycofania operacji
		public void actionPerformed(ActionEvent e){ //akcja dokonana przez uzytkownika
			if(!acc.dzialania.isEmpty() ){ //jesli lista dzialan nie jest pusta 
				int ostatniIndex = acc.dzialania.size(); //ostatni dokonany krok
				int wartosc = acc.dzialania.get(ostatniIndex - 1); // zeby uzyskac wartosc cofamy sie o jeden krok do tylu
				acc.operacjaPowrotu(-1 * wartosc); //odejmujemy/dodajemy ostatnia operacje (czyli to co ma robic przycisk Wroc)
				acc.dzialania.remove(ostatniIndex - 1); //usuwamy operacje z listy dzialan
				wrocLabel.setText("Wrocilismy"); //etykieta po powrocie
				stanLabel.setText("Stan: " + acc.wypiszStan() ); //etykieta stanu po powrocie
			}
			else{ //jesli nie ma zadnych wykonanych operacji
				wrocLabel.setText("Nie ma zadnych zapamietanych operacji!"); //zwroc ze nie ma zadnych wykonanych operacji
			}
		}
	}
	class Odblokowane implements ActionListener{ //definicja sluchacza przycisku Odblokowania
		public void actionPerformed(ActionEvent e){ //akcja dokonana
			if( blokada == true ){ //jesli blokada jest aktywowana
				blokada = false; //zdejmij blokade
				operacjaField.setEnabled(true); //pozwol uzywac pola operacji
				operacjaButton.setEnabled(true); //pozwol uzywac przycisku operacji
				wrocButton.setEnabled(true); //pozwol uzywac przycisku powrotu
			}
		}
	}
	class Operacja implements ActionListener{ //definicja sluchacza przycisku Operacji
		public void actionPerformed(ActionEvent e){ //akcja dokonana
			int liczba=0;
			try{ //podpunkt 3 zadania 
				liczba = Integer.parseInt(operacjaField.getText() );
			}
			catch(NumberFormatException nfE){ //jesli nie podano liczby podaj informacje ze wprowadzono zle dane
				rezultatLabel.setText("Zle dane"); 
			}
			finally{ //jesli wprowadzono dobre dane tj. liczbe
				try{
					acc.operacja(liczba);
				}
				catch(DebetException dE){ //jesli nie mamy srodkow na koncie(tj. mamy debet) wypisz odpowiednia informacje
					rezultatLabel.setText("Brakuje" + " " +dE.getLine() + "zl" );
				}
				finally{ //jesli mamy odpowiednia ilosc srodkow na koncie
					stanLabel.setText("Stan:" + acc.wypiszStan() ); //wykonaj operacje
					operacjaLabel.setText("OK!"); 
					operacjaField.setEnabled(false); //zablokuj pozostale opcje
					operacjaButton.setEnabled(false); //zablokuj pozostale opcje
					wrocButton.setEnabled(false); //zablokuj pozostale opcje
					blokada=true; //wlacz blokade konta
				}
			}
		}
	}
	public static void main(String[] args){
		JFrame frame = new KontoG();
	}
}
