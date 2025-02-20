package pizza.topping;
public abstract class MeatTopping extends PizzaTopping {
	@Override
    public String toNiceString() {
		int p = this.getPrice();
		return "Meat Topping: " + toString() + " ($" + p / 100 + "." + p % 100 + ")";
	}
}