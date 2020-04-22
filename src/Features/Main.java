package Features;

import Plot.DrawPlot;
import org.jfree.ui.RefineryUtilities;

import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Main {
    //    private static final double Pi  = java.lang.Math.PI;
    private static Scanner scanner = new Scanner(System.in);
    private static Function function = new Function();

    public static void main(String[] args) {
        Double x;
//        double x[] = new double[]{0, Pi / 4, 2 * Pi / 4, 3 * Pi / 4, 4 * Pi / 4, 5 * Pi / 4, 6 * Pi / 4, 7 * Pi / 4, 8 * Pi / 4, 9 * Pi / 4};
//        double y[] = new double[]{0, 0.7071, 1, 0.7071, 0, -0.7071, -1, -0.7071, 0, 0.7071};
        int func_num = Function();
        function.setFunc_num(func_num);
        function.ArrOfXAndY();
        if (checkUser()) {
            x = var();
        } else {
            x = null;
        }
        NewtonInterpolation interpolation = new NewtonInterpolation(func_num, function.getX(), function.getY());
//        Features.NewtonInterpolation interpolation = new Features.NewtonInterpolation(func_num, x, y);
        interpolation.setX_client(x);
        interpolation.tableOfDifferences();
        interpolation.dataset();
        System.out.println(interpolation.toString());
        DrawPlot drawPlot = new DrawPlot(func_num, interpolation.getX_interpolation(), interpolation.getY_interpolation(), function.getX(), function.getY());
        drawPlot.pack();
        RefineryUtilities.centerFrameOnScreen(drawPlot);
        drawPlot.setVisible(true);
    }

    private static int Function() {
        int number;
        boolean mistake;
        do {
            System.out.println(function.toString());
            mistake = false;
            number = scanner.nextInt();
            if (number < 1 || number > 4) {
                mistake = true;
                System.out.println("Введите число в диапазоне от 1 до 4 включительно.");
            }
        } while (mistake);

        return number;
    }

    private static double var() {
        System.out.println("Введите x  для которого надо найти f(x):");
        return scanner.nextDouble();
    }

    private static boolean checkUser() {
        boolean mistake;
        String s;
        System.out.println("Хотите найти  f(x) для x\n");
        System.out.println("Введите \"Да\" или \"Нет\": ");
        do {
            mistake = true;
            s = scanner.nextLine();
            s = s.toLowerCase();
            if (s.equals("да") || s.equals("нет")) {
                mistake = false;
            }
        } while (mistake);

        return s.equals("да");
    }
}
