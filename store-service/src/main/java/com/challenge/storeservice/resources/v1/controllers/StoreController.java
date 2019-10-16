package com.challenge.storeservice.resources.v1.controllers;

import com.challenge.storeservice.business.StoreBusiness;
import com.challenge.storeservice.resources.mapper.StoreMapper;
import com.challenge.storeservice.resources.v1.dtos.StoreRequestDto;
import com.challenge.storeservice.resources.v1.dtos.StoreResponseDto;
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
@RequestMapping("/challenge/v1/stores")
public class StoreController {

    @Autowired
    private StoreBusiness storeBusiness;

    @Autowired
    private StoreMapper storeMapper;

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "Create Store", response = StoreResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 409, message = "Conflict"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<StoreResponseDto>> create(@RequestBody @Valid final StoreRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(storeMapper
                        .serializeToDto(storeBusiness
                                .create(storeMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "Get All Stores", response = StoreResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<List<StoreResponseDto>>> read() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(storeMapper
                        .serializeListToDto(storeBusiness.read()));
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Update Store", response = StoreResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<StoreResponseDto>> update(@PathVariable final Integer id, @RequestBody @Valid final StoreRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(storeMapper
                        .serializeToDto(storeBusiness
                                .update(storeMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Delete Store By ID", response = StoreResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        storeBusiness.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Get Store By ID", response = StoreResponseDto.class, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Optional<StoreResponseDto>> findById(@PathVariable final Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(storeMapper
                        .serializeToDto(storeBusiness.findById(id)));
    }
}
