package OOP_Project;
import java.util.*;

public class AdminInterface implements inputInterface{
	private boolean adminLogout;
	
	private BookingList bl;
	Scanner in = new Scanner(System.in);
	
	public AdminInterface(BookingList b) {
		this.bl = b;
	}

    @Override
    public void collectInput() {
		boolean stayLoggedIn = false;
        // give list of options an admin has and depending on his choice call appropriate method, run on loop till exit
		do{
			System.out.println("Press 1 to approve a booking, 2 to reject a booking, 3 to enquire more about a specific booking and 4 to view all unapproved bookings, and 5 to log out");
			int adminno = in.nextInt();
			if(adminno==1) { // approve a booking
				System.out.println("Enter booking ID");
				Integer bookingID = Integer.valueOf(in.nextInt());
				stayLoggedIn = false;
				if(BookingList.approveBooking(bookingID)){
					System.out.println("Booking approved! Enter 0 to go to the home screen. ");
				}
				Main.tryAgain = in.nextInt();
			}
			else if(adminno==2) { // reject a booking
				System.out.println("Enter booking ID");
				Integer bookingID = Integer.valueOf(in.nextInt());
				stayLoggedIn = false;
				if(BookingList.approveBooking(bookingID)){
					System.out.println("Booking rejected! Enter 0 to go to the home screen. ");
				}
				Main.tryAgain = in.nextInt();
			}
			else if(adminno==3) { // enquire more about a specific booking
				System.out.println("Enter booking ID");
				Integer bookingID = Integer.valueOf(in.nextInt());
				System.out.println("Give reason");
				String reason = in.nextLine();
				enquireMore(bookingID, reason);
				stayLoggedIn = false;
			}
			else if(adminno==4) { // view all unapproved bookings
				viewAllUnapprovedBooking();
				stayLoggedIn = true;
			}
			else if (adminno ==5){
				stayLoggedIn = false;
				System.out.println("Logging out...");
			}
			else{
				System.out.println("Invalid input. Enter 0 to logout and 1 to retry.");
				int temp = in.nextInt();
				if (temp == 0){
					stayLoggedIn = false;
					System.out.println("Logging out...");
				}
				else if (temp!=0 && temp!=1){
					Main.tryAgain++;
					stayLoggedIn = false;
				}
			}
		}while(stayLoggedIn == true);
	}

    private void viewAllUnapprovedBooking(){
    	System.out.println(BookingList.getUnapprovedBookings());

    }

    private void enquireMore(Integer bookingID, String reason){
    	

    }

}
