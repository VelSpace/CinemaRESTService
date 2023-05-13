package cinema.Model;

public class Seat {
    public int row;
    public int column;
    public int price;
    public Seat(){}

    public Seat(int row, int col, int price){
        this.row = row;
        this.column = col;
        this.price = price;
    }
}
