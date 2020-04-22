package Features;

import java.util.Arrays;

class NewtonInterpolation {
    private double x_from_client[];
    private double y_from_client[];
    private double x_interpolation[];
    private double y_interpolation[];
    private double table_of_differences[][];
    private Function function;
    private Double x_client;
    private double y_for_client;

    void setX_client(Double x_client) {
        this.x_client = x_client;
    }

    NewtonInterpolation(int func_num, double[] x, double[] y_from_client) {
        function = new Function(func_num);
        this.x_from_client = Arrays.copyOf(x, x.length);
        this.y_from_client = Arrays.copyOf(y_from_client, y_from_client.length);
        table_of_differences = new double[x.length][];

    }

    double[] getX_interpolation() {
        return x_interpolation;
    }

    double[] getY_interpolation() {
        return y_interpolation;
    }

    void tableOfDifferences() {
        for (int i = 1; i <= x_from_client.length; i++) {
            table_of_differences[i - 1] = new double[x_from_client.length - (i - 1)];
            for (int j = 0; j < x_from_client.length - (i - 1); j++) {
                if (i - 1 == 0) {
                    table_of_differences[i - 1][j] = y_from_client[j];
                } else {
                    table_of_differences[i - 1][j] = table_of_differences[(i - 1) - 1][j + 1] - table_of_differences[(i - 1) - 1][j];
                }
            }
        }

//        for(int i = 0; i < table_of_differences.length; i++) {
//            for(int  j = 0; j < table_of_differences.length - i; j++){
//                System.out.println(table_of_differences[i][j]);
//            }
//            System.out.println();
//        }
    }

//    private double firstNInterpolation(double x) {
//        double first_NInterpolation = 0;
//        interpolation_phase = 0;
//        interpolation_phase = (x - this.x_from_client[0]) / (this.x_from_client[1] - this.x_from_client[0]);
//        double cnt;
//        first_NInterpolation += table_of_differences[0][0];
//        for (int i = 1; i < table_of_differences.length; i ++) {
//            cnt = 1;
//            cnt *= table_of_differences[i][0];
//            for (int j = 0; j < i; j++) {
//                cnt *= ((interpolation_phase - j) / (j + 1));
//            }
//            first_NInterpolation += cnt;
//        }
////        System.out.println(x + " " + first_NInterpolation);
//        return first_NInterpolation;
//    }

    private double NInterpolation(double x) {
        double second_NInterpolation = 0;
        double interpolation_phase;
        interpolation_phase = (x - this.x_from_client[this.x_from_client.length - 1]) / (this.x_from_client[1] - this.x_from_client[0]);
        double cnt;
//        System.out.println("---------" + table_of_differences[0][table_of_differences.length - 1]);
        second_NInterpolation += table_of_differences[0][table_of_differences.length - 1];
        for (int i = 1; i < table_of_differences.length; i++) {
            cnt = 1;
//            System.out.println(table_of_differences[i][table_of_differences.length - (i + 1)]);
            cnt *= table_of_differences[i][table_of_differences.length - (i + 1)];
            for (int j = 0; j < i; j++) {
                cnt *= ((interpolation_phase + j) / (j + 1));
            }
            second_NInterpolation += cnt;
        }
//        System.out.println(x + " " + second_NInterpolation);
        return second_NInterpolation;
    }

    void dataset() {
        double e = 0.0000000001;
        double k = function.step();
        int length = (int) ((((x_from_client[x_from_client.length - 1] + (k)) - x_from_client[0]) / k) + e);
        x_interpolation = new double[length];
        y_interpolation = new double[length];
        int j = 0;
        for (double i = x_from_client[0]; i < (x_from_client[x_from_client.length - 1] + (k)); i += k, j++) {
            x_interpolation[j] = i;
            y_interpolation[j] = NInterpolation(i);
        }

        if (x_client != null) {
            y_for_client = NInterpolation(x_client);
        }
//        System.out.println("-------------");
//        for(double x: x_interpolation) {
//            System.out.println(x);
//        }
//        System.out.println("-------------");
//        for(double y: y_interpolation) {
//            System.out.println(y);
//        }
    }

    @Override
    public String toString() {
        if (x_client != null) {
            return "{ " +
                    "x = " + x_client +
                    ", y = " + y_for_client +
                    " }";
        }
        return "";
    }
}
