/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediafilesecurity.utilities;

import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author filippo
 */
public class FormatConverter {

    public static byte[] toByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }

    public static String toHexString(byte[] array) {
        return DatatypeConverter.printHexBinary(array).toLowerCase();
    }

    public static String getByteBinaryString(byte b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; --i) {
            sb.append(b >>> i & 1);
        }
        return sb.toString();
    }
}
