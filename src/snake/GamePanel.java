package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    int lenth; //蛇的长度
    int[] snakeX = new int[600];  //蛇的坐标x
    int[] snakeY = new int[500];  //蛇的坐标y

    String fx;

    boolean isStart = false;

    Timer timer = new Timer(100,this);

    int foodX;
    int foodY;
    Random random = new Random();

    //死亡判断
    boolean isFailed = false;

    //积分系统
    int score;

    public GamePanel(){
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    public void init(){
        lenth = 3;
        fx="R";
        snakeX[0] = 100; snakeY[0] = 100;
        snakeX[1] = 75; snakeY[1] = 100;
        snakeX[2] = 50; snakeY[2] = 100;

        foodX = 25 + 25*random.nextInt(34);
        foodY = 75 + 25*random.nextInt(24);
        score = 0;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);//清屏
        this.setBackground(Color.BLACK); //设置面板的背景色

        if (fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if (fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }

        for (int i = 1; i < lenth; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        //画积分
        g.setColor(Color.WHITE);
        g.setFont(new Font("宋体",Font.BOLD,18));
        g.drawString("长度"+lenth,750,35);
        g.drawString("分数"+score,750,50);

        //画食物
        Data.food.paintIcon(this,g,foodX,foodY);

        if(isStart==false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("宋体",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);
        }

        //失败提醒
        if(isFailed){
            g.setColor(Color.RED);
            g.setFont(new Font("宋体",Font.BOLD,40));
            g.drawString("按下空格重新开始游戏",300,300);
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if(keyCode==KeyEvent.VK_SPACE){
            if(isFailed){
                isFailed = false;
                init();//重新初始化游戏
            }else{   //暂停游戏
                isStart = !isStart;
            }

            repaint();
        }

        if (keyCode==KeyEvent.VK_LEFT){
            fx = "L";
        }else if (keyCode==KeyEvent.VK_RIGHT){
            fx = "R";
        }else if (keyCode==KeyEvent.VK_UP){
            fx = "U";
        }else if (keyCode==KeyEvent.VK_DOWN){
            fx = "D";
        }

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart&&isFailed==false){
            for (int i = lenth-1; i > 0 ; i--) {
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }

            if (fx.equals("R")){
                snakeX[0] = snakeX[0]+25;
                if (snakeX[0]>850) snakeX[0] = 0;
            }else if (fx.equals("L")){
                snakeX[0] = snakeX[0]-25;
                if (snakeX[0]<25) snakeX[0] = 875;
            }else if (fx.equals("U")){
                snakeY[0] = snakeY[0]-25;
                if (snakeY[0]<75) snakeY[0] = 675;
            }else if (fx.equals("D")){
                snakeY[0] = snakeY[0]+25;
                if (snakeY[0]>650) snakeY[0] = 25;
            }

            //头和食物重合
            if(snakeX[0]==foodX&&snakeY[0]==foodY){
                lenth++;
                score = score + 10;

                //重新生成食物
                foodX = 25 + 25*random.nextInt(34);
                foodY = 75 + 25*random.nextInt(24);
            }

            for (int i = 1; i < lenth; i++) {
                if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]){
                    isFailed = true;
                }
            }


            repaint();
        }
        timer.start();
    }
}
