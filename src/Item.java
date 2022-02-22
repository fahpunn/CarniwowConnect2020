import java.awt.*;

public class Item {

    private String name;
    private Image img;
    private int x_absolute;
    private int y_absolute;
    private int x;
    private int y;

    public Item(String name, Image img,
                int x, int y) {
        this.name = name;
        this.img = img;
        this.x_absolute = x;
        this.y_absolute = y;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX_absolute() {
        return x_absolute;
    }

    public void setX_absolute(int x_absolute) {
        this.x_absolute = x_absolute;
    }

    public int getY_absolute() {
        return y_absolute;
    }

    public void setY_absolute(int y_absolute) {
        this.y_absolute = y_absolute;
    }

    public int getWidth() {
        return img.getWidth(null);
    }

    public int getHeight() {
        return img.getHeight(null);
    }

}
