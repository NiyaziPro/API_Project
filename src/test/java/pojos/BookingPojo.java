package pojos;

import java.io.Serializable;

public class BookingPojo implements Serializable {
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private BookingdatesPojo bookingdates;
	private String additionalneeds;

	public BookingPojo() {
	}

	public BookingPojo(String firstname, String lastname, int totalprice, boolean depositpaid, BookingdatesPojo bookingdates, String additionalneeds) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.totalprice = totalprice;
		this.depositpaid = depositpaid;
		this.bookingdates = bookingdates;
		this.additionalneeds = additionalneeds;
	}

	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getLastname(){
		return lastname;
	}

	public void setTotalprice(int totalprice){
		this.totalprice = totalprice;
	}

	public int getTotalprice(){
		return totalprice;
	}

	public void setDepositpaid(boolean depositpaid){
		this.depositpaid = depositpaid;
	}

	public boolean isDepositpaid(){
		return depositpaid;
	}

	public void setBookingdates(BookingdatesPojo bookingdates){
		this.bookingdates = bookingdates;
	}

	public BookingdatesPojo getBookingdates(){
		return bookingdates;
	}

	public void setAdditionalneeds(String additionalneeds){
		this.additionalneeds = additionalneeds;
	}

	public String getAdditionalneeds(){
		return additionalneeds;
	}

	@Override
 	public String toString(){
		return 
			"BookingPojo{" + 
			"firstname = '" + firstname + '\'' + 
			",lastname = '" + lastname + '\'' + 
			",totalprice = '" + totalprice + '\'' + 
			",depositpaid = '" + depositpaid + '\'' + 
			",bookingdates = '" + bookingdates + '\'' + 
			",additionalneeds = '" + additionalneeds + '\'' + 
			"}";
		}
}