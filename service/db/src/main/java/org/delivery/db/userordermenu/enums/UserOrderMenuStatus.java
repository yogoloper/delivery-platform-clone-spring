package org.delivery.db.userordermenu.enums;

public enum UserOrderMenuStatus {

    REGISTERTED("등록"),

    UNREGISTERTED("해지"),
    ;

    UserOrderMenuStatus(String description) {
        this.description = description;
    }

    private String description;
}
