package com.c.refactoring.movie;

import com.c.refactoring.StringUtils;
import java.util.Arrays;
import java.util.List;

public class Movie {

    private static final String A_RATING = "A";
    private static final List<String> VALID_B_RATINGS = Arrays.asList("B1", "B2", "B3", "B4");
    private String rating;

    public Movie(String rating) {
        super();
        this.rating = rating;
    }

    /*Axx or By
    Where x represents any digit between 0 and 9, and y represents 
    any digit between 1 and 4*/
    public boolean isValidRating() {
        if (rating == null) {
            return false;
        }
        if (isValidArating()) {
            return true;
        }

        if (isValidBRating()) {
            return true;
        }
        return false;
    }

    private boolean isValidArating() {
        final String firstCharacter = this.getRating().substring(0, 1);

        if (firstCharacter.equalsIgnoreCase(A_RATING)
                && rating.length() == 3
                && StringUtils.isNumeric(this.getRating().substring(1, 3))) {
            return true;
        }
        return false;
    }

    private boolean isValidBRating() throws NumberFormatException {

        return VALID_B_RATINGS.contains(this.getRating());

    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
