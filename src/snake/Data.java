package snake;

import javax.swing.*;
import java.net.URL;

public class Data {
    public static URL upUrl = Data.class.getResource("/sources/up.png");
    public static URL downUrl = Data.class.getResource("/sources/down.png");
    public static URL leftUrl = Data.class.getResource("/sources/left.png");
    public static URL rightUrl = Data.class.getResource("/sources/right.png");
    public static ImageIcon up = new ImageIcon(upUrl);
    public static ImageIcon down = new ImageIcon(downUrl);
    public static ImageIcon left = new ImageIcon(leftUrl);
    public static ImageIcon right = new ImageIcon(rightUrl);

    public static  URL bodyUrl = Data.class.getResource("/sources/body.png");
    public static ImageIcon body = new ImageIcon(bodyUrl);

    public static  URL foodUrl = Data.class.getResource("/sources/food.png");
    public static ImageIcon food = new ImageIcon(foodUrl);


}
