package ro.mycode.evomarketapi.system.security;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserPermisson {

    PRODUCT_ADD("product:add"),


    PRODUCT_REMOVE("product:remove"),

    PRODUCT_UPDATE("order:update"),

    PRODUCT_READ("product:read"),

    ORDER_ADD("order:add"),

    ORDER_REMOVE("order:remove"),

    ORDER_UPDATE("order:update"),

    ORDER_READ("order:read"),

    ORDERDETAILS_ADD("orderdetails:add"),

    ORDERDETAILS_REMOVE("orderdetails:remove"),

    ORDERDETAILS_UPDATE("orderdetails:update"),

    ORDERDETAILS_READ("orderdetails:read"),


    USER_READ("user:read"),

    USER_WRITE("user:write");


    private final String permission;

    public String getPermission() {
        return permission;
    }
}
