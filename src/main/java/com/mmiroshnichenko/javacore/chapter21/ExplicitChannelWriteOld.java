package main.java.com.mmiroshnichenko.javacore.chapter21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExplicitChannelWriteOld {

    public static void main(String[] args) {
        FileOutputStream fOut = null;
        FileChannel fChan = null;
        ByteBuffer  mBuf;

        try {
            fOut = new FileOutputStream("test.txt");

            fChan = fOut.getChannel();

            mBuf = ByteBuffer.allocate(26);

            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));
            }

            mBuf.rewind();

            fChan.write(mBuf);
        } catch (IOException e) {
            System.out.println("Error input output " + e);
        } finally {
            try {
                if (fChan != null) {
                    fChan.close();
                }
            } catch (IOException e) {
                System.out.println("Error channel closing");
            }

            try {
                if (fOut != null) {
                    fOut.close();
                }
            } catch (IOException e) {
                System.out.println("Error file closing");
            }
        }
    }


}
