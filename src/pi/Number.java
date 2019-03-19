package pi;

/**
 * Class that represents a Number.
 * @author Eva Kuntz
 */
public class Number {
	private double value;
	
	public Number() {
		this.value = 0.0;
	}
	
	public Number(double value) {
		this.value = value;
	}
	
	public void increment() {
		this.value++;
	}
	
	public double getValue() {
		return this.value;
	}

}
