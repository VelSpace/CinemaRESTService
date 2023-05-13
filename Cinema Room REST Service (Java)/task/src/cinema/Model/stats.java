package cinema.Model;

public class stats {
    public int current_income;
    public int number_of_available_seats;
    public int number_of_purchased_tickets;

    public stats(){}

    public stats(int current_income, int number_of_available_seats, int number_of_purchased_tickets) {
        this.current_income = current_income;
        this.number_of_available_seats = number_of_available_seats;
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }
}
