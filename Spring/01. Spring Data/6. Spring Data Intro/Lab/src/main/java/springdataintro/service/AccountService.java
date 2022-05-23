package springdataintro.service;

import springdataintro.entity.Account;
import springdataintro.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    Account createUserAccount(User user, Account account);
    void withdrawMoney(BigDecimal amount, Long accountId);
    void depositMoney(BigDecimal amount,Long accountId);
    void transferMoney(BigDecimal amount, Long fromAccountId, Long toAccountId);
    List<Account> getAllAccount();
}
