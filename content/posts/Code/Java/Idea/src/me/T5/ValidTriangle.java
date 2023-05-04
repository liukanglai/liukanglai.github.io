package me.T5;

/**
 * @author liukanglai
 * @date 4/17/21 - 4:26 PM
 */
public class ValidTriangle {
    double edge1, edge2, edge3;
    double area;
    ValidTriangle(double edge1, double edge2, double edge3) {
        this.edge1 = edge1;
        this.edge2 = edge2;
        this.edge3 = edge3;
    }
    void getArea() {
        if(edge1 + edge2 > edge3) {
            double p = (edge1 + edge2 + edge3) / 2;
            area = Math.sqrt(p * (p-edge1) * (p-edge1) * (p-edge1));
            System.out.println(area);
        }
        else {
            throw new InvalidTriangle("无效三角形!");
        }
    }

    public static void main(String[] args) {
        ValidTriangle a_triangle = new ValidTriangle(3, 4, 5);
        try {
            a_triangle.getArea();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ValidTriangle a_triangle1 = new  ValidTriangle(2, 2, 5);
        try {
            a_triangle1.getArea();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class InvalidTriangle extends RuntimeException {
    InvalidTriangle() {

    }
    InvalidTriangle(String msg) {
        super(msg);
    }
}
