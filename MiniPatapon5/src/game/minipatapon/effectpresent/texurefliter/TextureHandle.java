package game.minipatapon.effectpresent.texurefliter;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureHandle {
	public  static void  TextureFilterLinear(Texture x)
	{
		x.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
    public static void TextureFilterLinear(TextureRegion x)
    {
    	TextureFilterLinear(x.getTexture());
    }
    public static void TextureFilterLinear(ArrayList<TextureRegion> textureRegions)
    {
    	for (TextureRegion textureRegion : textureRegions) {
			TextureFilterLinear(textureRegion);
		}
    }

}
