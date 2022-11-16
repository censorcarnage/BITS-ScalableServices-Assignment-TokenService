package com.bitsassignment.tokenservice.service;

import com.bitsassignment.tokenservice.model.entity.Range;
import com.bitsassignment.tokenservice.model.response.RangeResponse;
import com.bitsassignment.tokenservice.repository.RangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
@Slf4j
public class TokenService {

    @Autowired
    private RangeRepository rangeRepository;


    public synchronized RangeResponse getRangeForNode(String nodeId) {
        RangeResponse rangeResponse;
        Integer rangeId = findRangeIdAndInvalidate(nodeId);
        if(Objects.isNull(rangeId)) {
            Range newRange = getNewRange();
            rangeResponse = RangeResponse.builder().startValue(newRange.getLower()).endValue(newRange.getHigher()).nodeId(nodeId).build();
            rangeRepository.updateRangeAssignment(newRange.getRangeid(), 1,nodeId);
        } else {
            rangeRepository.invalidateRange(rangeId,1);
            Range newRange = getNewRange();
            rangeResponse = RangeResponse.builder().startValue(newRange.getLower()).endValue(newRange.getHigher()).nodeId(nodeId).build();
            rangeRepository.updateRangeAssignment(newRange.getRangeid(), 1,nodeId);
        }
        return rangeResponse;
    }

    private Range getNewRange() {
        return rangeRepository.findFirstByUsedAndExpired(0,0);
    }

    private Integer findRangeIdAndInvalidate(String nodeId) {
        Range usedRange = rangeRepository.findByNodeAndUsedAndExpired(nodeId,1,0);
        return Objects.isNull(usedRange) || Objects.isNull(usedRange.getRangeid()) ? null : usedRange.getRangeid();
    }
}
