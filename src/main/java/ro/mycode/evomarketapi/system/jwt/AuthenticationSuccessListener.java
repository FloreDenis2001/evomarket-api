package ro.mycode.evomarketapi.system.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ro.mycode.evomarketapi.system.services.LoginAttemptService;

@Component
public class AuthenticationSuccessListener {

    private LoginAttemptService loginAttemptService;
    @Autowired
    public AuthenticationSuccessListener(LoginAttemptService loginAttemptService) {
        this.loginAttemptService = loginAttemptService;
    }

    @EventListener
    public void onAuthenticationSuccess(AuthenticationSuccessEvent event) {
        Object principal = event.getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            UserDetails username = (UserDetails) event.getAuthentication().getPrincipal();
            loginAttemptService.evictUserFromLoginAttemptCache(username.getUsername());
        }
    }

}
