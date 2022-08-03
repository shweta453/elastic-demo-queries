package com.elasticsearch.git.elasticdemoqueries.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum  Profession {
    BANKER("Banker"),
    FARMER("Farmer"),
    ACTOR("Actor"),
    DOCTOR("Doctor"),
    SINGER("Singer"),
    ATHLETE("Athlete"),
    IT_PROFESSIONAL("IT Professional");

    private String value;


    public static Profession generateRandomProfession() {
        Profession[] professions = Profession.values();
        Random random = new Random();
        final Integer index = random.ints(0, (professions.length - 1)).limit(1).findFirst().getAsInt();
        return professions[index];
    }
}