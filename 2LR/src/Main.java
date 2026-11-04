void main() {
    Random random = new Random();
    boolean running = true;
    while (running) {
        int choice = Integer.parseInt(IO.readln("Выберите пункт меню: "));
        switch (choice) {
            case 1 -> {
                int size = Integer.parseInt(IO.readln("Введите размер массива: "));
                int[] array = new int[size];
                for (int i = 0; i < size; i++) {
                    array[i] = random.nextInt(-50, 51);
                }
                IO.print("Массив: ");
                for (int value : array) {
                    IO.print(value + " ");
                }
                IO.println();
                int sum = 0;
                for (int value : array) {
                    sum += value;
                }
                IO.println("Сумма всех элементов массива: " + sum);
            }
            case 2 -> {
                int size = Integer.parseInt(IO.readln("Введите размер матрицы (NxN): "));
                int[][] matrix = new int[size][size];
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] = random.nextInt(-1, 1);
                    }
                }
                IO.println("Матрица:");
                for (int[] row : matrix) {
                    for (int value : row) {
                        IO.print(String.format("%5d", value));
                    }
                    IO.println();
                }
                int sum = 0;
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length -i -1; j++) {
                        sum += matrix[i][j];
                    }
                }
                IO.println("Сумма элементов побочной диагонали: " + sum);
            }
            case 0 -> running = false;
            default -> IO.println("Такого пункта меню нет, попробуйте снова");
        }
        IO.println();
    }
}