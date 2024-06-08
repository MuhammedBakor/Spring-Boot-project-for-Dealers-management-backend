package com.mohammad_bakur.Dealer_management_api;

import com.mohammad_bakur.Dealer_management_api.requests.DealerRURequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/v1/dealers")
public class DealerController {
    private final DealerService service;

    public DealerController(DealerService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public Dealer getDealer(@PathVariable("id") Integer id){
        return service.getDealerById(id);
    }

    @GetMapping
    public List<Dealer> getAllDealers(){
        return service.getAllDealers();
    }

    @PostMapping
    public void addDealer(@RequestBody DealerRURequest request){
        service.addDealer(request);
    }

    @DeleteMapping("{id}")
    public void deleteDealer(@PathVariable("id") Integer id){
        service.deleteDealerById(id);
    }

    @PutMapping("{id}")
    public void updateDealer(@PathVariable("id") Integer id, @RequestBody DealerRURequest dealer){
        service.updateDealer(id, dealer);
    }
}
