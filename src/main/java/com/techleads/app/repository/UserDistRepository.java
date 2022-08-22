package com.techleads.app.repository;

import com.techleads.app.model.UserDistributionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDistRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer maxUserDistKeyId() {
//        Object[] params={};
        String QRY = "SELECT max(USR_DSTBTN_KY) as scm_app_epds.USR_DSTBTN_KY FROM USR_DSTBTN ";
        Map<String, Object> params = new HashMap<>();
        return namedParameterJdbcTemplate.query(QRY, params, (rs) -> {

            Integer maxKey = null;
            if (rs.next()) {
                maxKey = rs.getInt("USR_DSTBTN_KY");
            }
            return maxKey;

        });
    }


    public String findFacilityIdByUserIdAndArea(String userId, String area) {
        String QRY = "SELECT  USR_DSTBTN_FCLTY_ID  FROM scm_app_epds.USR_DSTBTN  WHERE  USR_DFNTN_ID =:userId  AND  USR_DFNTN_WRK_ARA_NM =:area";

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
    }


    public int deleteUserDistributionByUserIdAndArea(String userId, String area) {
        String QRY = "DELETE FROM scm_app_epds.USR_DSTBTN where USR_DFNTN_ID =:userId AND USR_DFNTN_WRK_ARA_NM =:area";

        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("area", area);
        return namedParameterJdbcTemplate.update(QRY, params);

    }

    public List<UserDistributionResponse> findAllUserDistributionJoinUserDefId() {

        String QRY = "SELECT t1.USR_DFNTN_FRST_NM, t1.USR_DFNTN_LST_NM, t2.USR_DFNTN_ID, t2.USR_DFNTN_WRK_ARA_NM, t2.USR_DSTBTN_KY, t2.USR_DSTBTN_FCLTY_ID, t2.USR_DSTBTN_PRGRM_CD ,  t2.USR_DSTBTN_SPLR_NB , t2.USR_DSTBTN_PRT_FMLY_CD , t2.USR_DSTBTN_SHOP_CLAS_IN  FROM scm_app_epds.USR_DFNTN t1  INNER JOIN scm_app_epds.USR_DSTBTN t2  ON t1.USR_DFNTN_ID=t2.USR_DFNTN_ID";
        Map<String, Object> params = new HashMap<>();
        List<UserDistributionResponse> userDisResponses = new ArrayList<>();
        namedParameterJdbcTemplate.query(QRY, params, new ResultSetExtractor<List<UserDistributionResponse>>() {
            @Override
            public List<UserDistributionResponse> extractData(ResultSet rs) throws SQLException, DataAccessException {

//                while (rs.next()) {
//                    UserDistributionResponse resp = new UserDistributionResponse(5);
//
//                    resp.setPackageEngineer(toCamelCase(rs.getString("USR_DFNTN_FRST_NM"))+" " +
//                                            toCamelCase(rs.getString("USR_DFNTN_LST_NM")));
//                    resp.setUserId(rs.getString("USR_DFNTN_ID"));
//                    resp.setAreaName(rs.getString("USR_DFNTN_WRK_ARA_NM"));
//                    resp.setUsrDistKey(rs.getInt("USR_DSTBTN_KY"));
//                    resp.setFacility(rs.getString("USR_DSTBTN_FCLTY_ID"));
//                    resp.setProgramCode(rs.getString("USR_DSTBTN_PRGRM_CD"));
//                    resp.setSupplierNum(rs.getString("USR_DSTBTN_SPLR_NB"));
//                    resp.setPartFamily(rs.getString("USR_DSTBTN_PRT_FMLY_CD"));
//                    resp.setShopClass(rs.getString("USR_DSTBTN_SHOP_CLAS_IN"));
//                    userDisResponses.add(resp);
//                }
//                return userDisResponses;
                return null;
            }
        });
        return userDisResponses;

    }


    private String toCamelCase(String value) {
        if (value == null) {
            return value;
        }
        if (value.trim().length() == 1) {
            return value.toUpperCase();
        }
        return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
    }

}
