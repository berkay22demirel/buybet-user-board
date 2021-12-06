package com.berkay22demirel.buybetuserboard.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AuthorityRole implements BasicEnum<String> {

    USER("Role_user"),
    ADMIN("Role_admin");

    private String value;

    AuthorityRole(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    public static List<String> getValues() {
        return Arrays.stream(AuthorityRole.values())
                .map(AuthorityRole::getValue)
                .collect(Collectors.toList());
    }

}
