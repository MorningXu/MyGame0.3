package cn.MorningXu.game;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends Frame{

    Image bgImg = GameUtil.getImage("Image/bg.jpg");
    Image planeImg = GameUtil.getImage("Image/plane.png");
    Plane plane = new Plane(planeImg,300,300 , 3);
    Shell[] shells = new Shell[15];
    Exlode bao;

    public void paint(Graphics g){
        g.drawImage(bgImg,0,0,null);
        plane.drawMySelf(g);
        for(int i = 0 ; i < shells.length ; i++){
            shells[i].draw(g);
            boolean peng = shells[i].getRect().intersects(plane.getRect());
            if(peng){
                plane.live = false;
                if(bao == null){
                   bao = new Exlode(plane.x , plane.y);
                }
                bao.draw(g);
            }
        }

    }

    class PaintThread extends Thread{
        public void run(){
            while(true){
                repaint();
                try{
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            plane.addDriection(e);
        }
        public void keyReleased(KeyEvent e){
            plane.minusDirection(e);
        }
    }


    public void launchFrame(){
        setTitle("MyGame");//设置标题
        setSize(Constands.FRAME_WIDTH,Constands.FRAME_HEIGHT);
        setVisible(true);
        setLocation(300,300);
        //增加关闭窗口监听
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        new PaintThread().start();
        addKeyListener(new KeyMonitor());
        for(int i = 0 ; i < shells.length ; i++){
           shells[i]= new Shell();

        }
    }

    private Image offScreenImage = null;

    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(Constands.FRAME_WIDTH , Constands.FRAME_HEIGHT);//这是游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }

    private class Thrend {
    }
}