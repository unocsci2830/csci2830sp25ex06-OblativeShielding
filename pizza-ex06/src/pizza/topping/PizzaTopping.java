package pizza.topping;

import pizza.MenuItem;

public abstract class PizzaTopping implements MenuItem {
    @Override
    public abstract String toString();
    public String toNiceString() {
		int p = this.getPrice();
		return "Topping: " + toString() + " ($" + p / 100 + "." + p % 100 + ")";
	}
}