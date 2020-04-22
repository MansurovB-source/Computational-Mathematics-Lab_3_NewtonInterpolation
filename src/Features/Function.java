package Features;

import java.util.Scanner;

public class Function {
    private static final double Pi = Math.PI;
    private int func_num;
    private double x[];
    private double y[];

    public double[] getX() {
        return x;
    }

    double[] getY() {
        return y;
    }

    Function() {
    }

    public int getFunc_num() {
        return func_num;
    }

    public void setFunc_num(int func_num) {
        this.func_num = func_num;
    }

    public Function(int func_num) {
        this.func_num = func_num;
    }

    public double funcValue(double x) {
        if (func_num == 1) {
            return Math.sin(x);
        } else if (func_num == 2) {
            return Math.cos(x) * Math.pow(x, 0.5);
        } else {
            return (x * Math.sin((2 * x) + (Pi / 4))) + 1;
        }
    }

    void ArrOfXAndY() {
        Scanner scanner = new Scanner(System.in);
        boolean mistake;
        showArrOfX();
        int number;
        do {
            mistake = false;
            number = scanner.nextInt();
            if (number < 1 || number > 4) {
                mistake = true;
                System.out.println("Число должно быть в диапазоне от 0 до 4");
            }
        } while (mistake);

        if (number == 1) {
            if (func_num == 1) {
                x = new double[]{0, Pi / 2, Pi, 3 * Pi / 2, 2 * Pi};
                y = new double[]{0, 1, 0, -1, 0};
                //System.out.println(x.length + " " + y.length);
            } else if (func_num == 2) {
                x = new double[]{0, 2, 4, 6, 8, 10};
                y = new double[]{0, -0.59, -1.31, 2.35, -0.41, -2.65};
            } else {
                x = new double[]{-10, -5, 0, 5, 10};
                y = new double[]{4.57, 2.04, 1, -3.89, 10.34};
            }
        } else if (number == 2) {
            if (func_num == 1) {
                x = new double[]{0, Pi / 4, 2 * Pi / 4, 3 * Pi / 4, 4 * Pi / 4, 5 * Pi / 4, 6 * Pi / 4, 7 * Pi / 4, 8 * Pi / 4, 9 * Pi / 4};
                y = new double[]{0, 0.7071, 1, 0.7071, 0, -0.7071, -1, -0.7071, 0, 0.7071};
                //System.out.println(x.length + " " + y.length);
            } else if (func_num == 2) {
                x = new double[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                y = new double[]{0, 0.54, -0.59, -1.71, -1.31, 0.63, 2.35, 1.99, -0.41, -2.73, -2.65};
            } else {
                x = new double[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                y = new double[]{4.57, -7.98, 4.79, 5.23, -4.86, 2.04, 4.21, -1.63, 0.85, 1.94, 1, 1.35, -0.99, 2.44, 3.39, -3.89, 2.3, 6.58, -6.05, 0.42, 10.34};
            }
        } else if (number == 3) {
            if (func_num == 1) {
                x = new double[]{0, Pi / 4, 2 * Pi / 4, 3 * Pi / 4, 4 * Pi / 4, 5 * Pi / 4, 6 * Pi / 4, 7 * Pi / 4, 8 * Pi / 4, 9 * Pi / 4};
                y = new double[]{0, 0.7071, 1, 0.7071, 0, -5, -1, -0.7071, 0, 0.7071};
                //System.out.println(x.length + " " + y.length);
            } else if (func_num == 2) {
                x = new double[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                y = new double[]{0, 0.54, -0.59, -1.71, -1.31, 5, 2.35, 1.99, -0.41, -2.73, -2.65};
            } else {
                x = new double[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                y = new double[]{4.57, -7.98, 4.79, 5.23, -4.86, 2.04, -15, -1.63, 0.85, 1.94, 1, 1.35, -0.99, 2.44, 3.39, -3.89, 2.3, 6.58, -6.05, 0.42, 10.34};
            }
        } else {
            if (func_num == 1) {
                x = new double[]{0.5 * Pi, 1.5 * Pi, 2.5 * Pi, 3.5 * Pi, 4.5 * Pi, 5.5 * Pi, 6.5 * Pi, 7.5 * Pi, 8.5 * Pi, 9.5 * Pi, 10.5 * Pi, 11.5 * Pi};
                y = new double[]{1, -1, 1, -1, 1, -1, 1, -1, 1, -1, 1, -1};
                //System.out.println(x.length + " " + y.length);
            } else if (func_num == 2) {
                x = new double[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
                y = new double[]{-2.653, 1.825, 0.845, -4.218, 6.823, -7.377, 5.299, -0.987, -4.251, 8.623};
            } else {
                x = new double[]{-10, -5, 0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
                y = new double[]{4.6, 2, 1, -3.9, 10.3, -7.8, 2.1, 13.4, -25.7, 35.8, -30.2, 15.2, 13.6};
            }
        }
    }

    double step() {
        if (func_num == 1) {
            return Pi / 4;
        } else {
            return 1;
        }
    }

    private void showArrOfX() {
        System.out.println("Выберите множество точек:");
        if (func_num == 1) {
            System.out.println("1) 5 точек в интервале [0:2Pi]: " +
                    "[0, Pi/2, PI, 3Pi/2, 2Pi]\n" +
                    "2) 10 точек(без изменения значения функции) в интервале [0:2Pi]: " +
                    "[0, Pi/4, 2Pi/4, 3Pi/4, 4Pi/4, 5Pi/4, 6Pi/4, 7Pi/4, 8Pi/4, 9Pi/4]\n" +
                    "3) 10 точек(с изменениям значения функции)[0:2Pi]: \n" +
                    "4) 12 точек в интервале [0:50Pi]: " +
                    "[0, Pi, 2.5Pi, 3.5Pi, 4Pi, 5.5Pi, 6PI, 7Pi, 8.5Pi, 9Pi, 10,5Pi, 11Pi]");
        } else if (func_num == 2) {
            System.out.println("1) 6 точек в интервале [0:10]: " +
                    "[0, 2, 4, 6, 8, 10]\n" +
                    "2) 11 точек(без изменения значения функции) в интервале [0:10]: " +
                    "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\n" +
                    "3) 11 точек(с изменениям значения функции) в интервале [0:10]: \n" +
                    "4) 10 точек в интервале [0:100]: " +
                    "[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]");
        } else {
            System.out.println("1) 5 точек в интервале [-10:10]: " +
                    "[0, 2, 4, 6, 8, 10]\n" +
                    "2) 21 точек(без изменения значения функции) в интервале [-10:10]: " +
                    "[-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\n" +
                    "3) 21 точек(с изменениям значения функции) в интервале [-10:10]: \n" +
                    "4) 13 точек в интервале [-10:50]: " +
                    "[-10, -5, 0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50]");
        }
    }


    @Override
    public String toString() {
        return "Выберите функцию: \n" +
                "1) sin(x)\n" +
                "2) cos(x) * (x^(1/2))\n" +
                "3) x*sin(2*x + Pi/4) + 1";
    }
}
