package ro.mycode.evomarketapi.user.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.system.security.UserRole;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Table(name = "users")
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Data
public class User implements UserDetails {


    @Id

    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")

    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 3, max = 50, message = "Last name must be between 3 and 50 characters")
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "^[0-9]*$", message = "Phone number must contain only digits")
    @Size(min = 10, max = 10, message = "Phone number must be 10 characters")
    private String phoneNumber;

    @Email(message = "Email should be valid")
    @Column(name = "email", nullable = false)
    @Size(min = 3, max = 50, message = "Email must be between 3 and 50 characters")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;



    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;


    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;



    @Column(name = "active", nullable = false)
    private boolean active;


    public void setPassword(String password) {
        this.password =new BCryptPasswordEncoder().encode(password);
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.TRUE)
    @JsonManagedReference
    @Builder.Default
    private Set<Order> orderSet = new HashSet<>();

    public void addOrder(Order order) {
        orderSet.add(order);
        order.setUser(this);
    }

    @Override
    public String toString() {

        String text = "First Name : " + this.firstName + "\n";
        text += "Last Name : " + this.lastName + "\n";
        text += "Phone Number : " + this.phoneNumber + "\n";
        text += "Email : " + this.email + "\n";
        text += "Role : " + this.userRole + "\n";
        text += "Active : " + this.active + "\n";
        text += "Registered At : " + this.registeredAt + "\n";


        return text;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRole.getGrantedAuthorities();
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
