package ro.mycode.evomarketapi.system.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static ro.mycode.evomarketapi.system.security.UserPermisson.*;

@AllArgsConstructor
public enum UserRole {
    ADMIN(Sets.newHashSet(PRODUCT_ADD, PRODUCT_REMOVE, PRODUCT_UPDATE, PRODUCT_READ, ORDER_ADD, ORDER_REMOVE, ORDER_UPDATE, ORDER_READ, ORDERDETAILS_ADD, ORDERDETAILS_REMOVE, ORDERDETAILS_UPDATE, ORDERDETAILS_READ, USER_READ, USER_WRITE)),
    CLIENT(Sets.newHashSet(PRODUCT_READ, ORDER_READ, ORDERDETAILS_READ));

    private final Set<UserPermisson> permission;

    public Set<UserPermisson> getPermission() {
        return permission;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermission().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
