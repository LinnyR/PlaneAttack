package com.game.Panel;

import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.List;

public class RecordFrame extends JFrame {
    JPanel jp;//内容面板
    public static JPanel jp1 ;//放置图标的面板
    public static ImageIcon icon_bg;//背景图片
    public static ImageIcon icon_title;//皇牌飞行员图片
    public static ImageIcon icon_playerName_bg;//玩家名字底色图片
    public static ImageIcon icon_player;//玩家图片
    public static ImageIcon icon_back;//返回图片
    public static ImageIcon icon_back2;//返回2图片
    //分数集合
    public static List<Integer> score_list = new ArrayList<>();


    static{
        //修建背景图片
        icon_bg = new ImageIcon("src/img/天空背景.jpg");
        Image temp_bg = icon_bg.getImage().getScaledInstance(480, 700, icon_bg.getImage().SCALE_DEFAULT);
        icon_bg = new ImageIcon(temp_bg);
        //修建皇牌飞行员图片
        icon_title = new ImageIcon("src/img/皇牌飞行员.png");
        Image temp_title = icon_title.getImage().getScaledInstance(394, 66, icon_title.getImage().SCALE_DEFAULT);
        icon_title = new ImageIcon(temp_title);
        //修建玩家名称底色图片
        icon_playerName_bg = new ImageIcon("src/img/玩家底色.png");
        Image temp_playerName_bg = icon_playerName_bg.getImage().getScaledInstance(500, 45, icon_playerName_bg.getImage().SCALE_DEFAULT);
        icon_playerName_bg = new ImageIcon(temp_playerName_bg);
        //修建返回图片
        icon_back = new ImageIcon("src/img/返回.png");
        Image temp_back = icon_back.getImage().getScaledInstance(159, 67, icon_back.getImage().SCALE_DEFAULT);
        icon_back = new ImageIcon(temp_back);
        //修建返回2图片
        icon_back2 = new ImageIcon("src/img/返回2.png");
        Image temp_back2 = icon_back2.getImage().getScaledInstance(159, 67, icon_back2.getImage().SCALE_DEFAULT);
        icon_back2 = new ImageIcon(temp_back2);


    }

    public void init(){

        setResizable(false); //不可改变大小
        setVisible(true); //可见
        setLocation(600, 200);//设置位置
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭即关闭程序
        setSize(480, 700);//大小
        setTitle("排行榜");//标题


        jp = (JPanel) getContentPane();//内容面板
        jp.setOpaque(false);//透明
        jp1 = new JPanel();
        jp1.setOpaque(false);//透明
        jp1.setLayout(null);
        jp.add(jp1);


        //设置icon图标
        setIconImage(new ImageIcon("src/img/飞机大战图标.png").getImage());

        //设置背景图片
        JLabel label_bg = new JLabel();
        label_bg.setIcon(icon_bg);
        label_bg.setBounds(0, 0, 480, 700);
        getLayeredPane().add(label_bg, new Integer(Integer.MIN_VALUE));

        //设置皇牌飞行员标题
        JLabel label_title = new JLabel();
        RecordFrame.jp1.add(label_title);
        label_title.setIcon(icon_title);
        label_title.setBounds(43, 50, 394, 66);

        //每次清空score_list
        score_list.clear();
        //读取文件中的分数
        try(BufferedReader br = new BufferedReader(new FileReader("src/record/记录.txt"))){
            String str;
            while ((str=br.readLine())!=null){
                score_list.add(Integer.valueOf(str));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //给集合降序排序
        Collections.sort(score_list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //降序排序
                return o2-o1;
            }
        });
        //初始Y坐标
        int y=170;
        int len = score_list.size()>=5?5:score_list.size();



        for(int i=0;i<len;i++){
            //玩家1底色
            JLabel label_name1_bg = new JLabel();
            RecordFrame.jp1.add(label_name1_bg);
            label_name1_bg.setIcon(icon_playerName_bg);
            label_name1_bg.setBounds(43, y, 500, 45);
            //修建飞行员图片
            icon_player = new ImageIcon("src/img/飞行员"+(i+1)+".png");
            Image temp_player1 = icon_player.getImage().getScaledInstance(130, 35, icon_player.getImage().SCALE_DEFAULT);
            icon_player = new ImageIcon(temp_player1);
            //飞行员
            JLabel label_name = new JLabel();
            label_name1_bg.add(label_name);
            label_name.setBounds(40, 5, 130, 35);
            label_name.setIcon(icon_player);
            //分数
            JLabel label_score = new JLabel();
            label_name1_bg.add(label_score);
            label_score.setBounds(250, 5, 100, 35);
            label_score.setFont(new Font("宋体", Font.BOLD, 30));
            label_score.setForeground(Color.white);
            //将前五名的分数依次设置
            label_score.setText(String.valueOf(score_list.get(i)));
            y=y+85;
        }

        //返回按钮
        JLabel label_back = new JLabel();
        RecordFrame.jp1.add(label_back);
        label_back.setIcon(icon_back);
        label_back.setBounds(150, 575, 159, 67);

        //返回按钮监听事件
        label_back.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
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
                        GameMusic.Play("src/music/upgrade.wav",2.0);
                    }
                }).start();

                label_back.setIcon(icon_back2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label_back.setIcon(icon_back);
            }
        });


    }
}
