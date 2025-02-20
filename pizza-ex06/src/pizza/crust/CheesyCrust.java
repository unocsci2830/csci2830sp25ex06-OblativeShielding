package pizza.crust;
public class CheesyCrust extends PizzaCrust {
	@Override
	public String toString() {
		return "Cheesy Crust";
	}
	@Override
	public int getPrice() {
		return 350;
	}
}