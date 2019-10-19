package com.challenge.paymentservice.resources.v1.controllers;

import com.challenge.paymentservice.business.PaymentBusiness;
import com.challenge.paymentservice.resources.mapper.PaymentMapper;
import com.challenge.paymentservice.resources.v1.dtos.PaymentRequestDto;
import com.challenge.paymentservice.resources.v1.dtos.PaymentResponseDto;
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
@RequestMapping("/challenge/v1/payments")
@Api("Restful CRUD for manipulating payments.")
public class PaymentController {

    @Autowired
    private PaymentBusiness paymentBusiness;

    @Autowired
    private PaymentMapper paymentMapper;

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "Create Payment", response = PaymentResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<PaymentResponseDto>> create(@RequestBody @Valid final PaymentRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentMapper
                        .serializeToDto(paymentBusiness
                                .create(paymentMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Get All Payments", response = PaymentResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<List<PaymentResponseDto>>> read() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paymentMapper
                        .serializeListToDto(paymentBusiness.read()));
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Update Payment", response = PaymentResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<PaymentResponseDto>> update(@PathVariable final Integer id, @RequestBody @Valid final PaymentRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(paymentMapper
                        .serializeToDto(paymentBusiness
                                .update(paymentMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Delete Payment By ID", response = PaymentResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        paymentBusiness.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Get Payment By ID", response = PaymentResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<PaymentResponseDto>> findById(@PathVariable final Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(paymentMapper
                        .serializeToDto(paymentBusiness.findById(id)));
    }
}
