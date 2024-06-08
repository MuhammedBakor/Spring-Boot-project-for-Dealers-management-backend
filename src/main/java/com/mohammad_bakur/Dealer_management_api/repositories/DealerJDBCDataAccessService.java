package com.mohammad_bakur.Dealer_management_api.repositories;

import com.mohammad_bakur.Dealer_management_api.DataAccessObject;
import com.mohammad_bakur.Dealer_management_api.Dealer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class DealerJDBCDataAccessService implements DataAccessObject<Dealer> {
    private final JdbcTemplate template;

    public DealerJDBCDataAccessService(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void insert(Dealer entity) {
        var sql = """
                INSERT INTO dealer(
                full_name,
                email, 
                phone_number,
                password,
                address,
                   registration_date) VALUES (?, ?, ?, ?, ?, ?);
                """;

        template.update(sql,
                entity.getFullName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getPassword(),
                entity.getAddress(),
                entity.getRegistrationDate());
    }

    @Override
    public void removeById(Integer id) {
        String sql = """
                DELETE
                FROM dealer
                WHERE id = ?
                """;
        int result = template.update(sql, id);
        System.out.println("delete Dealer By Id result = " + result);
    }

    @Override
    public void update(Dealer entity) {
        if(entity.getFullName() != null){
            String sql = """
                UPDATE dealer SET full_name = ? WHERE id = ?
                """;

            int result = template.update(sql, entity.getFullName(), entity.getId());

            System.out.println("update dealer full_name result = " + result);
        }

        if(entity.getEmail() != null){
            String sql = """
                UPDATE dealer SET email = ? WHERE id = ?
                """;

            int result = template.update(sql, entity.getEmail(), entity.getId());

            System.out.println("update dealer email result = " + result);
        }

        if(entity.getPhoneNumber() != null){
            String sql = """
                UPDATE dealer SET phone_number = ? WHERE id = ?
                """;

            int result = template.update(sql, entity.getPhoneNumber(), entity.getId());

            System.out.println("update dealer phone_number result = " + result);
        }

        if(entity.getPassword() != null){
            String sql = """
                UPDATE dealer SET password = ? WHERE id = ?
                """;

            int result = template.update(sql, entity.getPassword(), entity.getId());

            System.out.println("update dealer password result = " + result);
        }

        if(entity.getAddress() != null){
            String sql = """
                UPDATE dealer SET address = ? WHERE id = ?
                """;

            int result = template.update(sql, entity.getAddress(), entity.getId());

            System.out.println("update dealer address result = " + result);
        }

        if(entity.getRegistrationDate() != null){
            String sql = """
                UPDATE dealer SET registration_date = ? WHERE id = ?
                """;

            int result = template.update(sql, entity.getRegistrationDate(), entity.getId());

            System.out.println("update dealer registration_date result = " + result);
        }
    }

    @Override
    public Optional<Dealer> getById(Integer id) {

        RowMapper<Dealer> mapper = (rs, rowNum) -> {

            Dealer dealer = new Dealer(
                    rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getString("password"),
                    rs.getString("address"),
                    rs.getTimestamp("registration_date").toLocalDateTime()
            );
            return dealer;
        };


        var sql = """
                SELECT id, full_name, email, phone_number, password, address, registration_date
                FROM dealer
                WHERE id = ?""";

        return template.query(sql, mapper, id)
                .stream().findFirst();
    }

    @Override
    public List<Dealer> getAll() {

        var sql = """
                SELECT id, full_name, email, phone_number, password, address,
                registration_date FROM dealer
                """;

        RowMapper<Dealer> mapper = (rs, rowNum) -> {

            Dealer dealer = new Dealer(
                    rs.getInt("id"),
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getString("password"),
                    rs.getString("address"),
                    rs.getTimestamp("registration_date").toLocalDateTime()
            );
            return dealer;
        };

        List<Dealer> dealers = template.query(sql, mapper);
        return dealers;

    }

    @Override
    public boolean existsWithId(Integer id) {
        String sql = """
                SELECT COUNT(id)
                FROM dealer
                WHERE id = ?
                """;
        Integer count = template.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }

    @Override
    public boolean existsWithEmail(String email) {
        String sql = """
                SELECT COUNT(id)
                FROM dealer
                WHERE email = ?
                """;
        Integer count = template.queryForObject(sql, Integer.class, email);
        return count != null && count > 0;
    }
}
