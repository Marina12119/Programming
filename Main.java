import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первую матрицу:");
        Matrix m1 = inputMatrix(scanner);

        System.out.println("Введите вторую матрицу:");
        Matrix m2 = inputMatrix(scanner);

        if (m1.canAddOrSubtract(m2)) {
            System.out.println("Сложение:");
            m1.add(m2).print();

            System.out.println("Вычитание:");
            m1.subtract(m2).print();
        }

        if (m1.canMultiply(m2)) {
            System.out.println("Умножение:");
            m1.multiply(m2).print();
        }

        if (!m1.canAddOrSubtract(m2) && !m1.canMultiply(m2)) {
            System.out.println("Невозможно выполнить ни одну операцию с заданными матрицами.");
        }
    }

    // Метод для ввода матрицы
    public static Matrix inputMatrix(Scanner scanner) {
        System.out.print("Введите количество строк: ");
        int rows = scanner.nextInt();

        System.out.print("Введите количество столбцов: ");
        int cols = scanner.nextInt();

        double[][] data = new double[rows][cols];
        System.out.println("Введите элементы матрицы построчно:");

        for (int i = 0; i < rows; i++) {
            System.out.printf("Строка %d:%n", i + 1);
            for (int j = 0; j < cols; j++) {
                System.out.printf("  Элемент [%d][%d]: ", i + 1, j + 1);
                data[i][j] = scanner.nextDouble();
            }
        }

        return new Matrix(data);
    }
}
