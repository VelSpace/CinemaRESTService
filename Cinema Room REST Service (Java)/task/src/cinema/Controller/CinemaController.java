package cinema.Controller;

import cinema.Model.PurchaseRequest;
import cinema.Model.PurchaseTicket;
import cinema.Model.ReturnRequest;
import cinema.Model.ReturnTicket;
import cinema.Service.CinemaService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CinemaController {

    private CinemaService cinemaService;
    public CinemaController(CinemaService cinemaService){
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public ResponseEntity<?> getSeats(){
        return ResponseEntity.ok().body(cinemaService.getAvilableSeats());
    }


    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTicket(@RequestBody PurchaseRequest purchaseRequest){
        try{
            PurchaseTicket seat = cinemaService.purchaseTicket(purchaseRequest);
            return ResponseEntity.ok().body(seat);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(
                    Map.of("error", e.getMessage()));
        }
    }

    @PostMapping("/return")
    public  ResponseEntity<?> returnTicket(@RequestBody ReturnRequest returnRequest){
        try{
            ReturnTicket ticket = cinemaService.returnTicket(returnRequest);
            return ResponseEntity.ok().body(ticket);
        }
        catch (IllegalArgumentException E){
            return ResponseEntity.badRequest().body(
                    Map.of("error", E.getMessage())
            );
        }
    }

    @PostMapping("/stats")
    public  ResponseEntity<?> statsTicket(@RequestParam (required = false) String password){
       if(password == null || !password.equals("super_secret") ){

           return ResponseEntity.status(HttpStatusCode.valueOf(401)).body(
                   Map.of("error", "The password is wrong!")
           );
       }
        return ResponseEntity.ok().body(cinemaService.getStats());
    }
}
