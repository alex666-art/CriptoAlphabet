import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileWriter {
    public void writeText(String text, String path) throws IOException {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rwd");
             FileChannel channel = randomAccessFile.getChannel();) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(text.getBytes().length);
            byteBuffer.put(text.getBytes());
            byteBuffer.flip();
            channel.write(byteBuffer);
        }
    }
}
