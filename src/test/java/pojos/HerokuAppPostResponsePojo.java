package pojos;

public class HerokuAppPostResponsePojo {

    private Integer bookingid;
    private HerokuAppGetResponsePojo booking;

    public HerokuAppPostResponsePojo() {
    }

    public HerokuAppPostResponsePojo(Integer bookingid, HerokuAppGetResponsePojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public HerokuAppGetResponsePojo getBooking() {
        return booking;
    }

    public void setBooking(HerokuAppGetResponsePojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "HerokuAppPostResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
