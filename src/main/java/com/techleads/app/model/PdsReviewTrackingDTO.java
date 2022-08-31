package com.techleads.app.model;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PdsReviewTrackingDTO {
    private String pdsReviewTrackingTypeName;
    private String pdsReviewTrackingReviewerId;
    private double pdsReviewTrackingResponseNumber;
    private Short pdsVersionNumber;
    private Long pdsTrackingKey;


    private String pdsReviewFacilityId;
    private String pdsReviewItemNumber;
    private String pdsReviewTrackingNumber;
    private String pdsReviewRevisionNumber;


    private String pdsReviewTrackingStatusName;
    private String pdsReviewTrackingResponderId;

//    private String pdsReviewTrackingUserId;
//    private LocalDateTime pdsReviewCreatedCreatedTs;
//    private String pdsReviewUpdateUpdatedUserId;
//    private LocalDateTime pdsReviewUpdateUpdatedTs;
}
