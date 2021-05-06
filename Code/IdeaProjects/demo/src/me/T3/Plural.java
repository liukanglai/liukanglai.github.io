package me.T3;

/**
 * @author liukanglai
 * @date 4/5/21 - 8:30 PM
 */
public class Plural {
    double real , imaginary;
    double add_real, add_imaginary;
    double sub_real, sub_imaginary;
    double mold;
    protected Plural() {
        real = 1;
        imaginary = 1;
    }
    protected void addUp(double another_real, double another_imaginary) {
        add_real = real + another_real;
        add_imaginary = imaginary + another_imaginary;
    }
    protected void subtract(double another_real, double another_imaginary) {
        add_real = real - another_real;
        add_imaginary = imaginary - another_imaginary;
    }
    protected void modulo() {
        mold = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }
    protected void putPlural() {
        System.out.printf("%f+%fi\n", real, imaginary);
    }

    public static void main(String[] args) {
        Plural a_plural = new Plural();
        a_plural.addUp(2,2);
        a_plural.subtract(2,2);
        a_plural.modulo();
        a_plural.putPlural();
    }
}
