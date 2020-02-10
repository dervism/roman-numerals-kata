package no.dervis.romannums;

public class RomanNums2 {

    int[] onesArr = new int[] {9, 5, 4, 1};
    String[] onesStrArr = new String[] {"IX", "V", "IV", "I"};

    int[] tensArr = new int[] {90, 50, 40, 10};
    String[] tenStrArr = new String[] {"XC", "L", "XL", "X"};

    int[] hundredsArr = new int[] {900, 500, 400, 100};
    String[] hundredsStrArr = new String[] {"CM", "D", "CD", "C"};

    public String toRoman(int number) {
        return toRoman(number, "");
    }

    /*
     * This solution uses the common logarithm
     * to find the base through the exponential function 10^x.
     */
    public String toRoman(int number, String romanText) {

        int base = (int) Math.pow(10, (int) Math.log10(number));

        if (number == 0) return romanText;

        if (base == 1) {
            Tuple t = calc(number, onesArr, onesStrArr, romanText);
            return toRoman(t.number, t.romanText);
        }

        if (base == 10) {
            Tuple t = calc(number, tensArr, tenStrArr, romanText);
            return toRoman(t.number, t.romanText);
        }

        if (base == 100) {
            Tuple t = calc(number, hundredsArr, hundredsStrArr, romanText);
            return toRoman(t.number, t.romanText);
        }

        return romanText;
    }

    /*
     * The pattern below continues.
     */

    public Tuple calc(int number, int[] numberArr, String[] romanStrArr, String romanText) {

        if (number >= numberArr[0]) {
            romanText += romanStrArr[0];
            number -= numberArr[0];
        }

        if (number >= numberArr[1]) {
            romanText += romanStrArr[1];
            number -= numberArr[1];
        }

        if (number >= numberArr[2]) {
            romanText += romanStrArr[2];
            number -= numberArr[2];
        }

        while (number >= numberArr[3]) {
            romanText += romanStrArr[3];
            number -= numberArr[3];
        }

        return new Tuple(number, romanText);
    }

    private static class Tuple {
        String romanText;
        int number;

        public Tuple(int number, String romanText) {
            this.romanText = romanText;
            this.number = number;
        }
    }
}
