package ir.maktab32.java.projects.tizpa.datasource;

import ir.maktab32.java.projects.tizpa.model.TripMethod;

public class DataSource {

    public static final int[][] coefficients = {
            {1, 2, 2, 4, 3},
            {2, 1, 4, 2, 3},
            {3, 5, 1, 3, 2},
            {4, 3, 3, 1, 2},
            {3, 3, 2, 2, 1}
    };

    public static final TripMethod[] tripMethods = {
            new TripMethod("Economical Trip", 5000, 1.4, 1.2, 1.2),
            new TripMethod("Express Trip", 10000, 3.0, 2.0, 2.0),
            new TripMethod("Motorcycle Trip", 4000, 1.5, 2.0, 0.8)
    };
}
