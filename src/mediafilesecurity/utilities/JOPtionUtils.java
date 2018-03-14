/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediafilesecurity.utilities;

import javax.swing.JOptionPane;

/**
 *
 * @author filippo
 */
public class JOPtionUtils {

    private JOPtionUtils() {
    }

    public static void showWarningMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Info.", JOptionPane.WARNING_MESSAGE);
    }
}
