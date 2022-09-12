package com.techleads.app.service;

import com.techleads.app.model.UserDistributionResponse;
import com.techleads.app.repository.UserDistRepository;
import com.techleads.app.repository.UserDistributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
@Service
public class UserDistributionService {

    @Autowired
    private UserDistRepository userDistRepository;

    @Autowired
    private UserDistributionRepository userDistributionRepository;

    public List<UserDistributionResponse> findAllDistributions() {

        List<UserDistributionResponse> userDisReponse = userDistributionRepository.findAllUserDistributionJoinUserDefId();

        userDisReponse.forEach(user -> {
            if (Objects.nonNull(user.getPackageEngineer()) && user.getPackageEngineer().length() > 0) {
                String[] name = user.getPackageEngineer().split("\\s+");
                if (name.length == 2) {
                    String firstName = toCamelCase(name[0]);
                    String lastName = toCamelCase(name[1]);
                    user.setPackageEngineer(firstName + " " + lastName);
                } else if (name.length == 1) {
                    String firstName = toCamelCase(name[0]);
                    user.setPackageEngineer(firstName);
                }
            }
        });
        return userDisReponse;


    }

    private String toCamelCase(String value) {
        if (Objects.isNull(value)) {
            return null;
        }
        if (value.trim().length() == 1) {
            return value.toUpperCase();
        }
        return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
    }

    public String testDel(String userId, String area) {
        Optional<Integer> integer = userDistributionRepository.deleteUserDistributionByUserIdAndArea(userId, area);
        return "testDel " + integer;
    }


}
