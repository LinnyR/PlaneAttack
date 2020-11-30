package com.game.PlayerBullet;

import com.game.Enemy.Enemy;
import com.game.Enemy.Enemy_Entity;
import com.game.EnemyBullet.EnemyBullet;
import com.game.Panel.Main;
import com.game.Player.Player_Entity;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PlayerBullet_Entity {

    public static int count = 0;//击打Boss音效
    public static int count2 = 0;//显示火星
    public static int[] pos_x = {20,20,13,20,14,21,18,22,10,15,20};
    public static int[] pos_y = {130,150,120,150,120,150,140,110,150,140,120};

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

    public static ImageIcon icon_fireStar;//Boss身上火星

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
        Image temp3_1 = icon3_1.getImage().getScaledInstance(165, 105, icon3_1.getImage().SCALE_DEFAULT);
        icon3_1 = new ImageIcon(temp3_1);
        //修建敌人3死亡2图片
        icon3_2 = new ImageIcon("src/img/enemy3_down2.png");
        Image temp3_2 = icon3_2.getImage().getScaledInstance(165, 105, icon3_2.getImage().SCALE_DEFAULT);
        icon3_2 = new ImageIcon(temp3_2);
        //修建敌人3死亡3图片
        icon3_3 = new ImageIcon("src/img/enemy3_down3.png");
        Image temp3_3 = icon3_3.getImage().getScaledInstance(165, 105, icon3_3.getImage().SCALE_DEFAULT);
        icon3_3 = new ImageIcon(temp3_3);
        //修建敌人3死亡4图片
        icon3_4 = new ImageIcon("src/img/enemy3_down4.png");
        Image temp3_4 = icon3_4.getImage().getScaledInstance(165, 105, icon3_4.getImage().SCALE_DEFAULT);
        icon3_4 = new ImageIcon(temp3_4);
        //修建敌人3死亡5图片
        icon3_5 = new ImageIcon("src/img/enemy3_down5.png");
        Image temp3_5 = icon3_5.getImage().getScaledInstance(165, 105, icon3_5.getImage().SCALE_DEFAULT);
        icon3_5 = new ImageIcon(temp3_5);
        //修建敌人3死亡6图片
        icon3_6 = new ImageIcon("src/img/enemy3_down6.png");
        Image temp3_6 = icon3_6.getImage().getScaledInstance(165, 105, icon3_6.getImage().SCALE_DEFAULT);
        icon3_6 = new ImageIcon(temp3_6);

        //修建Boss火星图片
        icon_fireStar = new ImageIcon("src/img/火星.png");
        Image temp_fireStar = icon_fireStar.getImage().getScaledInstance(34, 31, icon_fireStar.getImage().SCALE_DEFAULT);
        icon_fireStar = new ImageIcon(temp_fireStar);
    }


    //子弹移动攻击敌人的方法
    public static void attackEnemy(){
        //判断有没有子弹和敌人相撞
        for(int i=0;i<Main.enemy_list.size();i++){
            for(int j=0;j<Main.bullets_list.size();j++){
                if(Main.enemy_list.get(i).num==1){
                    //单发子弹命中敌人1
                    if(Main.player_entity.level ==1){
                        if(Main.enemy_list.get(i).label.getX()-Main.bullets_list.get(j).getX()<=Main.bullets_list.get(j).getWidth()&&
                                Main.bullets_list.get(j).getY()-Main.enemy_list.get(i).label.getY()<=Main.enemy_list.get(i).label.getHeight()&&
                                Main.enemy_list.get(i).label.getY()-Main.bullets_list.get(j).getY()<=Main.bullets_list.get(j).getHeight()&&
                                Main.bullets_list.get(j).getX()-Main.enemy_list.get(i).label.getX()<=Main.enemy_list.get(i).label.getWidth()

                        ){

                            //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                            PlayerBulletCreate.isActive=false;

                            //缓冲0ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合
                            //执行该方法时已经处于PlayerBulletCreate线程当中，所以根本不会创建及移动子弹，所以无需暂停及缓冲

                            //从面板中删除该子弹
                            Main.jp1.remove(Main.bullets_list.get(j));
                            //从集合中删除该子弹
                            Main.bullets_list.remove(Main.bullets_list.get(j));
                            j--;
                            //重新开启PlayerBulletCreate线程
                            PlayerBulletCreate.isActive=true;

                            //当前敌人的生命值-1
                            Main.enemy_list.get(i).health--;
                            //敌人生命值为0
                            if(Main.enemy_list.get(i).health<=0){
                                //暂停玩家collision方法（不要继续判断玩家碰撞检测方法了）
                                Player_Entity.isTure = false;
                                //暂停Enemy线程（不要继续创建及移动敌人）
                                Enemy.isTure = false;
                                //暂停EnemyBullet线程（不要继续创建以及移动敌人子弹啦）
                                EnemyBullet.isTrue=false;
                                //
                                //缓冲10ms 不能直接删除集合，否则数组下标越界
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //开启一个线程播放敌人1死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/enemy1_down.wav",2);
                                }).start();
                                //设置敌人1销毁图片1-4
                                Main.enemy_list.get(i).label.setIcon(icon1_1);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon1_2);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon1_3);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon1_4);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                //积分增加
                                Main.score+=Main.enemy_list.get(i).num*10;
                                //重新设置积分榜显示
                                Main.label_Score.setText("当前积分:"+Main.score);
                                //从面板上删除该敌人
                                Main.jp1.remove(Main.enemy_list.get(i).label);
                                //从集合中删除该敌人
                                Main.enemy_list.remove(Main.enemy_list.get(i));
                                i--;
                                //对panel1本身进行重绘
                                Main.jp1.repaint();

                                //重新开启Enemy线程（继续创建及移动敌人）
                                Enemy.isTure = true;
                                //重新开始collision玩家碰撞检测方法
                                Player_Entity.isTure = true;
                                //重新开始EnemyBullet线程(继续创建以及移动敌人子弹)
                                EnemyBullet.isTrue=true;
                                //当该敌人死亡后 直接判断下一个敌人
                                break;
                            }

                        }
                        //双发子弹命中敌人1
                    }else if(Main.player_entity.level==2){
                        if(Main.enemy_list.get(i).label.getX()-Main.bullets_list.get(j).getX()<=Main.bullets_list.get(j).getWidth()&&
                                Main.bullets_list.get(j).getY()-Main.enemy_list.get(i).label.getY()<=Main.enemy_list.get(i).label.getHeight()&&
                                Main.enemy_list.get(i).label.getY()-Main.bullets_list.get(j).getY()<=Main.bullets_list.get(j).getHeight()&&
                                Main.bullets_list.get(j).getX()-Main.enemy_list.get(i).label.getX()<=Main.enemy_list.get(i).label.getWidth()

                        ){

                            //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                            PlayerBulletCreate.isActive=false;

                            //缓冲0ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合
                            //执行该方法时已经处于PlayerBulletCreate线程当中，所以根本不会创建及移动子弹，所以无需暂停及缓冲

                            //从面板中删除该子弹
                            Main.jp1.remove(Main.bullets_list.get(j));
                            //从集合中删除该子弹
                            Main.bullets_list.remove(Main.bullets_list.get(j));
                            j--;
                            //重新开启PlayerBulletCreate线程
                            PlayerBulletCreate.isActive=true;

                            //当前敌人的生命值-2
                            Main.enemy_list.get(i).health=Main.enemy_list.get(i).health-2;
                            //敌人生命值为0
                            if(Main.enemy_list.get(i).health<=0){
                                //暂停玩家collision方法（不要继续判断玩家碰撞检测方法了）
                                Player_Entity.isTure = false;
                                //暂停Enemy线程（不要继续创建及移动敌人）
                                Enemy.isTure = false;
                                //暂停EnemyBullet线程（不要继续创建以及移动敌人子弹啦）
                                EnemyBullet.isTrue=false;
                                //
                                //缓冲10ms 不能直接删除集合，否则数组下标越界
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //开启一个线程播放敌人1死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/enemy1_down.wav",2);
                                }).start();
                                //设置敌人1销毁图片1-4
                                Main.enemy_list.get(i).label.setIcon(icon1_1);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon1_2);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon1_3);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon1_4);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                //积分增加
                                Main.score+=Main.enemy_list.get(i).num*10;
                                //重新设置积分榜显示
                                Main.label_Score.setText("当前积分:"+Main.score);
                                //从面板上删除该敌人
                                Main.jp1.remove(Main.enemy_list.get(i).label);
                                //从集合中删除该敌人
                                Main.enemy_list.remove(Main.enemy_list.get(i));
                                i--;
                                //对panel1本身进行重绘
                                Main.jp1.repaint();

                                //重新开启Enemy线程（继续创建及移动敌人）
                                Enemy.isTure = true;
                                //重新开始collision玩家碰撞检测方法
                                Player_Entity.isTure = true;
                                //重新开始EnemyBullet线程(继续创建以及移动敌人子弹)
                                EnemyBullet.isTrue=true;
                                //当该敌人死亡后 直接判断下一个敌人
                                break;
                            }

                        }
                        //三发子弹命中敌人1
                    }else{
                        if(Main.enemy_list.get(i).label.getX()-Main.bullets_list.get(j).getX()<=Main.bullets_list.get(j).getWidth()&&
                                Main.bullets_list.get(j).getY()-Main.enemy_list.get(i).label.getY()<=Main.enemy_list.get(i).label.getHeight()&&
                                Main.enemy_list.get(i).label.getY()-Main.bullets_list.get(j).getY()<=Main.bullets_list.get(j).getHeight()&&
                                Main.bullets_list.get(j).getX()-Main.enemy_list.get(i).label.getX()<=Main.enemy_list.get(i).label.getWidth()

                        ){

                            //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                            PlayerBulletCreate.isActive=false;

                            //缓冲0ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合

                            //执行该方法时已经处于PlayerBulletCreate线程当中，所以根本不会创建及移动子弹，所以无需暂停及缓冲

                            //从面板中删除该子弹
                            Main.jp1.remove(Main.bullets_list.get(j));
                            //从集合中删除该子弹
                            Main.bullets_list.remove(Main.bullets_list.get(j));
                            j--;

                            //重新开启PlayerBulletCreate线程
                            PlayerBulletCreate.isActive=true;

                            //当前敌人的生命值-3
                            Main.enemy_list.get(i).health=Main.enemy_list.get(i).health-3;
                            //敌人生命值为0
                            if(Main.enemy_list.get(i).health<=0){
                                //暂停玩家collision方法（不要继续判断玩家碰撞检测方法了）
                                Player_Entity.isTure = false;
                                //暂停Enemy线程（不要继续创建及移动敌人）
                                Enemy.isTure = false;
                                //暂停EnemyBullet线程（不要继续创建以及移动敌人子弹啦）
                                EnemyBullet.isTrue=false;
                                //
                                //缓冲10ms 不能直接删除集合，否则数组下标越界
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //开启一个线程播放敌人1死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/enemy1_down.wav",2);
                                }).start();
                                //设置敌人1销毁图片1-4
                                Main.enemy_list.get(i).label.setIcon(icon1_1);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon1_2);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon1_3);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon1_4);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                //积分增加
                                Main.score+=Main.enemy_list.get(i).num*10;
                                //重新设置积分榜显示
                                Main.label_Score.setText("当前积分:"+Main.score);
                                //从面板上删除该敌人
                                Main.jp1.remove(Main.enemy_list.get(i).label);
                                //从集合中删除该敌人
                                Main.enemy_list.remove(Main.enemy_list.get(i));
                                i--;
                                //对panel1本身进行重绘
                                Main.jp1.repaint();

                                //重新开启Enemy线程（继续创建及移动敌人）
                                Enemy.isTure = true;
                                //重新开始collision玩家碰撞检测方法
                                Player_Entity.isTure = true;
                                //重新开始EnemyBullet线程(继续创建以及移动敌人子弹)
                                EnemyBullet.isTrue=true;
                                //当该敌人死亡后 直接判断下一个敌人
                                break;
                            }

                        }
                    }

                }else if(Main.enemy_list.get(i).num==2){
                    //单发子弹命中敌人2
                    if(Main.player_entity.level==1){
                        if(Main.enemy_list.get(i).label.getX()-Main.bullets_list.get(j).getX()<=Main.bullets_list.get(j).getWidth()&&
                                Main.bullets_list.get(j).getY()-Main.enemy_list.get(i).label.getY()<=Main.enemy_list.get(i).label.getHeight()&&
                                Main.enemy_list.get(i).label.getY()-Main.bullets_list.get(j).getY()<=Main.bullets_list.get(j).getHeight()&&
                                Main.bullets_list.get(j).getX()-Main.enemy_list.get(i).label.getX()<=Main.enemy_list.get(i).label.getWidth()

                        ){
                            //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                            PlayerBulletCreate.isActive=false;

                            //缓冲0ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合

                            //从面板中删除该子弹
                            Main.jp1.remove(Main.bullets_list.get(j));
                            //从集合中删除该子弹
                            Main.bullets_list.remove(Main.bullets_list.get(j));
                            j--;
                            //重新开启PlayerBulletCreate线程
                            PlayerBulletCreate.isActive=true;

                            //当前敌人的生命值-1
                            Main.enemy_list.get(i).health--;
                            //敌人生命值为0
                            if(Main.enemy_list.get(i).health<=0){
                                //暂停玩家collision方法（不要继续判断玩家碰撞检测方法了）
                                Player_Entity.isTure = false;
                                //暂停Enemy线程（不要继续创建及移动敌人）
                                Enemy.isTure = false;
                                //缓冲10ms 不能直接删除集合，否则数组下标越界
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //开启一个线程播放敌人2死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/enemy2_down.wav",2);
                                }).start();
                                //设置敌人2销毁图片1-4
                                Main.enemy_list.get(i).label.setIcon(icon2_1);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon2_2);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon2_3);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon2_4);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                //积分增加
                                Main.score+=Main.enemy_list.get(i).num*10;
                                //重新设置积分榜显示
                                Main.label_Score.setText("当前积分:"+Main.score);
                                //从面板上删除该敌人
                                Main.jp1.remove(Main.enemy_list.get(i).label);
                                //从集合中删除该敌人
                                Main.enemy_list.remove(Main.enemy_list.get(i));
                                i--;
                                //对panel1本身进行重绘
                                Main.jp1.repaint();

                                //重新开启Enemy线程（继续创建及移动敌人）
                                Enemy.isTure = true;
                                //重新开始玩家碰撞检测方法
                                Player_Entity.isTure = true;
                                //当该敌人死亡后 直接判断下一个敌人
                                break;

                            }

                        }
                        //双发子弹命中敌人2
                    }else if(Main.player_entity.level==2){
                        if(Main.enemy_list.get(i).label.getX()-Main.bullets_list.get(j).getX()<=Main.bullets_list.get(j).getWidth()&&
                                Main.bullets_list.get(j).getY()-Main.enemy_list.get(i).label.getY()<=Main.enemy_list.get(i).label.getHeight()&&
                                Main.enemy_list.get(i).label.getY()-Main.bullets_list.get(j).getY()<=Main.bullets_list.get(j).getHeight()&&
                                Main.bullets_list.get(j).getX()-Main.enemy_list.get(i).label.getX()<=Main.enemy_list.get(i).label.getWidth()

                        ){
                            //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                            PlayerBulletCreate.isActive=false;

                            //缓冲0ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合

                            //从面板中删除该子弹
                            Main.jp1.remove(Main.bullets_list.get(j));
                            //从集合中删除该子弹
                            Main.bullets_list.remove(Main.bullets_list.get(j));
                            j--;
                            //重新开启PlayerBulletCreate线程
                            PlayerBulletCreate.isActive=true;

                            //当前敌人的生命值-2
                            Main.enemy_list.get(i).health= Main.enemy_list.get(i).health-2;
                            //敌人生命值为0
                            if(Main.enemy_list.get(i).health<=0){
                                //暂停玩家collision方法（不要继续判断玩家碰撞检测方法了）
                                Player_Entity.isTure = false;
                                //暂停Enemy线程（不要继续创建及移动敌人）
                                Enemy.isTure = false;
                                //缓冲10ms 不能直接删除集合，否则数组下标越界
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //开启一个线程播放敌人2死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/enemy2_down.wav",2);
                                }).start();
                                //设置敌人2销毁图片1-4
                                Main.enemy_list.get(i).label.setIcon(icon2_1);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon2_2);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon2_3);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon2_4);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                //积分增加
                                Main.score+=Main.enemy_list.get(i).num*10;
                                //重新设置积分榜显示
                                Main.label_Score.setText("当前积分:"+Main.score);
                                //从面板上删除该敌人
                                Main.jp1.remove(Main.enemy_list.get(i).label);
                                //从集合中删除该敌人
                                Main.enemy_list.remove(Main.enemy_list.get(i));
                                i--;
                                //对panel1本身进行重绘
                                Main.jp1.repaint();

                                //重新开启Enemy线程（继续创建及移动敌人）
                                Enemy.isTure = true;
                                //重新开始玩家碰撞检测方法
                                Player_Entity.isTure = true;
                                //当该敌人死亡后 直接判断下一个敌人
                                break;

                            }

                        }
                        //三发子弹命中敌人2
                    }else{
                        if(Main.enemy_list.get(i).label.getX()-Main.bullets_list.get(j).getX()<=Main.bullets_list.get(j).getWidth()&&
                                Main.bullets_list.get(j).getY()-Main.enemy_list.get(i).label.getY()<=Main.enemy_list.get(i).label.getHeight()&&
                                Main.enemy_list.get(i).label.getY()-Main.bullets_list.get(j).getY()<=Main.bullets_list.get(j).getHeight()&&
                                Main.bullets_list.get(j).getX()-Main.enemy_list.get(i).label.getX()<=Main.enemy_list.get(i).label.getWidth()

                        ){
                            //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                            PlayerBulletCreate.isActive=false;

                            //缓冲0ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合

                            //从面板中删除该子弹
                            Main.jp1.remove(Main.bullets_list.get(j));
                            //从集合中删除该子弹
                            Main.bullets_list.remove(Main.bullets_list.get(j));
                            j--;


                            //重新开启PlayerBulletCreate线程
                            PlayerBulletCreate.isActive=true;

                            //当前敌人的生命值-3
                            Main.enemy_list.get(i).health= Main.enemy_list.get(i).health-3;
                            //敌人生命值为0
                            if(Main.enemy_list.get(i).health<=0){
                                //暂停玩家collision方法（不要继续判断玩家碰撞检测方法了）
                                Player_Entity.isTure = false;
                                //暂停Enemy线程（不要继续创建及移动敌人）
                                Enemy.isTure = false;
                                //缓冲10ms 不能直接删除集合，否则数组下标越界
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //开启一个线程播放敌人2死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/enemy2_down.wav",2);
                                }).start();
                                //设置敌人2销毁图片1-4
                                Main.enemy_list.get(i).label.setIcon(icon2_1);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon2_2);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon2_3);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon2_4);
                                try{
                                    Thread.sleep(10);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                //积分增加
                                Main.score+=Main.enemy_list.get(i).num*10;
                                //重新设置积分榜显示
                                Main.label_Score.setText("当前积分:"+Main.score);
                                //从面板上删除该敌人
                                Main.jp1.remove(Main.enemy_list.get(i).label);
                                //从集合中删除该敌人
                                Main.enemy_list.remove(Main.enemy_list.get(i));
                                i--;
                                //对panel1本身进行重绘
                                Main.jp1.repaint();

                                //重新开启Enemy线程（继续创建及移动敌人）
                                Enemy.isTure = true;
                                //重新开始玩家碰撞检测方法
                                Player_Entity.isTure = true;
                                //当该敌人死亡后 直接判断下一个敌人
                                break;

                            }

                        }

                    }



                }else{
                    //单发子弹命中敌人3
                    if(Main.player_entity.level==1){
                        if(Main.enemy_list.get(i).label.getX()-Main.bullets_list.get(j).getX()<=Main.bullets_list.get(j).getWidth()&&
                                Main.bullets_list.get(j).getY()-Main.enemy_list.get(i).label.getY()<=Main.enemy_list.get(i).label.getHeight()&&
                                Main.enemy_list.get(i).label.getY()-Main.bullets_list.get(j).getY()<=Main.bullets_list.get(j).getHeight()&&
                                Main.bullets_list.get(j).getX()-Main.enemy_list.get(i).label.getX()<=Main.enemy_list.get(i).label.getWidth()

                        ){
                            //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                            PlayerBulletCreate.isActive=false;

                            //缓冲0ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合

                            //从面板中删除该子弹
                            Main.jp1.remove(Main.bullets_list.get(j));
                            //从集合中删除该子弹
                            Main.bullets_list.remove(Main.bullets_list.get(j));
                            j--;
                            //重新开启PlayerBulletCreate线程
                            PlayerBulletCreate.isActive=true;

                            //当前敌人的生命值-1
                            Main.enemy_list.get(i).health--;
                            //敌人生命值为0
                            if(Main.enemy_list.get(i).health<=0){
                                //暂停玩家collision方法（不要继续判断玩家碰撞检测方法了）
                                Player_Entity.isTure = false;
                                //暂停Enemy线程（不要继续创建及移动敌人）
                                Enemy.isTure = false;
                                //缓冲10ms 不能直接删除集合，否则数组下标越界
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //开启一个线程播放敌人3死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/enemy3_down.wav",2.0);
                                }).start();
                                //设置敌人3销毁图片1-6
                                Main.enemy_list.get(i).label.setIcon(icon3_1);
                                try{
                                    Thread.sleep(6);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_2);
                                try{
                                    Thread.sleep(6);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_3);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_4);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_5);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_6);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                //积分增加
                                Main.score+=Main.enemy_list.get(i).num*10;
                                //重新设置积分榜显示
                                Main.label_Score.setText("当前积分:"+Main.score);
                                //从面板上删除该敌人
                                Main.jp1.remove(Main.enemy_list.get(i).label);
                                //从集合中删除该敌人
                                Main.enemy_list.remove(Main.enemy_list.get(i));
                                i--;
                                //对panel1本身进行重绘
                                Main.jp1.repaint();

                                //重新开启Enemy线程（继续创建及移动敌人）
                                Enemy.isTure = true;
                                //重新开始collision玩家碰撞检测方法
                                Player_Entity.isTure = true;
                                //当该敌人死亡后 直接判断下一个敌人
                                break;
                            }


                        }

                        //双发子弹命中敌人3
                    }else if(Main.player_entity.level==2){
                        if(Main.enemy_list.get(i).label.getX()-Main.bullets_list.get(j).getX()<=Main.bullets_list.get(j).getWidth()&&
                                Main.bullets_list.get(j).getY()-Main.enemy_list.get(i).label.getY()<=Main.enemy_list.get(i).label.getHeight()&&
                                Main.enemy_list.get(i).label.getY()-Main.bullets_list.get(j).getY()<=Main.bullets_list.get(j).getHeight()&&
                                Main.bullets_list.get(j).getX()-Main.enemy_list.get(i).label.getX()<=Main.enemy_list.get(i).label.getWidth()

                        ){
                            //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                            PlayerBulletCreate.isActive=false;

                            //缓冲0ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合

                            //从面板中删除该子弹
                            Main.jp1.remove(Main.bullets_list.get(j));
                            //从集合中删除该子弹
                            Main.bullets_list.remove(Main.bullets_list.get(j));
                            j--;
                            //重新开启PlayerBulletCreate线程
                            PlayerBulletCreate.isActive=true;

                            //当前敌人的生命值-2
                            Main.enemy_list.get(i).health=Main.enemy_list.get(i).health-2;
                            //敌人生命值为0
                            if(Main.enemy_list.get(i).health<=0){
                                //暂停玩家collision方法（不要继续判断玩家碰撞检测方法了）
                                Player_Entity.isTure = false;
                                //暂停Enemy线程（不要继续创建及移动敌人）
                                Enemy.isTure = false;
                                //缓冲10ms 不能直接删除集合，否则数组下标越界
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //开启一个线程播放敌人3死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/enemy3_down.wav",2.0);
                                }).start();
                                //设置敌人3销毁图片1-6
                                Main.enemy_list.get(i).label.setIcon(icon3_1);
                                try{
                                    Thread.sleep(6);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_2);
                                try{
                                    Thread.sleep(6);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_3);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_4);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_5);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_6);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                //积分增加
                                Main.score+=Main.enemy_list.get(i).num*10;
                                //重新设置积分榜显示
                                Main.label_Score.setText("当前积分:"+Main.score);
                                //从面板上删除该敌人
                                Main.jp1.remove(Main.enemy_list.get(i).label);
                                //从集合中删除该敌人
                                Main.enemy_list.remove(Main.enemy_list.get(i));
                                i--;
                                //对panel1本身进行重绘
                                Main.jp1.repaint();

                                //重新开启Enemy线程（继续创建及移动敌人）
                                Enemy.isTure = true;
                                //重新开始collision玩家碰撞检测方法
                                Player_Entity.isTure = true;
                                //当该敌人死亡后 直接判断下一个敌人
                                break;
                            }


                        }

                        //三发子弹命中敌人3
                    }else{
                        if(Main.enemy_list.get(i).label.getX()-Main.bullets_list.get(j).getX()<=Main.bullets_list.get(j).getWidth()&&
                                Main.bullets_list.get(j).getY()-Main.enemy_list.get(i).label.getY()<=Main.enemy_list.get(i).label.getHeight()&&
                                Main.enemy_list.get(i).label.getY()-Main.bullets_list.get(j).getY()<=Main.bullets_list.get(j).getHeight()&&
                                Main.bullets_list.get(j).getX()-Main.enemy_list.get(i).label.getX()<=Main.enemy_list.get(i).label.getWidth()

                        ){
                            //暂停PlayerBulletCreate线程（不要继续创建以及移动子弹啦）  isTrue是PlayerBulletCreate的标志位
                            PlayerBulletCreate.isActive=false;

                            //缓冲0ms 因为此时移动子弹的循环可能还没结束 不可以立马清空子弹集合

                            //从面板中删除该子弹
                            Main.jp1.remove(Main.bullets_list.get(j));
                            //从集合中删除该子弹
                            Main.bullets_list.remove(Main.bullets_list.get(j));
                            j--;


                            //重新开启PlayerBulletCreate线程
                            PlayerBulletCreate.isActive=true;

                            //当前敌人的生命值-3
                            Main.enemy_list.get(i).health=Main.enemy_list.get(i).health-3;
                            //敌人生命值为0
                            if(Main.enemy_list.get(i).health<=0){
                                //暂停玩家collision方法（不要继续判断玩家碰撞检测方法了）
                                Player_Entity.isTure = false;
                                //暂停Enemy线程（不要继续创建及移动敌人）
                                Enemy.isTure = false;
                                //缓冲10ms 不能直接删除集合，否则数组下标越界
                                try{
                                    Thread.sleep(10);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                //开启一个线程播放敌人3死亡音效
                                new Thread(()->{
                                    GameMusic.Play("src/music/enemy3_down.wav",2.0);
                                }).start();
                                //设置敌人3销毁图片1-6
                                Main.enemy_list.get(i).label.setIcon(icon3_1);
                                try{
                                    Thread.sleep(6);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_2);
                                try{
                                    Thread.sleep(6);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_3);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_4);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_5);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                Main.enemy_list.get(i).label.setIcon(icon3_6);
                                try{
                                    Thread.sleep(7);
                                }catch (Exception E){
                                    E.printStackTrace();
                                }
                                //积分增加
                                Main.score+=Main.enemy_list.get(i).num*10;
                                //重新设置积分榜显示
                                Main.label_Score.setText("当前积分:"+Main.score);
                                //从面板上删除该敌人
                                Main.jp1.remove(Main.enemy_list.get(i).label);
                                //从集合中删除该敌人
                                Main.enemy_list.remove(Main.enemy_list.get(i));
                                i--;
                                //对panel1本身进行重绘
                                Main.jp1.repaint();

                                //重新开启Enemy线程（继续创建及移动敌人）
                                Enemy.isTure = true;
                                //重新开始collision玩家碰撞检测方法
                                Player_Entity.isTure = true;
                                //当该敌人死亡后 直接判断下一个敌人
                                break;
                            }


                        }
                    }


                }
            }
        }
        //如果boss存在
        if(Main.boss!=null){
            //遍历子弹列表
            for(int j=0;j<Main.bullets_list.size();j++){
                //单发子弹
                if(Main.player_entity.level==1){
                    if(Main.bullets_list.get(j).getX()-Main.boss.label.getX()<=203&&Main.bullets_list.get(j).getY()-Main.boss.label.getY()<=216&&
                    Main.boss.label.getX()-Main.bullets_list.get(j).getX()<=27&&Main.boss.label.getY()-Main.bullets_list.get(j).getY()<=22){

                        //从面板中删除该子弹
                        Main.jp1.remove(Main.bullets_list.get(j));
                        //从集合中删除该子弹
                        Main.bullets_list.remove(Main.bullets_list.get(j));
                        j--;

                        //对Boss造成1伤害
                        if(Main.boss!=null){
                            Main.boss.cur_health-=1;
                        }



                        //开一个线程在Boss身上添加火星
                        new Thread(()->{
                            //创建火星label
                            JLabel label = new JLabel();
                            //添加到Boss图片上面
                            Main.boss.label.add(label);
                            label.setIcon(icon_fireStar);
                            label.setBounds(Main.boss.label.getX()+pos_x[count2]-70, Main.boss.label.getY()+pos_y[count2], 34, 31);
                            //停留20ms
                            try {
                                Thread.sleep(20);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            //删除火星label
                            Main.boss.label.remove(label);
                            count2=(count2+1)%pos_x.length;

                        }).start();

                        count++;
                        if(count%3==0){
                            //开启一个线程播放击打Boss音效
                            new Thread(()->{
                                GameMusic.Play("src/music/击中Boss.wav", 0.8);
                            }).start();
                            count=0;
                        }


                    }
                    //双发子弹
                }else if(Main.player_entity.level==2){

                    if(Main.bullets_list.get(j).getX()-Main.boss.label.getX()<=203&&Main.bullets_list.get(j).getY()-Main.boss.label.getY()<=216&&
                    Main.boss.label.getX()-Main.bullets_list.get(j).getX()<=44&&Main.boss.label.getY()-Main.bullets_list.get(j).getY()<=21){
                        //从面板中删除该子弹
                        Main.jp1.remove(Main.bullets_list.get(j));
                        //从集合中删除该子弹
                        Main.bullets_list.remove(Main.bullets_list.get(j));
                        j--;

                        //对Boss造成2伤害
                        if(Main.boss!=null){
                            Main.boss.cur_health-=2;
                        }



                        //开一个线程在Boss身上添加火星
                        new Thread(()->{
                            //创建火星label
                            JLabel label = new JLabel();
                            //添加到Boss图片上面
                            Main.boss.label.add(label);
                            label.setIcon(icon_fireStar);
                            label.setBounds(Main.boss.label.getX()+pos_x[count2]-70, Main.boss.label.getY()+pos_y[count2], 34 ,31);
                            //停留20ms
                            try {
                                Thread.sleep(20);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            //删除火星label
                            Main.boss.label.remove(label);
                            count2=(count2+1)%pos_x.length;

                        }).start();

                        count++;
                        if(count%3==0){
                            //开启一个线程播放击打Boss音效
                            new Thread(()->{
                                GameMusic.Play("src/music/击中Boss.wav", 0.8);
                            }).start();
                            count=0;
                        }

                    }

                    //三发子弹
                }else{
                    if(Main.bullets_list.get(j).getX()-Main.boss.label.getX()<=203&&Main.bullets_list.get(j).getY()-Main.boss.label.getY()<=216&&
                    Main.boss.label.getX()-Main.bullets_list.get(j).getX()<=50&&Main.boss.label.getY()-Main.bullets_list.get(j).getY()<=21){
                        //从面板中删除该子弹
                        Main.jp1.remove(Main.bullets_list.get(j));
                        //从集合中删除该子弹
                        Main.bullets_list.remove(Main.bullets_list.get(j));
                        j--;

                        //对Boss造成3伤害
                        if(Main.boss!=null){
                            Main.boss.cur_health-=3;
                        }



                        //开一个线程在Boss身上添加火星
                        new Thread(()->{
                            //创建火星label
                            JLabel label = new JLabel();
                            //添加到Boss图片上面
                            Main.boss.label.add(label);
                            label.setIcon(icon_fireStar);
                            label.setBounds(Main.boss.label.getX()+pos_x[count2]-70, Main.boss.label.getY()+pos_y[count2], 34, 31);
                            //停留20ms
                            try {
                                Thread.sleep(20);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            //删除火星label
                            Main.boss.label.remove(label);
                            count2=(count2+1)%pos_x.length;

                        }).start();

                        count++;
                        if(count%3==0){
                            //开启一个线程播放击打Boss音效
                            new Thread(()->{
                                GameMusic.Play("src/music/击中Boss.wav", 0.8);
                            }).start();
                            count=0;
                        }

                    }




                }
            }
        }
    }
}
