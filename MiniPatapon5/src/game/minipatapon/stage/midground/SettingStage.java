/**
 * 
 */
package game.minipatapon.stage.midground;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.ValueChangedListener;

import game.minipatapon.configuration.Configuration;
import game.minipatapon.datasource.assets.MusicAssets;
import game.minipatapon.datasource.assets.ResourceLoader;
import game.minipatapon.datasource.assets.SoundAssets;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.actor.FlatImage;
import game.minipatapon.effectpresent.actor.Image;
import game.minipatapon.effectpresent.actor.NavigateImage;
import game.minipatapon.effectpresent.audioplayer.MusicManage;
import game.minipatapon.effectpresent.audioplayer.SoundManage;
import game.minipatapon.stage.base.BaseStage;

/**
 * @author ZhangY
 * 
 */
public class SettingStage extends BaseStage implements ActorLoader
{
	private Image backImage = new Image("backgroud", TextureAssets.GetTex(TextureAssets.BackgroundImg));
	private Slider mainSlider, musicSlider, soundSlider;

	@SuppressWarnings("unused")
	private Image mainImage, musicImage, soundImage;
	private NavigateImage quitImage;

	Music music = ResourceLoader.loadMusic(MusicAssets.settingMusicStr);
	
	public SettingStage(float width, float height, boolean stretch)
	{
		super(width, height, stretch);
		this.init();
		
		MusicManage.setLoopingMusic(music, true);
		MusicManage.playMusic(music);
	}

	@Override
	public void init()
	{
		backImage.width = width;
		backImage.height = height;
		this.addActor(backImage);
		// TODO Auto-generated method stub
		this.initMainVolumeSlider();
		this.initMusicVolumeSlider();
		this.initSoundVolumeSlider();
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

	
	/*
	 * private void testConfig() { Configuration.musicVolume = 99;
	 * DefaultLogger.getDefaultLogger().logWithSignature(this,
	 * String.valueOf(Configuration.mainVolume));
	 * DefaultLogger.getDefaultLogger().logWithSignature(this,
	 * String.valueOf(Configuration.musicVolume)); }
	 */

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		super.dispose();
		MusicManage.stopMusic(music);
	}

	private void initMainVolumeSlider()
	{
		Configuration.mainVolume = 50;
		Texture texture01 = ResourceLoader.loadTexture(TextureAssets.SliderImage);
		Texture texture02 = ResourceLoader.loadTexture(TextureAssets.Slider2Image);
		Texture texture03 = ResourceLoader.loadTexture(TextureAssets.MainVolume);
		TextureRegion textureRegion = new TextureRegion(texture02, 0, 0, texture02.getWidth(), texture02.getHeight());
		NinePatch ninePatch = new NinePatch(texture01, 2 * texture01.getWidth() / 3, 2 * texture01.getWidth() / 3, texture01.getHeight(), texture01.getHeight());
		SliderStyle style = new SliderStyle(ninePatch, textureRegion);
		mainSlider = new Slider(0.0f, 1.0f, 0.01f, style);

		mainSlider.x = this.centerX;
		mainSlider.y = centerY + 3 * this.centerY / 6;
		mainSlider.setValue((float) (Configuration.mainVolume / 100));

		mainSlider.setValueChangedListener(new ValueChangedListener()
		{

			@Override
			public void changed(Slider slider, float value)
			{
				// TODO Auto-generated method stub
				Configuration.mainVolume = (int) (value * 100);
			}
		});

		this.mainImage = new FlatImage(texture03, centerX - texture03.getWidth() / 2, centerY + 4 * centerY / 6, this);
		this.addActor(mainSlider);

	}

	private void initMusicVolumeSlider()
	{
		Configuration.musicVolume = 80;
		Texture texture01 = ResourceLoader.loadTexture(TextureAssets.SliderImage);
		Texture texture02 = ResourceLoader.loadTexture(TextureAssets.Slider2Image);
		Texture texture03 = ResourceLoader.loadTexture(TextureAssets.MusicVolume);
		TextureRegion textureRegion = new TextureRegion(texture02, 0, 0, texture02.getWidth(), texture02.getHeight());
		NinePatch ninePatch = new NinePatch(texture01, 2 * texture01.getWidth() / 3, 2 * texture01.getWidth() / 3, texture01.getHeight(), texture01.getHeight());
		SliderStyle style = new SliderStyle(ninePatch, textureRegion);
		musicSlider = new Slider(0.0f, 1.0f, 0.01f, style);

		musicSlider.x = this.centerX;
		musicSlider.y = centerY;
		musicSlider.setValue((float) (Configuration.musicVolume / 100));

		musicSlider.setValueChangedListener(new ValueChangedListener()
		{

			@Override
			public void changed(Slider slider, float value)
			{
				// TODO Auto-generated method stub
				Configuration.musicVolume = (int) (value * 100);
			}
		});

		this.musicImage = new FlatImage(texture03, centerX - texture03.getWidth() / 2, centerY + centerY / 6, this);
		this.addActor(musicSlider);

	}

	private void initSoundVolumeSlider()
	{
		Configuration.soundVolume = 70;
		Texture texture01 = ResourceLoader.loadTexture(TextureAssets.SliderImage);
		Texture texture02 = ResourceLoader.loadTexture(TextureAssets.Slider2Image);
		Texture texture03 = ResourceLoader.loadTexture(TextureAssets.SoundVolume);
		TextureRegion textureRegion = new TextureRegion(texture02, 0, 0, texture02.getWidth(), texture02.getHeight());
		NinePatch ninePatch = new NinePatch(texture01, 2 * texture01.getWidth() / 3, 2 * texture01.getWidth() / 3, texture01.getHeight(), texture01.getHeight());
		SliderStyle style = new SliderStyle(ninePatch, textureRegion);
		soundSlider = new Slider(0.0f, 1.0f, 0.01f, style);

		soundSlider.x = this.centerX;
		soundSlider.y = centerY - 4 * this.centerY / 6;
		soundSlider.setValue((float) (Configuration.soundVolume / 100));

		soundSlider.setValueChangedListener(new ValueChangedListener()
		{

			@Override
			public void changed(Slider slider, float value)
			{
				// TODO Auto-generated method stub
				Configuration.soundVolume = (int) (value * 100);
			}
		});

		this.soundImage = new FlatImage(texture03, centerX - texture03.getWidth() / 2, centerY - 3 * this.centerY / 6, this);
		this.addActor(soundSlider);

	}

	private void loadQuitImage()
	{
		Texture quitTexture = ResourceLoader.loadTexture("Level/quitbutton.png");
		TextureRegion textureRegion = new TextureRegion(quitTexture);
		this.quitImage = new NavigateImage("quit", textureRegion, 1.0f, 1.0f, this, MainMenuStage.class);
		this.quitImage.x = centerX + 5 * centerX / 6;
		this.quitImage.y = centerY - 11 * centerY / 12;
		this.addActor(this.quitImage);
	}
}
