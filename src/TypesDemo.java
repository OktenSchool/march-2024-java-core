import demo.Product;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class TypesDemo {

    public static void main(String[] args) {
        boolean bool = true;
        System.out.println(bool);
        byte b = 127;
        short s = 1234;
        int i = 12312123; // 2 ^ 31
        long l = 123123139123L; // 2 ^ 63
        double d = 43.43;
        float f = 12.3223F;
        String string = "this is a text";
        char a = 0;
        System.out.println(a);
        BigInteger bigInteger = BigInteger.valueOf(123);
        System.out.println(bigInteger);
        BigDecimal bigDecimal = new BigDecimal("0.123");
        System.out.println(bigDecimal);

        //-----

        Product product = Product.builder()
                .id(1)
                .name("олівець")
                .price(new BigDecimal("19.99"))
                .build();
        System.out.println(product);

        System.out.println(product.getId());
        System.out.println(product.getName());

        product.setName("зошит");
        System.out.println(product.getName());

        Product product2 = new Product("asd");
        System.out.println(product2.getPrice());

        //------

        Product apple = new Product("яблуко");
        Product pineapple = new Product("груша");
        Product ananas = new Product("ананас");

        Product[] products = new Product[10];
        products[0] = apple;
        products[1] = pineapple;
        products[2] = ananas;

        System.out.println(Arrays.toString(products));
        System.out.println(products[1]);

        ArrayList arrayList = new ArrayList();
        arrayList.add(apple);
        arrayList.add(pineapple);
        arrayList.add(ananas);
        arrayList.add(new Product("апельсин"));
        arrayList.add(123);
        arrayList.add("asdlkasdjl");
        arrayList.add(null);
        System.out.println(arrayList);

        apple.getReviews().add("дуже смачне яблуко");
        System.out.println(arrayList);

        for (Object o : arrayList) {
            System.out.println(o);
        }
    }
}
