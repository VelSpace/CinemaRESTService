package cinema.Model;

import java.util.List;

public class AllSeats {
    public int total_rows;
    public int total_columns;
    public List<Seat> available_seats;

    public AllSeats(){}
    public AllSeats(int total_rows, int total_columns, List<Seat> seats) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = seats;
    }
}
