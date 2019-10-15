package com.challenge.storeservice.resources.v1.controllers;

import com.challenge.storeservice.business.StoreBusiness;
import com.challenge.storeservice.resources.mapper.StoreMapper;
import com.challenge.storeservice.resources.v1.dtos.StoreRequestDto;
import com.challenge.storeservice.resources.v1.dtos.StoreResponseDto;
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
    public ResponseEntity<Optional<StoreResponseDto>> create(@RequestBody @Valid final StoreRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(storeMapper
                        .serializeToDto(storeBusiness
                                .create(storeMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Optional<List<StoreResponseDto>>> read(@PathVariable final Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(storeMapper
                        .serializeListToDto(storeBusiness.read()));
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Optional<StoreResponseDto>> update(@RequestBody @Valid final StoreRequestDto saleRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(storeMapper
                        .serializeToDto(storeBusiness
                                .update(storeMapper
                                        .serializeToModel(Optional.of(saleRequestDto)).get())));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        storeBusiness.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Optional<StoreResponseDto>> findById(@PathVariable final Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(storeMapper
                        .serializeToDto(storeBusiness.findById(id)));
    }
}
