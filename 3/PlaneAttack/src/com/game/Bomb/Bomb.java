package com.game.Bomb;

import com.game.Boss.Boss;
import com.game.Enemy.Enemy;
import com.game.EnemyBullet.EnemyBullet;
import com.game.Panel.Main;
import com.game.Player.Player_Entity;
import com.game.PlayerBullet.PlayerBulletCreate;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bomb implements Runnable{

    public static ImageIcon icon1_1;//敌人1销毁1
    public static ImageIcon icon1_2;//敌人1销毁2
    public static ImageIcon icon1_3;//敌人1销毁3
    public static ImageIcon icon1_4;//敌人1销毁4

    public static ImageIcon icon2_1;//敌人2销毁1
    public static ImageIcon icon2_2;//敌人2销毁2
    public static ImageIcon icon2_3;//敌人2销毁3
    public static ImageIcon icon2_4;//敌人2销毁4

    public static ImageIcon icon3_1;//敌人3销毁1
    public static ImageIcon icon3_2;//敌人3销毁2
    public static ImageIcon icon3_3;//敌人3销毁3
    public static ImageIcon icon3_4;//敌人3销毁4
    public static ImageIcon icon3_5;//敌人3销毁5
    public static ImageIcon icon3_6;//敌人3销毁6

    public static ImageIcon icon_skill;//奥义1字体
    public static ImageIcon icon_skill2;//奥义2字体
    public static ImageIcon icon_skill3;//奥义3字体
    public static ImageIcon icon_skill4;//奥义4字体
    public static ImageIcon icon_skill5;//奥义5字体
    public static ImageIcon icon_skill6;//奥义6字体
    public static ImageIcon icon_skill_font;//奥义字幕
    public static ImageIcon icon_thunder;//雷电特效1
    public static ImageIcon icon_thunder2;//雷电特效2
    public static ImageIcon icon_thunder3;//雷电特效3
    public static ImageIcon icon_thunder4;//雷电特效4
    public static ImageIcon icon_thunder5;//雷电特效5
    public static ImageIcon icon_thunder6;//雷电特效6
    public static ImageIcon icon_thunder7;//雷电特效7
    List<JLabel> thunder_list;
    static volatile boolean  isEnd = true; //上一次闪电是否结束

    public static volatile boolean isUse = false;

    static{
        //修建敌人1死亡1图片
        icon1_1 = new ImageIcon("src/img/enemy1_down1.png");
        Image temp1_1 = icon1_1.getImage().getScaledInstance(71, 44, icon1_1.getImage().SCALE_DEFAULT);
        icon1_1 = new ImageIcon(temp1_1);
        //修建敌人1死亡2图片
        icon1_2 = new ImageIcon("src/img/enemy1_down2.png");
        Image temp1_2 = icon1_2.getImage().getScaledInstance(71, 44, icon1_2.getImage().SCALE_DEFAULT);
        icon1_2 = new ImageIcon(temp1_2);
        //修建敌人1死亡3图片
        icon1_3 = new ImageIcon("src/img/enemy1_down3.png");
        Image temp1_3 = icon1_3.getImage().getScaledInstance(71, 44, icon1_3.getImage().SCALE_DEFAULT);
        icon1_3 = new ImageIcon(temp1_3);
        //修建敌人1死亡4图片
        icon1_4 = new ImageIcon("src/img/enemy1_down4.png");
        Image temp1_4 = icon1_4.getImage().getScaledInstance(71, 44, icon1_4.getImage().SCALE_DEFAULT);
        icon1_4 = new ImageIcon(temp1_4);



        //修建敌人2死亡1图片
        icon2_1 = new ImageIcon("src/img/enemy2_down1.png");
        Image temp2_1 = icon2_1.getImage().getScaledInstance(118, 92, icon2_1.getImage().SCALE_DEFAULT);
        icon2_1 = new ImageIcon(temp2_1);
        //修建敌人2死亡2图片
        icon2_2 = new ImageIcon("src/img/enemy2_down2.png");
        Image temp2_2 = icon2_2.getImage().getScaledInstance(118, 92, icon2_2.getImage().SCALE_DEFAULT);
        icon2_2 = new ImageIcon(temp2_2);
        //修建敌人2死亡3图片
        icon2_3 = new ImageIcon("src/img/enemy2_down3.png");
        Image temp2_3 = icon2_3.getImage().getScaledInstance(118, 92, icon2_3.getImage().SCALE_DEFAULT);
        icon2_3 = new ImageIcon(temp2_3);
        //修建敌人2死亡4图片
        icon2_4 = new ImageIcon("src/img/enemy2_down4.png");
        Image temp2_4 = icon2_4.getImage().getScaledInstance(118, 92, icon2_4.getImage().SCALE_DEFAULT);
        icon2_4 = new ImageIcon(temp2_4);



        //修建敌人3死亡1图片
        icon3_1 = new ImageIcon("src/img/enemy3_down1.png");
        Image temp3_1 = icon3_1.getImage().getScaledInstance(186, 116, icon3_1.getImage().SCALE_DEFAULT);
        icon3_1 = new ImageIcon(temp3_1);
        //修建敌人3死亡2图片
        icon3_2 = new ImageIcon("src/img/enemy3_down2.png");
        Image temp3_2 = icon3_2.getImage().getScaledInstance(186, 116, icon3_2.getImage().SCALE_DEFAULT);
        icon3_2 = new ImageIcon(temp3_2);
        //修建敌人3死亡3图片
        icon3_3 = new ImageIcon("src/img/enemy3_down3.png");
        Image temp3_3 = icon3_3.getImage().getScaledInstance(186, 116, icon3_3.getImage().SCALE_DEFAULT);
        icon3_3 = new ImageIcon(temp3_3);
        //修建敌人3死亡4图片
        icon3_4 = new ImageIcon("src/img/enemy3_down4.png");
        Image temp3_4 = icon3_4.getImage().getScaledInstance(186, 116, icon3_4.getImage().SCALE_DEFAULT);
        icon3_4 = new ImageIcon(temp3_4);
        //修建敌人3死亡5图片
        icon3_5 = new ImageIcon("src/img/enemy3_down5.png");
        Image temp3_5 = icon3_5.getImage().getScaledInstance(186, 116, icon3_5.getImage().SCALE_DEFAULT);
        icon3_5 = new ImageIcon(temp3_5);
        //修建敌人3死亡6图片
        icon3_6 = new ImageIcon("src/img/enemy3_down6.png");
        Image temp3_6 = icon3_6.getImage().getScaledInstance(186, 116, icon3_6.getImage().SCALE_DEFAULT);
        icon3_6 = new ImageIcon(temp3_6);

        //奥义1
        icon_skill = new ImageIcon("src/img/雷遁雷牢术.png");
        Image temp_skill = icon_skill.getImage().getScaledInstance(256, 163, icon_skill.getImage().SCALE_DEFAULT);
        icon_skill = new ImageIcon(temp_skill);
        //奥义2
        icon_skill2 = new ImageIcon("src/img/地狱火炮.png");
        Image temp_skill2 = icon_skill2.getImage().getScaledInstance(256, 163, icon_skill2.getImage().SCALE_DEFAULT);
        icon_skill2 = new ImageIcon(temp_skill2);
        //奥义3
        icon_skill3 = new ImageIcon("src/img/寄坏虫飓.png");
        Image temp_skill3 = icon_skill3.getImage().getScaledInstance(256, 163, icon_skill3.getImage().SCALE_DEFAULT);
        icon_skill3 = new ImageIcon(temp_skill3);
        //奥义4
        icon_skill4 = new ImageIcon("src/img/黑暗行之术.png");
        Image temp_skill4 = icon_skill4.getImage().getScaledInstance(256, 163, icon_skill4.getImage().SCALE_DEFAULT);
        icon_skill4 = new ImageIcon(temp_skill4);
        //奥义5
        icon_skill5 = new ImageIcon("src/img/恸哭千鸟.png");
        Image temp_skill5 = icon_skill5.getImage().getScaledInstance(256, 163, icon_skill5.getImage().SCALE_DEFAULT);
        icon_skill5 = new ImageIcon(temp_skill5);
        //奥义6
        icon_skill6 = new ImageIcon("src/img/无声杀人术.png");
        Image temp_skill6 = icon_skill6.getImage().getScaledInstance(256, 163, icon_skill6.getImage().SCALE_DEFAULT);
        icon_skill6 = new ImageIcon(temp_skill6);

        //奥义字幕
        icon_skill_font = new ImageIcon("src/img/奥义字幕.png");
        Image temp_skill_font = icon_skill_font.getImage().getScaledInstance(358, 64, icon_skill_font.getImage().SCALE_DEFAULT);
        icon_skill_font = new ImageIcon(temp_skill_font);



        //雷电特效1
        icon_thunder = new ImageIcon("src/img/闪电1.png");
        Image temp_thunder = icon_thunder.getImage().getScaledInstance(47, 127, icon_thunder.getImage().SCALE_DEFAULT);
        icon_thunder = new ImageIcon(temp_thunder);
        //雷电特效2
        icon_thunder2 = new ImageIcon("src/img/闪电2.png");
        Image temp_thunder2 = icon_thunder2.getImage().getScaledInstance(47, 127, icon_thunder2.getImage().SCALE_DEFAULT);
        icon_thunder2 = new ImageIcon(temp_thunder2);
        //雷电特效3
        icon_thunder3 = new ImageIcon("src/img/闪电3.png");
        Image temp_thunder3 = icon_thunder3.getImage().getScaledInstance(47, 127, icon_thunder3.getImage().SCALE_DEFAULT);
        icon_thunder3 = new ImageIcon(temp_thunder3);
        //雷电特效4
        icon_thunder4 = new ImageIcon("src/img/闪电4.png");
        Image temp_thunder4 = icon_thunder4.getImage().getScaledInstance(47, 127, icon_thunder4.getImage().SCALE_DEFAULT);
        icon_thunder4 = new ImageIcon(temp_thunder4);
        //雷电特效5
        icon_thunder5 = new ImageIcon("src/img/闪电5.png");
        Image temp_thunder5 = icon_thunder5.getImage().getScaledInstance(47, 127, icon_thunder5.getImage().SCALE_DEFAULT);
        icon_thunder5 = new ImageIcon(temp_thunder5);
        //雷电特效6
        icon_thunder6 = new ImageIcon("src/img/闪电6.png");
        Image temp_thunder6 = icon_thunder6.getImage().getScaledInstance(47, 127, icon_thunder6.getImage().SCALE_DEFAULT);
        icon_thunder6 = new ImageIcon(temp_thunder6);
        //雷电特效7
        icon_thunder7 = new ImageIcon("src/img/闪电7.png");
        Image temp_thunder7 = icon_thunder7.getImage().getScaledInstance(47, 127, icon_thunder7.getImage().SCALE_DEFAULT);
        icon_thunder7 = new ImageIcon(temp_thunder7);


    }

    @Override
    public void run() {
        while (true){
            if(isUse){
                //如果炸弹数>0 并且 boss没有出现
                if(!Boss.boss_appear &&Main.player_entity.bomb>0){

                    //玩家炸弹数-1
                    Main.player_entity.bomb--;
                    //重新设置炸弹数量
                    Main.label_bomb_count.setText(" X "+Main.player_entity.bomb);

                    //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                    PlayerBulletCreate.isActive=false;
                    //暂停EnemyBullet线程（不要继续创建以及移动敌人子弹啦）
                    EnemyBullet.isTrue=false;
                    //暂停玩家collision方法（不要继续判断玩家碰撞检测方法了）
                    Player_Entity.isTure = false;
                    //暂停Enemy线程（不要继续创建及移动敌人）
                    Enemy.isTure = false;
                    //缓冲20ms 不能直接清空集合，否则数组下标越界
                    try{
                        Thread.sleep(20);
                    }catch (Exception E){
                        E.printStackTrace();
                    }
                    //开启一个线程播放字幕特效
                    new Thread(()->{
                        //创建地狱火炮label
                        JLabel label = new JLabel();
                        //奥义字幕label
                        JLabel label2 = new JLabel();

                        Random random = new Random();
                        int num = random.nextInt(6)+1;
                        if(num==1){
                            label.setIcon(icon_skill);
                        }else if(num==2){
                            label.setIcon(icon_skill2);
                        }else if(num==3){
                            label.setIcon(icon_skill3);
                        }else if(num==4){
                            label.setIcon(icon_skill4);
                        }else if(num==5){
                            label.setIcon(icon_skill5);
                        }else{
                            label.setIcon(icon_skill6);
                        }
                        label2.setIcon(icon_skill_font);

                        label.setBounds(500, 220, 256, 163);
                        label2.setBounds(-320, 540, 358, 64);
                        //将字体特效及奥义字幕添加到面板
                        Main.jp1.add(label);
                        Main.jp1.add(label2);
                        //字体入场特效
                        for(int i=1;i<=190;i++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-2, label.getY());
                            label2.setLocation(label2.getX()+2, label2.getY());
                        }

                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        for(int i=1;i<=190;i++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-2, label.getY());
                            label2.setLocation(label2.getX()+2, label2.getY());
                        }
                        //删除地狱火炮字体
                        Main.jp1.remove(label);
                        //删除奥义字幕
                        Main.jp1.remove(label2);

                    }).start();

                    //开启一个线程播放雷电特效
                    new Thread(()->{
                        //如果上一次雷电结束
                        if (isEnd){
                            //设置为未结束状态
                            isEnd = false;
                            //雷电集合
                            thunder_list = new ArrayList<>();
                            int[] pos = {20,350,210,50,190,320,30,177,280,90};
                            ImageIcon[] icons = {icon_thunder,icon_thunder2,icon_thunder3,icon_thunder4,icon_thunder5,icon_thunder6,icon_thunder7};
                            int count = 0;//雷电数量
                            int num = 0;
                            int index=0;//ImageIcon下标
                            //创建雷电label
                            for(;;){
                                num++;
                                //每循环13次创建一个雷电
                                if(num%13==0){
                                    JLabel label = new JLabel();
                                    //初始图片为闪电1
                                    label.setIcon(icons[index]);
                                    index=(index+1)%icons.length;

                                    label.setBounds(pos[count], 700, 47, 127);
                                    //将雷电特效添加到面板
                                    Main.jp1.add(label);
                                    //将雷电特效添加到集合
                                    thunder_list.add(label);
                                    count++;
                                    if(count>=10){
                                        //删除所有雷电
                                        for(int i=0;i<thunder_list.size();i++){
                                            //将雷电从面板删除
                                            Main.jp1.remove(thunder_list.get(i));
                                            //从集合中删除雷电
                                            thunder_list.remove(thunder_list.get(i));
                                            i--;
                                        }
                                        //设置为结束状态
                                        isEnd = true;
                                        break;
                                    }
                                    num = 0;
                                }
                                //移动集合中的雷电
                                for(int i=0;i<thunder_list.size();i++){
                                    try {
                                        Thread.sleep(2);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    //修改闪电图片依次递增
                                    if(i<thunder_list.size()){
                                        thunder_list.get(i).setIcon(icons[index]);
                                        index=(index+1)%icons.length;
                                        thunder_list.get(i).setLocation(thunder_list.get(i).getX(), thunder_list.get(i).getY()-10);
                                        if(thunder_list.get(i).getY()<0){
                                            //将雷电从面板删除
                                            Main.jp1.remove(thunder_list.get(i));
                                            //从集合中删除雷电
                                            thunder_list.remove(thunder_list.get(i));
                                            i--;
                                        }
                                    }

                                }


                            }
                        }



                    }).start();

                    //开启一个线程播放地狱火炮音乐
                    new Thread(()->{
                        GameMusic.Play("src/music/地狱火炮.wav",2);
                    }).start();

                    //遍历玩家子弹集合
                    for(int j=0;j<Main.bullets_list.size();j++){
                        //从面板上删除该子弹
                        Main.jp1.remove(Main.bullets_list.get(j));
                        //从子弹集合中删除该子弹
                        Main.bullets_list.remove(Main.bullets_list.get(j));
                        j--;
                    }
                    //对panel1本身进行重绘
                    Main.jp1.repaint();
                    //遍历敌人子弹集合
                    for(int j=0;j<Main.enemy_bullets_list.size();j++){
                        //从面板上删除该敌人子弹
                        Main.jp1.remove(Main.enemy_bullets_list.get(j).label);
                        //从敌人子弹集合中删除该子弹
                        Main.enemy_bullets_list.remove(Main.enemy_bullets_list.get(j));
                        j--;
                    }
                    //对panel1本身进行重绘
                    Main.jp1.repaint();
                    //从面板上删除所有敌人
                    for(int i=0;i<Main.enemy_list.size();i++){
                        //待死亡
                        if(Main.enemy_list.get(i).num==1){
                            //设置敌人1销毁图片1-4
                            Main.enemy_list.get(i).label.setIcon(icon1_1);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon1_2);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon1_3);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon1_4);
                        }else if(Main.enemy_list.get(i).num==2){
                            //设置敌人2销毁图片1-4
                            Main.enemy_list.get(i).label.setIcon(icon2_1);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon2_2);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon2_3);
                            try{
                                Thread.sleep(100);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon2_4);
                        }else{
                            //设置敌人3销毁图片1-6
                            Main.enemy_list.get(i).label.setIcon(icon3_1);
                            try{
                                Thread.sleep(60);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon3_2);
                            try{
                                Thread.sleep(60);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon3_3);
                            try{
                                Thread.sleep(60);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon3_4);
                            try{
                                Thread.sleep(60);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon3_5);
                            try{
                                Thread.sleep(60);
                            }catch (Exception E){
                                E.printStackTrace();
                            }
                            Main.enemy_list.get(i).label.setIcon(icon3_6);
                        }
                        try{
                            Thread.sleep(100);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        //积分增加
                        Main.score+=Main.enemy_list.get(i).num*10;
                        //重新设置积分榜显示
                        Main.label_Score.setText("当前积分:"+Main.score);
                        //从面板中删除该敌人
                        Main.jp1.remove(Main.enemy_list.get(i).label);
                        //从集合中删除该敌人
                        Main.enemy_list.remove(Main.enemy_list.get(i));
                        i--;
                        Main.jp1.repaint();//对panel1本身进行重绘
                    }

                    //重新开启Enemy线程（继续创建及移动敌人）
                    Enemy.isTure = true;
                    //重新开始玩家碰撞检测方法
                    Player_Entity.isTure = true;
                    //重新开启PlayerBulletCreate线程
                    PlayerBulletCreate.isActive=true;
                    //先生成敌人再生成敌人子弹
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    //重新开启EnemyBullet线程
                    EnemyBullet.isTrue=true;

                    //如果敌人出现 释放大招
                }else if(Boss.boss_appear &&Main.player_entity.bomb>0){
                    //玩家炸弹数-1
                    Main.player_entity.bomb--;
                    //重新设置炸弹数量
                    Main.label_bomb_count.setText(" X "+Main.player_entity.bomb);

                    //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                    PlayerBulletCreate.isActive=false;
                    //缓冲20ms 不能直接清空集合，否则数组下标越界
                    try{
                        Thread.sleep(20);
                    }catch (Exception E){
                        E.printStackTrace();
                    }
                    //开启一个线程播放字幕特效
                    new Thread(()->{
                        //创建地狱火炮label
                        JLabel label = new JLabel();
                        //奥义字幕label
                        JLabel label2 = new JLabel();

                        Random random = new Random();
                        int num = random.nextInt(6)+1;
                        if(num==1){
                            label.setIcon(icon_skill);
                        }else if(num==2){
                            label.setIcon(icon_skill2);
                        }else if(num==3){
                            label.setIcon(icon_skill3);
                        }else if(num==4){
                            label.setIcon(icon_skill4);
                        }else if(num==5){
                            label.setIcon(icon_skill5);
                        }else{
                            label.setIcon(icon_skill6);
                        }
                        label2.setIcon(icon_skill_font);

                        label.setBounds(500, 220, 256, 163);
                        label2.setBounds(-320, 540, 358, 64);
                        //将字体特效及奥义字幕添加到面板
                        Main.jp1.add(label);
                        Main.jp1.add(label2);
                        //字体入场特效
                        for(int i=1;i<=190;i++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-2, label.getY());
                            label2.setLocation(label2.getX()+2, label2.getY());
                        }

                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        for(int i=1;i<=190;i++){
                            try {
                                Thread.sleep(1);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            label.setLocation(label.getX()-2, label.getY());
                            label2.setLocation(label2.getX()+2, label2.getY());
                        }
                        //删除地狱火炮字体
                        Main.jp1.remove(label);
                        //删除奥义字幕
                        Main.jp1.remove(label2);

                    }).start();

                    //开启一个线程播放雷电特效
                    new Thread(()->{
                        //如果上一次雷电结束
                        if (isEnd){
                            //设置为未结束状态
                            isEnd = false;
                            //雷电集合
                            thunder_list = new ArrayList<>();
                            int[] pos = {20,350,210,50,190,320,30,177,280,90};
                            ImageIcon[] icons = {icon_thunder,icon_thunder2,icon_thunder3,icon_thunder4,icon_thunder5,icon_thunder6,icon_thunder7};
                            int count = 0;//雷电数量
                            int num = 0;
                            int index=0;//ImageIcon下标
                            //创建雷电label
                            for(;;){
                                num++;
                                //每循环13次创建一个雷电
                                if(num%13==0){
                                    JLabel label = new JLabel();
                                    //初始图片为闪电1
                                    label.setIcon(icons[index]);
                                    index=(index+1)%icons.length;

                                    label.setBounds(pos[count], 700, 47, 127);
                                    //将雷电特效添加到面板
                                    Main.jp1.add(label);
                                    //将雷电特效添加到集合
                                    thunder_list.add(label);
                                    count++;
                                    if(count>=10){
                                        //删除所有雷电
                                        for(int i=0;i<thunder_list.size();i++){
                                            //将雷电从面板删除
                                            Main.jp1.remove(thunder_list.get(i));
                                            //从集合中删除雷电
                                            thunder_list.remove(thunder_list.get(i));
                                            i--;
                                        }
                                        //设置为结束状态
                                        isEnd = true;
                                        break;
                                    }
                                    num = 0;
                                }
                                //移动集合中的雷电
                                for(int i=0;i<thunder_list.size();i++){
                                    try {
                                        Thread.sleep(2);
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    //修改闪电图片依次递增
                                    if(i<thunder_list.size()){
                                        thunder_list.get(i).setIcon(icons[index]);
                                        index=(index+1)%icons.length;
                                        thunder_list.get(i).setLocation(thunder_list.get(i).getX(), thunder_list.get(i).getY()-10);
                                        if(thunder_list.get(i).getY()<0){
                                            //将雷电从面板删除
                                            Main.jp1.remove(thunder_list.get(i));
                                            //从集合中删除雷电
                                            thunder_list.remove(thunder_list.get(i));
                                            i--;
                                        }
                                    }

                                }


                            }
                        }



                    }).start();

                    //开启一个线程播放地狱火炮音乐
                    new Thread(()->{
                        GameMusic.Play("src/music/地狱火炮.wav",2);
                    }).start();

                    //遍历玩家子弹集合
                    for(int j=0;j<Main.bullets_list.size();j++){
                        //从面板上删除该子弹
                        Main.jp1.remove(Main.bullets_list.get(j));
                        //从子弹集合中删除该子弹
                        Main.bullets_list.remove(Main.bullets_list.get(j));
                        j--;
                    }
                    //对panel1本身进行重绘
                    Main.jp1.repaint();

                    //对敌人造成200伤害
                    Main.boss.cur_health-=200;
                    //重新开启PlayerBulletCreate线程
                    PlayerBulletCreate.isActive=true;

                }else{
                    new Thread(()->{
                        GameMusic.Play("src/music/全屏炸弹不足.wav",2);
                    }).start();
                }

                isUse = false;
            }
        }
    }
}
