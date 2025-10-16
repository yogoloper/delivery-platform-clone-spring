package org.delivery.api.common.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delibery.common.error.ErrorCode;
import org.delibery.common.error.ErrorCodeIfs;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {

    private Integer resultCode;

    private String resultMessage;

    private String resultDescription;

    public static Result OK() {
        return Result.builder()
                .resultCode(ErrorCode.OK.getErrorCode())
                .resultMessage(ErrorCode.OK.getDescription())
                .resultDescription("성공")
                .build();
    }

    public static Result ERROR(ErrorCodeIfs errorcodeIfs) {
        return Result.builder()
                .resultCode(errorcodeIfs.getErrorCode())
                .resultMessage(errorcodeIfs.getDescription())
                .resultDescription("에러 발생")
                .build();
    }

    public static Result ERROR(ErrorCodeIfs errorcodeIfs, Throwable tx) {
        return Result.builder()
                .resultCode(errorcodeIfs.getErrorCode())
                .resultMessage(errorcodeIfs.getDescription())
                .resultDescription(tx.getLocalizedMessage())
                .build();
    }

    public static Result ERROR(ErrorCodeIfs errorcodeIfs, String description) {
        return Result.builder()
                .resultCode(errorcodeIfs.getErrorCode())
                .resultMessage(errorcodeIfs.getDescription())
                .resultDescription(description)
                .build();
    }
}
