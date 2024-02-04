package com.sai.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.model.bankapplication;
import com.sai.repo.bankRepo;

@Service
public class bankserviceimp implements bankservice {

    @Autowired
    private bankRepo repo;

    @Override
    public bankapplication banksave(bankapplication Bankapplication) {
        return repo.save(Bankapplication);
    }

    @Override
    public bankapplication balance(long account, String name, String password) {
        return repo.findByAccountAndNameAndPassword(account, name, password);
    }
    @Override
    public bankapplication withdraw(long account, String name, String password, double amount) {
        bankapplication bank = repo.findByAccountAndNameAndPassword(account, name, password);
        
        if (bank != null && bank.getAmount() >= amount) {
            double newAmount = bank.getAmount() - amount;
            bank.setAmount(newAmount);
            repo.save(bank);
            return bank;
        }
        
        return null; // Return null if withdrawal is not successful
    }
    
    @Override
    public bankapplication deposite(long account, String name, String password, double amount) {
        bankapplication bank = repo.findByAccountAndNameAndPassword(account, name, password);
        
        if (bank != null && bank.getAmount() >= amount) {
            double newAmount = bank.getAmount() + amount;
            bank.setAmount(newAmount);
            repo.save(bank);
            return bank;
        }
        
        return null; // Return null if deposit is not successful    
 

    }
    
    
    @Override
    public bankapplication transfer(long account, String name, String password, int targetAccount, double amount) {
        bankapplication sourceAccount = repo.findByAccountAndNameAndPassword(account, name, password);
        bankapplication targetAccounts = repo.findByAccount(targetAccount);

        if (sourceAccount != null && targetAccounts != null &&
                name.equals(sourceAccount.getName()) && password.equals(sourceAccount.getPassword())) {

            // Check if there's enough balance in the source account to transfer
            if (sourceAccount.getAmount() >= amount) {
                double newSourceAmount = sourceAccount.getAmount() - amount;
                double newTargetAmount = targetAccounts.getAmount() + amount;

                sourceAccount.setAmount(newSourceAmount);
                targetAccounts.setAmount(newTargetAmount);

                repo.save(sourceAccount);
                repo.save(targetAccounts);

                return sourceAccount;
            }
        }

        return null;
    }

}
