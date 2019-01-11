package com.lordblack.SuperBank.ModelClasses;


public class Transactions
{
    String date;
    int credit,debit,finalAmount;

    public Transactions() {
    }

    public Transactions(String date, int credit, int debit, int finalAmount) {
        this.date = date;
        this.credit = credit;
        this.debit = debit;
        this.finalAmount = finalAmount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public void setFinalAmount(int finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getDate() {
        return date;
    }

    public int getCredit() {
        return credit;
    }

    public int getDebit() {
        return debit;
    }

    public int getFinalAmount() {
        return finalAmount;
    }
}
