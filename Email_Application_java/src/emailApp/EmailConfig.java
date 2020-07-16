package emailApp;

import java.util.Scanner;

public class EmailConfig {
	
	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=500;
	private int defaultPasswordLength=10;
	private String alternateEmail;
	private String companySuffix = "OOPScompany.com";
	
	//Constructor : to receive the first and last name.
	
	public EmailConfig(String firstname, String lastname){
		this.firstname= firstname;
		this.lastname= lastname;
		System.out.println("EMAIL CREATED :"+this.firstname+" "+this.lastname);
		
		//Call a method and ask for the department -- return the department.
		this.department= setDepartment();
		System.out.println("Department :"+this.department);
		
		//Call a method which generates a random password -- return the password.
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your Password is: "+this.password);
		
		//Combining the elements to generate the email.
		email = firstname.toLowerCase()+"."+lastname.toLowerCase()+"@"+department+"."+companySuffix;
		System.out.println("Your email is :"+email);
				
		
	}
	
	//Ask for the department.
	private String setDepartment() {
		System.out.print("The Department Codes are :\n1 for Sales.\n2 for Development.\n3 for Accounting.\n0 for None.\nEnter the Department code: ");
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		if(departmentChoice == 1) {
			return "Sales";
			in.close();
		}else if(departmentChoice == 2) {
			return "Development";
			in.close();
		}else if(departmentChoice == 3) {
			return "Accounting";
			in.close();
		}else {
			return "";
			in.close();
		}
		
		
	}
	
	//Generation of a random password.
	private String randomPassword(int length) {
		
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		
		for(int i=0; i<length; i++) {
			int rand = (int) (Math.random()* passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return hash.encrypt(new String (password));
		
	}
	
	//Set the mailbox capacity.
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity= capacity;
	}
	
	//Set the alternate email.
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password.
	public void changePassword(String password) {
		this.password=hash.encrypt(password);
	}
	
	public int getmailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail;}
	public String getPassword() { return password;}
	
	public String showInformation() {
		return "DISPLAY NAME: "+ firstname +" "+ lastname + "\nCOMPANY EMAIL: "+ email + "\nMAILBOX CAPACITY: "+mailboxCapacity+"mb";
	}

}
