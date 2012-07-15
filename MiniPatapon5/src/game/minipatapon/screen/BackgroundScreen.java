package game.minipatapon.screen;

import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.stage.background.BackgroundStage;

public class BackgroundScreen extends NavigateScreen {
	public BackgroundScreen() {
		this.setLayer(ScreenLayer.BACKGROUDN);
		
		DefaultLogger.getDefaultLogger().logWithSignature(this,
				"enter BackgroundScreen");
	}

	@Override
	public void show() {
		super.show();
		this.navigate(new BackgroundStage(getWidth(), getHeight(), false));
	}

}
