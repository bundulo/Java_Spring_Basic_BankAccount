package bundulo.spring5webapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
 public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int accountNumber;
    private double balance;
    private String accountName;
    @ManyToMany(mappedBy = "account")
    private Set<Customer> customer;

    public Account(Integer id, int accountNumber, double balance, String accountName, Set<Customer> customer) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountName = accountName;
        this.customer = customer;
    }

    public Account(){
    }

    public void depositFunds(double amount){
        if (amount <= 0){
            System.out.println("You can't deposit lesser amount than 1 HUF");
        }
        if (amount > 0){
            this.balance += amount;
            System.out.println("You successfully added " + amount + " HUF to your balance \n Your current Balance is " + balance + " HUF");

        }
    }

    public void withdrawFunds(double amount){
        if (amount <= 0){
            System.out.println("You can't withdraw lesser amount than 1 HUF");
        }
        if (balance < amount){
            System.out.println("lack of coverage \n Your current balance: " + balance);
        }
        if (amount > 0 && balance > amount){
            this.balance -= amount;
            System.out.println("You successfully withdraw " + amount + " HUF to your balance \n Your current Balance is " + balance + " HUF");
        }
    }
}

