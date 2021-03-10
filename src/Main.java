public class Main {
    public static void main(String[] args) throws ArrayException {
        Array<String> array=new Array<String>(2);
        array.add("a");
        array.add("b");
        array.add("c");
        array.add(0,"d");
        array.remove("c");
        array.add("Asasas");
        array.add("a");
        System.out.println(array.length());

        String a[]={"ab","bcd"};
        String b[]={"adv","ccfdd","xyz"};

        Array<String> arr=new Array<String>();
        arr.merge(a, b, (a1, b1) -> a1.compareTo(b1));

        for(int i=0;i<arr.length();i++)
            System.out.println(arr.getAnElement(i));

    }


}
