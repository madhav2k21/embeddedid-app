package com.techleads.app.service;

import com.techleads.app.model.UserDistribution;
import com.techleads.app.model.UserDistributionResponse;
import com.techleads.app.repository.UserDistRepository;
import com.techleads.app.repository.UserDistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserDistributionService {

    @Autowired
    private UserDistRepository userDistRepository;

    @Autowired
    private UserDistributionRepository userDistributionRepository;

    public List<UserDistributionResponse> findAllDistributions(){
        return userDistRepository.findAllUserDistributionJoinUserDefId();
    }

    public String testDel(String userId,String area){
        Optional<Integer> integer = userDistributionRepository.deleteUserDistributionByUserIdAndArea(userId, area);
        return "testDel "+integer;
    }
}
