package org.delivery.common.api

import org.delivery.common.error.ErrorCode
import org.delivery.common.error.ErrorCodeIfs

data class Result(
    val resultCode: Int ?= null,
    val resultMessage: String ?= null,
    val resultDescription: String ?= null,
) {
    companion object { // static 함수와 동일하게 동작
        @JvmStatic
        fun OK(): Result {
            return Result(
                resultCode = ErrorCode.OK.getErrorCode(),
                resultMessage = ErrorCode.OK.getDescription(),
                resultDescription = "성공"
            )
        }

        @JvmStatic
        fun ERROR(errorCodeIfs: ErrorCodeIfs): Result {
            return Result(
                resultCode = errorCodeIfs.getErrorCode(),
                resultMessage = errorCodeIfs.getDescription(),
                resultDescription = "에러 발생"
            )
        }

        @JvmStatic
        fun ERROR(errorCodeIfs: ErrorCodeIfs, tx: Throwable): Result {
            return Result(
                resultCode = errorCodeIfs.getErrorCode(),
                resultMessage = errorCodeIfs.getDescription(),
                resultDescription = tx.localizedMessage
            )
        }

        @JvmStatic
        fun ERROR(errorCodeIfs: ErrorCodeIfs, description: String): Result {
            return Result(
                resultCode = errorCodeIfs.getErrorCode(),
                resultMessage = errorCodeIfs.getDescription(),
                resultDescription = description
            )
        }
    }
}