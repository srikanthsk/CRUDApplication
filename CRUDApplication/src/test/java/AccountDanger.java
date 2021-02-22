

public class AccountDanger implements  Runnable{
    private Account account = new Account();

    public static void main(String[] args) {
        AccountDanger r = new AccountDanger();
        Thread one = new Thread(r,"lucy");
        Thread two = new Thread(r,"deep");
        one.start();
        two.start();
    }

    @Override
    public void run() {
        for (int i=0;i <2;i++){
            makeWithDrawl(25);
            if(account.getBalance() < 0){
                System.out.println("account is overdrawn " + account.getBalance());
            }
        }
    }

    private synchronized void makeWithDrawl(int amt){
        if(account.getBalance() >= amt){
            System.out.println(Thread.currentThread().getName() + " is going to withdraw ");
            try{
                Thread.sleep(500);
            }catch (Exception e){}
            int balance = account.withdraw(amt);
            System.out.println(Thread.currentThread().getName() + " completes the withdraw " +balance );
        }else {
            System.out.println("Not enough balance  in account for " + Thread.currentThread().getName() + " to withdraw");
        }
    }

    static class Account{
      private int balance=50;

      public int getBalance() {
         return balance;
      }

      public int withdraw(int amt){
         balance = balance - amt;
         return balance;
      }
    }
}


