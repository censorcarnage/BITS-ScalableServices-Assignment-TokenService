package com.bitsassignment.tokenservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "range_central")
public class Range {

    @Id
    private Integer rangeid;

    private Long lower;

    private Long higher;

    private String node;

    private LocalDateTime created;

    private Integer expired;

    private Integer used;
}
