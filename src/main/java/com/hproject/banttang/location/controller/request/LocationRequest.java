package com.hproject.banttang.location.controller.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class LocationRequest {
    @NotEmpty
    private String address1;
    @NotEmpty
    private String address2;

    @Builder
    public LocationRequest(String address1, String address2) {
        this.address1 = address1;
        this.address2 = address2;
    }
}
