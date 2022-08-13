package com.techleads.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDistRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer maxUserDistKeyId() {
//        Object[] params={};
        String QRY = "SELECT max(USR_DSTBTN_KY) as USR_DSTBTN_KY FROM USR_DSTBTN ";
        Map<String, Object> params = new HashMap<>();
        return namedParameterJdbcTemplate.query(QRY, params, (rs) -> {

            Integer maxKey = null;
            if (rs.next()) {
                maxKey = rs.getInt("USR_DSTBTN_KY");
            }
            return maxKey;

        });
//        return jdbcTemplate.query(QRY, (rs) -> {
//
//            Integer maxKey = null;
//            if (rs.next()) {
//                maxKey = rs.getInt("USR_DSTBTN_KY");
//            }
//            return maxKey;
//
//        },params);
    }


    public String findFacilityIdByUserIdAndArea(String userId, String area) {
        String QRY = "SELECT  USR_DSTBTN_FCLTY_ID  FROM USR_DSTBTN  WHERE  USR_DFNTN_ID =:userId  AND  USR_DFNTN_WRK_ARA_NM =:area";

        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("area", area);
        return namedParameterJdbcTemplate.query(QRY, params, (rs) -> {
            String facility = "N/A";
            if (rs.next()) {
                facility = rs.getString("USR_DSTBTN_FCLTY_ID");
            }
            return facility;
        });


//        Object[] params = {userId, area};
//        return jdbcTemplate.query(QRY, (rs) -> {
//            String facility = "N/A";
//            if (rs.next()) {
//                facility = rs.getString("USR_DSTBTN_FCLTY_ID");
//            }
//            return facility;
//
//        }, params);
    }


    public int deleteUserDistributionByUserIdAndArea(String userId, String area) {
        String QRY = "DELETE FROM USR_DSTBTN where USR_DFNTN_ID =:userId AND USR_DFNTN_WRK_ARA_NM =:area";

        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("area", area);
        return namedParameterJdbcTemplate.update(QRY, params);

    }



    }
