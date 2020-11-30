package com.game.Panel;

import com.game.Bomb.Bomb;
import com.game.Boss.Boss;
import com.game.Boss.Boss_Entity;
import com.game.BossBullet.BossBullet_Entity;
import com.game.Enemy.Enemy;
import com.game.Enemy.Enemy_Entity;
import com.game.EnemyBullet.EnemyBullet;
import com.game.EnemyBullet.EnemyBullet_Entity;
import com.game.Music.Music;
import com.game.Player.Player;
import com.game.Player.Player_Entity;
import com.game.Supply.Supply;
import com.game.Supply.Supply_Entity;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends JFrame {

    public static Main main = new Main();
    JPanel jp;//内容面板
    public static JPanel jp1 ;//放置图标的面板
    public static volatile List<JLabel> bullets_list ;//玩家子弹列表
    public static volatile List<Enemy_Entity> enemy_list ;//敌人列表
    public static volatile Boss_Entity boss;//Boss
    public static volatile List<EnemyBullet_Entity> enemy_bullets_list ;//敌人子弹列表
    public static volatile List<BossBullet_Entity> boss_bullets_list;//Boss子弹列表
    public static volatile JLabel Boss_laser1 = new JLabel(); //Boss激光1
    public static volatile JLabel Boss_laser2 = new JLabel(); //Boss激光2
    public static volatile List<Supply_Entity> supply_list ;//补给列表
    public static JLabel label_Score = new JLabel();//积分榜
    public static volatile int score = 0;//积分数
    public static JLabel label_Time = new JLabel(); //显示时间
    public static Player_Entity player_entity ;//玩家实体
    public static Player player  ;//玩家线程
    public static JLabel label_life = new JLabel();//生命图标
    public static JLabel label_life_Count = new JLabel();//生命数量

    public static JLabel label_bomb = new JLabel();//强力炸弹
    public static JLabel label_bomb_count = new JLabel();//强力炸弹数量

    public static JLabel label_main_title ;
    public static JLabel label_start_button ;
    public static JLabel label_end_button ;
    public static JLabel label_record ;
    public static JLabel label_choose ;

    public static JLabel photo;//背景图片

    //地图
    public static volatile String[] map ={"峡谷背景(长).jpg","熔岩地狱(长).jpg","天空都市(长).jpg","活死人之地(长).jpg","岛屿地图(长).png"};
    public static volatile int map_count = 0;

    //类一加载就执行
    static {
        //预加载音乐
        GameMusic.Play("src/music/test.wav",0);

        player_entity = new Player_Entity();//玩家实体
        bullets_list = new ArrayList<>();//玩家子弹列表
        enemy_list = new ArrayList<>();//敌人列表
        enemy_bullets_list = new ArrayList<>();//敌人子弹列表
        boss_bullets_list = new ArrayList<>();//Boss子弹列表
        supply_list = new ArrayList<>();//补给列表

        player = new Player();


        label_main_title = new JLabel();//主界面的title
        label_start_button = new JLabel();//开始按钮
        label_end_button = new JLabel();//结束按钮
        label_record = new JLabel();//排行榜按钮
        label_choose = new JLabel();//切换战机按钮
    }


    public void init(){

//        JOptionPane.showMessageDialog(null,"开始游戏？","飞机大战", JOptionPane.WARNING_MESSAGE);

        setResizable(false); //不可改变大小
        setVisible(true); //可见
        setLocation(600, 200);//设置位置
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭即关闭程序
        setSize(480, 700);//大小
        setTitle("激烈空战");//标题

        jp = (JPanel) getContentPane();//内容面板
        jp.setOpaque(false);//透明

        jp1 = new JPanel();
        jp1.setOpaque(false);//透明
        jp1.setLayout(null);
        jp.add(jp1);


        jp1.add(player_entity.label);
        jp1.add(label_Score);
        jp1.add(label_Time);
        jp1.add(label_bomb);
        jp1.add(label_bomb_count);
        jp1.add(label_life);
        jp1.add(label_life_Count);
        jp1.add(label_main_title);
        jp1.add(label_start_button);
        jp1.add(label_end_button);
        jp1.add(label_record);
        jp1.add(label_choose);

        //设置icon图标
        setIconImage(new ImageIcon("src/img/飞机大战图标.png").getImage());


        //开局随机地图
        map_count = new Random().nextInt(5);//0 - 4
        //修建背景图片
        ImageIcon icon_bg = new ImageIcon("src/img/"+map[map_count]);
        //设置背景图片
        photo = new JLabel(icon_bg);
        photo.setBounds(-2, -700, getWidth(),getHeight());
        getLayeredPane().add(photo, new Integer(Integer.MIN_VALUE));

        //开启一个线程移动背景图片
        new Thread(()->{
            int y = photo.getY();
            while (true){
                try{
                    Thread.sleep(15);
                }catch (Exception e){
                    e.printStackTrace();
                }
                y=y+1;
                if(y==0){
                    y=-700;
                }
                photo.setBounds(-2, y, 480, 1400);

            }

        }).start();


        //飞机大战标题
        ImageIcon icon5 = new ImageIcon("src/img/maintitlen.png");
        Image temp5 = icon5.getImage().getScaledInstance(477,240,icon5.getImage().SCALE_DEFAULT);
        icon5 = new ImageIcon(temp5);
        label_main_title.setIcon(icon5);
        label_main_title.setBounds(-5,50,477,240);


        //开始按钮图片
        ImageIcon icon6 = new ImageIcon("src/img/startbutton.png");
        Image temp6 = icon6.getImage().getScaledInstance(303, 45, icon6.getImage().SCALE_DEFAULT);
        icon6 = new ImageIcon(temp6);
        final ImageIcon icon7=new ImageIcon(temp6);
        label_start_button.setIcon(icon6);
        label_start_button.setBounds(88,330,303,45);


        //结束按钮图片
        final ImageIcon icon8 =new ImageIcon(new ImageIcon("src/img/endgame.png").getImage().getScaledInstance(303, 45, icon6.getImage().SCALE_DEFAULT));
        final ImageIcon icon9=new ImageIcon(new ImageIcon("src/img/endgamech.png").getImage().getScaledInstance(303,45,icon6.getImage().SCALE_DEFAULT));
        label_end_button.setIcon(icon8);
        label_end_button.setBounds(88,390,303,45);

        //选择战机图片
        ImageIcon icon_choose = new ImageIcon(new ImageIcon("src/img/选择.png").getImage().getScaledInstance(275, 75, icon6.getImage().SCALE_DEFAULT));
        label_choose.setIcon(icon_choose);
        label_choose.setBounds(103, 460, 270, 70);

        //选择战机2图片
        ImageIcon icon_choose2 = new ImageIcon(new ImageIcon("src/img/选择2.png").getImage().getScaledInstance(275, 75, icon6.getImage().SCALE_DEFAULT));

        //排行榜图片
        ImageIcon icon_record = new ImageIcon(new ImageIcon("src/img/排行榜1.png").getImage().getScaledInstance(226, 80, icon6.getImage().SCALE_DEFAULT));
        label_record.setIcon(icon_record);
        label_record.setBounds(123, 550, 226, 80);

        //排行榜图片2
        ImageIcon icon_record2 = new ImageIcon(new ImageIcon("src/img/排行榜2.png").getImage().getScaledInstance(226, 80, icon6.getImage().SCALE_DEFAULT));



        //音乐线程
        Music music = new Music();
        Thread thread_music = new Thread(music);
        thread_music.start();





        //开启敌人线程
        Enemy enemy = new Enemy();
        Thread thread_enemy = new Thread(enemy);
        thread_enemy.start();

        //排行榜按钮监听事件
        label_record.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //隐藏主界面
                Main.main.setVisible(false);
                //开启排行榜界面
                RecordFrame frame = new RecordFrame();
                frame.init();

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

                label_record.setIcon(icon_record2);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                label_record.setIcon(icon_record);
            }
        });


        //选择战机按钮监听事件
        label_choose.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //隐藏主界面
                Main.main.setVisible(false);
                //开启选择角色界面
                ChooseFrame chooseFrame = new ChooseFrame();
                chooseFrame.init();
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

                label_choose.setIcon(icon_choose2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label_choose.setIcon(icon_choose);
            }
        });



        //开始按钮监听事件
        label_start_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //修建玩家图标
                ImageIcon icon1 = new ImageIcon("src/img/玩家"+Player_Entity.player_index+"_1.png");
                Image temp1 = icon1.getImage().getScaledInstance(85, 62, icon1.getImage().SCALE_DEFAULT);
                icon1 = new ImageIcon(temp1);
                //设置玩家图片以及位置
                player_entity.label.setIcon(icon1);
                player_entity.label.setBounds(200,850 , 85, 62);

                //开启一个线程三个滑动特效
                new Thread(() -> {
                    int count=0;
                    while (count<390){
                        //三个滑动特效
                        label_main_title.setLocation(label_main_title.getX(),label_main_title.getY()-1);
                        player_entity.label.setLocation(player_entity.label.getX(),player_entity.label.getY()-1);
                        label_end_button.setLocation(label_end_button.getX()-2,label_end_button.getY());
                        label_start_button.setLocation(label_start_button.getX()+2,label_start_button.getY());
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        count++;
                    }

                    //玩家入场以后再开启敌人子弹碰撞检测方法
                    EnemyBullet.isAttack=true;

                }).start();



                //开一个线程显示组件
                new Thread(()->{

                    //删除选择战机
                    jp1.remove(label_choose);
                    //删除排行榜
                    jp1.remove(label_record);

                    //全屏炸弹线程
                    Bomb bomb = new Bomb();
                    Thread thread_bomb = new Thread(bomb);
                    thread_bomb.start();
                    //首先释放一个全屏炸弹
                    Bomb.isUse=true;



                    //积分榜
                    label_Score.setBounds(50, 30, 180, 25);
                    label_Score.setFont(new Font("宋体", Font.BOLD, 18));
                    label_Score.setForeground(Color.WHITE);
                    label_Score.setText("当前积分:"+score);


                    //强力炸弹
                    //修建图片
                    ImageIcon icon2 = new ImageIcon("src/img/全屏炸弹.png");
                    Image temp2 = icon2.getImage().getScaledInstance(63, 57, icon2.getImage().SCALE_DEFAULT);
                    icon2 = new ImageIcon(temp2);

                    label_bomb.setIcon(icon2);
                    label_bomb.setBounds(350,600, 63, 57);

                    //强力炸弹数量
                    label_bomb_count.setBounds(405, 615, 120, 25);
                    label_bomb_count.setFont(new Font("宋体", Font.BOLD, 20));
                    label_bomb_count.setForeground(Color.WHITE);
                    label_bomb_count.setText(" X "+player_entity.bomb);

                    //生命图片
                    //修建图片
                    ImageIcon icon3 = new ImageIcon("src/img/玩家"+Player_Entity.player_index+"_1.png");
                    Image temp3 = icon3.getImage().getScaledInstance(66, 48, icon3.getImage().SCALE_DEFAULT);
                    icon3 = new ImageIcon(temp3);

                    label_life.setIcon(icon3);
                    label_life.setBounds(30,600, 66, 48);

                    //生命数量
                    label_life_Count.setBounds(90, 615, 120, 25);
                    label_life_Count.setFont(new Font("宋体", Font.BOLD, 20));
                    label_life_Count.setForeground(Color.WHITE);
                    label_life_Count.setText(" X "+player_entity.health);



                    //时间线程
                    label_Time.setBounds(300, 30, 120, 25);
                    label_Time.setFont(new Font("宋体", Font.BOLD, 18));
                    label_Time.setForeground(Color.WHITE);
                    label_Time.setText("倒计时：300s");
                    Thread thread_time = new Thread(new Time());
                    thread_time.start();


                    //玩家线程
                    player = new Player() ;
                    Thread thread_player = new Thread(player);
                    thread_player.start();




                    //补给品线程
                    Supply supply = new Supply();
                    Thread thread_supply = new Thread(supply);
                    thread_supply.start();

                    //BOSS线程
                    Boss boss = new Boss();
                    Thread thread_boss = new Thread(boss);
                    thread_boss.start();


                }).start();




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


        //玩家移动
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //空格使用全屏炸弹
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    Bomb.isUse = true;
                }else{
                    //玩家移动
                    player.setKey(e.getKeyCode());
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        //结束按钮监听器
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
                        GameMusic.Play("src/music/upgrade.wav",2.0);
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
        main = new Main();
        main.init();
    }
}
