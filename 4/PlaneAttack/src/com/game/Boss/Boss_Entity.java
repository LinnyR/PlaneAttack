package com.game.Boss;

import com.game.BossBullet.BossBullet;
import com.game.Panel.Main;
import com.game.Player.Player;
import com.game.Player.Player_Entity;
import com.game.PlayerBullet.PlayerBulletCreate;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Boss_Entity {
    public int total_health;
    public int cur_health;
    public JLabel label;
    public int dir;
    public int num;//0 1 2
    public static boolean isAttack = true;

    public static ImageIcon icon_warning_laser1;//激光警告1
    public static ImageIcon icon_warning_laser2;//激光警告2
    public static ImageIcon icon_warning_laser3;//激光警告3
    public static ImageIcon icon_warning_laser4;//激光警告4
    public static ImageIcon icon_laser;//Boss激光
    public static ImageIcon icon_laser_head;//Boss激光头
    public static ImageIcon icon_laser_head2;//Boss激光头






    public static ImageIcon icon;//玩家图片
    public static ImageIcon icon1;//玩家图片1
    public static ImageIcon icon2;//玩家图片2
    public static ImageIcon icon3;//玩家图片3
    public static ImageIcon icon4;//玩家图片4
    public static ImageIcon icon5_1;//无敌图片1
    public static ImageIcon icon5_2;//无敌图片2
    public static ImageIcon icon5_3;//无敌图片3
    public static ImageIcon icon5_4;//无敌图片4
    public static ImageIcon icon5_5;//无敌图片5
    public static ImageIcon icon5_6;//无敌图片6
    public static ImageIcon icon5_7;//无敌图片7

    public static ImageIcon icon_protect;//保护罩图片





    static {
        //修建激光警告1图片
        icon_warning_laser1 = new ImageIcon("src/img/Boss激光预警.png");
        Image temp_warning_laser1 = icon_warning_laser1.getImage().getScaledInstance(128, 128, icon_warning_laser1.getImage().SCALE_DEFAULT);
        icon_warning_laser1 = new ImageIcon(temp_warning_laser1);
        //修建激光警告2图片
        icon_warning_laser2 = new ImageIcon("src/img/Boss激光预警2.png");
        Image temp_warning_laser2 = icon_warning_laser2.getImage().getScaledInstance(128, 128, icon_warning_laser2.getImage().SCALE_DEFAULT);
        icon_warning_laser2 = new ImageIcon(temp_warning_laser2);
        //修建激光警告3图片
        icon_warning_laser3 = new ImageIcon("src/img/Boss激光预警3.png");
        Image temp_warning_laser3 = icon_warning_laser3.getImage().getScaledInstance(128, 128, icon_warning_laser3.getImage().SCALE_DEFAULT);
        icon_warning_laser3 = new ImageIcon(temp_warning_laser3);
        //修建激光警告4图片
        icon_warning_laser4 = new ImageIcon("src/img/Boss激光预警4.png");
        Image temp_warning_laser4 = icon_warning_laser4.getImage().getScaledInstance(128, 128, icon_warning_laser4.getImage().SCALE_DEFAULT);
        icon_warning_laser4 = new ImageIcon(temp_warning_laser4);

        //修建boss激光图片
        icon_laser = new ImageIcon("src/img/Boss激光.png");
        Image temp_laser = icon_laser.getImage().getScaledInstance(39, 2800, icon_laser.getImage().SCALE_DEFAULT);
        icon_laser = new ImageIcon(temp_laser);
        //修建boss激光头1图片
        icon_laser_head = new ImageIcon("src/img/Boss激光(头).png");
        Image temp_laser_head = icon_laser_head.getImage().getScaledInstance(87, 63, icon_laser_head.getImage().SCALE_DEFAULT);
        icon_laser_head = new ImageIcon(temp_laser_head);
        //修建boss激光头2图片
        icon_laser_head2 = new ImageIcon("src/img/Boss激光(头)2.png");
        Image temp_laser_head2 = icon_laser_head2.getImage().getScaledInstance(87, 63, icon_laser_head2.getImage().SCALE_DEFAULT);
        icon_laser_head2 = new ImageIcon(temp_laser_head2);







        //修建玩家图片
        icon = new ImageIcon("src/img/玩家"+ Player_Entity.player_index+"_1.png");
        Image temp = icon.getImage().getScaledInstance(85, 62, icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);
        //修建玩家死亡1图片
        icon1 = new ImageIcon("src/img/me_destroy_1.png");
        Image temp1 = icon1.getImage().getScaledInstance(85, 62, icon1.getImage().SCALE_DEFAULT);
        icon1 = new ImageIcon(temp1);
        //修建玩家死亡2图片
        icon2 = new ImageIcon("src/img/me_destroy_2.png");
        Image temp2 = icon2.getImage().getScaledInstance(85, 62, icon2.getImage().SCALE_DEFAULT);
        icon2 = new ImageIcon(temp2);
        //修建玩家死亡3图片
        icon3 = new ImageIcon("src/img/me_destroy_3.png");
        Image temp3 = icon3.getImage().getScaledInstance(85, 62, icon3.getImage().SCALE_DEFAULT);
        icon3 = new ImageIcon(temp3);
        //修建玩家死亡4图片
        icon4 = new ImageIcon("src/img/me_destroy_4.png");
        Image temp4 = icon4.getImage().getScaledInstance(85, 62, icon4.getImage().SCALE_DEFAULT);
        icon4 = new ImageIcon(temp4);

        //修建无敌1图片
        icon5_1 = new ImageIcon("src/img/无敌1.png");
        Image temp5_1 = icon5_1.getImage().getScaledInstance(246, 161, icon5_1.getImage().SCALE_DEFAULT);
        icon5_1 = new ImageIcon(temp5_1);
        //修建无敌2图片
        icon5_2 = new ImageIcon("src/img/无敌2.png");
        Image temp5_2 = icon5_2.getImage().getScaledInstance(246, 161, icon5_2.getImage().SCALE_DEFAULT);
        icon5_2 = new ImageIcon(temp5_2);
        //修建无敌3图片
        icon5_3 = new ImageIcon("src/img/无敌3.png");
        Image temp5_3 = icon5_3.getImage().getScaledInstance(246, 161, icon5_3.getImage().SCALE_DEFAULT);
        icon5_3 = new ImageIcon(temp5_3);
        //修建无敌4图片
        icon5_4 = new ImageIcon("src/img/无敌4.png");
        Image temp5_4 = icon5_4.getImage().getScaledInstance(246, 161, icon5_4.getImage().SCALE_DEFAULT);
        icon5_4 = new ImageIcon(temp5_4);
        //修建无敌5图片
        icon5_5 = new ImageIcon("src/img/无敌5.png");
        Image temp5_5 = icon5_5.getImage().getScaledInstance(246, 161, icon5_5.getImage().SCALE_DEFAULT);
        icon5_5 = new ImageIcon(temp5_5);
        //修建无敌6图片
        icon5_6 = new ImageIcon("src/img/无敌6.png");
        Image temp5_6 = icon5_6.getImage().getScaledInstance(246, 161, icon5_6.getImage().SCALE_DEFAULT);
        icon5_6 = new ImageIcon(temp5_6);
        //修建无敌7图片
        icon5_7 = new ImageIcon("src/img/无敌7.png");
        Image temp5_7 = icon5_7.getImage().getScaledInstance(246, 161, icon5_7.getImage().SCALE_DEFAULT);
        icon5_7 = new ImageIcon(temp5_7);

        //修建保护罩图片
        icon_protect = new ImageIcon("src/img/保护罩.png");
        Image temp_protect = icon_protect.getImage().getScaledInstance(100, 100, icon_protect.getImage().SCALE_DEFAULT);
        icon_protect = new ImageIcon(temp_protect);


    }
    public Boss_Entity(int total_health,int cur_health,JLabel label,int dir,int num){
        this.total_health = total_health;
        this.cur_health = cur_health;
        this.label = label;
        this.dir = dir;
        this.num = num;
    }
    //Boss1/2释放激光
    public static  void shootLaser(){
        //创建激光警告label
        JLabel warning_label = new JLabel();
        Main.jp1.add(warning_label);
        warning_label.setBounds(Main.boss.label.getX()+37, Main.boss.label.getY()+Main.boss.label.getHeight(), 128, 128);
        //闪烁四次
        for(int i=1;i<=4;i++){
            warning_label.setIcon(icon_warning_laser1);
            try {
                Thread.sleep(150);
            }catch (Exception e){
                e.printStackTrace();
            }
            warning_label.setIcon(icon_warning_laser2);
            try {
                Thread.sleep(150);
            }catch (Exception e){
                e.printStackTrace();
            }
            warning_label.setIcon(icon_warning_laser3);
            try {
                Thread.sleep(150);
            }catch (Exception e){
                e.printStackTrace();
            }
            warning_label.setIcon(icon_warning_laser4);
            try {
                Thread.sleep(150);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //删除激光警告label
        Main.jp1.remove(warning_label);

        //创建Boss激光头图片
        JLabel laser_head = new JLabel();
        Main.jp1.add(laser_head);
        laser_head.setIcon(icon_laser_head);
        laser_head.setBounds(Main.boss.label.getX()+59,Main.boss.label.getY()+Main.boss.label.getHeight()-30,87,63);

        //创建Boss激光图片
        Main.jp1.add(Main.Boss_laser1);
        Main.Boss_laser1.setIcon(icon_laser);
        Main.Boss_laser1.setBounds(Main.boss.label.getX()+85, Main.boss.label.getY()+Main.boss.label.getHeight(), 39, 10);

        //开启一个线程播放激光音效
        new Thread(()->{
            GameMusic.Play("src/music/激光.wav", 2.0);
        }).start();

        //把激光射出去
        for(int i=1;i<=69;i++){

            //修改激光头图片
            laser_head.setIcon(icon_laser_head);
            try {
                Thread.sleep(4);
            }catch (Exception e){
                e.printStackTrace();
            }
            laser_head.setIcon(icon_laser_head2);
            try {
                Thread.sleep(5);
            }catch (Exception e){
                e.printStackTrace();
            }
            //激光射出去
            Main.Boss_laser1.setBounds(Main.boss.label.getX()+85, Main.boss.label.getY()+Main.boss.label.getHeight(), Main.Boss_laser1.getWidth(), Main.Boss_laser1.getHeight()+10);
            //激光攻击玩家
            if(isAttack){
                laser_attackPlayer();
            }
        }

        //蝎子原地发射激光
        if(Main.boss.num==0){

            for(int i=1;i<=210;i++){
                //修改激光头图片
                laser_head.setIcon(icon_laser_head);
                try {
                    Thread.sleep(4);
                }catch (Exception e){
                    e.printStackTrace();
                }
                laser_head.setIcon(icon_laser_head2);
                try {
                    Thread.sleep(5);
                }catch (Exception e){
                    e.printStackTrace();
                }
                if(Main.boss.cur_health<=0){
                    break;
                }
                //激光射出去
                if(Main.boss!=null){
                    Main.Boss_laser1.setBounds(Main.boss.label.getX()+85, Main.boss.label.getY()+Main.boss.label.getHeight(), Main.Boss_laser1.getWidth(), Main.Boss_laser1.getHeight()+10);
                    //激光攻击玩家
                    if(isAttack){
                        laser_attackPlayer();
                    }
                }
            }

            //删除Boss激光头图片
            Main.jp1.remove(laser_head);
            //删除Boss激光图片
            Main.jp1.remove(Main.Boss_laser1);

            //狮子移动发射激光
        }else if(Main.boss.num==1){

            //开启一个线程移动激光
            new Thread(()->{
                for(int i=1;i<=210;i++){
                    //修改激光头图片
                    laser_head.setIcon(icon_laser_head);
                    try {
                        Thread.sleep(4);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    laser_head.setIcon(icon_laser_head2);
                    try {
                        Thread.sleep(5);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if(Main.boss.cur_health<=0){
                        break;
                    }
                    if(Main.boss!=null){
                        //移动激光头
                        laser_head.setBounds(Main.boss.label.getX()+59,Main.boss.label.getY()+Main.boss.label.getHeight()-30,87,63);
                        //移动激光
                        Main.Boss_laser1.setBounds(Main.boss.label.getX()+85, Main.boss.label.getY()+Main.boss.label.getHeight(), Main.Boss_laser1.getWidth(), Main.Boss_laser1.getHeight()+10);
                        //激光攻击玩家
                        if(isAttack){
                            laser_attackPlayer();
                        }
                    }
                }

                //删除Boss激光头图片
                Main.jp1.remove(laser_head);
                //删除Boss激光图片
                Main.jp1.remove(Main.Boss_laser1);

            }).start();

        }


    }

    public static void shoot_double_laser(){
        //创建两个激光警告label
        JLabel warning_label1 = new JLabel();
        JLabel warning_label2 = new JLabel();
        Main.jp1.add(warning_label1);
        Main.jp1.add(warning_label2);
        warning_label1.setBounds(Main.boss.label.getX()-30, Main.boss.label.getY()+Main.boss.label.getHeight(), 128, 128);
        warning_label2.setBounds(Main.boss.label.getX()+105, Main.boss.label.getY()+Main.boss.label.getHeight(), 128, 128);
        //闪烁四次
        for(int i=1;i<=4;i++){
            warning_label1.setIcon(icon_warning_laser1);
            warning_label2.setIcon(icon_warning_laser1);
            try {
                Thread.sleep(150);
            }catch (Exception e){
                e.printStackTrace();
            }
            warning_label1.setIcon(icon_warning_laser2);
            warning_label2.setIcon(icon_warning_laser2);
            try {
                Thread.sleep(150);
            }catch (Exception e){
                e.printStackTrace();
            }
            warning_label1.setIcon(icon_warning_laser3);
            warning_label2.setIcon(icon_warning_laser3);
            try {
                Thread.sleep(150);
            }catch (Exception e){
                e.printStackTrace();
            }
            warning_label1.setIcon(icon_warning_laser4);
            warning_label2.setIcon(icon_warning_laser4);
            try {
                Thread.sleep(150);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //删除激光警告label
        Main.jp1.remove(warning_label1);
        Main.jp1.remove(warning_label2);

        //创建Boss激光头图片
        JLabel laser_head1 = new JLabel();
        JLabel laser_head2 = new JLabel();
        Main.jp1.add(laser_head1);
        Main.jp1.add(laser_head2);
        laser_head1.setIcon(icon_laser_head);
        laser_head2.setIcon(icon_laser_head);
        laser_head1.setBounds(Main.boss.label.getX()+5,Main.boss.label.getY()+Main.boss.label.getHeight()-30,87,63);
        laser_head2.setBounds(Main.boss.label.getX()+105,Main.boss.label.getY()+Main.boss.label.getHeight()-30,87,63);


        //创建Boss激光图片
        Main.jp1.add(Main.Boss_laser1);
        Main.jp1.add(Main.Boss_laser2);
        Main.Boss_laser1.setIcon(icon_laser);
        Main.Boss_laser2.setIcon(icon_laser);
        Main.Boss_laser1.setBounds(Main.boss.label.getX()+31, Main.boss.label.getY()+Main.boss.label.getHeight(), 39, 10);
        Main.Boss_laser1.setBounds(Main.boss.label.getX()+131, Main.boss.label.getY()+Main.boss.label.getHeight(), 39, 10);

        //开启一个线程播放激光音效
        new Thread(()->{
            GameMusic.Play("src/music/激光.wav", 2.0);
        }).start();

        //把激光射出去
        for(int i=1;i<=69;i++){

            //修改激光头图片
            laser_head1.setIcon(icon_laser_head);
            laser_head2.setIcon(icon_laser_head);
            try {
                Thread.sleep(4);
            }catch (Exception e){
                e.printStackTrace();
            }
            laser_head1.setIcon(icon_laser_head2);
            laser_head2.setIcon(icon_laser_head2);
            try {
                Thread.sleep(5);
            }catch (Exception e){
                e.printStackTrace();
            }
            //激光射出去
            Main.Boss_laser1.setBounds(Main.boss.label.getX()+31, Main.boss.label.getY()+Main.boss.label.getHeight(), Main.Boss_laser1.getWidth(), Main.Boss_laser1.getHeight()+10);
            Main.Boss_laser2.setBounds(Main.boss.label.getX()+131, Main.boss.label.getY()+Main.boss.label.getHeight(), Main.Boss_laser1.getWidth(), Main.Boss_laser1.getHeight()+10);
            //激光攻击玩家
            if(isAttack){
                laser_attackPlayer();
            }
        }

        //塔罗人原地射出两道激光
        for(int i=1;i<=210;i++){
            //修改激光头图片
            laser_head1.setIcon(icon_laser_head);
            laser_head2.setIcon(icon_laser_head);
            try {
                Thread.sleep(4);
            }catch (Exception e){
                e.printStackTrace();
            }
            laser_head1.setIcon(icon_laser_head2);
            laser_head2.setIcon(icon_laser_head2);
            try {
                Thread.sleep(5);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(Main.boss.cur_health<=0){
                break;
            }
            //激光射出去
            if(Main.boss!=null){
                Main.Boss_laser1.setBounds(Main.boss.label.getX()+31, Main.boss.label.getY()+Main.boss.label.getHeight(), Main.Boss_laser1.getWidth(), Main.Boss_laser1.getHeight()+10);
                Main.Boss_laser2.setBounds(Main.boss.label.getX()+131, Main.boss.label.getY()+Main.boss.label.getHeight(), Main.Boss_laser1.getWidth(), Main.Boss_laser1.getHeight()+10);
                //激光攻击玩家
                if(isAttack){
                    laser_attackPlayer();
                }
            }
        }

        //删除Boss激光头图片
        Main.jp1.remove(laser_head1);
        Main.jp1.remove(laser_head2);
        //删除Boss激光图片
        Main.jp1.remove(Main.Boss_laser1);
        Main.jp1.remove(Main.Boss_laser2);

    }

    public static void laser_attackPlayer(){
        if((Main.player_entity.label.getX() - Main.Boss_laser1.getX() <=Main.Boss_laser1.getWidth()&&
        Main.Boss_laser1.getX() - Main.player_entity.label.getX()<=Main.player_entity.label.getWidth()&&
        Main.player_entity.label.getY()-Main.Boss_laser1.getY()<=Main.Boss_laser1.getHeight()&&
        Main.Boss_laser1.getY()-Main.player_entity.label.getY()<=Main.player_entity.label.getHeight())||
                ((Main.player_entity.label.getX() - Main.Boss_laser2.getX() <=Main.Boss_laser2.getWidth()&&
                Main.Boss_laser2.getX() - Main.player_entity.label.getX()<=Main.player_entity.label.getWidth()&&
                Main.player_entity.label.getY()-Main.Boss_laser2.getY()<=Main.Boss_laser2.getHeight()&&
                Main.Boss_laser2.getY()-Main.player_entity.label.getY()<=Main.player_entity.label.getHeight())
        )){
            //开启一个线程来播放玩家死亡动画
            new Thread(()->{

                //暂停PlayerBulletCreate玩家子弹发射线程
                PlayerBulletCreate.isActive = false;
                //暂停Player玩家移动线程
                Player.isActive = false;
                //暂停Boss激光攻击玩家的方法
                Boss_Entity.isAttack = false;
                //暂停BossBullet线程子弹攻击玩家的方法
                BossBullet.isAttack = false;

                //缓冲20ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合
                try{
                    Thread.sleep(20);
                }catch (Exception e){
                    e.printStackTrace();
                }

                //清空玩家子弹集合
                for(int j=0;j<Main.bullets_list.size();j++){
                    //从面板上删除该子弹
                    Main.jp1.remove(Main.bullets_list.get(j));
                    //从子弹集合中删除该子弹
                    Main.bullets_list.remove(Main.bullets_list.get(j));
                    j--;
                }

                //对panel1本身进行重绘
                Main.jp1.repaint();

                //开启一个新线程播放玩家死亡音效
                new Thread(()->{
                    GameMusic.Play("src/music/玩家死亡.wav",2);
                }).start();

                //设置爆炸图片1-4
                Main.player_entity.label.setIcon(icon1);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon2);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon3);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon4);
                try{
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }

                //回到初始位置
                Main.player_entity.label.setBounds(120,443,246,161);
                //无敌1-无敌7特效
                Main.player_entity.label.setIcon(icon5_1);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_2);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_3);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_4);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_5);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_6);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_7);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_6);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_5);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_4);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_3);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_2);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Main.player_entity.label.setIcon(icon5_1);
                try{
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }

                //恢复玩家图片
                Main.player_entity.label.setIcon(icon);
                Main.player_entity.label.setBounds(200,500,85, 62);

                //玩家生命值>0
                if(Main.player_entity.health>0){
                    //玩家生命值-1
                    Main.player_entity.health--;
                    //重新设置生命数量
                    Main.label_life_Count.setText(" X "+Main.player_entity.health);
                    //玩家等级回到1
                    Main.player_entity.level=1;
                }else{
                    //玩家生命值<=0
                    //游戏结束

                    //将分数写入记录.txt
                    try(PrintWriter pw = new PrintWriter(new FileWriter("src/record/记录.txt",true))){
                        pw.println(Main.label_Score.getText().split(":")[1]);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null,"时间结束！\n玩家积分为"+Main.label_Score.getText(),"时间结束", JOptionPane.WARNING_MESSAGE);

                    System.exit(0);
                }

                //重新开启Player线程
                Player.isActive = true;

                //增加保护罩图片
                JLabel label_protect = new JLabel();
                Main.jp1.add(label_protect);
                label_protect.setIcon(icon_protect);
                label_protect.setBounds(Main.player_entity.label.getX()-8, Main.player_entity.label.getY()-10, 100, 100);
                Main.jp1.repaint();

                //开启一个线程移动保护罩
                new Thread(()->{
                    for(int k=1;k<=500;k++){
                        label_protect.setIcon(icon_protect);
                        try{
                            Thread.sleep(4);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        label_protect.setBounds(Main.player_entity.label.getX()-8, Main.player_entity.label.getY()-18, 100, 100);
                    }
                }).start();

                //2000ms无敌时间
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                //删除保护罩图片
                Main.jp1.remove(label_protect);

                //重新开启PlayerBulletCreate线程
                PlayerBulletCreate.isActive=true;

                //重新开启Boss激光攻击玩家的方法
                Boss_Entity.isAttack = true;
                //重新开启BossBullet线程子弹攻击玩家的方法
                BossBullet.isAttack = true;


            }).start();


        }
    }

}
