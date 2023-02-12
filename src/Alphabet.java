public class Alphabet {

     private final char[] LOW_CASE = {
             'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
             'з', 'и','й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
             'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э','ю', 'я'
     };
     private final char[] UP_CASE = {
             'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
             'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х',
             'Ц', 'Ч', 'Ш', 'Щ', 'Ы', 'Э', 'Ю', 'Я'
     };

    public char[] getLOW_CASE() {
        return LOW_CASE;
    }

    public char[] getUP_CASE() {
        return UP_CASE;
    }
}
