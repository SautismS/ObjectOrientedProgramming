import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Picture {
    private BufferedImage image;
    private int width;
    private int height;
    public Picture(String filename) throws IOException {
        File file = new File(filename);
        image = ImageIO.read(file);
        width = image.getWidth();
        height = image.getHeight();
    }
    public Picture(int width, int height){
        this.width = width;
        this.height = height;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void setColor(int col, int row, Color c){
        image.setRGB(col, row, c.getRGB());
    }
    public Color getColor(int col, int row){
        int rgb = image.getRGB(col, row);
        return new Color(rgb);
    }
    public void save(String filename) throws IOException {
        String suffix = filename.substring(filename.lastIndexOf('.')+1);
        if (suffix.equalsIgnoreCase("png") || suffix.equalsIgnoreCase("jpg"))
            ImageIO.write(image, suffix, new File(filename));
    }
    public void darker(){
        for(int i = 0; i < getWidth(); i++)
            for(int j = 0; j < getHeight(); j++){
                Color c = getColor(i,j);
                setColor(i,j, c.darker());
            }
    }

    public static void main(String[] args) throws IOException {
        Picture pic = new Picture("sloth.png");
        Picture.toGray(pic);
        pic.save("gray.png");
    }
    public static void toGray(Picture source){
        for(int i = 0; i < source.getWidth(); i++)
            for(int j = 0; j < source.getHeight(); j++){
                Color c = source.getColor(i,j);
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int comp = (int)(r*0.299 + g*0.587 + b*0.114);
                source.setColor(i,j,new Color(comp,comp,comp));
            }
    }
}
