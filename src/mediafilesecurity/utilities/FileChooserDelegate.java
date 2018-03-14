/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediafilesecurity.utilities;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author filippo
 */
public class FileChooserDelegate {

    /**
     * This method will get the absolute path of the file to be saved
     *
     * @param frame The parent window
     * @param file The file to be saved
     *
     * @return null if it's not approved
     */
    public String showSaveFileChooser(JFrame frame, File file) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose directory to save " + file.getName());

        fileChooser.setSelectedFile(file);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.enc", "enc"));

        int userSelection = fileChooser.showSaveDialog(frame);

        String approvedFilePath = null;

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSaveInPreferredDirectory = fileChooser.getSelectedFile();
            approvedFilePath = fileToSaveInPreferredDirectory.getAbsolutePath();
        }
        return approvedFilePath;
    }

    public File showOpenFileChooser(JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        File file = null;
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
        }
        return file;
    }
}
