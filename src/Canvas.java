import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HexFormat;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Canvas {

    private JFrame frame;
    private JPanel panel;
    private BufferedImage img;
    private int x = 1;
    private int y = 1;
    private int pixelSize = 10;
    int color = 0xFFFFFF;
    public Canvas(int width, int height) {
        frame = new JFrame();

        frame.setLayout(new BorderLayout());
        frame.setTitle("MSPaint++" /*+ this.getClass().getName()*/);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((dim.width-width)/2, (dim.height-height)/2);

        img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //img.setRGB(0,0,/*width,height,new int[] {*/0xFFFFFF/*},0,1*/);
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img,0,0,null);
            }
        };
        panel.setPreferredSize(new Dimension(width,height));

        frame.add(panel,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

        panel.requestFocus();
        panel.requestFocusInWindow();
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {//TODO fix
                super.mouseMoved(e);
                System.out.println("event");
                DrawLine(img.getWidth()/2/pixelSize,img.getWidth()/2/pixelSize,e.getX(),e.getY());
            }
        });
        panel.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyChar()){
                    case'w':
                        if(y==0){break;}
                        y--;
                        PaintPixel(x,y);
                        panel.repaint();
                        break;
                    case'a':
                        if(x==0){break;}
                        x--;
                        PaintPixel(x,y);
                        panel.repaint();
                        break;
                    case's':
                        if(y==height){break;}
                        y++;
                        PaintPixel(x,y);
                        panel.repaint();
                        break;
                    case'd':
                        if(x==width){break;}
                        x++;
                        PaintPixel(x,y);
                        panel.repaint();
                        break;
                    case'c':
                        Clear();
                        panel.repaint();
                        break;
                    case'g':
                        int raw = img.getRGB(x*pixelSize,y*pixelSize);
                        String hex = Integer.toHexString(raw);
                        int red = HexFormat.fromHexDigits(hex.substring(2,4));
                        int green = HexFormat.fromHexDigits(hex.substring(4,6));
                        int blue = HexFormat.fromHexDigits(hex.substring(6,8));

                        System.out.println("------------------");
                        System.out.println("Red: "+red);
                        System.out.println("Green: "+green);
                        System.out.println("Blue: "+blue);
                        break;
                    case'1':
                        color = 0xFFFFFF;
                        break;
                    case'2':
                        color = 0xFF0000;
                        break;
                    case'3':
                        color = 0x00FF00;
                        break;
                    case'4':
                        color = 0x0000FF;
                        break;
                }
            }
        });
    }
    private void PaintPixel(int x,int y){
        int[] pixel = new int[(int)Math.pow(pixelSize,2)];
        for (int i = 0;i<pixel.length;i++){
            pixel[i] = color;
        }
        img.setRGB(x*pixelSize,y*pixelSize,pixelSize,pixelSize,pixel,0,1);

    }
    private void Clear(){
        img = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_RGB);
    }
    private void DrawLine(int x1,int y1,int x2, int y2){
        //System.out.println(x1);
        Clear();
        PaintPixel(x1,y1);
        PaintPixel(x2,y2);
        panel.repaint();
    }
}