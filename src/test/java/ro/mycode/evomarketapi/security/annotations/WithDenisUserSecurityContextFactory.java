package ro.mycode.evomarketapi.security.annotations;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ro.mycode.evomarketapi.system.security.UserRole;
import ro.mycode.evomarketapi.user.dto.UserDTO;
import ro.mycode.evomarketapi.user.models.User;

import java.util.Arrays;
import static org.springframework.security.core.context.SecurityContextHolder.clearContext;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class WithDenisUserSecurityContextFactory implements WithSecurityContextFactory<WithDenisUser> {

    @Override
    public SecurityContext createSecurityContext(WithDenisUser withDenisUser) {
        User user=new User();
        user.setFirstName(withDenisUser.firstName());
        user.setLastName(withDenisUser.lastName());
        user.setEmail(withDenisUser.email());
        user.setPassword(withDenisUser.password());
        user.setPhoneNumber(withDenisUser.phoneNumber());
        user.setActive(true);
        user.setRegisteredAt(LocalDateTime.now());
        user.setCreatedAt(LocalDateTime.now());

        user.setUserRole(UserRole.CLIENT);

        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(
             user,withDenisUser.password(),Arrays.stream(withDenisUser.authorities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList())
        );

        clearContext();

        getContext().setAuthentication(authenticationToken);

        return getContext();


    }
}
