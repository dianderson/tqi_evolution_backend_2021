package br.com.tqi.evolution_test.repository.model;

import br.com.tqi.evolution_test.resource.dto.request.CustomerRequest;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Customer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    @CPF
    @NotBlank
    @Column(unique = true)
    private String cpf;
    @NotBlank
    @Column(unique = true)
    private String rg;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
    @NotNull
    private Double income;
    @NotBlank
    private String password;
    @NotNull
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Role> roles;

    public static Customer of(CustomerRequest customerRequest) {
        var customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        customer.setCpf(customerRequest.getCpf());
        customer.setRg(customerRequest.getRg());
        customer.setAddress(Address.of(customerRequest.getAddress()));
        customer.setIncome(customerRequest.getIncome());
        customer.setPassword(new BCryptPasswordEncoder().encode(customerRequest.getPassword()));
        customer.setRoles(Role.of(customerRequest.getRoleName()));
        return customer;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
