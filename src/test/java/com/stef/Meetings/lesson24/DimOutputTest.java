package com.stef.Meetings.lesson24;

import org.junit.Test;

import static org.junit.Assert.*;

public class DimOutputTest {
    @Test
    public void showXYZT() throws Exception {
        TwoDim td[] = {
                new TwoDim(2, 5),
                new TwoDim(3, 6),
                new TwoDim(4, 7),
                new TwoDim(5, 8),
                new TwoDim(6, 9)
        };

        ThreeDim trd[] = {
                new ThreeDim(2, 5, 7),
                new ThreeDim(3, 6, 7),
                new ThreeDim(4, 7, 7),
                new ThreeDim(5, 8, 7),
        };

        FourDim fd[] = {
                new FourDim(2, 5, 7, 9),
                new FourDim(3, 6, 8, 9),
                new FourDim(4, 7, 9, 9),
                new FourDim(5, 8, 10, 9),
        };


        Coordinates<TwoDim> tdGen = new Coordinates<TwoDim>(td);

        DimOutput.showXY(tdGen);
        //DimOutput.showXYZ(tdGen);
        //DimOutput.showXYZT(tdGen);

        Coordinates<ThreeDim> trGen = new Coordinates<ThreeDim>(trd);
        DimOutput.showXY(trGen);
        DimOutput.showXYZ(trGen);
        //DimOutput.showXYZT(tdGen);

        Coordinates<FourDim> fGen = new Coordinates<FourDim>(fd);
        DimOutput.showXY(fGen);
        DimOutput.showXYZ(fGen);
        DimOutput.showXYZT(fGen);
    }

}