package org.delivery.db.userorder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;
import org.delivery.db.store.StoreEntity;
import org.delivery.db.userorder.enums.UserOrderStatus;
import org.delivery.db.userordermenu.UserOrderMenuEntity;
import org.hibernate.internal.build.AllowNonPortable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

//@Data
//@NoArgsConstructor
//@AllowNonPortable
//@EqualsAndHashCode(callSuper = true)
//@SuperBuilder
//@Entity
//@Table(name = "user_order")
//public class UserOrderEntity extends BaseEntity {
//
//    @Column(nullable = false)
//    private Long userId;
//
//    @JoinColumn(nullable = false, name = "store_id")
//    @ManyToOne
//    private StoreEntity store;
//
//    @Enumerated(EnumType.STRING)
//    @Column(length = 50, nullable = false)
//    private UserOrderStatus status;
//
//    @Column(precision = 11, scale = 4, nullable = false)
//    private BigDecimal amount;
//
//    private LocalDateTime orderedAt;
//
//    private LocalDateTime acceptedAt;
//
//    private LocalDateTime cookingStartedAt;
//
//    private LocalDateTime deliveryStartedAt;
//
//    private LocalDateTime receivedAt;
//
//    @OneToMany(mappedBy = "userOrder")
//    @ToString.Exclude
//    @JsonIgnore
//    private List<UserOrderMenuEntity> userOrderMenuList;
//}
