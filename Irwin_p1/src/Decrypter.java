public class Decrypter {
    public static String decrypt(String integer) {
        //string called integer (being the inputted code) put into an array, charAt doesn't like string[]
        int arr[] = new int[4];
        for (int i = 0; i < 4; i++) {
            char ch = integer.charAt(i);
            arr[i] = Character.getNumericValue(ch);
        }
        //shifting the positions of the integers in the array
        int temp = arr[0];
        arr[0] = arr[2];
        arr[2] = temp;
        temp = arr[1];
        arr[1] = arr[3];
        arr[3] = temp;
        //all possible cases for the subtraction of 7; cant be negative
        for (int i = 0; i < 4; i++) {
            int code = arr[i];
            switch (code) {
                case 0:
                    arr[i] = 3;
                    break;
                case 1:
                    arr[i] = 4;
                    break;
                case 2:
                    arr[i] = 5;
                    break;
                case 3:
                    arr[i] = 6;
                    break;
                case 4:
                    arr[i] = 7;
                    break;
                case 5:
                    arr[i] = 8;
                    break;
                case 6:
                    arr[i] = 9;
                    break;
                case 7:
                    arr[i] = 0;
                    break;
                case 8:
                    arr[i] = 1;
                    break;
                case 9:
                    arr[i] = 2;
                    break;
            }
        }
        //algorithm for multiplication of 10
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
