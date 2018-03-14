/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediafilesecurity;

import mediafilesecurity.ui.MainWindow;

/**
 *
 * @author filippo
 */
public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setLocationRelativeTo(null);
                mainWindow.setTitle("Media File Security Processor");
                mainWindow.setVisible(true);
            }
        });
    }
}
