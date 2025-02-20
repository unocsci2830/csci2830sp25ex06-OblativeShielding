package pizza.topping;
public abstract class VeggieTopping extends PizzaTopping {
	
	@Override
    public String toNiceString() {
		int p = this.getPrice();
		return "Veggie Topping: " + toString() + " ($" + p / 100 + "." + p % 100 + ")";
	}
	
}