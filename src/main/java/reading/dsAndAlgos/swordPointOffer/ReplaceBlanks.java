package reading.dsAndAlgos.swordPointOffer;

/**
 * created by ran
 */
public class ReplaceBlanks {

    private static int solution(char[] string, int usedLength) {
        if (string == null || usedLength > string.length ) return -1;

        int whiteCount = 0;
        for (char c : string) {
            if (c == ' ') whiteCount++;
        }
        if (whiteCount == 0) return usedLength;

        int targetLength = usedLength + whiteCount * 2;
        if (targetLength > string.length) {
            throw new RuntimeException("No enough space for expand");
        }

        int tmp = targetLength;
        usedLength--;
        targetLength--;

        while (usedLength >= 0) {
            if (string[usedLength] == ' ') {
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            } else {
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }
        return tmp;
    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';

        int length = solution(string, 12);
        System.out.println(new String(string, 0, length));
    }
}
