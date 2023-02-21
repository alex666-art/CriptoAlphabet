public class Decryption {
    /* Decryption algorithm */
    public static String decryption(String text, int step) {
        String result = "";
        Alphabet alphabet = new Alphabet();
        char[] textChar = text.toCharArray();

        for (int i = 0; i < textChar.length; i++) {
            int index = 0;
            if (Character.isLowerCase(textChar[i])) {
                while (textChar[i] != alphabet.getLOW_CASE()[index]) index++;
                index = index - step;
                if (index > 32) {
                    index -= 33;
                }
                if (index < 0) {
                    index += 33;
                }
                textChar[i] = alphabet.getLOW_CASE()[index];
            }
            if (textChar[i] == '.' || textChar[i] == ',' || textChar[i] == '"' || textChar[i] == ':' ||
                    textChar[i] == '-' || textChar[i] == '!' || textChar[i] == '?' || textChar[i] == ' ') {
                while (textChar[i] != alphabet.getSYMBOLS()[index]) index++;
                index = index - step;
                if (index > 7) {
                    index -= 8;
                }
                if (index < 0) {
                    index += 8;
                }
                textChar[i] = alphabet.getSYMBOLS()[index];
            } else if (Character.isUpperCase(textChar[i])) {
                while (textChar[i] != alphabet.getUP_CASE()[index]) index++;
                index = index - step;
                if (index > 32) {
                    index -= 33;
                }
                if (index < 0) {
                    index += 33;
                }
                textChar[i] = alphabet.getUP_CASE()[index];
            }
        }
        for (char c : textChar) {
            result = result + c;
        }
        return result;
    }
}