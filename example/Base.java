
public class Base {
	public int number;
	public String name;

	public Base() {
		this(1);
	}

	public Base(int num) {
		this(num, "base_intial");
	}

	public Base(int n, String name) {
		number = n;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

}
