package pizza.crust;
public class ThinCrust extends PizzaCrust {
	@Override
	public String toString() {
		return "Thin Crust";
	}
	@Override
	public int getPrice() {
		return 175;
	}
}