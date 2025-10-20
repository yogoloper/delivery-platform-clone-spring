package org.delivery.db.userorder

import org.delivery.db.userorder.enums.UserOrderStatus
import org.springframework.data.jpa.repository.JpaRepository

interface UserOrderRepository : JpaRepository<UserOrderEntity?, Long?> {
    // 즉정 유저의 모든 주문
    fun findAllByUserIdAndStatusOrderByIdDesc(userId: Long?, status: UserOrderStatus?): MutableList<UserOrderEntity>

    fun findAllByUserIdAndStatusInOrderByIdDesc(
        userId: Long?,
        status: MutableList<UserOrderStatus>?
    ): MutableList<UserOrderEntity>

    // 특정 주문
    fun findFirstByIdAndStatusAndUserId(id: Long?, status: UserOrderStatus?, userId: Long?): UserOrderEntity?

    fun findFirstByIdAndUserId(id: Long?, userId: Long?): UserOrderEntity?
}
