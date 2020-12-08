package sample;


import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author imssbora
 *
 */
public class AddingGraphs extends JFrame {

    private static final long serialVersionUID = 1L;

    public AddingGraphs(String title) {
        super(title);
        // Create dataset
        DefaultCategoryDataset dataset = createDataset();
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Arraylist vs Linkedlist ADD", // Chart title
                "amount", // X-Axis Label
                "average time", // Y-Axis Label
                dataset
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private DefaultCategoryDataset createDataset() {

        String series1 = "Arraylist";
        String series2 = "Linkedlist";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();



        dataset.addValue(1910, series1, "10");
        dataset.addValue(4783, series1, "100");
        dataset.addValue(1089, series1, "1000");
        dataset.addValue(919, series1, "10000");
        dataset.addValue(532, series1, "100000");

        dataset.addValue(4670, series2, "10");
        dataset.addValue(2035, series2, "100");
        dataset.addValue(682, series2, "1000");
        dataset.addValue(269, series2, "10000");
        dataset.addValue(263, series2, "100000");
        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddingGraphs example = new AddingGraphs("Graphs");
            example.setAlwaysOnTop(true);
            example.pack();
            example.setSize(600, 400);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}