package Monsters;

public class Bear extends Monster{
	public Bear() {
		this.id = 3;
		this.damage = 7;
		this.currentHealth = this.maxHealth;
		this.maxHealth = 20;
		this.gold = 12;
	}

}
