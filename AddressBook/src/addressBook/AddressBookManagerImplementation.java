package addressBook;
import java.util.*;

public class AddressBookManagerImplementation implements AddressBookManagerInterface {
	static AddressBookImplementation ab = new AddressBookImplementation();
	String s;
	ArrayList<Person> persons;
	
	public AddressBookManagerImplementation () 	{
		persons = new ArrayList<Person>();
	}

		@Override
	public void newAddressBook() {
								
			
	}
	@Override
	public void openAddressBook()  {
	
	}
	@Override
	public void saveAddressBook() {

		
	}
	@Override
	public void saveAsAddressBook() {
	   	
	}
	@Override
	public void closeAddressBook() {
		
	}
	@Override
	public void quit() {
		
	}
	
	
}
