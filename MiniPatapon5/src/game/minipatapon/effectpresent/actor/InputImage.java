package game.minipatapon.effectpresent.actor;


import game.minipatapon.event.music.MatchMusicType;
import game.minipatapon.event.music.MusicInputArg;
import game.minipatapon.logger.DefaultLogger;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class InputImage extends FlatImage{
	public MatchMusicType m_type;

	public InputImage(TextureRegion region, float x, float y, Stage stage, MatchMusicType type) {
		super(region, x, y, stage);
		// TODO Auto-generated constructor stub
		m_type =  type;
		this.touchable = true;
		
	}
	

	public void show()
	{
		color.a=1;
	}
	
	public void hide(){
		color.a=0;
	}
	@Override
	public boolean touchDown(float x, float y, int pointer) {
		// TODO Auto-generated method stub
		MusicInputArg arg =new MusicInputArg(m_type);
		arg.EventArgSent();
		//DefaultLogger.get//DefaultLogger().log(0, "  command sent","");
	//	return super.touchDown(x, y, pointer);
		return touchable;
	}
	

}
