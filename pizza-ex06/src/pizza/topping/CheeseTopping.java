package pizza.topping;
public abstract class CheeseTopping extends PizzaTopping {
	
	@Override
    public String toNiceString() {
		int p = this.getPrice();
		return "Cheese Topping: " + toString() + " ($" + p / 100 + "." + p % 100 + ")";
	}
	
}