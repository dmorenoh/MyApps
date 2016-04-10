package com.app.triagle.impl;

import com.app.triagle.exceptions.InvalidTriangleException;
import com.app.triagle.helpers.TriangleHelper;
import com.app.triagle.model.Triangle;
import com.app.triagle.model.TriangleType;
import com.app.triagle.service.impl.TriangleOperationsServiceImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by dmorenoh on 10/4/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class TriangleOperationsServiceImplTest {

    @InjectMocks
    public TriangleOperationsServiceImpl testSubject;

    @Mock
    public TriangleHelper triangleHelper;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void determineTriangleType_anyInvalidSideForTriangle_throwsException() {
        Triangle triangle = new Triangle(0, 0, 0);
        when(triangleHelper.hasInvalidSidesLength(triangle)).thenReturn(true);
        expectedException.expect(InvalidTriangleException.class);
        expectedException.expectMessage("Invalid size length");
        testSubject.determineTriangleType(triangle);
        verify(triangleHelper, times(1)).hasInvalidSidesLength(triangle);
        verify(triangleHelper, never()).isTriangleInequality(any(Triangle.class));
        verify(triangleHelper, never()).isEquilateral(any(Triangle.class));
        verify(triangleHelper, never()).isIsosceles(any(Triangle.class));
    }

    @Test
    public void determineTriangleType_triangleWithInequalitySides_throwsException() {
        Triangle triangle = new Triangle(0, 0, 0);
        when(triangleHelper.hasInvalidSidesLength(triangle)).thenReturn(false);
        when(triangleHelper.isTriangleInequality(triangle)).thenReturn(true);
        expectedException.expect(InvalidTriangleException.class);
        expectedException.expectMessage("Triangle Inequality");
        testSubject.determineTriangleType(triangle);
        verify(triangleHelper, times(1)).hasInvalidSidesLength(triangle);
        verify(triangleHelper, times(1)).isTriangleInequality(triangle);
        verify(triangleHelper, never()).isEquilateral(any(Triangle.class));
        verify(triangleHelper, never()).isIsosceles(any(Triangle.class));
    }

    @Test
    public void determineTriangleType_equilateralTriangle_returnEquilateralType() {
        Triangle triangle = new Triangle(0, 0, 0);
        when(triangleHelper.hasInvalidSidesLength(triangle)).thenReturn(false);
        when(triangleHelper.isTriangleInequality(triangle)).thenReturn(false);
        when(triangleHelper.isEquilateral(triangle)).thenReturn(true);
        TriangleType result = testSubject.determineTriangleType(triangle);
        verify(triangleHelper, times(1)).hasInvalidSidesLength(triangle);
        verify(triangleHelper, times(1)).isTriangleInequality(triangle);
        verify(triangleHelper, times(1)).isEquilateral(triangle);
        verify(triangleHelper, never()).isIsosceles(any(Triangle.class));
        assertThat(result, equalTo(TriangleType.EQUILATERAL));
    }

    @Test
    public void determineTriangleType_isoscelesTriangle_returnIsoscelesType() {
        Triangle triangle = new Triangle(0, 0, 0);
        when(triangleHelper.hasInvalidSidesLength(triangle)).thenReturn(false);
        when(triangleHelper.isTriangleInequality(triangle)).thenReturn(false);
        when(triangleHelper.isEquilateral(triangle)).thenReturn(false);
        when(triangleHelper.isIsosceles(triangle)).thenReturn(true);
        TriangleType result = testSubject.determineTriangleType(triangle);
        verify(triangleHelper, atLeastOnce()).hasInvalidSidesLength(triangle);
        verify(triangleHelper, atLeastOnce()).isTriangleInequality(triangle);
        verify(triangleHelper, atLeastOnce()).isEquilateral(triangle);
        verify(triangleHelper, atLeastOnce()).isIsosceles(triangle);
        assertThat(result, equalTo(TriangleType.ISOSCELES));
    }

    @Test
    public void determineTriangleType_scaleneTriangle_returnScaleneType() {
        Triangle triangle = new Triangle(0, 0, 0);
        when(triangleHelper.hasInvalidSidesLength(triangle)).thenReturn(false);
        when(triangleHelper.isTriangleInequality(triangle)).thenReturn(false);
        when(triangleHelper.isEquilateral(triangle)).thenReturn(false);
        when(triangleHelper.isIsosceles(triangle)).thenReturn(false);
        TriangleType result = testSubject.determineTriangleType(triangle);
        verify(triangleHelper, atLeastOnce()).hasInvalidSidesLength(triangle);
        verify(triangleHelper, atLeastOnce()).isTriangleInequality(triangle);
        verify(triangleHelper, atLeastOnce()).isEquilateral(triangle);
        verify(triangleHelper, atLeastOnce()).isIsosceles(triangle);
        assertThat(result, equalTo(TriangleType.SCALENE));
    }
}