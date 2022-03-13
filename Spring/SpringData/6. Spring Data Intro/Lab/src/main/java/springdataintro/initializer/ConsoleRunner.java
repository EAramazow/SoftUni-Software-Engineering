package springdataintro.initializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springdataintro.entity.Account;
import springdataintro.entity.User;
import springdataintro.exception.InvalidAccountOperationException;
import springdataintro.exception.NonExistingEntityException;
import springdataintro.service.AccountService;
import springdataintro.service.UserService;

import java.math.BigDecimal;

@Component
@Slf4j
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Ivan Petrov", 42);
        Account account1 = new Account(new BigDecimal(3500));

        user1 = userService.register(user1);
        account1 = accountService.createUserAccount(user1, account1);

        try {
            accountService.withdrawMoney(new BigDecimal(2000), account1.getId());
            accountService.depositMoney(new BigDecimal(200), account1.getId());
            accountService.getAllAccount().forEach(System.out::println);
        } catch (NonExistingEntityException | InvalidAccountOperationException ex) {
            log.error(String.format("Error executing operation for account: %s: %s ", account1, ex.getMessage()));
        }

        User user2 = new User("Ivan Petrov", 25);
        Account account2 = new Account(new BigDecimal(23000));

        user2 = userService.register(user2);
        account2 = accountService.createUserAccount(user2, account2);

        try {
            accountService.transferMoney(new BigDecimal(1000), account1.getId(), account2.getId());
            accountService.getAllAccount().forEach(System.out::println);
        } catch (NonExistingEntityException | InvalidAccountOperationException ex) {
            log.error(String.format("Error executing operation for account: %s: %s ", account1, ex.getMessage()));
        }

    }
}
