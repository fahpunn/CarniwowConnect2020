import java.awt.*;

public class StaticItem {

    private String name;
    private Image img;
    private int x_absolute;
    private int y_absolute;
    private int size_max;
    private int size_now;
    private int container_size_max;
    private int container_size_now;

    public StaticItem(String name, Image img,
           int x, int y, int size, int c_size) {
        this.container_size_max = c_size;
        this.container_size_now = c_size;
        this.name = name;
        this.img = img;
        this.x_absolute = x;
        this.y_absolute = y;
        this.size_max = size;
        this.size_now = size;
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

    public int getSize_max() {
        return size_max;
    }

    public void setSize_max(int size_max) {
        this.size_max = size_max;
    }

    public int getSize_now() {
        return size_now;
    }

    public void setSize_now(int size_now) {
        this.size_now = size_now;
    }

    public int getContainer_size_max() {
        return container_size_max;
    }

    public void setContainer_size_max(int container_size_max) {
        this.container_size_max = container_size_max;
    }

    public int getContainer_size_now() {
        return container_size_now;
    }

    public void setContainer_size_now(int container_size_now) {
        this.container_size_now = container_size_now;
    }

    public int getWidth() {
        return img.getWidth(null);
    }

    public int getHeight() {
        return img.getHeight(null);
    }

}
