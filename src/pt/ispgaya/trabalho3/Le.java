/*
 * Le.java
 *
 * Created on 7 de Novembro de 2005, 14:59
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package pt.ispgaya.trabalho3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
