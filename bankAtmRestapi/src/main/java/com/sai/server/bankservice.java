package com.sai.server;

import com.sai.model.bankapplication;

public interface bankservice {

    public bankapplication banksave(bankapplication Bankapplication);

	public bankapplication balance(long account, String name, String password);

	public bankapplication withdraw(long account, String name, String password, double amount);

	public bankapplication deposite(long account, String name, String password, double amount);

	bankapplication transfer(long account, String name, String password, int targetAccount, double amount);
}
