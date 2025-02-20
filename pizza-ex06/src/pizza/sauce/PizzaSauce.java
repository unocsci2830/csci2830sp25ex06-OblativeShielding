package pizza.sauce;

import pizza.MenuItem;

public abstract class PizzaSauce implements MenuItem {
	@Override
	public abstract String toString();
	public String toNiceString() {
		int p = this.getPrice();
		return "Sauce: " + toString() + " ($" + p / 100 + "." + p % 100 + ")";
	}
}