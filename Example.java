class Example {

    public static void main(String[] args) {
        String firstString = "Jemma";
        String secondString = "Computer Science";
        if (firstString.equals(secondString)) {
            // This code will not run, the strings are not equal
        }
        if (firstString.compareTo(secondString) > 0) {
            // This code will run because "Computer Science" comes after "Jemma" in
            // alphabetic order
        }
    }
}