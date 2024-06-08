package com.mohammad_bakur.Dealer_management_api;

import com.mohammad_bakur.Dealer_management_api.exceptions.RequestValidationException;
import com.mohammad_bakur.Dealer_management_api.exceptions.ResourceDuplicatedException;
import com.mohammad_bakur.Dealer_management_api.exceptions.ResourceNotFoundException;
import com.mohammad_bakur.Dealer_management_api.requests.DealerRURequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DealerService {
    private final DataAccessObject<Dealer> dao;

    public DealerService(@Qualifier("jdbc") DataAccessObject<Dealer> dao) {
        this.dao = dao;
    }

    public Dealer getDealerById(Integer id){
        return dao.getById(id).orElseThrow(()->
                new ResourceNotFoundException("Dealer with id [%s] is not found".formatted(id)));
    }

    public List<Dealer> getAllDealers(){

        List<Dealer> allDealers = dao.getAll();
        if (allDealers.isEmpty()){
            throw new ResourceNotFoundException("No Dealers Found");
        }
        return allDealers;
    }

    public void addDealer(DealerRURequest request){
        if (dao.existsWithEmail(request.email())){
            throw new ResourceDuplicatedException("Email is already taken");
        }

        Dealer dealer = new Dealer(
                request.fullName(),
                request.email(),
                request.phoneNumber(),
                request.password(),
                request.address(),
                LocalDateTime.now()
        );

        dao.insert(dealer);
    }

    public void deleteDealerById(Integer id){
        if (!dao.existsWithId(id)){
            throw new ResourceNotFoundException(
                    ("Could not delete dealer with id [%s] is not found".formatted(id)));
        }

        dao.removeById(id);
    }

    public void updateDealer(Integer id, DealerRURequest request){
        Dealer dealer = getDealerById(id);
        boolean changes = false;

        if (request.fullName() != null && !request.fullName().equals(dealer.getFullName())) {
            dealer.setFullName(request.fullName());
            changes = true;
        }

        if (request.email() != null && !request.email().equals(dealer.getEmail())) {
            if (dao.existsWithEmail(request.email())){
                throw new ResourceDuplicatedException("Email is already taken");
            }
            dealer.setEmail(request.email());
            changes = true;
        }

        if (request.phoneNumber() != null && !request.phoneNumber().equals(dealer.getPhoneNumber())) {
            dealer.setPhoneNumber(request.phoneNumber());
            changes = true;
        }

        if (request.password() != null && !request.password().equals(dealer.getPassword())) {
            dealer.setPassword(request.password());
            changes = true;
        }

        if (request.address() != null && !request.address().equals(dealer.getAddress())) {
            dealer.setAddress(request.address());
            changes = true;
        }

        if(!changes){
            throw new RequestValidationException("No data changes found");
        }

        dao.update(dealer);
    }
}
