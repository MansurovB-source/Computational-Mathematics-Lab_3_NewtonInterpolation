package Plot;

import Features.Function;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

class DataSet {

    static XYDataset createDataset(int func_num, double x[], double y[], double x_node[], double y_node[]) {
        Function function = new Function(func_num);
        XYSeriesCollection dataset = new XYSeriesCollection();

        XYSeries func_series = new XYSeries("функция");
        for (double aX : x) {
            func_series.add(aX, function.funcValue(aX));
        }
        dataset.addSeries(func_series);

        XYSeries interpolation_series = new XYSeries("интерполяция");
        for (int i = 0; i < x.length; i++) {
            interpolation_series.add(x[i], y[i]);
        }
        dataset.addSeries(interpolation_series);

        XYSeries node_unit = new XYSeries("Узлы");
        for (int i = 0; i < x_node.length; i++) {
            node_unit.add(x_node[i], y_node[i]);
        }
        dataset.addSeries(node_unit);

        return dataset;
    }
}
