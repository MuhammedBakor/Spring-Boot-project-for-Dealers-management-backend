package com.mohammad_bakur.Dealer_management_api.repositories;

import com.mohammad_bakur.Dealer_management_api.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DealerRepository extends JpaRepository<Dealer, Integer> {
    boolean existsDealerById(Integer id);
    boolean existsDealerByEmail(String email);
}
