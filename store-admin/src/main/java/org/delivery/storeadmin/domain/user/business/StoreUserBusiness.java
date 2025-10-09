package org.delivery.storeadmin.domain.user.business;

import lombok.RequiredArgsConstructor;
import org.delivery.db.store.StoreRepository;
import org.delivery.db.store.enums.StoreStatus;
import org.delivery.storeadmin.common.annotation.Business;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserRegisterRequest;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserResponse;
import org.delivery.storeadmin.domain.user.converter.StoreUserConverter;
import org.delivery.storeadmin.domain.user.service.StoreUserService;

@RequiredArgsConstructor
@Business
public class StoreUserBusiness {

    private final StoreUserConverter storeUserConverter;

    private final StoreUserService storeUserService;

    private final StoreRepository storeRepository; // TODO service로 변경하기

    public StoreUserResponse register(
            StoreUserRegisterRequest request
    ) {
        var storeEntity = storeRepository.findFirstByNameAndStatusOrderByIdDesc(request.getStoreName(), StoreStatus.REGISTERED);

        var entity = storeUserConverter.toEntity(request, storeEntity.get());

        var newStoreUserEntity = storeUserService.register(entity);

        var response = storeUserConverter.toResponse(newStoreUserEntity, storeEntity.get());

        return response;
    }
}
