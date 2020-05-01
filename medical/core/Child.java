package project.medical.core;

public class Child extends Person {
	private Person parent;
	private WeightHeight[] childWH;


	public Child() {
		super();
		childWH = null;
		parent = null;
	}

	public Child(String id, String lastName, String firstName, String dateOfBirth, String gender,
			String address, HistoryMedical[] histories, WeightHeight[] childWH, Person parent) {
		super(id, lastName, firstName, dateOfBirth, gender,  address, histories);
		this.childWH = childWH;
		this.setParent(parent);
	}

	public Child(String id, String lastName, String firstName, String dateOfBirth, String gender, String address) {
		super(id, lastName, firstName, dateOfBirth, gender, address);
		
	}

	
	
	public WeightHeight[] getchildWH() {
		return childWH;
	}

	public void setchildWH(WeightHeight[] childWH) {
		this.childWH = childWH;
	}

	public Person getParent() {
		return parent;
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}
	
	
}
