import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class Gameplay extends JPanel {

    private static final int TYPE_ICE = 0;
    private static final int TYPE_POPCORN = 1;
    private static final int TYPE_MARSHMELLO_PLAIN = 21;
    private static final int TYPE_MARSHMELLO_BURNED = 22;
    private static final int TYPE_SYRUP_RED = 31;
    private static final int TYPE_SYRUP_YELLOW = 32;
    private static final int TYPE_SYRUP_BLUE = 33;
    private static final int TYPE_SYMBOL_STAR = 41;
    private static final int TYPE_SYMBOL_SUN = 42;
    private static final int TYPE_SYMBOL_MOON = 43;
    private static final int TYPE_PENGUIN = 5;
    private static final int TYPE_POPCORN_GLASS = 6;
    private static final int TYPE_SPRINKLE = 7;
    private static final int TYPE_OJO = 8;
    private static final int TYPE_GRILL = 9;
    private static final int TYPE_BIN = 10;
    private static final int TYPE_CUSTOMER_1 = 11;
    private static final int TYPE_CUSTOMER_2 = 12;
    private static final int TYPE_CUSTOMER_3 = 13;
    private static final int TYPE_CUSTOMER_4 = 14;

    private Image bg;
    private final Image clock;
    private final Overall overall;
    private int score;

    private final ArrayList<Item> iceList = new ArrayList<>();
    private final ArrayList<Item> marshList = new ArrayList<>();
    private final ArrayList<Item> popList = new ArrayList<>();
    private StaticItem ojo;
    private StaticItem sprinkle;
    private StaticItem star;
    private StaticItem sun;
    private StaticItem moon;
    private StaticItem syrupRed;
    private StaticItem syrupYellow;
    private StaticItem syrupBlue;
    private StaticItem grill;
    private StaticItem popcornGlass;
    private StaticItem penguin;
    private StaticItem bin;

    private Customer c1, c2, c3, c4;

    private Timer t1, t2, t3, t4;
    private int s1, s2, s3, s4;

    public Gameplay(Overall parent) {

        // Set Background Image
        score = 0;
        URL urlBg = getClass().getResource("/resource/Background.png");
        this.bg = new ImageIcon(urlBg).getImage();

        urlBg = getClass().getResource("/resource/Timer.png");
        this.clock =  new ImageIcon(urlBg).getImage();

        this.overall = parent;
        s1 = overall.getDifficulty();
        s2 = overall.getDifficulty();
        s3 = overall.getDifficulty();
        s4 = overall.getDifficulty();

        // Counting Timer
        t1Timer();
        t1.start();
        t2Timer();
        t2.start();
        t3Timer();
        t3.start();
        t4Timer();
        t4.start();

        // Create Item
        createIce(25);
        createIce(110);
        createIce(195);
        createPopcorn(860);
        createPopcorn(935);
        createPopcorn(1010);
        createMarshmelloBurned(650);
        createMarshmelloBurned(710);
        createMarshmelloBurned(770);
        createSyrupRed();
        createSyrupYellow();
        createSyrupBlue();
        createGrill();
        createPopcornGlass();
        createPenguin();
        createBin();
        createOjo();
        createSprinkle();
        createStar();
        createSun();
        createMoon();

        createCustomer1();
        createCustomer2();
        createCustomer3();
        createCustomer4();

        IceListener iceAction = new IceListener(
                this.penguin,
                this.bin,
                this.syrupRed,
                this.syrupYellow,
                this.syrupBlue,
                this.ojo,
                this.sprinkle,
                this.iceList,
                this);

        this.addMouseListener(iceAction);
        this.addMouseMotionListener(iceAction);

        PopListener popAction = new PopListener(
                this.bin,
                this.star,
                this.sun,
                this.moon,
                this.popcornGlass,
                this.popList,
                this);

        this.addMouseListener(popAction);
        this.addMouseMotionListener(popAction);

        MarshListener marshAction = new MarshListener(
                this.bin,
                this.grill,
                this.marshList,
                this);

        this.addMouseListener(marshAction);
        this.addMouseMotionListener(marshAction);

        PenguinListener penguinAction = new PenguinListener(
                this.penguin,
                this);

        this.addMouseListener(penguinAction);

        PopGlassListener popGlassAction = new PopGlassListener(
                this.popcornGlass,
                this);

        this.addMouseListener(popGlassAction);

        GrillListener grillAction = new GrillListener(
                this.grill,
                this);

        this.addMouseListener(grillAction);

        SyrupListener syrupAction1 = new SyrupListener(
                this.syrupRed,
                this);

        this.addMouseListener(syrupAction1);

        SyrupListener syrupAction2 = new SyrupListener(
                this.syrupYellow,
                this);

        this.addMouseListener(syrupAction2);

        SyrupListener syrupAction3 = new SyrupListener(
                this.syrupBlue,
                this);

        this.addMouseListener(syrupAction3);

        SyrupListener syrupAction4 = new SyrupListener(
                this.sprinkle,
                this);

        this.addMouseListener(syrupAction4);

        SyrupListener syrupAction5 = new SyrupListener(
                this.ojo,
                this);

        this.addMouseListener(syrupAction5);
    }

    protected void createIce(int x) {
        Image img = this.getItemImage(0);
        Item item = new Item("Ice_Empty", img, x, 540);
        this.iceList.add(item);
    }

    protected void createPopcorn(int x) {
        Image img = this.getItemImage(1);
        Item item = new Item("Popcorn_Empty", img, x, 480);
        this.popList.add(item);
    }

    protected void createMarshmelloBurned(int x) {
        Image img = this.getItemImage(22);
        Item item = new Item("Marshmello_Burned", img, x, 500);
        this.marshList.add(item);
    }

    private void createSyrupRed() {
        Image img = this.getItemImage(31);
        this.syrupRed = new StaticItem("Syrup_Red", img, 150, 300, 3, 3);
    }

    private void createSyrupYellow() {
        Image img = this.getItemImage(32);
        this.syrupYellow = new StaticItem("Syrup_Yellow", img, 275, 300, 3, 3);
    }

    private void createSyrupBlue() {
        Image img = this.getItemImage(33);
        this.syrupBlue = new StaticItem("Syrup_Blue", img, 400, 300, 3, 3);
    }

    private void createGrill() {
        Image img = this.getItemImage(9);
        this.grill = new StaticItem("Grill", img, 650, 505, 3, 0);
    }

    private void createPopcornGlass() {
        Image img = this.getItemImage(6);
        this.popcornGlass = new StaticItem("Popcorn_Glass", img, 1075, 300, 3, 3);
    }

    private void createPenguin() {
        Image img = this.getItemImage(5);
        this.penguin = new StaticItem("Penguin", img, 0, 375, 3, 3);
    }

    private void createBin() {
        Image img = this.getItemImage(10);
        this.bin = new StaticItem("Bin", img, 1010, 600, 0, 0);
    }

    private void createOjo() {
        Image img = this.getItemImage(8);
        this.ojo = new StaticItem("Ojo", img, 580, 425, 7, 3);
    }

    private void createSprinkle() {
        Image img = this.getItemImage(7);
        this.sprinkle = new StaticItem("Sprinkle", img, 530, 445, 3, 3);
    }

    private void createStar() {
        Image img = this.getItemImage(41);
        this.star = new StaticItem("Star", img, 850, 405, 0, 0);
    }

    private void createSun() {
        Image img = this.getItemImage(42);
        this.sun = new StaticItem("Sun", img, 929, 394, 0, 0);
    }

    private void createMoon() {
        Image img = this.getItemImage(43);
        this.moon = new StaticItem("Moon", img, 1005, 400, 0, 0);
    }

    protected void createCustomer1() {
        Image img = this.getItemImage(11);
        this.c1 = new Customer(img, 30, 70);
    }

    protected void createCustomer2() {
        Image img = this.getItemImage(13);
        this.c2 = new Customer(img, 300, 70);
    }

    protected void createCustomer3() {
        Image img = this.getItemImage(12);
        this.c3 = new Customer(img, 570, 70);
    }

    protected void createCustomer4() {
        Image img = this.getItemImage(14);
        this.c4 = new Customer(img, 840, 70);
    }

    private Image getItemImage(int type) {
        String getFile = "";
        switch (type) {
            case TYPE_ICE -> getFile += "Ice_Empty";
            case TYPE_POPCORN -> getFile += "Popcorn_Empty";
            case TYPE_MARSHMELLO_PLAIN -> getFile += "Marshmello_Plain";
            case TYPE_MARSHMELLO_BURNED -> getFile += "Marshmello_Burned";
            case TYPE_SYRUP_RED -> getFile += "Syrup_Red_Full";
            case TYPE_SYRUP_BLUE -> getFile += "Syrup_Blue_Full";
            case TYPE_SYRUP_YELLOW -> getFile += "Syrup_Yellow_Full";
            case TYPE_SYMBOL_STAR -> getFile += "Symbol_Star";
            case TYPE_SYMBOL_SUN -> getFile += "Symbol_Sun";
            case TYPE_SYMBOL_MOON -> getFile += "Symbol_Moon";
            case TYPE_PENGUIN -> getFile += "Penguin_Ice";
            case TYPE_POPCORN_GLASS -> getFile += "Container_Popcorn_Full";
            case TYPE_SPRINKLE -> getFile += "Sprinkle_Full";
            case TYPE_OJO -> getFile += "Ojo_Full";
            case TYPE_GRILL -> getFile += "Grill";
            case TYPE_BIN -> getFile += "Bin";
            case TYPE_CUSTOMER_1 -> getFile += "Customer_2";
            case TYPE_CUSTOMER_2 -> getFile += "Customer_3";
            case TYPE_CUSTOMER_3 -> getFile += "Customer_4";
            case TYPE_CUSTOMER_4 -> getFile += "Customer_5";
        }
        getFile += ".png";

        URL urlImg = getClass().getResource("/resource/" + getFile);
        return new ImageIcon(urlImg).getImage();
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(this.bg, 0, 0, null);

        g.drawImage(this.c1.getImg(), this.c1.getX(), this.c1.getY(), null);
        g.drawImage(this.c1.getItem1Img(), this.c1.getX()+15, this.c1.getY()+10, null);
        g.drawImage(this.c1.getItem2Img(), this.c1.getX()+15, this.c1.getY()+120, null);

        g.drawImage(this.c2.getImg(), this.c2.getX(), this.c2.getY(), null);
        g.drawImage(this.c2.getItem1Img(), this.c2.getX()+15, this.c2.getY()+10, null);
        g.drawImage(this.c2.getItem2Img(), this.c2.getX()+15, this.c2.getY()+120, null);

        g.drawImage(this.c3.getImg(), this.c3.getX(), this.c3.getY(), null);
        g.drawImage(this.c3.getItem1Img(), this.c3.getX()+15, this.c3.getY()+10, null);
        g.drawImage(this.c3.getItem2Img(), this.c3.getX()+15, this.c3.getY()+120, null);

        g.drawImage(this.c4.getImg(), this.c4.getX(), this.c4.getY(), null);
        g.drawImage(this.c4.getItem1Img(), this.c4.getX()+15, this.c4.getY()+10, null);
        g.drawImage(this.c4.getItem2Img(), this.c4.getX()+15, this.c4.getY()+120, null);


        g.drawImage(this.clock, 1055, 15, null);
        g.drawImage(this.syrupRed.getImg(), this.syrupRed.getX_absolute(),
                this.syrupRed.getY_absolute(), null);
        g.drawImage(this.syrupYellow.getImg(), this.syrupYellow.getX_absolute(),
                this.syrupYellow.getY_absolute(), null);
        g.drawImage(this.syrupBlue.getImg(), this.syrupBlue.getX_absolute(),
                this.syrupBlue.getY_absolute(), null);
        g.drawImage(this.grill.getImg(), this.grill.getX_absolute(), this.grill.getY_absolute(),
                null);
        g.drawImage(this.popcornGlass.getImg(), this.popcornGlass.getX_absolute(),
                this.popcornGlass.getY_absolute(), null);
        g.drawImage(this.penguin.getImg(), this.penguin.getX_absolute(),
                this.penguin.getY_absolute(), null);
        g.drawImage(this.bin.getImg(), this.bin.getX_absolute(), this.bin.getY_absolute(), null);
        g.drawImage(this.star.getImg(), this.star.getX_absolute(), this.star.getY_absolute(), null);
        g.drawImage(this.sun.getImg(), this.sun.getX_absolute(), this.sun.getY_absolute(), null);
        g.drawImage(this.moon.getImg(), this.moon.getX_absolute(), this.moon.getY_absolute(), null);
        g.drawImage(this.ojo.getImg(), this.ojo.getX_absolute(), this.ojo.getY_absolute(), null);
        g.drawImage(this.sprinkle.getImg(), this.sprinkle.getX_absolute(), this.sprinkle.getY_absolute(),
                null);
        for (Item pop : this.popList) {
            g.drawImage(pop.getImg(), pop.getX(), pop.getY(), null);
        }
        for (Item ice : this.iceList) {
            g.drawImage(ice.getImg(), ice.getX(), ice.getY(), null);
        }
        for (Item marsh : this.marshList) {
            g.drawImage(marsh.getImg(), marsh.getX(), marsh.getY(), null);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Blogger Sans Medium", Font.BOLD, 60));
        g.drawString((overall.getSecond()/10)+"", 1080, 91);

        g.setFont(new Font("Blogger Sans Medium", Font.BOLD, 40));
        g.drawString("SCORE : "+score, 10, 50);

        // Timer
        g.setFont(new Font("Blogger Sans Medium", Font.BOLD, 20));
        g.drawString(""+(s1/10), this.c1.getX(), this.c1.getY());
        g.drawString(""+(s2/10), this.c2.getX(), this.c2.getY());
        g.drawString(""+(s3/10), this.c3.getX(), this.c3.getY());
        g.drawString(""+(s4/10), this.c4.getX(), this.c4.getY());
    }

    public Image getBg() {
        return bg;
    }

    public void setBg(Image bg) {
        this.bg = bg;
    }

    public ArrayList<Item> getMarshList() {
        return marshList;
    }

    public Customer getC1() {
        return c1;
    }

    public void setC1(Customer c1) {
        this.c1 = c1;
    }

    public Customer getC2() {
        return c2;
    }

    public void setC2(Customer c2) {
        this.c2 = c2;
    }

    public Customer getC3() {
        return c3;
    }

    public void setC3(Customer c3) {
        this.c3 = c3;
    }

    public Customer getC4() {
        return c4;
    }

    public void setC4(Customer c4) {
        this.c4 = c4;
    }

    public void t1Timer() {
        t1 = new Timer(100, e -> {
            s1--;
            this.repaint();
            if(s1 == 0){
                s1 = overall.getDifficulty();
                createCustomer1();
            }
        });
    }

    public void t2Timer() {
        t2 = new Timer(100, e -> {
            s2--;
            this.repaint();
            if(s2 == 0){
                s2 = overall.getDifficulty();
                createCustomer2();
            }
        });
    }

    public void t3Timer() {
        t3 = new Timer(100, e -> {
            s3--;
            this.repaint();
            if(s3 == 0){
                s3 = overall.getDifficulty();
                createCustomer3();
            }
        });
    }

    public void t4Timer() {
        t4 = new Timer(100, e -> {
            s4--;
            this.repaint();
            if(s4 == 0){
                s4 = overall.getDifficulty();
                createCustomer4();
            }
        });
    }

    public Timer getT1() {
        return t1;
    }

    public void setT1(Timer t1) {
        this.t1 = t1;
    }

    public Timer getT2() {
        return t2;
    }

    public void setT2(Timer t2) {
        this.t2 = t2;
    }

    public Timer getT3() {
        return t3;
    }

    public void setT3(Timer t3) {
        this.t3 = t3;
    }

    public Timer getT4() {
        return t4;
    }

    public void setT4(Timer t4) {
        this.t4 = t4;
    }

    public int getS1() {
        return s1;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public int getS2() {
        return s2;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    public int getS3() {
        return s3;
    }

    public void setS3(int s3) {
        this.s3 = s3;
    }

    public int getS4() {
        return s4;
    }

    public void setS4(int s4) {
        this.s4 = s4;
    }

    public Overall getOverall() {
        return overall;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
