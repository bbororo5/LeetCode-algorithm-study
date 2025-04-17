class Bank {
    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(balance.length < account1 || balance.length < account2) {
            return false;
        }

        long account1Balance = balance[account1 - 1];
        long account2Balance = balance[account2 - 1];
        if (!(withdraw(account1, money) && deposit(account2, money))) {
            balance[account1 - 1] = account1Balance;
            balance[account2 - 1] = account2Balance;
            return false;
        } else {
            return true;
        }
    }
    
    public boolean deposit(int account, long money) {
        if (account > balance.length + 1) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(balance.length < account) {
            return false;
        }

        if(balance[account - 1] < money) {
            return false;
        } else {
            balance[account - 1] -= money;
            return true;
        }
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */