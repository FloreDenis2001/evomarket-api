package ro.mycode.evomarketapi.system.security;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserPermisson {

    PRODUCT_READ("product:read"),
    PRODUCT_WRITE("product:write"),
    ORDER_READ("order:read"),

    ORDER_WRITE("order:write"),

    USER_READ("user:read"),

    USER_WRITE("user:write"),
    ;


    private final String permission;

    public String getPermission() {
        return permission;
    }
}
