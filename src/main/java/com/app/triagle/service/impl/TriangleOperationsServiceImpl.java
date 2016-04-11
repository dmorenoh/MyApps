package com.app.triagle.service.impl;

import com.app.triagle.exceptions.InvalidTriangleException;
import com.app.triagle.helpers.TriangleHelper;
import com.app.triagle.model.Triangle;
import com.app.triagle.model.TriangleType;
import com.app.triagle.service.TriangleOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dmorenoh on 10/4/16.
 */
@Service("triangleOperationsService")
public class TriangleOperationsServiceImpl implements TriangleOperationsService {

    @Autowired
    TriangleHelper triangleHelper;

    @Override
    public TriangleType determineTriangleType(final Triangle triangle) {

        validateTriangle(triangle);

        return getTriangleType(triangle);
    }

    private TriangleType getTriangleType(Triangle triangle) {
        if (triangleHelper.isEquilateral(triangle)) {
            return TriangleType.EQUILATERAL;
        }

        if (triangleHelper.isIsosceles(triangle)) {
            return TriangleType.ISOSCELES;
        }

        return TriangleType.SCALENE;
    }

    private void validateTriangle(Triangle triangle) {
        if (triangleHelper.hasInvalidSidesLength(triangle)) {
            throw new InvalidTriangleException("Invalid size length");
        }
        if (triangleHelper.isTriangleInequality(triangle)) {
            throw new InvalidTriangleException("Triangle Inequality");
        }
    }

}
