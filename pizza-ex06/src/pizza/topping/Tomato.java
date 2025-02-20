package pizza.topping;
public class Tomato extends VeggieTopping {
	@Override
	public String toString() {
		return "Tomato";
	}
	@Override
	public int getPrice() {
		return 70;
	}
}