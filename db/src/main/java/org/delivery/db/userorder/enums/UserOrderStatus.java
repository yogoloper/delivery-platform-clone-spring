package org.delivery.db.userorder.enums;

import org.hibernate.internal.build.AllowNonPortable;

//@AllowNonPortable
public enum UserOrderStatus {

    REGISTERED("등록"),

    UNREGISTERED("해지"),
    ;

    UserOrderStatus(String desciption) {
        this.desciption = desciption;
    }

    private String desciption;
}
