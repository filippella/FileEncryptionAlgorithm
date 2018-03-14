/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediafilesecurity.processor;

/**
 *
 * @author filippo
 */
public abstract class BaseProcess implements Runnable {

    private boolean isRunning = false;
    private Thread thread;

    public void startProcess() {
        if (!isRunning && thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stopProcess() {
        this.isRunning = false;
        if (thread != null) {
            thread.stop();
        }
        thread = null;
    }

    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void run() {
        this.isRunning = true;
        doStart();
    }

    protected abstract void doStart();
}
