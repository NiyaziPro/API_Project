package pojos;

import java.io.Serializable;

public class ResponsePojo implements Serializable {
	private int bookingid;
	private BookingPojo booking;

	public ResponsePojo() {

	}

	public ResponsePojo(int bookingid, BookingPojo booking) {
		this.bookingid = bookingid;
		this.booking = booking;
	}

	public void setBookingid(int bookingid){
		this.bookingid = bookingid;
	}

	public int getBookingid(){
		return bookingid;
	}

	public void setBooking(BookingPojo booking){
		this.booking = booking;
	}

	public BookingPojo getBooking(){
		return booking;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePojo{" + 
			"bookingid = '" + bookingid + '\'' + 
			",booking = '" + booking + '\'' + 
			"}";
		}
}