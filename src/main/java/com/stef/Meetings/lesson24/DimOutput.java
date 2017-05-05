package com.stef.Meetings.lesson24;

public class DimOutput {
    public static void showXY(Coordinates<?>obj){
        for(int i=0;i<obj.coords.length;i++){
            System.out.println("X: "+obj.coords[i].x+" "+"Y: "+obj.coords[i].y);
        }
    }

    public static void showXYZ(Coordinates<? extends ThreeDim>obj){
        for(int i=0;i<obj.coords.length;i++){
            System.out.println("X: "+obj.coords[i].x+" "
                    +"Y: "+obj.coords[i].y+" "+"Z: "+obj.coords[i].z);
        }
    }

    public static void showXYZT(Coordinates<? extends FourDim>obj){
        for(int i=0;i<obj.coords.length;i++){
            System.out.println("X: "+obj.coords[i].x+" "
                    +"Y: "+obj.coords[i].y+" "+"Z: "+obj.coords[i].z+" "
            +"T: "+obj.coords[i].t);
        }
    }
}
