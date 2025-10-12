package org.delivery.storeadmin.domain.storemenu.converter;

import org.delivery.db.storemenu.StoreMenuEntity;
import org.delivery.storeadmin.domain.storemenu.controller.model.StoreMenuResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreMenuConverter {

    public StoreMenuResponse toResponse(StoreMenuEntity entity) {
        return StoreMenuResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .amount(entity.getAmount())
                .thumbnailUrl(entity.getThumbnailUrl())
                .likeCount(entity.getLikeCount())
                .sequence(entity.getSequence())
                .build();
    }

    public List<StoreMenuResponse> toResponse(List<StoreMenuEntity> list) {
        return list.stream()
                        .map(it -> {
                            return toResponse(it);
                        })
                        .collect(Collectors.toList());


    }
}
