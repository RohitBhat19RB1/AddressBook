package addressBook;

public class Person  {
	String firstName;
	String lastName;
	String city;
	String state;
	int zipCode;
	long pNum;
	
	//standard setters
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
	public void setzipCode(int zipCodee) {
		this.zipCode = zipCodee;
	}
	public void setpNum(long pNumm) {
		this.pNum = pNumm;
	}
	//standard getters
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
	public int getzipCode() {
		return zipCode;
	}
	public long getpNum() {
		return pNum;
	}
	
	public Person(String firstName, String lastName, String city, String state, int zipCode2, long pNum2) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode2;
		this.pNum = pNum2;
	}
		
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + ", pNum=" + pNum + "]";
	}
	
}

