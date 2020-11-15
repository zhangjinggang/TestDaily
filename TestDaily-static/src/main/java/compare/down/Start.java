package compare.down;

import java.io.File;

public class Start {

    public static void main(String[] args) {

        startThread("F:\\mp4\\", "F:\\temp", 43347);

        startThread("G:\\mp4\\", "G:\\temp", 42340);

        startThread("H:\\mp4\\", "H:\\temp", 41340);

        startThread("I:\\mp4\\", "I:\\temp", 40340);

        startThread("J:\\mp4\\", "J:\\temp", 39340);

//        startThread("H:\\mp4\\", "H:\\temp", 43340);
    }

    private static void startThread(String DES_PATH, String TEMP_DIR, int i) {
        DownVideoRunnable downVideoRunnable = new DownVideoRunnable();
        downVideoRunnable.setDES_PATH(DES_PATH);
        downVideoRunnable.setTEMP_DIR(TEMP_DIR);
        downVideoRunnable.setIndex(i);
        Thread thread = new Thread(downVideoRunnable);
        thread.start();
    }
}
