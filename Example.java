class Example {

    public static void main(String[] args) {
        // I want to print "First Print" a lot of times
        System.out.println("First Print");
        System.out.println("First Print");
        System.out.println("First Print");
        System.out.println("First Print");
        System.out.println("First Print");
        System.out.println("First Print");
        System.out.println("First Print");

        int x = 10;
        int y = 200;
        x = y + 30;
        y = x - 10;
        x = y * y;

        System.out.println("This message will not print");
        System.out.println("This is a second message");
        System.out.println("Hello, world!");

        x = 10;
        y = 50;
        System.out.print("10 + 50 is: ");
        System.out.println(x + y);

        int[] arr = { 1, 2, 3, 4 };
        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
    }
}