package org.example.view;

import java.util.Scanner;

public class InputView {

    public static int inputIdView() {
        Scanner scanner = new Scanner(System.in);
        int newId = 0;

        System.out.println("Введите id: ");
        while(true) {
            if (scanner.hasNextInt()) {
                newId = scanner.nextInt();
                break;
            } else {
                System.out.println("Необходимо ввести целое число.\nПопробуйте снова:");
                scanner.next();
            }
        }
        return newId;
    }

    public static String inputToyNameView() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("Введите название игрушки:");
        while(true) {
            input = scanner.nextLine();
            if(input.matches("\\W")) {
                System.out.println("В названии допустимы только буквы, цифры и нижнее подчеркивание.\nПопробуйте снова:");
            } else {
                return input;
            }
        }
    }

    public static double inputWeightView() {
        Scanner scanner = new Scanner(System.in);
        double newWeight = 0.0;

        System.out.println("Введите вес(частоту выпадения) игрушки в %: ");
        while(true) {
            if (scanner.hasNextDouble()) {
                newWeight = scanner.nextDouble();
                break;
            } else {
                System.out.println("Необходимо ввести число double.\nПопробуйте снова: ");
                scanner.next();
            }
        }
        return newWeight;
    }
}