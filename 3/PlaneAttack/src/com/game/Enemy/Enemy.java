package com.game.Enemy;

import com.game.EnemyBullet.EnemyBullet;
import com.game.Panel.Main;
import com.game.Player.Player_Entity;
import com.game.Util.GameMusic;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy implements Runnable{
    private static  ImageIcon icon1;
    private static  ImageIcon icon2;
    private static  ImageIcon icon3;
    public volatile static  boolean isTure = true;
    static{
        //修建敌人1图片
        icon1 = new ImageIcon("src/img/enemy1.png");
        Image temp1 = icon1.getImage().getScaledInstance(71, 44, icon1.getImage().SCALE_DEFAULT);
        icon1 = new ImageIcon(temp1);

        //修建敌人2图片
        icon2 = new ImageIcon("src/img/enemy2.png");
        Image temp2 = icon2.getImage().getScaledInstance(118, 92, icon2.getImage().SCALE_DEFAULT);
        icon2 = new ImageIcon(temp2);

        //修建敌人3图片
        icon3 = new ImageIcon("src/img/enemy3.png");
        Image temp3 = icon3.getImage().getScaledInstance(186, 116, icon3.getImage().SCALE_DEFAULT);
        icon3 = new ImageIcon(temp3);

    }

    @Override
    public void run() {
        int count = 0;
        Random random = new Random();

        //开启创建敌人子弹线程
        EnemyBullet enemyBullet = new EnemyBullet();
        Thread thread_enemy_bullet = new Thread(enemyBullet);
        thread_enemy_bullet.start();

        while (true){
            //isTrue为真 则不停生成敌人并移动
            if(isTure){
                count++;
                //每循环 50 次并且敌人集合小于 6 时
                if(count%50==0&&Main.enemy_list.size()<6){
                    //生成一个随机数（1 2 3）敌人等级
                    int num = random.nextInt(3)+1;
                    //生成一个随机数 位置
                    int x = random.nextInt(400);
                    //创建敌人图片
                    JLabel label_enemy = new JLabel();

                    if(num==1){
                        label_enemy.setIcon(icon1);
                        label_enemy.setBounds(x,-50, 71, 44);
                    }else if(num==2){
                        label_enemy.setIcon(icon2);
                        label_enemy.setBounds(x,-80, 118, 92);
                    }else{
                        label_enemy.setIcon(icon3);
                        label_enemy.setBounds(x,-150, 186, 116);
                    }

                    //设置给敌人实体
                    Enemy_Entity enemy_entity = new Enemy_Entity(num,num*3, label_enemy);
                    //将敌人图片加入面板当中
                    Main.jp1.add(enemy_entity.label);
                    //将敌人实体加入集合当中
                    Main.enemy_list.add(enemy_entity);
                    count = 0;
                }
                //移动敌人
                for (int i=0;i<Main.enemy_list.size();i++){
                    if(!isTure){
                        break;
                    }
                    //统一速度
                    for(int j=1;j<=6-Main.enemy_list.size();j++){
                        try{
                            Thread.sleep(2);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    try{
                        Thread.sleep(4);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if(i<Main.enemy_list.size()){
                        Main.enemy_list.get(i).label.setLocation(Main.enemy_list.get(i).label.getX(), Main.enemy_list.get(i).label.getY()+4-Main.enemy_list.get(i).num);
                        //敌人到达指定位置
                        if(Main.enemy_list.get(i).label.getY()>700){
                            //暂停玩家collision()
                            Player_Entity.isTure = false;
                            //将敌人从面板删除
                            Main.jp1.remove(Main.enemy_list.get(i).label);
                            //从集合中删除敌人
                            Main.enemy_list.remove(Main.enemy_list.get(i));
                            i--;
                            //重新开启玩家collision()
                            Player_Entity.isTure = false;
                        }
                    }

                }
                Main.jp1.repaint();//对panel1本身进行重绘
            }

        }
    }
}
