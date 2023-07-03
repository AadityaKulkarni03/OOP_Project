package OOP_Project;

public class Main {
    public static int tryAgain = 0;
    public static void main(String args[]){
    
        BookingList bookingList = new BookingList();
        System.out.println("Welcome to the BITS Booking Management System ");
        Login loginPage = new Login(bookingList);
        while(tryAgain==0){
            loginPage.collectInput();
        }
    }
}