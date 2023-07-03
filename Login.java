package OOP_Project;
import java.util.*;

public class Login implements inputInterface {
	
	Scanner sc=new Scanner(System.in);
	
	String admin1name= "Admin1";
	String admin1pass= "123";
	String admin2name= "Admin2";
	String admin2pass= "456";
	String admin3name= "Admin3";
	String admin3pass= "789";
	
	BookingList bookingList;

	public Login(BookingList bookingList){
		this.bookingList = bookingList;
	}
	

	@Override
	public void collectInput()
	{
		System.out.println("Press 1 if you are a user and press 2 if you are an admin");
		int a=sc.nextInt();
		if(a==2)
		{ //admin
			System.out.println("Enter username");
			String userName= sc.next();
			System.out.println("Enter password");
			String password= sc.next();
			if((userName.equals(admin1name)&&password.equals(admin1pass))||(userName.equals(admin2name)&&password.equals(admin2pass))||(userName.equals(admin3name)&&password.equals(admin3pass)))
			{ // Correct Credentials of admin
				AdminInterface admin = new AdminInterface(bookingList);
				admin.collectInput();
			}
			else
			{ // Wrong Credentials of admin
				System.out.println("Wrong credentials. Enter 0 to start over. ");
				Main.tryAgain = sc.nextInt();
			}
		}
		else if(a==1)
		{ // user
			System.out.println("Enter username");
			String userName= sc.next();
			System.out.println("Enter password");
			String password= sc.next();
			UserInterface user = new UserInterface(bookingList);
			user.collectInput();
		}
		else{
			System.out.println("Invalid input. Enter 0 to start over. ");
			Main.tryAgain = sc.nextInt();
		}
	}
}
