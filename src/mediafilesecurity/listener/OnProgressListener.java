/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediafilesecurity.listener;

/**
 *
 * @author filippo
 */
public interface OnProgressListener {

    void onProgressUpdate(int progressVal, byte b);

    void onProgressStarted();

    void onProgressComplete(int progress);

    void onProgressInterrupted();
}
