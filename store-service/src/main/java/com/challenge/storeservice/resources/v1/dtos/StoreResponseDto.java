package com.challenge.storeservice.resources.v1.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StoreResponseDto {
    private Integer id;
    private String name;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date createdAt;
}
