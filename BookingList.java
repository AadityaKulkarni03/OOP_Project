package OOP_Project;

import java.util.*;

public class BookingList {

    private static HashMap<Integer, Booking> allBookings;
    private static HashMap<Integer, Booking> unapprovedBookings;
    //private HashMap<Integer, Booking> approvedBooking;

    public BookingList() {
        allBookings = new HashMap<>();
        //approvedBooking = new HashMap<>();
        unapprovedBookings = new HashMap<>();
    }

    public static boolean approveBooking(Integer bookingID) {
    	if(allBookings.get(bookingID) == null) {
    		System.out.println("Invalid booking ID, try again");
            return false;
    	}
    	else {
        	allBookings.get(bookingID).approvedStatus();
            return true;
    	}
        // return false if booking id not present
        // else remove id from unapproved, change status of booking and return true
    }

    public static void rejectBooking(Integer bookingID) {
    	if(allBookings.get(bookingID) == null) {
    		System.out.println("Invalid booking ID, try again");
    	}
    	else {
        	allBookings.get(bookingID).rejectedStatus();
        	
    	}
        // return false if booking id not present
        // else remove from unapproved booking, change status of booking to rejected, set reason of rejection to reason in booking class
        // by calling setReasonOfRejection and return true
    }

    public void addBooking(Integer bookingID, Booking booking) {
        // return false if bookingID already present in allBookings
        // else add booking to allBookings and unapprovedBooking and return true
    	allBookings.put(bookingID,booking);
    	unapprovedBookings.put(bookingID,booking);
    }
    
    public static void removeBooking(Integer bookingID, Booking booking) {
    	allBookings.remove(bookingID, booking);
    }

    public static HashMap<Integer, Booking> getUnapprovedBookings(){
        return unapprovedBookings;
    }
    public static int size() {
    	return allBookings.size();
    }
    
    public static Booking getBooking(int i) {
    	return allBookings.get(i);
    }
}

