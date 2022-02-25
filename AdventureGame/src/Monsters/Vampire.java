package Monsters;

public class Vampire extends Monster{
	public Vampire() {
		this.id = 2;
		this.damage = 4;
		this.currentHealth = this.maxHealth;
		this.maxHealth = 14;
		this.gold = 7;
	}
}
