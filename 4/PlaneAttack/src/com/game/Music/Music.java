package com.game.Music;

import com.game.Util.GameMusic;

public class Music implements Runnable{
    @Override
    public void run() {
        while (true){
            GameMusic.Play("src/music/ButterFly.wav",1.0);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            GameMusic.Play("src/music/全民飞机大战游戏音乐.wav",2.0);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            GameMusic.Play("src/music/飞机大战菜单音效.wav",1.5);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            GameMusic.Play("src/music/飞机大战音效.wav",1.5);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
