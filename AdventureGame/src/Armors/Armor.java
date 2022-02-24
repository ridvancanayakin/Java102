package Armors;

public abstract class Armor {
	protected int id, block, price;
	@Override
	public String toString(){
		String result = "" ;
		result = this.getClass().getSimpleName() + " Bloklama: " + this.block + " Ücret: " + this.price ;
		return result;
	}
	
	public int getPrice() {
		return price;
	} 
	
	public int getBlock() {
		return block;
	}
}
