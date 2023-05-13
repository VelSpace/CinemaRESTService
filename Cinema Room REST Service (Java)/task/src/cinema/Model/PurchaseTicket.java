package cinema.Model;

public class PurchaseTicket {
    public String token;

    public Seat ticket;

    public PurchaseTicket(){}

    public PurchaseTicket(String token, Seat seat){
        this.token = token;
        this.ticket = seat;
    }

}
