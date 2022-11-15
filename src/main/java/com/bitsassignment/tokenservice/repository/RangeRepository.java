package com.bitsassignment.tokenservice.repository;

import com.bitsassignment.tokenservice.model.entity.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface RangeRepository extends JpaRepository<Range,Integer> {
    Range findByNodeAndUsed(String node, Integer used);
    Range findFirstByUsedAndExpired(Integer used, Integer expired);

    @Modifying
    @Transactional
    @Query("update range_central u set u.used=:newUsed, u.expired=:newExpired where u.rangeid=:rangeId")
    void invalidateRange(Integer rangeId, Integer newUsed,Integer newExpired);

    @Modifying
    @Transactional
    @Query("update range_central u set u.used=:newUsed, u.node=:node where u.rangeid=:rangeId")
    void updateRangeAssignment(Integer rangeId, Integer newUsed,String node);
}
