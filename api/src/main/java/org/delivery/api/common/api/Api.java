package org.delivery.api.common.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.delivery.api.common.error.ErrorCodeIfs;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Api<T> {

    private Result result;

    @Valid
    private T body;

    public static <T> Api<T> OK(T data) {
        var api = new Api<T>();
        api.result = Result.OK();
        api.body = data;

        return api;
    }

    public static Api<Object> ERROR(Result result) {
        var api = new Api<Object>();
        api.result = result;

        return api;
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorcodeIfs) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorcodeIfs);

        return api;
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorcodeIfs, Throwable tx) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorcodeIfs, tx);

        return api;
    }

    public static Api<Object> ERROR(ErrorCodeIfs errorcodeIfs, String description) {
        var api = new Api<Object>();
        api.result = Result.ERROR(errorcodeIfs, description);

        return api;
    }
}
