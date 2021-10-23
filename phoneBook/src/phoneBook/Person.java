package phoneBook;

public class Person {

	private String firstName; 
	private String middleName;
	private String lastName;
	private String telephone;
	private Address address;
	public Person(String firstName, String middleName, String lastName, String telephone, String string) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.telephone = telephone;
		
	}
	public Person() {}
	
	
	public Person(String firstName2, String middleName2, String lastName2, String telephone2, Address johnDoeAdd) {
		// TODO Auto-generated constructor stub
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
	return middleName;
}
	public void setMiddleName(String MiddleName) {
	this.middleName = MiddleName;
}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", middleName=" + middleName + ",lastName=" + lastName + ", telephone=" + telephone + "]";
	}
	
}
