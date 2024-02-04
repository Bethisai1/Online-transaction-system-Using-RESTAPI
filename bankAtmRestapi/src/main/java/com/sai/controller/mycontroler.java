package com.sai.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sai.model.bankapplication;
import com.sai.server.bankservice;



@RestController
public class mycontroler {

    @Autowired
    private bankservice bank;

    @PostMapping("/save")
    public String banksave(@RequestBody bankapplication Bankapplication) {
        bankapplication sa = bank.banksave(Bankapplication);
        String message = null;
        if (sa != null) {
            message = "data saved successfully";
        } else {
            message = "data not successful";
        }
        return message;
    }

    @GetMapping("/balance")
    public bankapplication balance(@RequestParam long account, @RequestParam String name, @RequestParam String password) {
        bankapplication authenticatedUser = bank.balance(account, name, password);
        	String message = null;
        if (authenticatedUser != null) {
            // You can return the authenticated user details or any other relevant information
            message = "User authenticated successfully";
        } else {
            // You might want to return an HTTP status code indicating authentication failure
            message ="Authentication failed";
        }
		return authenticatedUser;
    }
    
    @GetMapping("/withdraw")
    public String withdraw(@RequestParam long account, @RequestParam String name, @RequestParam String password, @RequestParam double amount) {
        bankapplication result = bank.withdraw(account, name, password, amount);
        return result != null ? "Withdrawal successful. New balance: " + result.getAmount() : "Withdrawal failed";
    }
    
    @GetMapping("/deposite")
    public String deposite(@RequestParam long account, @RequestParam String name, @RequestParam String password, @RequestParam double amount) {
        bankapplication result = bank.deposite(account, name, password, amount);
        return result != null ? "deposite successful. New balance: " + result.getAmount() : "deposite failed";
    }
    
   
    
    @GetMapping("/trans")
    public String transferAmount(@RequestParam long account, @RequestParam String name, @RequestParam String password,
                                 @RequestParam int targetAccount, @RequestParam double amount) {
        bankapplication result = bank.transfer(account, name, password, targetAccount, amount);
        return result != null ? "Transfer successful. New balance: " + result.getAmount() : "Transfer failed";
    }
}
