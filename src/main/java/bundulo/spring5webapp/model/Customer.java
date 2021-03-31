package bundulo.spring5webapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String customerName;
    private String email;
    private String phoneNumber;
    @ManyToMany
    @JoinTable(name = "account_customer", joinColumns = @JoinColumn(name = "customer_id"),
    inverseJoinColumns = @JoinColumn(name = "account_id"))
    private Set<Account> account;

    public Customer(String customerName, String email, String phoneNumber, Set<Account> account) {
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public Customer(){}

}
