/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediafilesecurity.utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filippo
 */
public class FileUtils {

    public static String getFileExtension(String fileName) {
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    public static String getFileBaseName(String fileName) {
        int index = fileName.lastIndexOf('.');
        if (index == -1) {
            return fileName;
        } else {
            return fileName.substring(0, index);
        }
    }

    public static byte[] getFileAsBytes(File file) {
        try {
            byte[] bytesArray = new byte[(int) file.length()];

            try (FileInputStream fis = new FileInputStream(file)) {
                fis.read(bytesArray);
            }
            return bytesArray;
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new byte[]{};
    }

    public static void writeFile(File file, byte[] array) {
        if (file.exists()) {
            file.delete();
        }

        BufferedOutputStream bs = null;
        try {
            FileOutputStream fs = new FileOutputStream(file, true);
            bs = new BufferedOutputStream(fs);
            bs.write(array);
            bs.close();
            bs = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bs != null) {
            try {
                bs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
