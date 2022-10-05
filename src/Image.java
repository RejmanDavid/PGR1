import java.awt.image.BufferedImage;

public class Image {
    private final BufferedImage img;//really dont see the point of this
    public Image(int width, int height){
        img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    }
    int getPixel(int x,int y){
        int color = 0;
        return color;
    }
    void drawPixel(int x,int y,int color){
        img.setRGB(x,y,color);
    }
}
