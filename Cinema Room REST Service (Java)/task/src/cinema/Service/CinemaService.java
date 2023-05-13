package cinema.Service;

import cinema.Model.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CinemaService {
    public final int totalRows = 9;
    public final int totalColumns = 9;
    public static HashMap<String, Seat> hm = new HashMap<>();
    public static HashSet<String> purchasedSeats = new HashSet<>();
    public static int total_price = 0;
    public static int number_of_available_seats = 81;
    public static int number_of_purchased_tickets = 0;


    public AllSeats getAvilableSeats(){
        AllSeats allSeats = new AllSeats(9 , 9 , new ArrayList<>());
        for(int row = 1; row <= 9 ; row++){
            for(int col = 1; col <= 9; col++){
                allSeats.available_seats.add(new Seat(row, col, row <= 4 ? 10 : 8));
            }
        }
        return allSeats;
    }
    public PurchaseTicket purchaseTicket(PurchaseRequest request){
        synchronized(hm){
            String seatKey = request.row+"-"+ request.column;
            validateSeat(request);
            if(purchasedSeats.contains(seatKey)){
                throw new IllegalArgumentException("The ticket has been already purchased!");
            }
            purchasedSeats.add(seatKey);
            String token = UUID.randomUUID().toString();
            Seat seat = new Seat(request.row, request.column, request.row <= 4 ? 10 : 8);

            number_of_available_seats--;
            number_of_purchased_tickets++;
            total_price += request.row <= 4 ? 10 : 8;

            hm.put(token, seat);
            return new PurchaseTicket(token, seat);
        }

    }
    public void validateSeat(PurchaseRequest request){
        if(request.row <= 0 || request.row > totalRows){
            throw new IllegalArgumentException("The number of a row or a column is out of bounds!");
        }
        if(request.column <= 0 || request.column > totalColumns){
            throw new IllegalArgumentException("The number of a row or a column is out of bounds!");
        }
    }
    public ReturnTicket returnTicket(ReturnRequest returnRequest){
        String str = returnRequest.token;
        if(!hm.containsKey(str)){
            throw new IllegalArgumentException("Wrong token!");
        }
        number_of_available_seats++;
        number_of_purchased_tickets--;
        total_price -= hm.get(str).row <= 4 ? 10 : 8;
        return new ReturnTicket(hm.get(str));
    }
    public stats getStats(){
        return new stats(total_price, number_of_available_seats, number_of_purchased_tickets);
    }
}
