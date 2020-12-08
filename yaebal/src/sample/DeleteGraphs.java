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
public class DeleteGraphs extends JFrame {

    private static final long serialVersionUID = 1L;

    public DeleteGraphs(String title) {
        super(title);
        // Create dataset
        DefaultCategoryDataset dataset = createDataset();
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Arraylist vs Linkedlist Delete", // Chart title
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



        dataset.addValue(10350, series1, "10");
        dataset.addValue(5363, series1, "100");
        dataset.addValue(18249, series1, "1000");
        dataset.addValue(3149, series1, "10000");
        dataset.addValue(22272, series1, "100000");

        dataset.addValue(21000, series2, "10");
        dataset.addValue(4181, series2, "100");
        dataset.addValue(13419, series2, "1000");
        dataset.addValue(107013, series2, "10000");
        dataset.addValue(854703, series2, "100000");
        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DeleteGraphs example = new DeleteGraphs("Graphs");
            example.setAlwaysOnTop(true);
            example.pack();
            example.setSize(600, 400);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}