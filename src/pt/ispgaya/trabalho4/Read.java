package pt.ispgaya.trabalho4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Read {
    private Read() {
    }

    static int Int() {
        while (true) {
            try {
                return Integer.parseInt(String().trim());
            } catch (Exception e) {
                System.out.println("Not an Integer");
            }
        }
    }

    static String String() {
        String s = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 1);
            s = in.readLine();
        } catch (IOException e) {
            System.out.println(" Error ");
        }
        return s;
    }

    static double Double() {
        while (true) {
            try {
                return Double.parseDouble(String().trim());
            } catch (Exception e) {
                System.out.println("Not a Double");
            }
        }
    }
}
