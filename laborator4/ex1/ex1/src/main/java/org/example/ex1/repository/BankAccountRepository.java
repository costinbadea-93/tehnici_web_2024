package org.example.ex1.repository;

import lombok.AllArgsConstructor;
import org.example.ex1.model.BankAccount;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BankAccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<BankAccount> findAll() {
       String sql = "select * from bank_account";

       return jdbcTemplate.query(sql, (rs, rowNum) -> {
            return BankAccount
                    .builder()
                    .accountNumber(rs.getString("accountNumber"))
                    .accountOwner(rs.getString("accountOwner"))
                    .balance(rs.getDouble("balance"))
                    .currency(rs.getString("currency"))
                    .build();
        });
    }

    public BankAccount create(BankAccount bankAccount) {
        String sql =
                "Insert into bank_account(accountNumber,accountOwner,balance,currency) values(?,?,?,?)";

//        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(sql, ps -> {
            ps.setString(1, bankAccount.getAccountNumber());
            ps.setString(2, bankAccount.getAccountOwner());
            ps.setDouble(3, bankAccount.getBalance());
            ps.setString(4, bankAccount.getCurrency());
        });

//        bankAccount.setId(keyHolder.getKey().intValue());

        return bankAccount;
    }
}
