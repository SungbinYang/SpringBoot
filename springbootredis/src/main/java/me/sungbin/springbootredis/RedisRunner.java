package me.sungbin.springbootredis;

import me.sungbin.springbootredis.account.Account;
import me.sungbin.springbootredis.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("sungbin", "robert");
        values.set("springboot", "2.6");
        values.set("hello", "world");

        Account account = new Account();
        account.setEmail("robert@email.com");
        account.setUsername("sungbin");

        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        System.out.println(byId.get().getEmail());
        System.out.println(byId.get().getUsername());
    }
}
