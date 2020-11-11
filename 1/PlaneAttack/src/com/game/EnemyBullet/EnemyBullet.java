package com.game.EnemyBullet;

public class EnemyBullet {
    int distant; //飞行距离 = 100 + 等级*30
    int interval;//发射间隔 = 800/等级 ms
    int speed;   //发射速度 = 10*等级
    public EnemyBullet(int distant,int interval,int speed){
        this.distant = distant;
        this.interval = interval;
        this.speed = speed;
    }
}
