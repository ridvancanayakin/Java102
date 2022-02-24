import java.util.Scanner;

import Builds.*;
import Locations.*;

public class Main {
	static String name;
	static Build playerCharacter;
	static Scanner s = new Scanner(System.in);
	static Market m = new Market();
	//static Location location ; 
	
	public static void main(String[] args) {
		
		init();
		print();
		m.onLocation(playerCharacter);
	}
	
	
	
	public static void print() {
		System.out.println(playerCharacter.getName()+ 
				" Ýsimli Karakterin:\nCaný : "+ playerCharacter.getCurrentHealth()
				+ "\nHasarý : "+ playerCharacter.getDamage()
				+ "\nAltýný : "+ playerCharacter.getGold()
				);
	}
	
	public static void init() {
		System.out.print("Macera Oyununa Hoþgeldin! \nAdýn nedir? ");
		name =s.nextLine();
		selectChar();
		System.out.println("Tebrikler! "+ playerCharacter.getName() + 
				" Ýsimli Bir " + playerCharacter.getClass().getSimpleName() +" Karakteri Oluþturdun!");
	}
	
	public static void selectChar() {
		boolean choosen = false;
		System.out.println("Merhaba " + name +". Þimdi Karakterini Belirleme Sýrasý! Ýstediðin Karakter Ýçin Bir Numara Tuþla!");
		while (!choosen) {
			System.out.println("--------------------------------------------------------\n"
					+ "1- Samuray\n2- Okçu\n3- Þovalye");
			switch(s.nextInt()) {
			case 1:
				playerCharacter = new Samurai(name);
				choosen = true;
				break;
			case 2:
				playerCharacter = new Archer(name);
				choosen = true;
				break;
			case 3:
				playerCharacter = new Knight(name);
				choosen = true;
				break;
			default:
				System.out.println("Yanlýþ Bir Seçim Yaptýn. Tekrar Dene!");
			}
		}
	}
}
