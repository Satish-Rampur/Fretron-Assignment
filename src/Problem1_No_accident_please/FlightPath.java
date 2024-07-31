package Problem1_No_accident_please;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class FlightPath extends JPanel {
    private final List<int[][]> flights;

    public FlightPath(List<int[][]> flights) {
        this.flights = flights;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Colors for each flight path
        Color[] colors = {Color.RED, Color.BLUE, Color.YELLOW};

        for (int i = 0; i < flights.size(); i++) {
            int[][] coordinates = flights.get(i);
            g2.setColor(colors[i % colors.length]);
            for (int j = 0; j < coordinates.length - 1; j++) {
                g2.drawLine(coordinates[j][0] * 100, coordinates[j][1] * 100,
                        coordinates[j + 1][0] * 100, coordinates[j + 1][1] * 100);
            }
        }
    }

    public static void main(String[] args) {
        // Example coordinates for 3 flights
        List<int[][]> flights = new ArrayList<>();
        flights.add(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        flights.add(new int[][]{{1, 1}, {2, 4}, {3, 2}});
        flights.add(new int[][]{{1, 1}, {4, 2}, {3, 4}});

        // Set up the frame
        JFrame frame = new JFrame("Flight Paths");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new FlightPath(flights));
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
