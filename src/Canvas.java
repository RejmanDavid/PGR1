import javax.swing.*;
import java.awt.*;

public class Canvas {

    private JFrame frame;
    public Canvas(int width, int height) {
        frame = new JFrame();

        frame.setLayout(new BorderLayout());
        frame.setTitle("MSPaint++" /*+ this.getClass().getName()*/);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(width,height);

        frame.pack();
        frame.setVisible(true);
    }

//    private JFrame frame;
//    private JPanel panel;
//    private BufferedImage img;
//
//    public Canvas(int width, int height) {
//        frame = new JFrame();
//
//        frame.setLayout(new BorderLayout());
//        frame.setTitle("UHK FIM PGRF : " + this.getClass().getName());
//        frame.setResizable(false);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//
//        panel = new JPanel() {
//            private static final long serialVersionUID = 1L;
//
//            @Override
//            public void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                present(g);
//            }
//        };
//
//        panel.setPreferredSize(new Dimension(width, height));
//
//        frame.add(panel, BorderLayout.CENTER);
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    public void clear() {
//        Graphics gr = img.getGraphics();
//        gr.setColor(new Color(0x2f2f2f));
//        gr.fillRect(0, 0, img.getWidth(), img.getHeight());
//    }
//
//    public void present(Graphics graphics) {
//        graphics.drawImage(img, 0, 0, null);
//    }
//
//    public void draw() {
//        clear();
//        img.setRGB(10, 10, 0xffff00);
//    }
//
//    public void start() {
//        draw();
//        panel.repaint();
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new Canvas(800, 600).start());
//    }

}