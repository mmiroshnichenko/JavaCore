package main.java.com.mmiroshnichenko.javacore.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        Path filepath = null;

        // get file path
        try {
            filepath = Paths.get("test.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path Error " + e);
            return;
        }

        try (SeekableByteChannel fChan = Files.newByteChannel(filepath)) {
            //give memory for buffer
            ByteBuffer mBuf = ByteBuffer.allocate(128);
            do {
                //read data from file in buffer
                count = fChan.read(mBuf);

                if (count != -1) {
                    //prepare buffer for reading data
                    mBuf.rewind();

                    for (int i = 0; i < count; i++) {
                        System.out.print((char) mBuf.get());
                    }
                }
            } while (count != -1);
        } catch (IOException e) {
            System.out.println("Error input output " + e);
        }
    }
}
