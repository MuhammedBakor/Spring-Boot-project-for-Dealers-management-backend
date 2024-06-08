package com.mohammad_bakur.Dealer_management_api.repositories;

import com.mohammad_bakur.Dealer_management_api.DataAccessObject;
import com.mohammad_bakur.Dealer_management_api.Dealer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa")
public class DealerDataAccessService implements DataAccessObject<Dealer> {
    private final DealerRepository repository;

    public DealerDataAccessService(DealerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(Dealer entity) {
        repository.save(entity);
    }

    @Override
    public void removeById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Dealer entity) {
        repository.save(entity);
    }

    @Override
    public Optional<Dealer> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Dealer> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean existsWithId(Integer id) {
        return repository.existsDealerById(id);
    }

    @Override
    public boolean existsWithEmail(String email) {
        return repository.existsDealerByEmail(email);
    }
}
