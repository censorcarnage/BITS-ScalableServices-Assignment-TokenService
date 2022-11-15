package com.bitsassignment.tokenservice.controller;

import com.bitsassignment.tokenservice.model.response.RangeResponse;
import com.bitsassignment.tokenservice.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/range/{nodeId}")
    private ResponseEntity<RangeResponse> generateRangeParameters(@PathVariable String nodeId) {
        log.info("Going to generate range parameters for node {}",nodeId);
        RangeResponse rangeResponse = tokenService.getRangeForNode(nodeId);
        return ResponseEntity.ok(rangeResponse);
    }
}
