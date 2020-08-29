package addressBook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookManagerImplementation implements AddressBookManagerInterface {
	static AddressBookImplementation ab = new AddressBookImplementation();
	String s;
	ArrayList<Person> persons;

	public AddressBookManagerImplementation() {
		persons = new ArrayList<Person>();
	}

	@SuppressWarnings("resource")
	@Override
	public void newAddressBook() {

		Scanner sc = new Scanner(System.in);
		System.out.println("By What name would you like to save ur new Address Book ---- ");
		String name = sc.nextLine();
		System.out.println("what extension would you like to give (.csv , .txt or .json) ---- ");
		String ext = sc.nextLine();

		{
			try {
				File myObj = new File("C:\\AddressBook\\" + name + ext);
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}

		{
			try {
				System.out.println("how many enteries u want to enter = ");
				int entry = sc.nextInt();
				FileWriter myWriter = new FileWriter("C:\\AddressBook\\" + name + ext);
				PrintWriter pw = new PrintWriter(myWriter);
				{
					for (int i = 0; i < entry; i++) {
						System.out.println("for entry " + (i + 1));
						System.out.println("Enter first name = ");
						String firstName = sc.next();
						System.out.println("Enter last name = ");
						String lastName = sc.next();
						System.out.println("Enter city = ");
						String city = sc.next();
						System.out.println("Enter state = ");
						String state = sc.next();
						System.out.println("Enter zipcode = ");
						String zipCode = sc.next();
						System.out.println("Enter phone number = ");
						String pNum = sc.next();
						// construct new person object
						Person p = new Person(firstName, lastName, city, state, zipCode, pNum);
						// add the above PersonInfo object to arraylist
						persons.add(p);

						pw.print(p.getfirstName() + " ");
						pw.print(p.getlastName() + " ");
						pw.print(p.getcity() + " ");
						pw.print(p.getstate() + " ");
						pw.print(p.getzipCode() + " ");
						pw.print(p.getPhoneNumber());
						pw.println();
					}
					pw.close();
				}
				System.out.println("Successfully wrote to the file");

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}

	}

	@Override
	public void openAddressBook() {
		System.out.println("Total AddressBooks present  ");
		File file = new File("C:\\AddressBook\\");
		String[] files = file.list();
		for (String string : files) {
			System.out.println(string);
		}
		System.out.println("Enter the name of Address Book you want to open --- ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String name1 = sc.next();
		try {
			File myObj = new File("C:\\AddressBook\\" + name1);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		System.out.println("Please Choose from the below given Options what Operations would you like to perform");
		System.out.println();
		while (true) {
			System.out.println("\t Enter (1) to add new Person");
			System.out.println("\t Enter (2) to edit any Person");
			System.out.println("\t Enter (3) to delete any Person");
			System.out.println("\t Enter (4) to search Person");
			System.out.println("\t Enter (5) to sort by Zip");
			System.out.println("\t Enter (6) to sort by name");
			System.out.println("\t Enter (7) to display");
			System.out.println("\t Enter (8) to quit");
			System.out.println();

			try (Scanner sci = new Scanner(System.in)) {
				System.out.print("Please Enter your choice  --->");
				int ch = sci.nextInt();
				switch (ch) {
				case 1:
					ab.addPerson(name1);
					break;
				case 2:
					System.out.println("Enter the phone number of the person u want to edit-");
					String number = sci.next();
					ab.editPerson(name1, number);
					break;
				case 3:
					System.out.println("Enter the phone number of the person u want to delete-");
					String number1 = sci.next();
					ab.deletePerson(name1, number1);
					break;
				case 4:
					ab.searchPerson(name1);
					break;
				case 5:
					ab.sortByZip(name1);
					break;
				case 6:
					ab.sortByNames(name1);
					break;
				case 7:
					ab.display();
					break;
				case 8:
					ab.quit();
				default:
					System.out.println("please enter your choice from the menu");
				}
			}
		}
	}

	@Override
	public void saveAddressBook() throws FileNotFoundException, IOException, ClassNotFoundException {
		String firstName = "";
		String zipCode = "";
		String lastName = "";
		String PhoneNumber = "";
		String state = "";
		String city = "";
		Person p1 = new Person(firstName, lastName, city, state, zipCode, PhoneNumber);
		@SuppressWarnings("resource")
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Person.txt"));
		out.writeObject(p1);
		@SuppressWarnings("resource")
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Person.txt"));
		Person p2 = (Person) in.readObject();

		System.out.println(p2.getfirstName() + " ");
		System.out.println(p2.getlastName() + " ");
		System.out.println(p2.getcity() + " ");
		System.out.println(p2.getstate() + " ");
		System.out.println(p2.getzipCode() + " ");
		System.out.println(p2.getPhoneNumber() + " ");

	}

	@Override
	public void saveAsAddressBook() {
		System.out.println("Enter the AddressBook name you want to rename(with extension)-");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("Enter the new name for AddressBook(with same extension) -");
		String newname = sc.next();
		File newFile = new File("C:\\AddressBook\\" + name);
		File renFile = new File("C:\\AddressBook\\" + newname);
		if (newFile.renameTo(renFile)) {
			System.out.println(newFile.getName() + "renamed to" + renFile.getName());
		} else {
			System.out.println("an error occured");
		}
		renFile.delete();

	}

	@Override
	public void closeAddressBook() {

		System.exit(0);
	}

}
