package snake;

import javax.swing.*;

public class StartGames {
        public static void main(String[] args) {
            JFrame frame = new JFrame("贪吃蛇小游戏");
            frame.setBounds(10,10,900,720);
            frame.setResizable(false); //窗口大小不可调整,即固定窗口大小
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭事件，游戏可以关闭

            GamePanel gamePanel = new GamePanel();
            frame.add(gamePanel);

            frame.setVisible(true);
        }
}
