package main.java.com.mmiroshnichenko.javacore.chapter21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedChannelReadOld {
    public static void main(String[] args) {
        FileInputStream fIn = null;
        FileChannel fChan = null;
        MappedByteBuffer mBuf;
        long fSize;

        try {
            fIn = new FileInputStream("test.txt");

            fChan = fIn.getChannel();

            fSize = fChan.size();

            mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);

            for (int i = 0; i < fSize; i++) {
                System.out.print((char) mBuf.get());
            }
        } catch (IOException e) {
            System.out.println("Error input output");
        } finally {
            try {
                if (fChan != null) {
                    fChan.close();
                }
            } catch (IOException e) {
                System.out.println("Error channel closing");
            }

            try {
                if (fIn != null) {
                    fIn.close();
                }
            } catch (IOException e) {
                System.out.println("Error file closing");
            }
        }
    }
}
