package game.minipatapon.stage.midground;

import game.minipatapon.datasource.assets.MusicAssets;
import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.actor.FlatImage;
import game.minipatapon.effectpresent.actor.Image;
import game.minipatapon.effectpresent.actor.NavigateImage;
import game.minipatapon.effectpresent.audioplayer.MusicManage;
import game.minipatapon.screen.ContentScreen;
import game.minipatapon.stage.base.BaseStage;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


/**
 * @description : HelpStage继承自BaseStage
 * @author ZhangY
 * 
 */
public class HelpStage extends BaseStage implements ActorLoader
{
	private NavigateImage quitImage;
	private Image aboutUsImage;

	@SuppressWarnings("unused")
	private ContentScreen contentScreen;
	
	Music music = ResourceLoader.getMusic(MusicAssets.helpMusicStr);

	public HelpStage(float width, float height, boolean stretch)
	{
		super(width, height, stretch);
//		this.loadContent(screen);
		MusicManage.setLoopingMusic(music, true);
		MusicManage.playMusic(music);
		this.init();
	}

//	@Override
//	public void loadContent(ContentScreen screen)
//	{
//		this.contentScreen = screen;
//	}

	@Override
	public void init()
	{
		this.loadAboutUsImage();
		this.loadQuitImage();
	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		MusicManage.pauseMusic(music);
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}
	

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		super.dispose();
		MusicManage.stopMusic(music);
	}

	private void loadAboutUsImage()
	{
		TextureRegion regions = ResourceLoader.getRegionFromPacker(TextureAssets.AboutUs);
//		Texture aboutUsTexture = ResourceLoader.loadTexture("about us.png");
		this.aboutUsImage = new FlatImage(regions, 0f, 0f, this);
		this.aboutUsImage.width = this.width;
		this.aboutUsImage.height = this.height;
	}

	private void loadQuitImage()
	{
		Texture quitTexture = ResourceLoader.getTexture("Level/quitbutton.png");
		TextureRegion textureRegion = new TextureRegion(quitTexture);
		this.quitImage = new NavigateImage("quit", textureRegion, 1.0f, 1.0f, this, MainMenuStage.class);
		this.quitImage.x = centerX + 5 * centerX / 6;
		this.quitImage.y = centerY - 11 * centerY / 12;
		this.addActor(this.quitImage);
	}
}
