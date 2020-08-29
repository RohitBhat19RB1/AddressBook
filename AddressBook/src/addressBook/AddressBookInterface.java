package addressBook;

public interface AddressBookInterface {

	public void addPerson(String n);

	public void editPerson(String n, String num);

	public void deletePerson(String n, String num);

	public void searchPerson(String n);

	public void sortByZip(String n);

	public void sortByNames(String n);

	public void display();

}
