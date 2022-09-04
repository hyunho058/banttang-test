package com.hproject.banttang.location.controller.response;

import com.hproject.banttang.location.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LocationResponse {
    private final String address1;
    private final String address2;

    public LocationResponse(Location location) {
        this(
                location.getAddress1(),
                location.getAddress2()
        );
    }
}
