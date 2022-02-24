package Wepons;

public abstract class Weapon{
	protected int id, damage, price;
	public int getPrice() {
		return price;
	}
	public int getDamage() {
		return damage;
	}
	@Override
	public String toString(){
		String result = "" ;
		result = this.getClass().getSimpleName() + " Hasar: " + this.damage + " Ücret: " + this.price ;
		return result;
	}
}
