import java.io.IOException;

public class BrutForce {

    public static String brutForce(String path) {
        String result = "";
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        Vocabulary vocabulary = new Vocabulary();
        String originalText = fileReader.readText(path);

        for (int i = 0; i < 33; i++) {
            for (int j = 0; j < vocabulary.getVocabulary().size(); j++) {
                result = Decryption.decryption(originalText, i);
                char[] symbols = result.toCharArray();
                String pattern = vocabulary.getVocabulary().get(j);
                boolean isSpace = Character.isWhitespace(symbols[j]);
                if (isSpace) {
                    for (int x = 0; x < vocabulary.getVocabulary().size(); x++) {
                        if (result.contains(pattern)) {
                            try {
                                fileWriter.writeText(result, path);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.printf("Break-in was successful on %d iteration", i + 1);
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}