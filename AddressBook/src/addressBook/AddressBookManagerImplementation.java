package addressBook;
import java.io.*;
import java.util.*;

public class AddressBookManagerImplementation implements AddressBookManagerInterface {
	static AddressBookImplementation ab = new AddressBookImplementation();
	String s;
	ArrayList<Person> persons;
	
	public AddressBookManagerImplementation () 	{
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

		{ try 
			   {
				 File myObj = new File("C:\\AddressBook\\"+name+ext);
			         if (myObj.createNewFile()) 
			         	{
			    	      System.out.println("File created: " + myObj.getName());
		         	    }
			         else 
			      		{
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
				        FileWriter myWriter = new FileWriter("C:\\AddressBook\\"+name+ext);
				        PrintWriter pw = new PrintWriter(myWriter);
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
								int zipCode = sc.nextInt();
								System.out.println("Enter phone number = ");
								long pNum = sc.nextLong();
								//construct new person object
								Person p = new Person(firstName, lastName, city, state, zipCode, pNum);
								//add the above PersonInfo object to arraylist
								persons.add(p);
				            
							 pw.print(p.getfirstName()+" ");
				             pw.print(p.getlastName()+" ");
				             pw.print(p.getcity()+" ");
				             pw.print(p.getstate()+" ");
				             pw.print(p.getzipCode()+" ");
				             pw.print(p.getpNum());
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
