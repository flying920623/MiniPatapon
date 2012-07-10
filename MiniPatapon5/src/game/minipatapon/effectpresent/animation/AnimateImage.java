package game.minipatapon.effectpresent.animation;

import game.minipatapon.effectpresent.actor.FlatImage;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class AnimateImage extends FlatImage{

	ArrayList< ArrayList<TextureRegion> > regionLists = null;
	
	//private ArrayList<TextureRegion> regions;

	Animation animation;
	float stateTime;
	float platTime;

	
	public AnimateImage(ArrayList<TextureRegion> regions, float x, float y, Stage stage, float playTime)
	{
		super(regions.get(0), x, y, stage);
		
		animation = new Animation(playTime/regions.size(), regions);
	} 

	
	@Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
        
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(currentFrame, this.x * this.scaleX , this.y * this.scaleY , this.x , this.y , currentFrame.getRegionWidth(), currentFrame.getRegionHeight(), this.scaleX, this.scaleY, this.rotation);    
    }
	
	
}
