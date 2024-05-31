class Example {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = (int) ((double) j / (double) 10);
        }
        System.out.print("[ ");
        for (int j = 0; j < arr.length - 1; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.print(arr[arr.length - 1] + " ]");

    }
}