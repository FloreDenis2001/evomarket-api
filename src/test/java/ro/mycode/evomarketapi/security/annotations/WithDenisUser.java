package ro.mycode.evomarketapi.security.annotations;


import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.*;
import java.time.LocalDateTime;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@WithSecurityContext(factory = WithDenisUserSecurityContextFactory.class)
public @interface WithDenisUser {

    String lastName() default "Flore";
    String firstName() default "Denis";
    String email() default "floredenis907@yahoo.com";
    String password() default "parola";
    String phoneNumber() default "0773941000";
    String[] authorities() default {"ROLE_CLIENT"};

}
