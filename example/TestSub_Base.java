public class TestSub_Base {

	public static void main(String[] args) {
		Base b = new Base();
		System.out.println("base.number=" + b.number);
		System.out.println("base.name=" + b.name);
		System.out.println("base.getNumber():" + b.getNumber());
		System.out.println("base.getName():" + b.getName());

		Sub s = new Sub();
		System.out.println("sub.number=" + s.number);
		System.out.println("sub.name=" + s.name);
		System.out.println("sub.getNumber():" + s.getNumber());
		System.out.println("sub.getName():" + s.getName());
		System.out.println("((Base)sub).getName()=" + ((Base) s).getName());
		System.out.println("((Base)sub).name=" + ((Base) s).name);

		System.out.println("sub.getSuperName():" + s.getSuperName());
		System.out.println("sub.getThisName():" + s.getThisName());

		b = s;
		System.out.println("base.number=" + b.number);
		System.out.println("base.name=" + b.name);
		System.out.println("((Sub)base).name=" + ((Sub) b).name);
		System.out.println("base.getNumber():" + b.getNumber());
		System.out.println("base.getName():" + b.getName());
		//System.out.println("sub.getSuperName():"+b.getSuperName());
		//System.out.println("sub.getThisName():"+b.getThisName());
	}

}
