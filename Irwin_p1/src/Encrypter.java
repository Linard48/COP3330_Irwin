public class Encrypter {
    public static String encrypt(String number) {
        //string called integer (being the inputted code) put into an array, charAt doesn't like string[]
        int arr[] = new int[4];
        for (int i = 0; i < 4; i++) {
            char ch = number.charAt(i);
            arr[i] = Character.getNumericValue(ch);
        }
        //applies addition of 7 and modulus 10 to the integers before being shifted
        for (int i = 0; i < 4; i++) {
            int temp = arr[i];
            temp += 7;
            temp = temp % 10;
            arr[i] = temp;
        }
        //shifting the positions of the integers in the array
        int temp = arr[0];
        arr[0] = arr[2];
        arr[2] = temp;
        temp = arr[1];
        arr[1] = arr[3];
        arr[3] = temp;

        int replacedInt = 0;
        for (int i = 0; i < 4; i++)
            replacedInt = replacedInt * 10 + arr[i];
        String message = Integer.toString(replacedInt);
        //in case of leading 0
        if (arr[0] == 0)
            message = ("0" + message);
        return message;
    }
}