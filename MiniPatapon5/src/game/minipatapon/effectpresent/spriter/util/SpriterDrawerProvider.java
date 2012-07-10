package game.minipatapon.effectpresent.spriter.util;

import game.minipatapon.effectpresent.spriter.SpriterObject;
import game.minipatapon.effectpresent.spriter.SpriterSprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public interface SpriterDrawerProvider {
	public void draw(SpriteBatch spriteBatch, SpriterObject spriterObject, SpriterSprite tweenedSprite);

}
