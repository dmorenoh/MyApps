package com.app.triagle.service;

import com.app.triagle.model.Triangle;
import com.app.triagle.model.TriangleType;

/**
 * Created by dmorenoh on 10/4/16.
 */
public interface TriangleOperationsService {
    TriangleType determineTriangleType (Triangle triangle);
}
