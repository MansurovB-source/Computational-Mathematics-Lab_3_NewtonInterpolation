package Plot;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

import java.awt.*;

public class DrawPlot extends ApplicationFrame {

    public DrawPlot(int func_num, double x[], double y[], double x_node[], double y_node[]) {
        super("");
        JFreeChart chart = createChart(func_num, x, y, x_node, y_node);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(560, 480));
        setContentPane(chartPanel);
    }

    private JFreeChart createChart(int func_num, double x[], double y[], double x_node[], double y_node[]) {
        final JFreeChart chart;

        chart = ChartFactory.createXYLineChart(
                "Демонстрация интерполяции",
                null,
                null,
                null,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );

        chart.setBackgroundPaint(Color.WHITE);
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(new Color(232, 232, 232));

        //Цвет сетки графика
        plot.setDomainGridlinePaint(Color.gray);
        plot.setRangeGridlinePaint(Color.gray);
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
//        plot.setRangeGridlinePaint(Color.BLACK);
//        plot.setDomainGridlinePaint(Color.BLACK);

        // Определение отступа меток делений
        plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));

        // Скрытие осевых линий и меток делений
        ValueAxis axis = plot.getDomainAxis();
        axis.setAxisLineVisible(true);

        //Настройка NumberAxis
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setAxisLineVisible(true);
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // Настройка XYSplineRenderer
        // Precision: количество отрезков между двумя точками [по умолчанию: 5]
        XYSplineRenderer renderer = new XYSplineRenderer();
        renderer.setPrecision(80);
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesLinesVisible(2, false);
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesShapesVisible(2, true);
        renderer.setSeriesPaint(0, Color.orange);
        renderer.setSeriesPaint(1, Color.red);
        renderer.setSeriesPaint(2, Color.black);
        renderer.setSeriesStroke(0, new BasicStroke(2.f));
        renderer.setSeriesStroke(
                1, new BasicStroke(2.f, BasicStroke.CAP_ROUND,
                        BasicStroke.JOIN_ROUND,
                        1.0f, new float[]{10.0f, 6.0f}, 0.0f)
        );


        //Набор данных
        XYDataset dataset = DataSet.createDataset(func_num, x, y, x_node, y_node);
        plot.setDataset(dataset);
        plot.setRenderer(renderer);

        return chart;
    }
}
