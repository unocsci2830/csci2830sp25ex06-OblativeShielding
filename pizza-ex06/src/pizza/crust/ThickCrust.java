package pizza.crust;
public class ThickCrust extends PizzaCrust {
	
	boolean deepDish;
	
	public ThickCrust(boolean deep) {
		deepDish = deep;
	}
	
	@Override
	public String toString() {
		return (deepDish ? "Deep Dish" : "Normal") + " Thick Crust";
	}
	
	@Override
	public String checkIntegrity() {
		if(ingredient.toLowerCase().equals("cauliflower")) {
			return "\nCareful! A thick cauliflower crust may break easily!\n";
		} else {
			return "";
		}
	}
	@Override
	public int getPrice() {
		return (deepDish ? 425 : 325);
	}
}