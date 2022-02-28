package Builds;

import Armors.*;
import Wepons.*;

public abstract class Build {
	protected int id, damage, currentHealth, maxHealth, gold;
	protected String name;
	protected Weapon weapon = null;
	protected Armor armor = null;
	private boolean odun = false, su = false, yemek = false, dead = false;
	
	public String getName() {
		return name;
	}
	public int getDamage() {
		int result = 0;
		if(null != weapon)
			result = result +weapon.getDamage();
		result = result +damage;
		return result;
	}
	public int getBlock() {
		if(null != armor) {
			return armor.getBlock();
		}
		return 0;
	}
	public boolean getOdun() {
		return odun;
	}
	public void setOdun(boolean odun) {
		this.odun = odun;
	}
	public boolean getSu() {
		return su;
	}
	public void setSu(boolean su) {
		this.su = su;
	}
	public boolean getDead() {
		return dead;
	}
	public void setDead() {
		this.dead = true;
	}
	public boolean getYemek() {
		return yemek;
	}
	public void setYemek(boolean yemek) {
		this.yemek = yemek;
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
	public boolean setWeapon(Weapon w ,int price) {
		if (this.weapon == null || this.weapon.getDamage()< w.getDamage()) {
			if(this.gold>=price) {
				this.weapon = w;
				changeGold(-price);
				return true;
			}else {
				System.out.println("Paranýz Yeterli Deðil!");
			}
		}else {
			System.out.println("Mevcut Silahýnýz Daha Ýyi!");
		}
		return false;
	}
	public boolean setArmor(Armor a, int price) {
		if (this.armor == null || this.armor.getBlock()<a.getBlock() ) {
			if(this.gold >= price) {
				this.armor = a;
				changeGold(-price);
				return true;
			}else {
				System.out.println("Paranýz Yeterli Deðil!");
			}
		}else {
			System.out.println("Mevcut Zýrhýnýz Daha Ýyi!");
		}
		return false;
	}
	public boolean takeDamage(int damage) {
		boolean result = false;
		if(damage>=currentHealth) {
			currentHealth = 0;
			setDead();
			result = true;
		}else {
			currentHealth = currentHealth - damage;
		}
		return result;
	}
}
