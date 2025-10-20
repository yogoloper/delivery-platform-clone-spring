package org.delivery.api.domain.userorder.controller.model

import org.delivery.api.domain.store.controller.model.StoreResponse
import org.delivery.api.domain.storemenu.controller.model.StoreMenuResponse

class UserOrderDetailResponse (
    var userOrderResponse: UserOrderResponse? = null,
    var storeResponse: StoreResponse? = null,
    var storeMenuResponseList: MutableList<StoreMenuResponse>? = null,
)
