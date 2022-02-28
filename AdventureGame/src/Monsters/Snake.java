package Monsters;

public class Snake extends Monster{
	public Snake() {
		this.id = 4;
		this.damage = (int) (Math.random()*4+3);
		this.maxHealth = 12;
		this.currentHealth = this.maxHealth;
	}

}
