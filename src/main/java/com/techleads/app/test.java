package com.techleads.app;

import com.techleads.app.model.ApproverNames;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args) {
        String str="nextval('scm_app_epds.non_id_seq')";


        List<ApproverNames> list = Arrays.asList(new ApproverNames("madhav anupoju", null, null, null, null));

        capitalizeFullName(list);


        System.out.println(list);
        System.exit(0);

//        String test="madhav anupoju";
        String test=null;
        String capitalize = StringUtils.capitalize(test);
        System.out.println(capitalize);

//        getEvenNumbers(2,4).forEach(System.out::println);
    }

    private static List<Integer> getEvenNumbers(int offset, int limit) {

//        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> integers = Arrays.asList(1);

        return integers.stream().skip(offset)
//                .limit(limit)
                .collect(Collectors.toList());

//        return Stream.iterate(0, i -> i + 1)
//                .filter(i -> i % 2 == 0)
//                .skip(offset)
//                .limit(limit)
//                .collect(Collectors.toList());
    }


    private static void capitalizeFullName(List<ApproverNames> allApproverNames) {
        allApproverNames.forEach(names->{
            if (Objects.nonNull(names.getFullName()) && names.getFullName().length() > 0) {
                String[] name = names.getFullName().split("\\s+");
                if (name.length == 2) {
                    String firstName = StringUtils.capitalize(name[0]);
                    String lastName = StringUtils.capitalize(name[1]);
                    names.setFullName(firstName + " " + lastName);
                } else if (name.length == 1) {
                    String firstName = StringUtils.capitalize(name[0]);
                    names.setFullName(firstName);
                }
            }
        });
    }
}
