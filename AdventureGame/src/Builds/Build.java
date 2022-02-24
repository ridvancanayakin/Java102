package Builds;

import Armors.*;
import Wepons.*;

public abstract class Build {
	protected int id, damage, currentHealth, maxHealth, gold;
	protected String name;
	protected Weapon weapon = null;
	protected Armor armor = null;
	
	public String getName() {
		return name;
	}
	public int getDamage() {
		return damage;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	public int getGold() {
		return gold;
	}
	public void heal() {
		currentHealth = maxHealth;
	}
	public void changeGold(int i) {
		this.gold = this.gold + i;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public Armor getArmor() {
		return armor;
	}
	public boolean setWeapon(Weapon w) {
		if (this.weapon == null || this.weapon.getDamage()< w.getDamage()) {
			if(this.gold>=w.getPrice()) {
				this.weapon = w;
				changeGold(-w.getPrice());
				return true;
			}else {
				System.out.println("Paran�z Yeterli De�il!");
			}
		}else {
			System.out.println("Mevcut Silah�n�z Daha �yi!");
		}
		return false;
	}
	public boolean setArmor(Armor a) {
		if (this.armor == null || this.armor.getBlock()<a.getBlock() ) {
			if(this.gold >= a.getPrice()) {
				this.armor = a;
				changeGold(-a.getPrice());
				return true;
			}else {
				System.out.println("Paran�z Yeterli De�il!");
			}
		}else {
			System.out.println("Mevcut Z�rh�n�z Daha �yi!");
		}
		return false;
	}
}
