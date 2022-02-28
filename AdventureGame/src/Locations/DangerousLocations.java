package Locations;

import Builds.Build;
import Monsters.Monster;

public abstract class DangerousLocations extends Location{
	//private Monster[] monsters;
	protected int numberOfEnemies, maxEnemy = 3 ;
	protected Monster monster;
	protected String reward;
	
	@Override
	public void onLocation(Build pC) {
		numberOfEnemies = (int)(Math.random()*maxEnemy+1);
		System.out.println("--------------------------------------------------------");
		System.out.println(this.getClass().getSimpleName()+" Bölgesine Geldin. Ýçeride "+numberOfEnemies+" Adet " +monster.getClass().getSimpleName()+" Var!");
		System.out.println("Onlarý Öldürürsen "+this.reward+" kazanýrsýn!");
		System.out.println("0-Ayrýl\n1-Savaþ");
		switch(s.nextInt()) {
		case 0:
			this.monster.healMax();
			System.out.println(this.getClass().getSimpleName() +" Bölgesinden Ayrýlýyorsunuz.");
			break;
		case 1:
			fight(pC);
			break;
		default:
			System.out.println("Yanlýþ Bir Tercih Yaptýnýz");
			break;
		}
	}
	protected void fight(Build pC) {
		while(numberOfEnemies > 0) {
			System.out.println("--------------------------------------------------------");
			System.out.println(numberOfEnemies + " adet " + this.monster.getClass().getSimpleName()
					+ " hayatta.\n0-Kaç\n1-Saldýr");
			switch (s.nextInt()) {
			case 0:
				this.monster.healMax();
				System.out.println(this.getClass().getSimpleName() +" Bölgesinden Kaçýyorsunuz.");
				return;
			case 1:
				hit(pC);
				break;
			default:
				break;
			}
		}
		System.out.println("Bölgeyi Tamamladýn ve Ödülü aldýn");
		getReward(pC);
	}
	
	protected void hit(Build pC) {
		System.out.println("--------------------------------------------------------");
		if((int)(Math.random()*2)==0) {
			System.out.println("Ýlk Sen Vuruyorsun !");
			System.out.println(this.monster.getClass().getSimpleName() + " "+pC.getDamage()+ " Hasar Aldý!");
			if(this.monster.takeDamage(pC.getDamage())) {
				System.out.println(this.monster.getClass().getSimpleName() + " Öldü!");
				killedMon(pC, this.monster);
				System.out.println(pC.getName()+" Karakterinin Kalan Caný : "+ pC.getCurrentHealth() +" Parasý : " + pC.getGold());
				numberOfEnemies = numberOfEnemies-1;		
				this.monster.healMax();
				return;
			}else {
				System.out.println("Þimdi " +this.monster.getClass().getSimpleName()+" Vuruyor !");
				System.out.println(pC.getName() +" Karakteri "+(this.monster.getDamage()-pC.getBlock()) + " Hasar Aldý!");
				if(pC.takeDamage(this.monster.getDamage()-pC.getBlock())) {
					System.out.println("Öldünüz ve Oyunu Kaybettiniz.");
					System.exit(0);
				}
			}
		}else {
			System.out.println("Ýlk " + this.monster.getClass().getSimpleName()+" vuruyor !");
			System.out.println(pC.getName() +" Karakteri "+(this.monster.getDamage() - pC.getBlock()) + " Hasar Aldý!");
			if(pC.takeDamage(this.monster.getDamage()-pC.getBlock())) {
				System.out.println("Öldünüz ve Oyunu Kaybettiniz.");
				System.exit(0);
			}else {
				System.out.println("Þimdi Sen Vuruyorsun !");
				System.out.println(this.monster.getClass().getSimpleName() + " "+pC.getDamage()+ " Hasar Aldý!");
				if(this.monster.takeDamage(pC.getDamage())) {
					System.out.println(this.monster.getClass().getSimpleName() + " Öldü!");
					killedMon(pC, this.monster);
					System.out.println(pC.getName()+" Karakterinin Kalan Caný : "+ pC.getCurrentHealth() +" Parasý : " + pC.getGold());
					numberOfEnemies = numberOfEnemies-1;
					this.monster.healMax();
					return;
				}
			}
		}
		System.out.println(this.monster.getClass().getSimpleName() +" Kalan Caný : "+ this.monster.getCurrentHealth()
		+"\n"+pC.getName() + " Karakterinin Kalan Caný : "+ pC.getCurrentHealth() );
	}
	
	protected abstract void getReward(Build pC);
	
	protected void killedMon(Build pC, Monster monster) {
		System.out.println("Ganimet Olarak "+this.monster.getGold()+" Altýn Kazandýn!");
		pC.changeGold(this.monster.getGold());
	}
}
