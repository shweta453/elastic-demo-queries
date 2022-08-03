package com.elasticsearch.git.elasticdemoqueries.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum  MaritalStatus {

    SINGLE("Single"),
    MARRIED("Married"),
    DIVORCED("Divorced"),
    WIDOWED("Widowed"),
    SEPARATED("Separated");

    private String status;

    public static MaritalStatus generateMaritalStatus() {
        MaritalStatus[] maritalStatuses = MaritalStatus.values();
        Random random = new Random();
        final Integer index = random.ints(0, (maritalStatuses.length - 1)).limit(1).findFirst().getAsInt();
        return maritalStatuses[index];
    }
}