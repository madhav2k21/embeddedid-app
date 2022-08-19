package com.techleads.app.service;

import com.techleads.app.model.UserDistributionDTO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDistributionCSVHelper {

    public static String TYPE = "text/csv";
    private static final String[] HEADERS={"Package Engineer","UserId","Area","Facility","ProgramCode","SupplierNum","PartFamily","ShopClass","PartNumber"};
//    static String[] HEADERs = { "Id", "Title", "Description", "Published" };
    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }
    public static List<UserDistributionDTO> csvToUserDistributionDTO(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

//             Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.RFC4180.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
             ) {

//            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(fileReader);
            List<UserDistributionDTO> userDistList = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            csvRecords.forEach(csvRecord-> {
                UserDistributionDTO userDTO = new UserDistributionDTO();

                userDTO.setUserId(csvRecord.get("UserId"));
                userDTO.setAreaName(csvRecord.get("Area"));

                userDTO.setFacility(csvRecord.get("Facility"));
                userDTO.setProgramCode(csvRecord.get("ProgramCode"));
                userDTO.setSupplierNum(csvRecord.get("SupplierNum"));
                userDTO.setPartFamily(csvRecord.get("PartFamily"));
                userDTO.setSupplierNum(csvRecord.get("SupplierNum"));
                userDTO.setPartFamily(csvRecord.get("PartFamily"));
                userDTO.setShopClass(csvRecord.get("ShopClass"));
                userDTO.setPartNumber(csvRecord.get("PartNumber"));
                userDistList.add(userDTO);
            });
//            for (CSVRecord csvRecord : csvRecords) {
//                UserDistributionDTO userDTO = new UserDistributionDTO();
//
//                userDTO.setUserId(csvRecord.get("UserId"));
//                userDTO.setAreaName(csvRecord.get("Area"));
//
//                userDTO.setFacility(csvRecord.get("Facility"));
//                userDTO.setProgramCode(csvRecord.get("ProgramCode"));
//                userDTO.setSupplierNum(csvRecord.get("SupplierNum"));
//                userDTO.setPartFamily(csvRecord.get("PartFamily"));
//                userDTO.setSupplierNum(csvRecord.get("SupplierNum"));
//                userDTO.setPartFamily(csvRecord.get("PartFamily"));
//                userDTO.setShopClass(csvRecord.get("ShopClass"));
//                userDTO.setPartNumber(csvRecord.get("PartNumber"));
//                userDistList.add(userDTO);
//            }
            return userDistList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
