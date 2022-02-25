package Monsters;

public abstract class Monster {
	protected int id, damage, currentHealth, maxHealth, gold;
	public boolean takeDamage(int damage) {
		
		boolean result = false;
		if(damage>=currentHealth) {
			currentHealth = 0;
			result = true;
		}else {
			currentHealth = currentHealth - damage;
		}
		return result;
	}
	public int getDamage() {
		return damage;
	}

	public int getGold() {
		return gold;
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	public void healMax() {
		currentHealth = maxHealth;
	}


}
