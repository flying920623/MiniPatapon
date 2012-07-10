/*package game.minipatapon.effectpresent.widget;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.RotateTo;
import com.badlogic.gdx.scenes.scene2d.actors.Image;
import game.minipatapon.screen.ContentScreen;
//import game.minipatapon.service.ApplicationService;
import game.minipatapon.stage.base.BaseStage;
//import game.minipatapon.stage.content.DestinationStage;
//import game.minipatapon.stage.content.common.EnumDestStage;

public class NavigatorImage extends Image {

	private ContentScreen contentScreen; // 中间层屏幕

	private EnumDestStage destStage; // 跳转的目标Stage枚举

	private BaseStage sourceStage;

	private final float scaleSize = 10f;// 缩放幅度
	private final float clockwiseAngles = 360f;// 顺时针旋转360度
	private final float duration = 2f;// 间隔

	*//**
	 * 
	 * @param screen
	 * @param destStage
	 * @param region
	 * @param x
	 * @param y
	 *//*
	public NavigatorImage(ContentScreen screen, EnumDestStage destStage,
			TextureRegion region, float x, float y) {
		super("default", region);
		this.contentScreen = screen;
		this.destStage = destStage;
		this.touchable = true;
	}

	*//**
	 * 
	 * @param region
	 * @param x
	 * @param y
	 *//*
	public NavigatorImage(TextureRegion region, float x, float y) {
		super("default", region);
	}

	public NavigatorImage(ContentScreen screen, EnumDestStage destStage,
			Texture texture, float x, float y) {
		super("default", texture);
		this.contentScreen = screen;
		this.destStage = destStage;
		this.touchable = true;
	}

	*//**
	 * 
	 * @param screen
	 * @param source
	 * @param destStage
	 * @param texture
	 * @param x
	 * @param y
	 *//*
	public NavigatorImage(ContentScreen screen, BaseStage source,
			EnumDestStage destStage, Texture texture, float x, float y) {
		super("default", texture);
		this.contentScreen = screen;
		this.sourceStage = source;
		this.destStage = destStage;
		this.x = x;
		this.y = y;
		this.sourceStage.addActor(this);
		this.touchable = true;
	}

	*//**
	 * 
	 * @param screen
	 * @param source
	 * @param destStage
	 * @param region
	 * @param x
	 * @param y
	 *//*
	public NavigatorImage(ContentScreen screen, BaseStage source,
			EnumDestStage destStage, TextureRegion region, float x, float y) {
		super("default", region);
		this.contentScreen = screen;
		this.sourceStage = source;
		this.destStage = destStage;
		this.x = x;
		this.y = y;
		this.sourceStage.addActor(this);
		this.touchable = true;
	}

	*//**
	 * 
	 * @param texture
	 * @param x
	 * @param y
	 *//*
	public NavigatorImage(Texture texture, float x, float y) {
		super("default", texture);
	}

	*//**
	 * 
	 * @param destStage
	 *//*
	private void navigate(EnumDestStage destStage) {
		if (!(EnumDestStage.DISPOSESTAGE == this.destStage))
			this.contentScreen.navigate(DestinationStage.getDestnationStage(
					contentScreen, destStage));
		else
			ApplicationService.getInstance().exitGame();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer) {
		this.action(RotateTo.$(this.clockwiseAngles, this.duration));
		this.width += scaleSize;
		this.height += scaleSize;
		return touchable;
	}

	@Override
	public void touchUp(float x, float y, int pointer) {
		this.width -= scaleSize;
		this.height -= scaleSize;
	}

	@Override
	public void touchDragged(float x, float y, int pointer) {
		this.navigate(destStage);
	}

}
*/