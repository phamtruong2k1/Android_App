package com.example.phamtruong.haui.flappybird;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;


import java.util.Random;
import java.util.logging.LogRecord;

public class GameView extends View {
    Handler handler;
    Runnable runnable;
    final int Update_millis = 30;
    Bitmap background;
    Bitmap toptube , botTube;
    Display display;
    Point point;
    int dWidth,dHeight;
    Rect rect;
    Bitmap[] birds;
    int birdFrame =0;
    int velocity=0,gravity=3;
    int birdX , birdY;
    boolean gameState = false;
    int gap =400;
    int minTubeoffset,maxTubeoffset;
    int numberoftubes =4;
    int distanceBetweenTubes;
    int[] tubeX = new int[numberoftubes];
    int[] topTubeY = new int[numberoftubes];
    Random random;
    int tubeVelocity = 8;


    public GameView(Context context) {
        super(context);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        background = BitmapFactory.decodeResource(getResources(),R.mipmap.background01);
        toptube = BitmapFactory.decodeResource(getResources(),R.mipmap.uptube);//1
        botTube = BitmapFactory.decodeResource(getResources(),R.mipmap.downtube);//1


        display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        point = new Point();
        display.getSize(point);
        dWidth = point.x;
        dHeight = point.y;
        rect = new Rect(0,0,dWidth,dHeight);
        birds = new Bitmap[2];
        birds[0] = BitmapFactory.decodeResource(getResources(),R.mipmap.bird1);//1
        birds[1] = BitmapFactory.decodeResource(getResources(),R.mipmap.bird2);//1
        birdX = dWidth/2-birds[0].getWidth()/2;
        birdY = dHeight/2-birds[0].getHeight()/2;
        distanceBetweenTubes = dWidth*3/4;
        minTubeoffset = gap/2;
        maxTubeoffset = dHeight- minTubeoffset - gap;
        random = new Random();
        for (int i=0;i<numberoftubes;i++){
            tubeX[i]= dWidth + i*distanceBetweenTubes;
            topTubeY[i] = minTubeoffset + random.nextInt(maxTubeoffset - minTubeoffset + 1);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawBitmap(background,0,0,null);
        canvas.drawBitmap(background,null,rect,null);
        if (birdFrame==0){
            birdFrame =1;
        } else{
            birdFrame =0;
        }
        if (gameState){
            if (birdY < dHeight - birds[0].getHeight() || velocity<0){
                velocity += gravity;
                birdY+=velocity;
            }
            for (int i=0;i<numberoftubes;i++){
                tubeX[i] -= tubeVelocity;
                if (tubeX[i]< -toptube.getWidth()){
                    tubeX[i] += numberoftubes * distanceBetweenTubes;
                    topTubeY[i] = minTubeoffset + random.nextInt(maxTubeoffset - minTubeoffset + 1);
                }
                canvas.drawBitmap(toptube,tubeX[i],topTubeY[i]-toptube.getHeight(),null);
                canvas.drawBitmap(botTube,tubeX[i],topTubeY[i]+gap,null);
            }

        }

        canvas.drawBitmap(birds[birdFrame],birdX,birdY,null);
        handler.postDelayed(runnable,Update_millis);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if ( action == MotionEvent.ACTION_DOWN){
            velocity = -30;
            gameState = true;
//            topTubeY = minTubeoffset + random.nextInt(maxTubeoffset - minTubeoffset + 1);
        }
        return true;
    }
}
