package com.challenge.orderservice.resources.v1.controllers;

import com.challenge.orderservice.business.OrderBusiness;
import com.challenge.orderservice.resources.mapper.OrderMapper;
import com.challenge.orderservice.resources.v1.dtos.OrderRequestDto;
import com.challenge.orderservice.resources.v1.dtos.OrderResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/challenge/v1/orders")
@Api("Restful CRUD for manipulating orders.")
public class OrderController {

    @Autowired
    private OrderBusiness orderBusiness;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "Create Order", response = OrderResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<OrderResponseDto>> create(@RequestBody @Valid final OrderRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderMapper
                        .serializeToDto(orderBusiness
                                .create(orderMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Get All Orders", response = OrderResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<List<OrderResponseDto>>> read() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderMapper
                        .serializeListToDto(orderBusiness.read()));
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Update Order", response = OrderResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<OrderResponseDto>> update(@PathVariable final Integer id, @RequestBody @Valid final OrderRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderMapper
                        .serializeToDto(orderBusiness
                                .update(orderMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Delete Order By ID", response = OrderResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        orderBusiness.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Get Order By ID", response = OrderResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<OrderResponseDto>> findById(@PathVariable final Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(orderMapper
                        .serializeToDto(orderBusiness.findById(id)));
    }
}
