package com.game.Panel;

import com.game.Player.Player_Entity;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChooseFrame extends JFrame {

    JPanel jp;//内容面板
    public static JPanel jp1 ;//放置图标的面板
    public static ImageIcon icon_bg;//背景图片
    public static ImageIcon icon_player1;   //战机1图片
    public static ImageIcon icon_player1_2; //战机1图片2
    public static ImageIcon icon_player2;   //战机2图片
    public static ImageIcon icon_player2_2; //战机2图片2
    public static ImageIcon icon_player3;   //战机3图片
    public static ImageIcon icon_player3_2; //战机3图片2
    public JLabel label_player = new JLabel();//显示战机1的图片
    public JLabel label_player2 = new JLabel();//显示战机2的图片
    public JLabel label_player3 = new JLabel();//显示战机3的图片

    static {
        //修建背景图片
        icon_bg = new ImageIcon("src/img/天空背景.jpg");
        Image temp_bg = icon_bg.getImage().getScaledInstance(480, 700, icon_bg.getImage().SCALE_DEFAULT);
        icon_bg = new ImageIcon(temp_bg);

        //修建战机1图片
        icon_player1 = new ImageIcon("src/img/玩家1选择.jpg");
        Image temp_player1 = icon_player1.getImage().getScaledInstance(480, 225, icon_player1.getImage().SCALE_DEFAULT);
        icon_player1 = new ImageIcon(temp_player1);
        //修建战机1图片2
        icon_player1_2 = new ImageIcon("src/img/玩家1选择2.jpg");
        Image temp_player1_2 = icon_player1_2.getImage().getScaledInstance(480, 225, icon_player1_2.getImage().SCALE_DEFAULT);
        icon_player1_2 = new ImageIcon(temp_player1_2);

        //修建战机2图片
        icon_player2 = new ImageIcon("src/img/玩家2选择.jpg");
        Image temp_player2 = icon_player2.getImage().getScaledInstance(480, 225, icon_player2.getImage().SCALE_DEFAULT);
        icon_player2 = new ImageIcon(temp_player2);
        //修建战机2图片2
        icon_player2_2 = new ImageIcon("src/img/玩家2选择2.jpg");
        Image temp_player2_2 = icon_player2_2.getImage().getScaledInstance(480, 225, icon_player2_2.getImage().SCALE_DEFAULT);
        icon_player2_2 = new ImageIcon(temp_player2_2);

        //修建战机3图片
        icon_player3 = new ImageIcon("src/img/玩家3选择.jpg");
        Image temp_player3 = icon_player3.getImage().getScaledInstance(480, 225, icon_player3.getImage().SCALE_DEFAULT);
        icon_player3 = new ImageIcon(temp_player3);
        //修建战机3图片2
        icon_player3_2 = new ImageIcon("src/img/玩家3选择2.jpg");
        Image temp_player3_2 = icon_player3_2.getImage().getScaledInstance(480, 225, icon_player3_2.getImage().SCALE_DEFAULT);
        icon_player3_2 = new ImageIcon(temp_player3_2);
    }

    public void init(){
        setResizable(false); //不可改变大小
        setVisible(true); //可见
        setLocation(600, 200);//设置位置
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭即关闭程序
        setSize(480, 700);//大小
        setTitle("选择战机");//标题


        jp = (JPanel) getContentPane();//内容面板
        jp.setOpaque(false);//透明
        jp1 = new JPanel();
        jp1.setOpaque(false);//透明
        jp1.setLayout(null);
        jp.add(jp1);

        jp1.add(label_player);
        jp1.add(label_player2);
        jp1.add(label_player3);

        //设置icon图标
        setIconImage(new ImageIcon("src/img/飞机大战图标.png").getImage());

        //设置背景图片
        JLabel label_bg = new JLabel();
        label_bg.setIcon(icon_bg);
        label_bg.setBounds(0, 0, 480, 700);
        getLayeredPane().add(label_bg, new Integer(Integer.MIN_VALUE));

        //设置战机1图片
        label_player.setIcon(icon_player1);
        label_player.setBounds(0, 0, 480, 225);
        //设置战机2图片
        label_player2.setIcon(icon_player2);
        label_player2.setBounds(0, 225, 480, 225);
        //设置战机3图片
        label_player3.setIcon(icon_player3);
        label_player3.setBounds(0, 450, 480, 225);

        //设置战机label1鼠标事件
        label_player.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //开启一个线程播放战机1语音
                new Thread(()->{
                    GameMusic.Play("src/music/玩家1选择语音.wav", 2.0);
                }).start();

                //修改战机编号为1
                Player_Entity.player_index=1;
                //关闭当前界面
                dispose();
                //重新显示主界面
                Main.main.setVisible(true);
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
                        GameMusic.Play("src/music/upgrade.wav",1.0);
                    }
                }).start();
                label_player.setIcon(icon_player1_2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label_player.setIcon(icon_player1);
            }
        });

        //设置战机label2鼠标事件
        label_player2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //开启一个线程播放战机2语音
                new Thread(()->{
                    GameMusic.Play("src/music/玩家2选择语音.wav", 2.0);
                }).start();

                //修改战机编号为2
                Player_Entity.player_index=2;
                //关闭当前界面
                dispose();
                //重新显示主界面
                Main.main.setVisible(true);
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
                        GameMusic.Play("src/music/upgrade.wav",1.0);
                    }
                }).start();

                label_player2.setIcon(icon_player2_2);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                label_player2.setIcon(icon_player2);
            }
        });

        //设置战机label3鼠标事件
        label_player3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //开启一个线程播放战机3语音
                new Thread(()->{
                    GameMusic.Play("src/music/玩家3选择语音.wav", 2.0);
                }).start();

                //修改战机编号为3
                Player_Entity.player_index=3;
                //关闭当前界面
                dispose();
                //重新显示主界面
                Main.main.setVisible(true);
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
                        GameMusic.Play("src/music/upgrade.wav",1.0);
                    }
                }).start();

                label_player3.setIcon(icon_player3_2);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                label_player3.setIcon(icon_player3);
            }
        });



    }
}
