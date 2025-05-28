public class Matrix {
    private final int rows;
    private final int cols;
    private final double[][] data;

    // Конструктор
    public Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (data[i].length != cols) {
                throw new IllegalArgumentException("Неправильная форма матрицы: строки разной длины");
            }
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }

    // Метод сложения матриц (только если размеры совпадают)
    public Matrix add(Matrix other) {
        ensureSameDimensions(other);
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    // Метод вычитания матриц (только если размеры совпадают)
    public Matrix subtract(Matrix other) {
        ensureSameDimensions(other);
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return new Matrix(result);
    }

    // Метод умножения матриц (только если this.cols == other.rows)
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException(
                "Невозможно умножить: число столбцов первой матрицы должно быть равно числу строк второй матрицы."
            );
        }

        double[][] result = new double[this.rows][other.cols];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    // Метод вывода матрицы в консоль
    public void print() {
        for (double[] row : data) {
            for (double val : row) {
                System.out.printf("%8.2f", val);
            }
            System.out.println();
        }
    }

    // Проверка совпадения размеров (для сложения и вычитания)
    private void ensureSameDimensions(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одинакового размера для этой операции.");
        }
    }
    public boolean canAddOrSubtract(Matrix other) {
        return this.rows == other.rows && this.cols == other.cols;
    }

    public boolean canMultiply(Matrix other) {
        return this.cols == other.rows;
    }
}


