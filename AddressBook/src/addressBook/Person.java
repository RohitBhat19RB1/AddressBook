package addressBook;

public class Person implements Comparable<Person> {
	String firstName;
	String lastName;
	String city;
	String state;
	String zipCode;
	String phoneNumber;

	public int namecompare(Person p1, Person p2) {
		return p1.firstName.compareTo(p2.firstName);
	}

	public int zipcompare(Person p1, Person p2) {
		return p1.zipCode.compareTo(p2.zipCode);
	}

	// standard setters
	public void setfirstName(String fName) {
		this.firstName = fName;
	}

	public void setlastName(String lName) {
		this.lastName = lName;
	}

	public void setcity(String cityy) {
		this.city = cityy;
	}

	public void setstate(String statee) {
		this.state = statee;
	}

	public void setzipCode(String zipCodee) {
		this.zipCode = zipCodee;
	}

	public void setPhoneNumber(String pNumm) {
		this.phoneNumber = pNumm;
	}

	// standard getters
	public String getfirstName() {
		return firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public String getcity() {
		return city;
	}

	public String getstate() {
		return state;
	}

	public String getzipCode() {
		return zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Person(String firstName, String lastName, String city, String state, String zipCode, String pNum) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNumber = pNum;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + ", pNum=" + phoneNumber + "]";
	}

	@Override
	public int compareTo(Person arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
