package com.freelancex.biddingservice.dtos.common;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Response {

    private String message;

    private int statusCode;
}
