package com.game.EnemyBullet;


import com.game.Panel.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EnemyBullet implements Runnable{
    private static ImageIcon icon1 ;
    private static ImageIcon icon2 ;
    public static volatile boolean isTrue = true; //是否继续创建及移动子弹
    public static volatile  boolean isAttack = false;//是否攻击玩家
    static{
        //修建敌人子弹1图片
        icon1 = new ImageIcon("src/img/enemyBullet.png");
        Image temp1 = icon1.getImage().getScaledInstance(18, 29, icon1.getImage().SCALE_DEFAULT);
        icon1 = new ImageIcon(temp1);
        //修建敌人子弹2图片
        icon2 = new ImageIcon("src/img/敌人子弹2.png");
        Image temp2 = icon2.getImage().getScaledInstance(18, 29, icon2.getImage().SCALE_DEFAULT);
        icon2 = new ImageIcon(temp2);
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
                if(count%10==0&&Main.enemy_bullets_list.size()<7){
                    //随机生成产生子弹的敌人的下标
                    if(Main.enemy_list.size()>0){
                        index = random.nextInt(Main.enemy_list.size());//0 - size-1
                        //并设置敌人子弹位置
                        if(index<Main.enemy_list.size()){
                            //获取这个敌人的等级
                            num = Main.enemy_list.get(index).num;

                            //创建敌人子弹图片
                            JLabel label_bullet = new JLabel();
                            //随机设置敌人子弹样式
                            int num_icon = random.nextInt(2)+1;// 1 2
                            if(num_icon==1){
                                label_bullet.setIcon(icon1);
                            }else{
                                label_bullet.setIcon(icon2);
                            }

                            if(num==1){
                                label_bullet.setBounds(Main.enemy_list.get(index).label.getX()+28,Main.enemy_list.get(index).label.getY()+44,18,29);
                            }else if(num==2){
                                label_bullet.setBounds(Main.enemy_list.get(index).label.getX()+49,Main.enemy_list.get(index).label.getY()+92,18,29);
                            }else{
                                label_bullet.setBounds(Main.enemy_list.get(index).label.getX()+73,Main.enemy_list.get(index).label.getY()+105,18,29);
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
