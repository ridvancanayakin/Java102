package Monsters;

public class Zombie extends Monster{
	public Zombie() {
		this.id = 1;
		this.damage = 3;
		this.maxHealth = 10;
		this.currentHealth = this.maxHealth;
		this.gold = 4;
	}
}
