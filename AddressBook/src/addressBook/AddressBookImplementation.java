package addressBook;
import java.io.*;
import java.util.*;



public class AddressBookImplementation implements AddressBookInterface {
ArrayList<Person> persons;
	
	public AddressBookImplementation () {
		persons = new ArrayList<Person>();
	}
	
	public void addPerson(String n){
		
		{
			try {
					 System.out.println("how many enteries u want to enter = ");
					 @SuppressWarnings("resource")
					 Scanner sc = new Scanner(System.in);
						int entry = sc.nextInt();
				
						 File myObj = new File("C:\\AddressBook\\"+n);
						FileWriter fw = new FileWriter(myObj, true);
				      PrintWriter pw = new PrintWriter(fw, true);
				    { for(int i=0; i < entry; i++) 
				        {	    System.out.println("for entry "+ (i+1));
						    	System.out.println("Enter first name = ");
							    String firstName = sc.next();
							    System.out.println("Enter last name = ");
							    String lastName = sc.next();
							    System.out.println("Enter city = ");
							    String city = sc.next();
							    System.out.println("Enter state = ");
								String state = sc.next();
								System.out.println("Enter zipcode = ");
								long zipCode = sc.nextInt();
								System.out.println("Enter phone number = ");
								long pNum = sc.nextLong();
								//construct new person object
								Person p = new Person(firstName, lastName, city, state, zipCode, pNum);
								//add the above PersonInfo object to arraylist
								persons.add(p);
				            
								fw.append(p.getfirstName()+" ");
								fw.append(p.getlastName()+" ");
								fw.append(p.getcity()+" ");
								fw.append(p.getstate()+" ");
								pw.print(p.getzipCode()+" ");
								pw.print(p.getpNum()+" ");
				        }
					fw.close();
					pw.close();
				    }
				      System.out.println("Successfully wrote to the file");
				      System.out.println("After modifications ");
				      try {
					      File myOb = new File("C:\\AddressBook\\"+n);
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
	
	public void editPerson() {	
		
		}
	
	public void deletePerson() {
		
	}
	
	public void searchPerson() {
		 
	} 
	
	public void sortByZip() {
		
	}
	
	public void sortByNames() {
		
				}
	
	public void display() {
		 
		
	}
	
}	
