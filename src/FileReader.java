import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileReader {

    public String readText(String path) throws IOException {
        String result = "";
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
             FileChannel channel = randomAccessFile.getChannel()) {

            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            StringBuilder builder = new StringBuilder();
            channel.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                builder.append((char) byteBuffer.get());
            }
            result = String.valueOf(builder);
        }
        return result;
    }
}
