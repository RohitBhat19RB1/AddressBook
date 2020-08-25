package addressBook;
import java.util.*;


public class AddressBookMain {
	static AddressBookManagerImplementation ab1 = new AddressBookManagerImplementation();

	public static void main(String[] args) {

		
		
		System.out.println("         ------ Welcome to Address Book Application ------");
		System.out.println("\n");
		System.out.println("Please Choose from the below given Options what Operation would you like to perform");
		System.out.println();
		System.out.println("\t Enter (1) to Create new Address Book");
		System.out.println("\t Enter (2) to Open Address Book");
		System.out.println("\t Enter (3) to Save Address Book");
		System.out.println("\t Enter (4) to SaveAs Address Book");
		System.out.println("\t Enter (5) to Close Address Book");
		System.out.println("\t Enter (6) to Quit");
		System.out.println();
		
		try (Scanner sc = new Scanner(System.in)){
		System.out.print("Please Enter your choice  --->");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
		    ab1.newAddressBook();
			break;
		case 2:
			ab1.openAddressBook();
			break;	
		case 3:
			ab1.saveAddressBook();
			break;
		case 4:
			ab1.saveAsAddressBook();
			break;
		case 5:
			ab1.closeAddressBook();
			break;
		case 6:
			ab1.quit();
			break;
		default:
			System.out.println("please enter your choice from the menu");
		}
		}
		

}

	
}	
	


