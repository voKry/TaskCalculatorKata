import java.io.IOException;
import java.util.Collections;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

public class MyClass {
    public static void main(String[] args) throws ArithmeticException {
        Scanner userEnterNum = new Scanner(System.in);

        String enteredPhrase = userEnterNum.nextLine();

        String[] withoutSpace = enteredPhrase.split(" ");

        String[] rimNumbers = {
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"
        };
        try {
            if (isValid(withoutSpace[0]) != isValid(withoutSpace[2])){
                throw new ArithmeticException("Разные системы счисления");
            } else {

                if (withoutSpace.length > 3) {
                    throw new ArithmeticException("Элементов в выражении больше двух");
                } else {

                    if (isValid(withoutSpace[0]) && isValid(withoutSpace[2])) {
                        int result = calculateRimNum(converterRimToArab(rimNumbers, withoutSpace[0]),
                                converterRimToArab(rimNumbers, withoutSpace[2]), withoutSpace[1]);
                        if (result <= 0) {
                            throw new ArithmeticException("В римской системе нет отрицательных чисел");
                        } else {
                            System.out.println(intToRoman(result));
                        }
                    } else {
                        if ((Integer.parseInt(withoutSpace[0]) > 10) || (Integer.parseInt(withoutSpace[2])) > 10) {
                            throw new ArithmeticException("Одно из введенных чисел больше 10");
                        } else {
                            System.out.println(calculateArabicNum(withoutSpace[0], withoutSpace[2], withoutSpace[1]));
                        }
                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArithmeticException("Не является математической операцией");
        }


        //System.out.println(converterRimToArab(rimNumbers, withoutSpace[0]));

    }

    public static int calculateArabicNum(String num1, String num2, String operationSymbol) {

        int result = 0;
        int convertedNum1 = Integer.parseInt(num1);
        int convertedNum2 = Integer.parseInt(num2);

        switch (operationSymbol) {
            case "+":
                return result = convertedNum1 + convertedNum2;
            case "-":
                return result = convertedNum1 - convertedNum2;
            case "*":
                return result = convertedNum1 * convertedNum2;
            case "/":
                return result = convertedNum1 / convertedNum2;
            default:
                return 0;
        }


    }
    public static int converterRimToArab (String[] stringArray, String element) {
        int returnNum = 0;
        for (int i = 0; i < stringArray.length; i++) {
            if(stringArray[i].equals(element)) {
                returnNum = i + 1;
                break;
            }
        }
        return returnNum;
    }
    public static int calculateRimNum (int convertedNum1, int convertedNum2, String operationSymbol){
        int result = 0;
        //int convertedNum1 = converterRimToArab(rimNumbers);
        //int convertedNum2 = Integer.parseInt(num2);

        switch (operationSymbol) {
            case "+":
                return result = convertedNum1 + convertedNum2;
            case "-":
                return result = convertedNum1 - convertedNum2;
            case "*":
                return result = convertedNum1 * convertedNum2;
            case "/":
                return result = convertedNum1 / convertedNum2;
            default:
                return 0;
        }

    }
    public static boolean isValid (String word) {

        return word.matches("[I,V,X]+");
    }

    public static String intToRoman(int number) {
        if (number >= 4000 || number <= 0)
            return null;
        StringBuilder result = new StringBuilder();
        for(Integer key : units.descendingKeySet()) {
            while (number >= key) {
                number -= key;
                result.append(units.get(key));
            }
        }
        return result.toString();
    }

    private static final NavigableMap<Integer, String> units;
    static {
        NavigableMap<Integer, String> initMap = new TreeMap<>();
        initMap.put(1000, "M");
        initMap.put(900, "CM");
        initMap.put(500, "D");
        initMap.put(400, "CD");
        initMap.put(100, "C");
        initMap.put(90, "XC");
        initMap.put(50, "L");
        initMap.put(40, "XL");
        initMap.put(10, "X");
        initMap.put(9, "IX");
        initMap.put(5, "V");
        initMap.put(4, "IV");
        initMap.put(1, "I");
        units = Collections.unmodifiableNavigableMap(initMap);
    }

}
