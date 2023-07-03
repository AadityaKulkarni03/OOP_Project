package OOP_Project;
import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class UserInterface implements inputInterface{
	
	private String name;
	private String ID;
	//private boolean club;
	private String clubName;
	//private int roomno;
	private String roomName;
    private int bookingID=0;
    private int starthour;
    private int endhour;
    private String date;
    private User buddy;
    private int noOfStudents;
    private String reasonOfBooking;
	
	Scanner sc = new Scanner(System.in);
	private BookingList bl;
	
	public UserInterface(BookingList b) {
		this.bl = b;
	}
    @Override
    public void collectInput() {
        // give list of options an admin has and depending on his choice call appropriate method, run on loop till exit
    	System.out.println("Press 1 to add booking, 2 to cancel booking, 3 to view existing booking");
    	int userno = sc.nextInt();
    	if(userno==1) {   //add booking
    		System.out.println("Enter your name");
    		name = sc.next();
    		System.out.println("Enter your BITS ID");
    		ID = sc.next();
    		System.out.println("Press 1 if you are booking as an individual or 2 if you are booking as a club");
    		int ifclub = sc.nextInt();
    		if(ifclub==1) { // booking as an individual
    			buddy = new User(name, ID);
    		}
    		else if(ifclub==2) { // booking as a club
    			System.out.println("Enter club name");
    			clubName = sc.next();
    			buddy = new User(name, ID, clubName);
    		}
			else{
				System.out.println("Invalid Input. Enter 0 to start over");
				Main.tryAgain = sc.nextInt(); //     <-----------------
			}
    		System.out.println("Press 1 if you want to book Library brainstorm room, 2 if you want to book LTC Halls, 3 if you want to book NAB audi");
    		int roomno = sc.nextInt();
    		if(roomno==1) { // book Library brainstorm room
    			roomName = "Library Brainstorming Room";
    		}
    		else if(roomno==2) { // book LTC Halls
    			System.out.println("Press 1 for 5101, 2 for 5102 and 3 for 5103");
    			int ltcno = sc.nextInt();
    			if(ltcno==1) {
    				roomName = "LTC 5101";
    			}
    			else if(ltcno==2) {
    				roomName = "LTC 5102";
    			}
    			else if(ltcno==3) {
    				roomName = "LTC 5103";
    			}
    		}
    		else if(roomno==3) { // book NAB audi
    			roomName = "NAB Audi";
    		}
			else{
				System.out.println("Invalid input. Enter 0 to start over. ");
				Main.tryAgain = sc.nextInt();
			}
    		System.out.println("Enter the date you want to book in the format: DDMMYYYY");
    		date = sc.next();
    		System.out.println("Enter the starting time as an hour in 24hr format (from 8 to 21)");
    		starthour = sc.nextInt();
    		System.out.println("Enter the endtime as an hour in 24hr format (from 9 to 22)");
    		endhour = sc.nextInt();
    		checkClashes(roomName, date, starthour, endhour);
    		System.out.println("Enter number of students");
    		noOfStudents = sc.nextInt();


			// criteria for maximum number of students
			if(roomno ==1 && noOfStudents > 15){
				System.out.println("Cannot book Library Brainstorming Room for more than 15 students.");
				System.out.println("Enter 0 to start over");
				Main.tryAgain = sc.nextInt();
			}
			else if(roomno ==2 && noOfStudents > 100 ){
				System.out.println("Cannot book LTC for more than 100 students.");
				System.out.println("Enter 0 to start over");
				Main.tryAgain = sc.nextInt();
			}
			else if(roomno ==3 && noOfStudents > 150 ){
				System.out.println("Cannot book NAB Audi for more than 150 students.");
				System.out.println("Enter 0 to start over");
				Main.tryAgain = sc.nextInt();
			}
    		else {
				System.out.println("Enter the reason for your booking");
				sc.nextLine();
				reasonOfBooking = sc.nextLine();
				addBooking(buddy, roomName, date, starthour, endhour, noOfStudents, reasonOfBooking);
				System.out.println("Booking request made. Admin approval pending!");
			}
    	}
    	else if(userno==2) {  // cancel booking
    		System.out.println("Enter booking ID");
    		int cancelID = sc.nextInt();
    		Booking cancelBooking = BookingList.getBooking(cancelID);
    		BookingList.removeBooking(cancelID, cancelBooking);
    		System.out.println("Booking removed!");
    	}
    	else if(userno==3) { // view existing booking
    		System.out.println("Enter booking ID");
    		int getBookID = sc.nextInt();
    		Booking getBook = BookingList.getBooking(getBookID);
    		System.out.println(getBook.toString());
    	}
		else{
			System.out.println("Invalid input. Enter 0 to start over. ");
			Main.tryAgain = sc.nextInt();
		}
    }

    private void addBooking(User buddy, String roomName, String date, int starthour, int endhour, int noOfStudents, String reasonOfBooking) {
    	Booking newBooking = new Booking(buddy, roomName, date, starthour, endhour, noOfStudents, reasonOfBooking);
    	int bookingID = newBooking.getBookingID();
    	
    	bl.addBooking(bookingID, newBooking);
    	
    }

	// Why checkClashes here?
    private boolean checkClashes(String roomName, String date, int starthour, int endhour) {
    	boolean ifclashes=false;
    	for(int i=0; i<BookingList.size(); i++) {
    		Booking oldbooking = BookingList.getBooking(i);
    		if(oldbooking.getDate().equals(date) && (oldbooking.getRoomname().equals(roomName)) && ((starthour>=oldbooking.getStarthour()&&starthour<oldbooking.getEndhour()) || (endhour>oldbooking.getStarthour()&&endhour>=oldbooking.getEndhour()))) {
    			ifclashes=true;
    			return ifclashes;
    		}
    		else continue;
    		
    	}
    	return ifclashes;
    }




}
