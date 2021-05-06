package me.T4;

/**
 * @author liukanglai
 * @date 4/8/21 - 5:18 PM
 */


class T2Start {
    public static void main(String[] args) {
        Cylinder a_cylinder = new Cylinder(10,2);
        Cone a_cone = new Cone(10,2);
        a_cylinder.calculateSurfaceArea();
        a_cylinder.calculateVolume();
        a_cone.calculateSurfaceArea();
        a_cone.calculateVolume();
    }
}

public interface ThreeDimensionalGraphics {
    void calculateSurfaceArea();
    void calculateVolume();
}


class Cylinder implements ThreeDimensionalGraphics {
    double hight, radius;
    Cylinder(double hight, double radius){
        this.hight = hight;
        this.radius = radius;
    }
    public void calculateSurfaceArea() {
        double surface_area = hight * Math.PI * 2 * radius + 2 * radius * radius * Math.PI;
        System.out.println("Cylinder's surface_area = " + surface_area);
    }

    public void calculateVolume() {
        double volume = hight * Math.PI * radius * radius;
        System.out.println("Cylinder's volume = " + volume);
    }

}
class Cone implements ThreeDimensionalGraphics {
    double hight, radius;

    Cone(double hight, double radius){
        this.hight = hight;
        this.radius = radius;
    }
    public void calculateSurfaceArea() {
        double surface_area = Math.PI  * radius * Math.pow((hight * hight + radius * radius), 0.5) + Math.PI * radius *radius;
        System.out.println("Cone's surface_area = " + surface_area);
    }

    public void calculateVolume() {
        double volume = hight * Math.PI * radius * radius / 3.0;
        System.out.println("Cone's surface_area = " + volume);
    }
}