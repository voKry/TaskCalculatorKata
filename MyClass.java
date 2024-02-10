import java.io.IOException;
import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner userEnterNum = new Scanner(System.in);

        String enteredPhrase = userEnterNum.nextLine();

        String[] withoutSpace = enteredPhrase.split(" ");

        String[] rimNumbers = {
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"
        };
        try {
            if (isValid(withoutSpace[0]) != isValid(withoutSpace[2])){
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Разные системы счисления");
                }

            } else {

                if (withoutSpace.length > 3) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Элементов в выражении больше двух");
                    }


                } else {

                    if (isValid(withoutSpace[0]) && isValid(withoutSpace[2])) {
                        int result = calculateRimNum(converterRimToArab(rimNumbers, withoutSpace[0]),
                                converterRimToArab(rimNumbers, withoutSpace[2]), withoutSpace[1]);
                        if (result <= 0) {
                            try {
                                throw new IOException();
                            } catch (IOException e) {
                                System.out.println("Ошибка: В римской системе нет отрицательных чисел");
                            }
                        } else {
                            System.out.println(rimNumbers[result - 1]);
                        }
                    } else {
                        if ((Integer.parseInt(withoutSpace[0]) > 10) || (Integer.parseInt(withoutSpace[2])) > 10) {
                            System.out.println("Error: First or seconds number more than 10");
                        } else {
                            System.out.println(calculateArabicNum(withoutSpace[0], withoutSpace[2], withoutSpace[1]));
                        }
                    }
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Не является математической операцией");
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

}
