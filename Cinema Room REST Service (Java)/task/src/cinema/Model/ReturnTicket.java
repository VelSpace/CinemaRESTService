package cinema.Model;

public class ReturnTicket {
    public Seat returned_ticket;

    public ReturnTicket(){}

    public ReturnTicket(Seat seat){
        this.returned_ticket = seat;
    }
}
