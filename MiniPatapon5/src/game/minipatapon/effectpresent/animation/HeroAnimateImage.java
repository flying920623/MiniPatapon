package game.minipatapon.effectpresent.animation;

import game.minipatapon.event.gamecmd.NavLayeredScreenStageArg;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.stage.base.BaseStage;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class HeroAnimateImage extends AnimateImage
{
	private ArrayList<TextureRegion> m_regionsHero = new ArrayList<TextureRegion>();
	private ArrayList<TextureRegion> m_regionsCircle = new ArrayList<TextureRegion>();
	public int indexTexture=2;

	public Class<? extends BaseStage> cls;
	public HeroAnimateImage(ArrayList<TextureRegion> regions, float x, float y, Stage stage, float playTime)
	{
		super(regions, x, y, stage, playTime);
		// TODO Auto-generated constructor stub
		
	}
	
	public HeroAnimateImage(ArrayList<TextureRegion> regionPoint, ArrayList<TextureRegion> regionHero,ArrayList<TextureRegion> regionCircle,float x, float y, Stage stage, float playTime,Class<? extends BaseStage> _cls)
	{
		super(regionPoint, x, y, stage, playTime);
		// TODO Auto-generated constructor stub
		m_regionsCircle = regionCircle;
		m_regionsHero =regionHero;
		cls = _cls;
		
	}
	@Override
	public void touchUp(float x, float y, int pointer) {
		super.touchUp(x, y, pointer);
		DefaultLogger.getDefaultLogger().log(0, "e ","e ");
		NavLayeredScreenStageArg arg2 =new NavLayeredScreenStageArg(0, this.cls);
		arg2.EventArgSent();
	}
	@Override
	public void draw(SpriteBatch batch, float parentAlpha){
		super.draw(batch,parentAlpha);
		batch.draw(m_regionsCircle.get(indexTexture), this.x * this.scaleX , this.y * this.scaleY ,
				this.x , this.y , m_regionsCircle.get(indexTexture).getRegionWidth(), m_regionsCircle.get(indexTexture).getRegionHeight(), this.scaleX, this.scaleY, this.rotation); 
		batch.draw(m_regionsHero.get(indexTexture), this.x * this.scaleX , this.y * this.scaleY , this.x , this.y , 
				m_regionsHero.get(indexTexture).getRegionWidth(), m_regionsHero.get(indexTexture).getRegionHeight(), this.scaleX, this.scaleY, this.rotation); 
	//   DefaultLogger.getDefaultLogger().log(0, ""+String.valueOf(indexTexture));
	}

}
