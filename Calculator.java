package calculator2;

import java.util.Scanner;

public class Calculator {
    private static boolean its_an_arabic_numbers = true;

    public Calculator() {
    }

    private static String[] pars(String input) {
        String[] parsed_input = input.split(" ");
        if (parsed_input.length != 3) {
            Scanner input_a_value_again = new Scanner(System.in);
            System.out.println("Неверный формат ввода данных. Введите выражение, разделяя  пробелом");
            input = input_a_value_again.nextLine();
            return pars(input);
        } else {
            return parsed_input;
        }
    }

    public static void main(String[] args) {
        Scanner input_a_value = new Scanner(System.in);
        System.out.print("Введите выражение: ");

        for(String input = input_a_value.nextLine(); !input.isEmpty(); input = input_a_value.nextLine()) {
            String[] parsed_input = pars(input);
            String operation = parsed_input[1];
            int value1 = 0;
            int value2 = 0;

            try {
                value1 = Integer.parseInt(parsed_input[0]);
                value2 = Integer.parseInt(parsed_input[2]);
            } catch (NumberFormatException var9) {
                its_an_arabic_numbers = false;
                System.out.println("Введены римские цифры");
            }

            Object values;
            if (its_an_arabic_numbers) {
                values = new Arabic(value1, value2);
            } else {
                values = new Romes(parsed_input[0], parsed_input[2]);
            }

            if (operation.equals("+")) {
                ((Number)values).sum();
            } else if (operation.equals("-")) {
                ((Number)values).sub();
            } else if (!operation.equals("/") && !operation.equals(":")) {
                if (operation.equals("*") || operation.equals("x")) {
                    ((Number)values).mul();
                }
            } else {
                ((Number)values).div();
            }

            if (its_an_arabic_numbers) {
                System.out.println("Ответ: " + ((Number)values).getResult());
            } else {
                System.out.println("Ответ: " + ((Number)values).getStringResult());
            }

            System.out.println();
            System.out.print("Введите следующее выражение: ");
        }

        System.out.println("Вы вышли из калькулятора");
    }
}