public class Encryption {
    /* Encryption algorithm */
    public static String encryption(String text, int step) {
        String result = "";
        Alphabet alphabet = new Alphabet();
        char[] textChar = text.toCharArray();

        for (int i = 0; i < textChar.length; i++) {
            int index = 0;
            boolean isNotLetter = Character.isWhitespace(textChar[i]);
            if (!isNotLetter) {
                if (Character.isLowerCase(textChar[i])) {
                    while (textChar[i] != alphabet.getLOW_CASE()[index]) index++;
                    index = index + step;
                    if (index > 32) {
                        index -= 33;
                    }
                    textChar[i] = alphabet.getLOW_CASE()[index];
                } else if (Character.isUpperCase(textChar[i])) {
                    while (textChar[i] != alphabet.getUP_CASE()[index]) index++;
                    index = index + step;
                    if (index > 32) {
                        index -= 33;
                    }
                    textChar[i] = alphabet.getUP_CASE()[index];
                }
            }
        }
        for (char c : textChar) {
            result = result + c;
        }
        return result;
    }
}