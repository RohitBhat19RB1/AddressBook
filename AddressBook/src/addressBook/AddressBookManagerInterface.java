package addressBook;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface AddressBookManagerInterface {

	public void newAddressBook();

	public void openAddressBook();

	public void saveAddressBook() throws FileNotFoundException, IOException, ClassNotFoundException;

	public void saveAsAddressBook();

	public void closeAddressBook();

}
