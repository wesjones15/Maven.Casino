package io.zipcoder.casino.sweetasscasinotools;

import java.util.concurrent.ThreadLocalRandom;

public class Die {
    private final Integer numberOfFaces;
    private Integer currentFacesValue;

    public Die(Integer numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public Integer roll() {
        //currentFacesValue becomes a random value between 1 and numberOfFaces
        ThreadLocalRandom randomNumberGenerator = ThreadLocalRandom.current();
        Integer randomFaceValue = randomNumberGenerator.nextInt(1,numberOfFaces);
        this.currentFacesValue = randomFaceValue;
        return currentFacesValue;
    }
    public Integer getCurrentFacesValue() {

        return currentFacesValue;
    }
}
