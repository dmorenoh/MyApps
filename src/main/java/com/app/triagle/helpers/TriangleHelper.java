package com.app.triagle.helpers;

import com.app.triagle.model.Triangle;
import org.springframework.stereotype.Component;

/**
 * Created by dmorenoh on 10/4/16.
 */
@Component
public class TriangleHelper {

    public boolean hasInvalidSidesLength(Triangle triangle) {
        if (isValidSide(triangle.getSideOne()) ||
                isValidSide(triangle.getSideTwo()) ||
                isValidSide(triangle.getSideThree())) {
            return true;
        }
        return false;
    }

    public boolean isTriangleInequality(Triangle triangle) {
        if (triangle.getSideOne() >= triangle.getSideTwo() + triangle.getSideThree() ||
                triangle.getSideTwo() >= triangle.getSideTwo() + triangle.getSideOne() ||
                triangle.getSideThree() >= triangle.getSideOne() + triangle.getSideTwo()) {
            return true;
        }
        return false;
    }

    private boolean isValidSide(Double side) {
        return (side == null || side <= 0);
    }

    public boolean isEquilateral(Triangle triangle) {
        if (triangle.getSideOne() == triangle.getSideTwo() &&
                triangle.getSideTwo() == triangle.getSideThree()) {
            return true;
        }
        return false;
    }

    public boolean isIsosceles(Triangle triangle) {
        if (triangle.getSideOne() == triangle.getSideTwo() ||
                triangle.getSideOne() == triangle.getSideThree() ||
                triangle.getSideTwo() == triangle.getSideThree()) {
            return true;
        }
        return false;
    }
}
