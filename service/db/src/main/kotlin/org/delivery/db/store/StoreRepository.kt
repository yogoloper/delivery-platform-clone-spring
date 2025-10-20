package org.delivery.db.store

import org.delivery.db.store.enums.StoreCategory
import org.delivery.db.store.enums.StoreStatus
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StoreRepository : JpaRepository<StoreEntity, Long> {
    // 유효한 스토어
    fun findFirstByIdAndStatusOrderByIdDesc(id: Long?, status: StoreStatus?): StoreEntity?

    // 유요한 스토어 리스트
    fun findAllByStatusOrderByIdDesc(status: StoreStatus?): MutableList<StoreEntity>

    // 유요한 특정 카테고리의 스토어 리스트
    fun findAllByStatusAndCategoryOrderByStarDesc(
        status: StoreStatus?,
        category: StoreCategory?
    ): MutableList<StoreEntity>

    fun findFirstByNameAndStatusOrderByIdDesc(name: String?, status: StoreStatus?): StoreEntity?
}
