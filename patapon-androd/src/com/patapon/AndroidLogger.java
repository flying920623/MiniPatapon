package com.patapon;

import android.util.Log;
import game.minipatapon.dataprocess.resourcemanage.SoundManage;
import game.minipatapon.logger.LoggerBase;

public class AndroidLogger extends  LoggerBase{

	@Override
	protected void writeMessage(String msg) {
		// TODO Auto-generated method stub

		
		Log.v("patapon-logger", msg);
	}

}
