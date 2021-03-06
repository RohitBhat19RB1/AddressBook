package addressBook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddressBookImplementation implements AddressBookInterface {
	ArrayList<Person> persons;

	public AddressBookImplementation() {
		persons = new ArrayList<Person>();
	}

	public void addPerson(String n) {

		{
			try {
				System.out.println("how many enteries u want to enter = ");
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				int entry = sc.nextInt();

				File myObj = new File("C:\\AddressBook\\" + n);
				FileWriter fw = new FileWriter(myObj, true);
				PrintWriter pw = new PrintWriter(fw, true);
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

						fw.append(p.getfirstName() + " ");
						fw.append(p.getlastName() + " ");
						fw.append(p.getcity() + " ");
						fw.append(p.getstate() + " ");
						pw.print(p.getzipCode() + " ");
						pw.print(p.getPhoneNumber() + " ");
					}
					fw.close();
					pw.close();
				}
				System.out.println("Successfully wrote to the file");
				System.out.println("After modifications ");
				try {
					File myOb = new File("C:\\AddressBook\\" + n);
					Scanner myReader = new Scanner(myOb);
					while (myReader.hasNextLine()) {
						String data = myReader.nextLine();
						System.out.println(data);
					}
					myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

			} catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}

	}

	public void editPerson(String n, String num) {
		@SuppressWarnings("resource")
		Scanner sca = new Scanner(System.in);
		System.out.println("Enter the new first name = ");
		String nfName = sca.next();
		System.out.println("Enter new last name = ");
		String nlName = sca.next();
		System.out.println("Enter city = ");
		String ncity = sca.next();
		System.out.println("Enter state = ");
		String nstate = sca.next();
		System.out.println("Enter zipcode = ");
		String nzipCode = sca.next();
		System.out.println("Enter phone number = ");
		String npNum = sca.next();
		File oldFile = new File("C:\\AddressBook\\" + n);
		File newFile = new File("C:\\AddressBook\\temp.txt");
		String firstName = "";
		String lastName = "";
		String city = "";
		String state = "";
		String zipCode = "";
		String pNum = "";
		Scanner x;
		try {
			FileWriter fw = new FileWriter("C:\\AddressBook\\temp.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			x = new Scanner(new File("C:\\AddressBook\\" + n));
			x.useDelimiter("[ \n]");
			while (x.hasNext()) {
				firstName = x.next();
				lastName = x.next();
				city = x.next();
				state = x.next();
				zipCode = x.next();
				pNum = x.next();
				if (pNum.equals(num)) {
					// construct new person object
					Person p = new Person(nfName, nlName, ncity, nstate, nzipCode, npNum);
					// add the above PersonInfo object to arraylist
					persons.add(p);
					pw.println(p.getfirstName() + " ");
					pw.println(p.getlastName() + " ");
					pw.println(p.getcity() + " ");
					pw.println(p.getstate() + " ");
					pw.println(p.getzipCode() + " ");
					pw.println(p.getPhoneNumber() + " ");
				} else {
					Person p = new Person(firstName, lastName, city, state, zipCode, pNum);
					persons.add(p);
					pw.println(p.getfirstName() + " ");
					pw.println(p.getlastName() + " ");
					pw.println(p.getcity() + " ");
					pw.println(p.getstate() + " ");
					pw.println(p.getzipCode() + " ");
					pw.println(p.getPhoneNumber() + " ");
				}
			}
			x.close();
			pw.close();
			newFile.delete();
			File dump = new File("C:\\AddressBook\\" + n);
			oldFile.renameTo(dump);
			System.out.println("Successfully wrote to the file");

		} catch (Exception e) {
			System.out.println("error");
		}
		{
			try {
				File myObj = new File("C:\\AddressBook\\" + n);
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
		}
	}

	public void deletePerson(String n, String num) {
		String firstName = "";
		String lastName = "";
		String city = "";
		String state = "";
		String zipCode = "";
		String pNum = "";
		Scanner x;
		File oldFile = new File("C:\\AddressBook\\" + n);
		File newFile = new File("C:\\AddressBook\\temp.txt");

		try {
			File myObj = new File("C:\\AddressBook\\" + n);
			FileWriter fw = new FileWriter(myObj, true);
			PrintWriter pw = new PrintWriter(fw, true);

			x = new Scanner(new File("C:\\AddressBook\\" + n));
			x.useDelimiter("[ \n]");
			while (x.hasNext()) {
				firstName = x.next();
				lastName = x.next();
				city = x.next();
				state = x.next();
				zipCode = x.next();
				pNum = x.next();
				if (!pNum.equals(num)) {
					Person p = new Person(firstName, lastName, city, state, zipCode, pNum);
					persons.add(p);
					pw.println(p.getfirstName() + " ");
					pw.println(p.getlastName() + " ");
					pw.println(p.getcity() + " ");
					pw.println(p.getstate() + " ");
					pw.println(p.getzipCode() + " ");
					pw.println(p.getPhoneNumber() + " ");
				}
			}
			x.close();
			pw.close();
			newFile.delete();
			File dump = new File("C:\\AddressBook\\" + n);
			oldFile.renameTo(dump);
			System.out.println("Successfully deleted the record");

		} catch (Exception e) {
			System.out.println("error");
		}
	}

	public void searchPerson(String n) {
		boolean found = false;
		String firstName = "";
		String lastName = "";
		String city = "";
		String state = "";
		String zipCode = "";
		String pNum = "";
		System.out.println("Enter the contact number of person you want to search = ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		Scanner x;

		try {
			x = new Scanner(new File("C:\\AddressBook\\" + n));
			x.useDelimiter("[ \n]");
			while (x.hasNext()) {
				firstName = x.next();
				lastName = x.next();
				city = x.next();
				state = x.next();
				zipCode = x.next();
				pNum = x.next();
				if (pNum.equals(number)) {
					found = true;
				}
			}
			if (found == true) {
				System.out.println("firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", state="
						+ state + ", zipCode=" + zipCode + ", phone number=" + pNum);
			} else {
				System.out.println("Record not found");
			}
		} catch (Exception e) {
			System.out.println("error");
		}

	}

	public void sortByZip(String n) {
		// Creating BufferedReader object to read the input text file
		BufferedReader reader = new BufferedReader(new FileReader("C:\\AddressBook\\" + n));
		String currentLine = reader.readLine(); // Reading person records one by one
		String firstName = "";
		String zipCode = "";
		String lastName = "";
		String pNum = "";
		String state = "";
		String city = "";

		while (currentLine != null) {
			String[] personDetail = currentLine.split(" ");
			String name = personDetail[0];
			persons.add(new Person(firstName, lastName, city, state, zipCode, pNum)); // Creating Student object for
																						// every person record and
																						// adding it to ArrayList
			currentLine = reader.readLine();
		}

		Collections.sort(persons, new zipCompare()); // Sorting ArrayList studentRecords based on names

		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\AddressBook\\temp.txt")); // Creating
																									// BufferedWriter
																									// object to write
																									// into output text
																									// file
		for (Person p : persons) // Writing every person Records into output text file
		{
			writer.write(p.firstName + " ");
			writer.write(p.lastName + " ");
			writer.write(p.city + " ");
			writer.write(p.state + " ");
			writer.write(p.zipCode + " ");
			writer.write(p.phoneNumber + " ");
			writer.newLine();
		}

		reader.close(); // Closing the resources
		writer.close();

	}

	public void sortByNames(String n) {
		// Creating BufferedReader object to read the input text file
		BufferedReader reader = new BufferedReader(new FileReader("C:\\AddressBook\\" + n));
		String currentLine = reader.readLine(); // Reading person records one by one
		String firstName = "";
		String zipCode = "";
		String lastName = "";
		String pNum = "";
		String state = "";
		String city = "";

		while (currentLine != null) {
			String[] personDetail = currentLine.split(" ");
			String name = personDetail[0];
			persons.add(new Person(firstName, lastName, city, state, zipCode, pNum)); // Creating Student object for
																						// every person record and
																						// adding it to ArrayList
			currentLine = reader.readLine();
		}

		Collections.sort(persons, new nameCompare()); // Sorting ArrayList studentRecords based on names

		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\AddressBook\\temp.txt")); // Creating
																									// BufferedWriter
																									// object to write
																									// into output text
																									// file
		for (Person p : persons) // Writing every person Records into output text file
		{
			writer.write(p.firstName + " ");
			writer.write(p.lastName + " ");
			writer.write(p.city + " ");
			writer.write(p.state + " ");
			writer.write(p.zipCode + " ");
			writer.write(p.phoneNumber + " ");
			writer.newLine();
		}

		reader.close(); // Closing the resources
		writer.close();
	}

	public void display() {
		System.out.println("--- Total AddressBooks present ---");
		try {
			File myObj = new File("C:\\AddressBook\\");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("Enter the addressBook you want to open ");
		@SuppressWarnings("resource")
		Scanner ab = new Scanner(System.in);
		String nam = ab.next();
		System.out.println(" --Contents in the addressbook--");
		try {
			File myObj = new File("C:\\AddressBook\\" + nam);
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

	public void quit() {
		System.exit(0);
	}

}
