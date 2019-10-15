package com.challenge.storeservice.resources.v1.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StoreRequestDto {
    private Integer id;
    private String name;
    private Date createdAt;
}
