package me.sungbin.springbootjpa.account;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    @DisplayName("의존성 테스트")
    void di() {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("repository test")
    void repoTest() {
        Account account = new Account();
        account.setUsername("sungbin");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);

        assertNotNull(newAccount);

        Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
        assertNotNull(existingAccount);

        Optional<Account> nonExistingAccount = accountRepository.findByUsername("robert");
        assertTrue(nonExistingAccount.isEmpty());
    }
}