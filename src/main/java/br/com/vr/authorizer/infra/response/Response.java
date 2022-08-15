package br.com.vr.authorizer.infra.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Response<T> {

    private T data;
    private HashMap meta;
    private List<String> errors;

    public Response() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HashMap getMeta() {
        return meta;
    }

    public void setMeta(HashMap meta) {
        this.meta = meta;
    }

    public List<String> getErrors() {
        if (this.errors == null) {
            this.errors = new ArrayList<String>();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

}
