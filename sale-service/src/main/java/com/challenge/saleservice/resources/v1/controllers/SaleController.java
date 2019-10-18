package com.challenge.saleservice.resources.v1.controllers;

import com.challenge.saleservice.business.SaleBusiness;
import com.challenge.saleservice.resources.mapper.SaleMapper;
import com.challenge.saleservice.resources.v1.dtos.SaleRequestDto;
import com.challenge.saleservice.resources.v1.dtos.SaleResponseDto;
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
@RequestMapping("/challenge/v1/sales")
@Api("Restful CRUD for manipulating sales.")
public class SaleController {

    @Autowired
    private SaleBusiness saleBusiness;

    @Autowired
    private SaleMapper saleMapper;

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "Create Sale", response = SaleResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<SaleResponseDto>> create(@RequestBody @Valid final SaleRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saleMapper
                        .serializeToDto(saleBusiness
                                .create(saleMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Get All Sales", response = SaleResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<List<SaleResponseDto>>> read() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(saleMapper
                        .serializeListToDto(saleBusiness.read()));
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Update Sale", response = SaleResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<SaleResponseDto>> update(@PathVariable final Integer id, @RequestBody @Valid final SaleRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(saleMapper
                        .serializeToDto(saleBusiness
                                .update(saleMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Delete Sale By ID", response = SaleResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        saleBusiness.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Get Sale By ID", response = SaleResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<SaleResponseDto>> findById(@PathVariable final Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(saleMapper
                        .serializeToDto(saleBusiness.findById(id)));
    }
}
