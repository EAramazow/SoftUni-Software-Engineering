package springdataintro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataintro.dataAccessObject.AccountRepository;
import springdataintro.entity.Account;
import springdataintro.entity.User;
import springdataintro.exception.InvalidAccountOperationException;
import springdataintro.exception.NonExistingEntityException;
import springdataintro.service.AccountService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepo;

    @Autowired
    public void setAccountRepo(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Account createUserAccount(User user, Account account) {
        account.setId(null);
        account.setUser(user);
        user.getAccounts().add(account);
        return accountRepo.save(account);
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long accountId) {
        Account account = accountRepo.findById(accountId).orElseThrow(() ->
                new NonExistingEntityException(
                        String.format("Entity with ID: %s does not exist.", accountId)));

        if (account.getBalance().compareTo(amount) < 0) {
            throw new InvalidAccountOperationException(
                    String.format("Account ID: %s balance (%s) is less than required withdraw amount: %s",
                            accountId, account.getBalance(), amount));
        }

        account.setBalance(account.getBalance().subtract(amount));
    }    // here -> commit transaction @Transactional

    @Override
    public void depositMoney(BigDecimal amount, Long accountId) {
        Account account = accountRepo.findById(accountId).orElseThrow(() ->
                new NonExistingEntityException(
                        String.format("Entity with ID: %s does not exist.", accountId)));

        account.setBalance(account.getBalance().add(amount));

    }

    @Override
    public void transferMoney(BigDecimal amount, Long fromAccountId, Long toAccountId) {

        depositMoney(amount, toAccountId);
        withdrawMoney(amount, fromAccountId);
    } // here -> commit transaction

    @Override
    public List<Account> getAllAccount() {
        return accountRepo.findAll();
    }
}
