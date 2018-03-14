/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediafilesecurity.processor;

import mediafilesecurity.listener.OnProgressListener;

/**
 *
 * @author filippo
 */
public class ViewFileBytesAsString extends BaseProcess {

    private final OnProgressListener progressListener;
    private byte[] fileAsBytes;

    public ViewFileBytesAsString(OnProgressListener progressListener) {
        this.progressListener = progressListener;
    }
    
    public void setBytesToDisplay(byte[] fileAsBytes) {
        this.fileAsBytes = fileAsBytes;
    }

    @Override
    protected void doStart() {
        if(fileAsBytes == null) return;
        int lenght = fileAsBytes.length;
        int progressVal;

        this.progressListener.onProgressStarted();
        for (int i = 0; i < lenght; i++) {
            if(!isRunning()) break;
            byte b = fileAsBytes[i];
            progressVal = (int) (((i * 1.0f) / lenght) * 100);
            this.progressListener.onProgressUpdate(progressVal, b);
        }
        if(isRunning()) this.progressListener.onProgressComplete(100);
        else this.progressListener.onProgressInterrupted();
    }
}
