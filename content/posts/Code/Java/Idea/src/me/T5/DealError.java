package me.T5;

/**
 * @author liukanglai
 * @date 4/14/21 - 10:30 PM
 */
public class DealError{
    public static void main(String[] args) {
        Student a_student = new Student();
        try {
            a_student.setName("无敌独孤不败");
            //a_student.setName("");
            //a_student.setName("无");
            System.out.println(a_student.name);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            a_student.setAddress("北京市");
            //a_student.setAddress("河南省");
            //a_student.setAddress("河北省xx市");
            System.out.println(a_student.address);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class IllegalNameException extends RuntimeException{
    public IllegalNameException() {
    }
    public IllegalNameException(String msg) {
        super(msg);
    }
}

class IllegalAddressException extends RuntimeException{
    public  IllegalAddressException(){
    }
    public  IllegalAddressException(String msg) {
        super(msg);
    }
}
class Student {
    String name, address;

    void setName(String name) {
        if(name.length() < 1 || name.length() > 5) {
            //System.out.println(name.length());
            throw new IllegalNameException("名字必须1-5个字");
        }
        else {
            this.name = name;
        }

    }
    void setAddress(String address) {
        if(address.contains("省") && address.contains("市")){
            this.address = address;
        }
        else {
            throw new IllegalAddressException("必须含有省和市");
        }
    }
}