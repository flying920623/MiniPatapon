package game.minipatapon.effectpresent.dialog;

import java.util.ArrayList;
import java.util.Random;

import game.minipatapon.datasource.assets.FontAssets;
import game.minipatapon.datasource.assets.TextureAssets;
import game.minipatapon.effectpresent.actor.FlatImage;
import game.minipatapon.effectpresent.actor.Image;
import game.minipatapon.effectpresent.spriter.SpriterObject;
import game.minipatapon.logger.DefaultLogger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;

public class Dialog extends FlatImage {

	protected String text;

	BitmapFont bitmapFont = new BitmapFont();

	float paddingTop = 20;
	float paddingBottom = 40;
	float paddingLeft = 20;
	float paddingRight = 20;

	Actor target;

	protected boolean show = false;

	protected float timeElapse = 0f;
	protected float showTime = 0f;
	protected boolean showLimit = false;

	
	HAlignment alignment = HAlignment.CENTER;

	public Dialog(String name, String text, TextureRegion region, float x,
			float y, Stage stage, float paddingTop, float paddingBottom,
			float paddingLeft, float paddingRight, float width) {
		super(name, region, x, y, stage);

		this.x = x;
		this.y = y;

		this.text = text;

		this.width = width;

		bitmapFont.setScale(Gdx.graphics.getHeight() / 40
				/ bitmapFont.getCapHeight());

		this.paddingTop = paddingTop;
		this.paddingBottom = paddingBottom;
		this.paddingLeft = paddingLeft;
		this.paddingRight = paddingRight;

		calculateDialogSize();

		bitmapFont.setColor(new Color(0, 0, 0, 1));
	}

	
	
	public Dialog(String name, String text, TextureRegion region, float x,
			float y, Stage stage, float padding, float width) {
		this(name, text, region, x, y, stage, padding, padding, padding,
				padding, width);
	}

	public Dialog(String name, String text, TextureRegion region, float x,
			float y, Stage stage) {
		this(name, text, region, x, y, stage, Gdx.graphics.getHeight() / 15,
				Gdx.graphics.getHeight() / 10, Gdx.graphics.getHeight() / 15,
				Gdx.graphics.getHeight() / 15, Gdx.graphics.getWidth() / 5);
	}

	public Dialog(String name, String text, TextureRegion region, float x,
			float y, float width, Stage stage) {
		this(name, text, region, x, y, stage);
		this.width = width;

		calculateDialogSize();

	}

	// public Dialog(String name, String text, Texture texture, float x, float
	// y, Stage stage, ArrayList<DialogFontArg> fontArgs)
	// {
	// this(name, text, x, y, stage);
	//
	// this.fontArgs = fontArgs;
	// }

	public Dialog(String name, String text, float x, float y, Stage stage) {
		this(name, text, new TextureRegion(
				TextureAssets.GetTex(TextureAssets.DialogBg)), x, y, stage);

	}

	//
	// public Dialog(String name, String text, Actor target, Stage stage) {
	// super(name, TextureAssets.GetTex(TextureAssets.DialogBg), target.x,
	// target.y, stage);
	//
	// this.target = target;
	// this.text = text;
	// this.x = target.x + target.width / 2;
	// this.y = target.y + target.height;
	//
	// bitmapFont.setScale(Gdx.graphics.getHeight() / 40
	// / bitmapFont.getCapHeight());
	// // TextBounds bounds = bitmapFont.getMultiLineBounds(text);
	//
	// TextBounds bounds = bitmapFont.getWrappedBounds(text,
	// Gdx.graphics.getWidth() / 6);
	//
	// paddingTop = Gdx.graphics.getHeight() / 15;
	// paddingBottom = Gdx.graphics.getHeight() / 8;
	// paddingLeft = Gdx.graphics.getHeight() / 15;
	// paddingRight = Gdx.graphics.getHeight() / 15;
	//
	// this.width = bounds.width + paddingLeft + paddingRight;
	// this.height = bounds.height + paddingTop + paddingBottom;
	//
	// bitmapFont.setColor(new Color(0, 0, 0, 1));
	//
	// }

	// public Dialog(String name, String text, float width, float x, float y,
	// float height, Stage stage) {
	// this(name, text, stage);
	//
	// this.width = width;
	// this.height = height;
	// }

	public void setFont(String fontName) {
		bitmapFont = new BitmapFont(Gdx.files.internal(fontName + ".fnt"),
				Gdx.files.internal(fontName + ".png"), false);
	}

	public void draw(SpriteBatch batch, float parentAlpha) {

		if (!show) {
			return;
		}

		if (showLimit) {
			timeElapse += Gdx.graphics.getDeltaTime();
			if (timeElapse > showTime) {
				this.hide();
			}

		}

		super.draw(batch, parentAlpha);
		//
		// if (target instanceof SpriterObject) {
		// SpriterObject object = (SpriterObject) target;
		//
		// x = object.x + object.getWidth() / 2 - width / 2;
		// y = object.y + object.getHeith() * 2 / 3;
		// } else {
		// x = target.x + target.width / 2 - width / 2;
		// y = target.y + target.height * 2 / 3;
		// }

		float fontY = y + height - paddingTop;
		float fontX = x + paddingLeft;

		bitmapFont.drawWrapped(batch, text, fontX, fontY, width - paddingLeft
				- paddingRight, alignment);

	}

	public void show(float time) {
		timeElapse = 0;
		showTime = time;
		showLimit = true;
		show = true;

		if (time == -1) {
			showLimit = false;
		}
	}

	public void hide() {
		this.show = false;
	}

	public void setText(String text) {
		this.text = text;
		
		calculateDialogSize();
	}
	
	protected void calculateDialogSize()
	{
		TextBounds bounds = bitmapFont.getWrappedBounds(text,width - paddingLeft - paddingRight);

		this.height = bounds.height + paddingTop + paddingBottom;
	}

}
