package com.app.triagle.helpers;

import com.app.triagle.model.Triangle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by dmorenoh on 10/4/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class TriangleHelperTest {

    @InjectMocks
    TriangleHelper triangleHelper;

    @Test
    public void hasInvalidSidesLength_hasAAnyLowerThanZeroSide_returnTrue() {
        Triangle triangle = new Triangle(2, -2, 7);
        assertThat(triangleHelper.hasInvalidSidesLength(triangle), is(true));
    }

    @Test
    public void hasInvalidSidesLength_hasAllSizeGreaterThanZeroSide_returnFalse() {
        Triangle triangle = new Triangle(2, 4, 7);
        assertThat(triangleHelper.hasInvalidSidesLength(triangle), is(false));
    }

    @Test
    public void isTriangleInequality_hasOneSideGreaterThanSumOfOthers_returnTrue() {
        Triangle triangle = new Triangle(10, 5, 15);
        assertThat(triangleHelper.isTriangleInequality(triangle), is(true));
    }

    @Test
    public void isTriangleInequality_hasAnySideLowerThanSumOfOthers_returnFalse() {
        Triangle triangle = new Triangle(10, 5, 14);
        assertThat(triangleHelper.isTriangleInequality(triangle), is(false));
    }

    @Test
    public void isEquilateral_triangleHasNoAllSidesEqualLength_returnFalse() {
        Triangle triangle = new Triangle(10, 11, 10);
        assertThat(triangleHelper.isEquilateral(triangle),is(false));
    }

    @Test
    public void isEquilateral_triangleHasAllSidesEqualLength_returnTrue() {
        Triangle triangle = new Triangle(7, 7, 7);
        assertThat(triangleHelper.isEquilateral(triangle),is(true));
    }

    @Test
    public void isIsosceles_triangleHasAllSideDifferentLength_returnFalse() {
        Triangle triangle = new Triangle(7, 8, 9);
        assertThat(triangleHelper.isIsosceles(triangle),is(false));
    }

    @Test
    public void isIsosceles_triangleHasTwoSidesEqualLength_returnTrue() {
        Triangle triangle = new Triangle(8, 8, 9);
        assertThat(triangleHelper.isIsosceles(triangle),is(true));
    }
}