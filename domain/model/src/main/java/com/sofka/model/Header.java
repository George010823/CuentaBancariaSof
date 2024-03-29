package com.sofka.model;

import lombok.Builder;

import java.io.FileFilter;
@Builder(toBuilder = true)
public class Header {
    private String authorization;
    private String accept;
    private String contentType;
    private String idempotencyKey;

    public Header() {
    }

    public Header(String authorization, String accept, String contentType, String idempotencyKey) {
        this.authorization = authorization;
        this.accept = accept;
        this.contentType = contentType;
        this.idempotencyKey = idempotencyKey;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    @Override
    public String toString() {
        return "Header{" +
                "authorization='" + authorization + '\'' +
                ", accept='" + accept + '\'' +
                ", contentType='" + contentType + '\'' +
                ", idempotencyKey='" + idempotencyKey + '\'' +
                '}';
    }
}
