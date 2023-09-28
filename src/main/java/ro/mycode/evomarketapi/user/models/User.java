package ro.mycode.evomarketapi.user.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Table(name = "user")
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class User {

    @Id

    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")

    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @Size(min = 3, max = 50, message = "First name must be between 3 and 50 characters")
    private String first_name;

    @Column(name = "last_name", nullable = false)
    @Size(min = 3, max = 50, message = "Last name must be between 3 and 50 characters")
    private String last_name;

    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "^[0-9]*$", message = "Phone number must contain only digits")
    @Size(min = 10, max = 10, message = "Phone number must be 10 characters")
    private String phone_number;
    @Email(message = "Email should be valid")
    @Column(name = "email", nullable = false)
    @Size(min = 3, max = 50, message = "Email must be between 3 and 50 characters")
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 3, max = 50, message = "Password must be between 3 and 50 characters")
    private String password;

    @Column(name = "role", nullable = false)
    @Size(min = 3, max = 50, message = "Role must be between 3 and 50 characters")
    private String role;


    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registered_at;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Override
    public String toString() {

        String text = "First Name : " + this.first_name + "\n";
        text += "Last Name : " + this.last_name + "\n";
        text += "Phone Number : " + this.phone_number + "\n";
        text += "Email : " + this.email + "\n";
        text += "Role : " + this.role + "\n";
        text += "Active : " + this.active + "\n";
        text += "Registered At : " + this.registered_at + "\n";
        text += "Created At : " + this.created_at + "\n";

        return text;

    }

}
