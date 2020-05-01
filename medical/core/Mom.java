package project.medical.core;

public class Mom extends Person {
	private WeightHeight[] fetalWH;

	
	public Mom() {
		super();
		fetalWH = null;
	}

	public Mom(String id, String lastName, String firstName, String dateOfBirth, String gender, String occupation,
			String address, String email, String phoneNumber, HistoryMedical[] histories, WeightHeight[] fetalWH) {
		super(id, lastName, firstName, dateOfBirth, gender, occupation, address, email, phoneNumber, histories);
		this.fetalWH = fetalWH;
	}

	public Mom(String id, String lastName, String firstName, String dateOfBirth, String gender, String occupation,
			String address, String email, String phoneNumber) {
		super(id, lastName, firstName, dateOfBirth, gender, occupation, address, email, phoneNumber);
	}

	
	public WeightHeight[] getFetalWH() {
		return fetalWH;
	}

	public void setFetalWH(WeightHeight[] fetalWH) {
		this.fetalWH = fetalWH;
	}

	
	

}
