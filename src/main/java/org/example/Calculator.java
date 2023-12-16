package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public static void main(String[] args) {
        int exit = 1;
        while (exit != 0) {
            int num1;
            int num2;
            try {
                System.out.print("Введите число1: ");
                num1 = scanner.nextInt();
                logger.info("Введено число1: " + num1);
                System.out.println("Выберите операцию: " +
                        "1. + " +
                        "2. - " +
                        "3. * " +
                        "4. / ");
                String line = scanner.next();
                logger.info("Введена операция: " + line);
                System.out.print("Введите число2: ");
                num2 = scanner.nextInt();
                logger.info("Введено число2: " + num2);
                if (num2 == 0 && line.equals("/")) {
                    System.out.println("На 0 делить нельзя");
                    logger.error("Деление на 0");
                    break;
                }
                getResult(num1, num2, line, scanner);
                System.out.print("Если хочешь продолжить введи 1. Для выхода введи 0: ");
                exit = scanner.nextInt();
                logger.info("Выбран: " + exit);
            } catch (Exception e) {
                logger.error("Пользователь ввел некорректное число");
                break;
            }
        }
    }

    public static void getResult(int num1, int num2, String line, Scanner scanner) {
        double result = 0.0;
        switch (line) {
            case "+":
                System.out.println(num1 + " + " + num2 + " = " + (result = num1 + num2));
                logger.info("Прошла операция сложения: " + num1 + " + " + num2 + " = " + (result = num1 + num2));
                break;
            case "-":
                System.out.println(num1 + " - " + num2 + " = " + (result = num1 - num2));
                logger.info("Прошла операция вычитания: " + num1 + " - " + num2 + " = " + (result = num1 - num2));
                break;
            case "*":
                System.out.println(num1 + " * " + num2 + " = " + (result = num1 * num2));
                logger.info("Прошла операция умножения: " + num1 + " * " + num2 + " = " + (result = num1 * num2));
                break;
            case "/":
                System.out.println(num1 + " / " + num2 + " = " + (result = num1 / num2));
                logger.info("Прошла операция деления: " + num1 + " / " + num2 + " = " + (result = num1 / num2));
                break;
            default:
                System.out.println("Операция некорретна. Попробуйте сначала!");
                break;
        }
    }
}