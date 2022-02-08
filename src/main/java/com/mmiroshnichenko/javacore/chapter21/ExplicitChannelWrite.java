package main.java.com.mmiroshnichenko.javacore.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWrite {
    public static void main(String[] args) {
        try (FileChannel fChan = (FileChannel)
                Files.newByteChannel(Paths.get("test2.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer mBuff = ByteBuffer.allocate(26);

            for (int i = 0; i < 26; i++) {
                mBuff.put((byte) ('A' + i));
            }
            mBuff.rewind();

            fChan.write(mBuff);
        } catch (InvalidPathException e) {
            System.out.println("Path exception " + e);
        } catch (IOException e) {
            System.out.println("Error input output");
            System.exit(1);
        }

    }
}
