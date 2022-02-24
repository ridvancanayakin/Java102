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
				" �simli Karakterin:\nCan� : "+ playerCharacter.getCurrentHealth()
				+ "\nHasar� : "+ playerCharacter.getDamage()
				+ "\nAlt�n� : "+ playerCharacter.getGold()
				);
	}
	
	public static void init() {
		System.out.print("Macera Oyununa Ho�geldin! \nAd�n nedir? ");
		name =s.nextLine();
		selectChar();
		System.out.println("Tebrikler! "+ playerCharacter.getName() + 
				" �simli Bir " + playerCharacter.getClass().getSimpleName() +" Karakteri Olu�turdun!");
	}
	
	public static void selectChar() {
		boolean choosen = false;
		System.out.println("Merhaba " + name +". �imdi Karakterini Belirleme S�ras�! �stedi�in Karakter ��in Bir Numara Tu�la!");
		while (!choosen) {
			System.out.println("--------------------------------------------------------\n"
					+ "1- Samuray\n2- Ok�u\n3- �ovalye");
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
				System.out.println("Yanl�� Bir Se�im Yapt�n. Tekrar Dene!");
			}
		}
	}
}
