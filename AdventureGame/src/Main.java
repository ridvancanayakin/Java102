import java.util.Scanner;

import Builds.*;
import Locations.*;

public class Main {
	static String name;
	static Build playerCharacter;
	static Scanner s = new Scanner(System.in);
	static SafeHouse safeHouse = new SafeHouse();
	static Market market = new Market();
	static Cave cave = new Cave();
	static Woods woods = new Woods();
	static River river = new River();
	static Mine mine = new Mine();
	static Location location ;
	static boolean dead = false;
	
	
	public static void main(String[] args) {
		
		location = safeHouse;
		init();
		print();
		play();
	}
	
	public static void setDead() {
		dead = true;
	}
	
	public static void play() {
		while(true) {
			printNextTour();
			switch (s.nextInt()) {
			case 1:
				setLocation(safeHouse);
				break;
			case 2:
				setLocation(market);
				break;
			case 3:
				if(playerCharacter.getYemek())
					System.out.println("Bölgeyi Zaten Temizledin ve Yemeði Aldýn. Buraya Tekrar Giremezsin.");
				else 
					setLocation(cave);
				break;
			case 4:
				if(playerCharacter.getOdun())
					System.out.println("Bölgeyi Zaten Temizledin ve Yemeði Aldýn. Buraya Tekrar Giremezsin.");
				else 
					setLocation(woods);
				break;
			case 5:
				if(playerCharacter.getSu())
					System.out.println("Bölgeyi Zaten Temizledin ve Yemeði Aldýn. Buraya Tekrar Giremezsin.");
				else 
					setLocation(river);
				break;
			case 6:
				setLocation(mine);
				break;
			default:
				break;
			}
		}
		
	}
	
	public static void print() {
		System.out.println("--------------------------------------------------------");
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
	
	public static void printNextTour() {
		System.out.println("--------------------------------------------------------");
		System.out.println("Nereye Gitmek Ýstiyorsun? \n1-Güvenli Ev\n2-Pazar Yeri\n3-Maðara\n4-Orman\n5-Nehir");
		
	}
	public static void setLocation(Location l) {
		location = l;
		location.onLocation(playerCharacter);
	}
}
