
public class Sub extends Base {
	public String name;

	public Sub() {
		this("sub_initial");
	}

	public Sub(String name) {
		this(2, name);
	}

	public Sub(int number, String name) {
		super(number);
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getSuperName() {
		return super.getName();
	}

	public String getThisName() {

		return this.getName();
	}

}
