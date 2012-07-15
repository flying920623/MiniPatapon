package com.patapon;

import game.minipatapon.application.MiniPataponManager;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.logger.Loggable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.android.AndroidApplication;


import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class PataponActivity extends AndroidApplication  {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        DefaultLogger.setInnerLogger( new AndroidLogger() );
		DefaultLogger.setEnable(true);

		// �������
		Loggable logger = DefaultLogger.getDefaultLogger();
		logger.logWithSignature("AndroidStarter", "Enter from android");

		try {
			
			
			// ��ù�����
			MiniPataponManager manager = MiniPataponManager.getInstance();
			// ����������
			initialize(MiniPataponManager.getInstance(), false);
			
			
			
		} catch (Exception e) {
			logger.logWithSignature("AndroidStarter", 1, "�������г���:%1$s",
					e.getMessage());
		}
        
    }
    
    
    public void onDestroy()
    {
    	super.onDestroy();
    	DefaultLogger.getDefaultLogger().logWithSignature(this, "onDestroy");
    	int nPid = android.os.Process.myPid();
    	android.os.Process.killProcess(nPid);
    }
}