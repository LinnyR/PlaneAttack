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

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    static {
        GameMusic.Play("src/music/test.wav");
    }
    public void init(){
        JOptionPane.showMessageDialog(null,"开始游戏？","飞机大战", JOptionPane.WARNING_MESSAGE);
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

        jp1.add(label_Score);
        jp1.add(label_Time);
        jp1.add(player_entity.label);
        jp1.add(label_bomb);
        jp1.add(label_bomb_count);
        jp1.add(label_life);
        jp1.add(label_life_Count);



        //设置背景图片
        ImageIcon icon = new ImageIcon("src/img/飞机大战背景.png");
        JLabel photo = new JLabel(icon);
        photo.setBounds(0, 0, getWidth(), getHeight());
        getLayeredPane().add(photo, new Integer(Integer.MIN_VALUE));

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



        //玩家图标
        //修建图片
        ImageIcon icon1 = new ImageIcon("src/img/玩家.png");
        Image temp1 = icon1.getImage().getScaledInstance(63, 78, icon1.getImage().SCALE_DEFAULT);
        icon1 = new ImageIcon(temp1);

        player_entity.label.setIcon(icon1);
        player_entity.label.setBounds(200,500, 63, 78);

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
                        for
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





    }

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }
}