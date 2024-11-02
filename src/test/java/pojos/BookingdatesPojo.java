package pojos;

import java.io.Serializable;

public class BookingdatesPojo implements Serializable {
	private String checkin;
	private String checkout;

	public BookingdatesPojo() {
	}

	public BookingdatesPojo(String checkin, String checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public void setCheckin(String checkin){
		this.checkin = checkin;
	}

	public String getCheckin(){
		return checkin;
	}

	public void setCheckout(String checkout){
		this.checkout = checkout;
	}

	public String getCheckout(){
		return checkout;
	}

	@Override
 	public String toString(){
		return 
			"BookingdatesPojo{" + 
			"checkin = '" + checkin + '\'' + 
			",checkout = '" + checkout + '\'' + 
			"}";
		}
}