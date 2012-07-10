package game.minipatapon.screen;

import java.lang.reflect.InvocationTargetException;

import game.minipatapon.logical.GameRule.GameStateListener;
import game.minipatapon.stage.base.BaseStage;
import game.minipatapon.stage.foreground.ForegroundStage;

public class ForegroundScreen extends NavigateScreen implements GameStateListener {
	public ForegroundScreen() {
		this.setLayer(ScreenLayer.FOREGROUND);
	}

	@Override
	public void show() {
		super.show();
		this.navigate(new ForegroundStage(getWidth(), getHeight(), false));
	}

	@Override
	public void OnGameStart() {
		// TODO Auto-generated method stub
		try {
			this.stage.getClass().getMethod("showActor").invoke(this.stage);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	@Override
	public void OnGameEnd() {
		// TODO Auto-generated method stub
		try {
			this.stage.getClass().getMethod("hideActor").invoke(this.stage);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
