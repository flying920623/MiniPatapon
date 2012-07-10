package game.minipatapon.effectpresent.dialog;

import game.minipatapon.datasource.assets.TextureAssets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class TimerDialog extends Dialog{

	TimerCounter timerCounter = new TimerCounter(0);

	public TimerDialog(String name, float x, float y, Stage stage) {
		
		super(name, "asdfasdf", TextureAssets.GetTextureRegionFromPacker(TextureAssets.StartMenuBg), 
				x, y, stage, 10, Gdx.graphics.getWidth()/7);
		
		// TODO Auto-generated constructor stub

		this.bitmapFont.setColor(1, 1, 1, 1);

	}
	
	public TimerDialog(String name, Stage stage)
	{
		this(name, 0, 0, stage);
		

		x = stage.width() - width*2;
		y = stage.height() - height*2;
	}
	
	public void setTime(int time)
	{
		timerCounter.setTime(time);
	}
	
	public void start(int time)
	{
		timerCounter.start(time);
	}
	
	public void draw(SpriteBatch batch, float parentAlpha)
	{
		this.text = timerCounter.getTime();
		
		super.draw(batch, parentAlpha);
	}

}
