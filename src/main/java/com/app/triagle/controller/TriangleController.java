package com.app.triagle.controller;

import com.app.triagle.model.Triangle;
import com.app.triagle.service.TriangleOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dmorenoh on 10/4/16.
 */
@Controller
@EnableAutoConfiguration
@ComponentScan("com.app")
public class TriangleController {

    @Autowired
    private TriangleOperationsService triangleOperationsService;

    @RequestMapping(value = "/triangle/side1/{side1}/side2/{side2}/side3/{side3}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Triangle getTriangleTypeBySides(
            @PathVariable("side1") int side1,
            @PathVariable("side2") int side2,
            @PathVariable("side3") int side3) {
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setTriangleType(triangleOperationsService.determineTriangleType(triangle).name());
        return triangle;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TriangleController.class, args);
    }
}
