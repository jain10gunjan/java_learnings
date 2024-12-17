package javaBasics;

public class Strings {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Gunjan");
        System.out.println(sb.capacity());
        System.out.println(sb.length());

        //Append Method:
        sb.append(" Jain");
        System.out.println(sb);

        // They are not equal: String str = sb. Conversion is required.
        String str = sb.toString();

        //deleteCharAt Method:
        sb.deleteCharAt(2);
        System.out.println(sb);

        //Insert Method:
        sb.insert(2, "Java");
        System.out.println(sb);

        //SubString Method:

        //Mobile Class:
        Mobile obj1 = new Mobile();
        obj1.brand = "Apple";
        obj1.price = 1500;
        obj1.name = "SmartPhone";
        obj1.printData();

        Mobile obj2 = new Mobile();
        obj2.brand = "Samsung";
        obj2.price = 1700;
        obj2.name = "SmartPhone";
        obj2.printData();
    }
}

class Mobile{
    String brand;
    int price;
    String name;
    // Static Keyword: static String name - This will now be a class member not an object member.
    public void printData(){
        System.out.println(brand + " " + price + " " + name);
    }
}
