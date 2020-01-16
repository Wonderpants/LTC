
package pt.ispgaya.trabalho1.File;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Le {
    private Le() {
    }

    public static String umaString() {
        String s = "";
        try {
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(System.in), 1);
            s = in.readLine();
        } catch (IOException e) {
            System.out.println(" Error ");
        }
        return s;
    }
}
