package project.medical.core;
public class Person {
	private String id;
	private String lastName;
	private String firstName;
	private String dateOfBirth;
	private String gender;
	private String occupation;
	private String address;
	private String email;
	private String phoneNumber ;
	private HistoryMedical [] histories;
	
	//Constructor
	
	public Person() {
		id = null;
		lastName = null;
		firstName = null;
		dateOfBirth = null;
		gender = null;
		occupation = null;
		address = null;
		email = null;
		phoneNumber = null;

	}
	
	
	public Person(String id, String lastName, String firstName, String dateOfBirth, String gender, String occupation,
			String address, String email, String phoneNumber,  HistoryMedical[] histories) {

		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.occupation = occupation;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.histories = histories;
	}

	public Person(String id, String lastName, String firstName, String dateOfBirth, String gender, String occupation,
			String address, String email, String phoneNumber) {

		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.occupation = occupation;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;

	}
	
	public Person(String id, String lastName, String firstName, String dateOfBirth, String gender, String occupation,
			String address, String phoneNumber) {

		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.occupation = occupation;
		this.address = address;
		this.phoneNumber = phoneNumber;
		
	}
	
	public Person(String id, String lastName, String firstName, String dateOfBirth, String gender,
			String address, HistoryMedical[] histories) {
		
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.histories = histories;
	}
	
	public Person(String id, String lastName, String firstName, String dateOfBirth, String gender, String address) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
	}

	//Setter & Getter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public HistoryMedical[] getHistories() {
		return histories;
	}
	public void setHistories(HistoryMedical[] histories) {
		this.histories = histories;
	}

	
	

}
