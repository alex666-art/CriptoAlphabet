import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static java.nio.file.Files.readAllBytes;

public class FileReader {

    public String readText(String pathOriginal) {
        Path path = Path.of(pathOriginal);
        String result = "";
        try {
            byte[] arrayBytes = readAllBytes(path);
            result = new String(arrayBytes, StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        return result;
    }
}
