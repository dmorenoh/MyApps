package com.app.triagle;

import com.app.config.AppConfig;
import com.app.triagle.exceptions.InvalidTriangleException;
import com.app.triagle.model.Triangle;
import com.app.triagle.model.TriangleType;
import com.app.triagle.service.TriangleOperationsService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by dmorenoh on 10/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TriangleServiceIntegrationTest {
    @Configuration
    @Import({AppConfig.class})
    public static class TestConfig {

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private TriangleOperationsService triangleOperationsService;

    @Test
    public void determineTriangleType_invalidSideTriangle_throwException() {
        expectedException.expect(InvalidTriangleException.class);
        expectedException.expectMessage("Invalid size length");
        triangleOperationsService.determineTriangleType(new Triangle(0, 0, 0));
    }

    @Test
    public void determineTriangleType_triangleWithInequalitySides_throwException() {
        expectedException.expect(InvalidTriangleException.class);
        expectedException.expectMessage("Triangle Inequality");
        triangleOperationsService.determineTriangleType(new Triangle(10, 5, 20));
    }

    @Test
    public void determineTriangleType_triangleEquilateral_returnEquilaterlaType() {
        TriangleType triangleType = triangleOperationsService.determineTriangleType(new Triangle(10, 10, 10));
        assertThat(triangleType, equalTo(TriangleType.EQUILATERAL));
    }

    @Test
    public void determineTriangleType_triangleIsosceles_returnEquilaterlaType() {
        TriangleType triangleType = triangleOperationsService.determineTriangleType(new Triangle(10, 10, 5));
        assertThat(triangleType, equalTo(TriangleType.ISOSCELES));
    }

    @Test
    public void determineTriangleType_triangleScalene_returnEquilaterlaType() {
        TriangleType triangleType = triangleOperationsService.determineTriangleType(new Triangle(10, 11, 5));
        assertThat(triangleType, equalTo(TriangleType.SCALENE));
    }
}
