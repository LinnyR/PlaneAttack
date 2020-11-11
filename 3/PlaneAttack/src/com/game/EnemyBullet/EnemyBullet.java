package com.game.EnemyBullet;


import com.game.Panel.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EnemyBullet implements Runnable{
    int distant; //飞行距离 = 100 + 等级*30
    int interval;//发射间隔 = 800/等级 ms
    int speed;   //发射速度 = 10*等级
    private static ImageIcon icon ;
    public static volatile boolean isTrue = true; //是否继续创建及移动子弹
    public  static volatile  boolean isAttack = true;//是否攻击玩家
    static{
        //修建图片
        icon = new ImageIcon("src/img/enemyBullet.png");
        Image temp = icon.getImage().getScaledInstance(18, 29, icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(temp);
    }

    @Override
    public void run() {
        int count = 0;
        int count2 = 0;//每20次执行一次敌人子弹攻击玩家的方法
        Random random = new Random();
        //给100ms缓冲 先生成敌人
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        while(true){
            if(isTrue){
                count++;
                count2++;
                int index=0;
                int num = 0;
                //每循环10次发射一颗子弹
                if(count%10==0&&Main.enemy_bullets_list.size()<Main.player_entity.level+3){
                    //随机生成产生子弹的敌人的下标
                    if(Main.enemy_list.size()>0){
                        index = random.nextInt(Main.enemy_list.size());//0 - size-1
                        //获取这个敌人的等级
                        num = Main.enemy_list.get(index).num;
                        //创建敌人子弹图片并设置位置
                        JLabel label_bullet = new JLabel();
                        label_bullet.setIcon(icon);
                        if(num==1){
                            label_bullet.setBounds(Main.enemy_list.get(index).label.getX()+28,Main.enemy_list.get(index).label.getY()+44,18,29);
                        }else if(num==2){
                            label_bullet.setBounds(Main.enemy_list.get(index).label.getX()+49,Main.enemy_list.get(index).label.getY()+92,18,29);
                        }else{
                            label_bullet.setBounds(Main.enemy_list.get(index).label.getX()+85,Main.enemy_list.get(index).label.getY()+116,18,29);
                        }
                        //设置给敌人子弹实体
                        EnemyBullet_Entity enemyBullet_entity = new EnemyBullet_Entity(num, label_bullet);
                        //将子弹加入面板当中
                        Main.jp1.add(enemyBullet_entity.label);
                        //将子弹加入到list当中
                        Main.enemy_bullets_list.add(enemyBullet_entity);
                        count = 0;
                    }
                }
                //移动集合中的子弹
                for(int i=0;i<Main.enemy_bullets_list.size();i++){
                    if(!isTrue){
                        break;
                    }
                    try{
                        Thread.sleep(2);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if(i< Main.enemy_bullets_list.size()){
                        //每2ms 移动当前 生成子弹的敌人 的 等级+1 的距离
                        Main.enemy_bullets_list.get(i).label.setLocation(Main.enemy_bullets_list.get(i).label.getX(), Main.enemy_bullets_list.get(i).label.getY()+Main.enemy_bullets_list.get(i).num+1);
                        //如果子弹到达指定位置
                        if(Main.enemy_bullets_list.get(i).label.getY()>700){
                            //从面板中删除该子弹
                            Main.jp1.remove(Main.enemy_bullets_list.get(i).label);
                            //从集合中删除该子弹
                            Main.enemy_bullets_list.remove(Main.enemy_bullets_list.get(i));
                            i--;
                        }
                        Main.jp1.repaint();//对panel1本身进行重绘
                        //子弹移动时攻击玩家
                        if(isAttack&&count2%10==0){
                            EnemyBullet_Entity.attackPlayer();
                            count2=0;
                        }
                    }
                }
            }

        }
    }
}
