package com.game.Panel;

import com.game.Enemy.Enemy;
import com.game.Enemy.Enemy_Entity;
import com.game.Music.Music;
import com.game.Player.Player;
import com.game.Player.Player_Entity;
import com.game.Time.Time;
import com.game.Util.GameMusic;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.awt.windows.ThemeReader;
import sun.jvm.hotspot.gc_implementation.shared.ImmutableSpace;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    JPanel jp;//内容面板
    public static JPanel jp1 ;//放置图标的面板
    public static List<Enemy_Entity> enemy_list = new ArrayList<>();//敌人列表
    public static List<JLabel> bullets_list = new ArrayList<>();//玩家子弹列表
    public static JLabel label_Score = new JLabel();//积分榜
    public static JLabel label_Time = new JLabel(); //显示时间
    public static Player_Entity player_entity = new Player_Entity();//玩家实体
    public static JLabel label_life = new JLabel();//生命图标
    public static JLabel label_life_Count = new JLabel();//生命数量

    public static JLabel label_bomb = new JLabel();//强力炸弹
    public static JLabel label_bomb_count = new JLabel();//强力炸弹数量
    public static JLabel label_main_title = new JLabel();//主界面的title
    public static JLabel label_start_button = new JLabel();//开始按钮
    public static JLabel label_end_button = new JLabel();//结束按钮

    static {
        GameMusic.Play("src/music/test.wav");
    }
    public void init(){
        //JOptionPane.showMessageDialog(null,"开始游戏？","飞机大战", JOptionPane.WARNING_MESSAGE);
        setResizable(false); //不可改变大小
        setVisible(true); //可见
        setLocation(600, 200);//设置位置
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭即关闭程序
        setSize(480, 700);//大小
        setTitle("飞机大战");//标题

        jp = (JPanel) getContentPane();//内容面板
        jp.setOpaque(false);//透明

        jp1 = new JPanel();
        jp1.setOpaque(false);//透明
        jp1.setLayout(null);

        jp.add(jp1);


        jp1.add(label_main_title);
        jp1.add(label_start_button);
        jp1.add(label_end_button);

        //设置背景图片
        ImageIcon icon = new ImageIcon("src/img/飞机大战背景.png");
        JLabel photo = new JLabel(icon);
        photo.setBounds(0, 0, getWidth(), getHeight());
        getLayeredPane().add(photo, new Integer(Integer.MIN_VALUE));

        //
        ImageIcon icon5 = new ImageIcon("src/img/maintitlen.png");
        Image temp5 = icon5.getImage().getScaledInstance(477,240,icon5.getImage().SCALE_DEFAULT);
        icon5 = new ImageIcon(temp5);
        label_main_title.setIcon(icon5);
        label_main_title.setBounds(1,50,477,240);
//        label_main_title.setVisible(true);


        //积分榜
        label_Score.setBounds(50, 30, 120, 25);
        label_Score.setFont(new Font("宋体", Font.BOLD, 18));
        label_Score.setText("当前积分:"+0);

        //强力炸弹
        //修建图片
        ImageIcon icon2 = new ImageIcon("src/img/全屏炸弹.png");
        Image temp2 = icon2.getImage().getScaledInstance(63, 57, icon.getImage().SCALE_DEFAULT);
        icon2 = new ImageIcon(temp2);

        label_bomb.setIcon(icon2);
        label_bomb.setBounds(350,600, 63, 57);

        //强力炸弹数量
        label_bomb_count.setBounds(405, 615, 120, 25);
        label_bomb_count.setFont(new Font("宋体", Font.BOLD, 27));
        label_bomb_count.setText(" X "+player_entity.bomb);

        //生命图片
        //修建图片
        ImageIcon icon3 = new ImageIcon("src/img/life.png");
        Image temp3 = icon3.getImage().getScaledInstance(46, 57, icon3.getImage().SCALE_DEFAULT);
        icon3 = new ImageIcon(temp3);

        label_life.setIcon(icon3);
        label_life.setBounds(30,600, 46, 57);

        //生命数量
        label_life_Count.setBounds(70, 615, 120, 25);
        label_life_Count.setFont(new Font("宋体", Font.BOLD, 27));
        label_life_Count.setText(" X "+player_entity.health);

        //音乐线程
        Music music = new Music();
        Thread thread_music = new Thread(music);
        thread_music.start();

        //时间线程
        label_Time.setBounds(300, 30, 120, 25);
        label_Time.setFont(new Font("宋体", Font.BOLD, 18));
        label_Time.setText("倒计时：90s");
        Thread thread_time = new Thread(new Time());
        thread_time.start();
        label_Time.setVisible(false);


        //玩家图标
        //修建图片
        ImageIcon icon1 = new ImageIcon("src/img/玩家.png");
        Image temp1 = icon1.getImage().getScaledInstance(63, 78, icon1.getImage().SCALE_DEFAULT);
        icon1 = new ImageIcon(temp1);

        player_entity.label.setIcon(icon1);
        player_entity.label.setBounds(200,780, 63, 78);
        //开始按钮逻辑
        ImageIcon icon6 = new ImageIcon("src/img/startbutton.png");
        Image temp6 = icon6.getImage().getScaledInstance(303, 45, icon1.getImage().SCALE_DEFAULT);
        icon6 = new ImageIcon(temp6);
        final ImageIcon icon7=new ImageIcon(temp6);
        label_start_button.setIcon(icon6);
        label_start_button.setBounds(88,400,303,45);
        label_start_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_Time.setVisible(true);
                new Thread(() -> {
                    int count=0;
                    while (count<280){
                        label_main_title.setLocation(label_main_title.getX(),label_main_title.getY()-1);
                        player_entity.label.setLocation(player_entity.label.getX(),player_entity.label.getY()-1);
                        label_end_button.setLocation(label_end_button.getX()-2,label_end_button.getY());
                        label_start_button.setLocation(label_start_button.getX()+2,label_start_button.getY());
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        count++;
                    }
                    //JOptionPane.showMessageDialog(null,"开始游戏？","飞机大战", JOptionPane.WARNING_MESSAGE);
                }).start();
                //玩家线程
                Player player = new Player() ;
                Thread thread_player = new Thread(player);
                thread_player.start();

                //敌人线程
                Enemy enemy = new Enemy();
                Thread thread_enemy = new Thread(enemy);
                thread_enemy.start();

                //玩家移动
                addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        //空格使用全屏炸弹
                        if(e.getKeyCode()==KeyEvent.VK_SPACE){
                            //如果炸弹数>0
                            if(player_entity.bomb>0){
                                //玩家炸弹数-1
                                player_entity.bomb--;
                                //重新设置炸弹数量
                                Main.label_bomb_count.setText(" X "+player_entity.bomb);
                                //消灭所有敌人
                                //暂停Enemy线程（不要继续创建及移动敌人）
                                Enemy.isTure = false;
                                //缓冲10ms 不能直接清空集合，否则数组下标越界
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                //从面板上删除所有

                            }

                        }else{
                            //玩家移动
                            player.setKey(e.getKeyCode());
                        }




                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });

                jp1.add(label_Score);
                jp1.add(label_Time);
                jp1.add(player_entity.label);
                jp1.add(label_bomb);
                jp1.add(label_bomb_count);
                jp1.add(label_life);
                jp1.add(label_life_Count);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        GameMusic.Play("src/music/upgrade.wav");
                    }
                }).start();

                ImageIcon icon8 = new ImageIcon("src/img/startbuttononclick.png");
                Image temp8 = icon8.getImage().getScaledInstance(303, 45, icon8.getImage().SCALE_DEFAULT);
                icon8 = new ImageIcon(temp8);
                label_start_button.setIcon(icon8);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label_start_button.setIcon(icon7);
            }
        });

        final ImageIcon icon8 =new ImageIcon(new ImageIcon("src/img/endgame.png").getImage().getScaledInstance(303, 45, icon1.getImage().SCALE_DEFAULT));
        final ImageIcon icon9=new ImageIcon(new ImageIcon("src/img/endgamech.png").getImage().getScaledInstance(303,45,icon.getImage().SCALE_DEFAULT));
        label_end_button.setIcon(icon8);
        label_end_button.setBounds(88,460,303,45);
        label_end_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        GameMusic.Play("src/music/upgrade.wav");
                    }
                }).start();
                label_end_button.setIcon(icon9);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label_end_button.setIcon(icon8);
            }
        });
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.init();
    }
}
