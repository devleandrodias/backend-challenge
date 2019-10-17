package com.challenge.orderservice.resources.v1.controllers;

import com.challenge.orderservice.business.OrderBusiness;
import com.challenge.orderservice.resources.mapper.OrderMapper;
import com.challenge.orderservice.resources.v1.dtos.OrderRequestDto;
import com.challenge.orderservice.resources.v1.dtos.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/challenge/v1/orders")
public class OrderController {

    @Autowired
    private OrderBusiness orderBusiness;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Optional<OrderResponseDto>> create(@RequestBody @Valid final OrderRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderMapper
                        .serializeToDto(orderBusiness
                                .create(orderMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Optional<List<OrderResponseDto>>> read() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderMapper
                        .serializeListToDto(orderBusiness.read()));
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Optional<OrderResponseDto>> update(@PathVariable final Integer id, @RequestBody @Valid final OrderRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderMapper
                        .serializeToDto(orderBusiness
                                .update(orderMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        orderBusiness.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Optional<OrderResponseDto>> findById(@PathVariable final Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderMapper
                        .serializeToDto(orderBusiness.findById(id)));
    }
}
