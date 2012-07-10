package game.minipatapon.effectpresent.spriter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Interface required from the SpriterDrawer to get Texture objects for the given Filenames. The
 * Implementer can implement its own texture caching. This class does not handle the texture
 * disposal.
 * 
 * @author cfinckle
 */
public interface TextureProvider {

  public Texture getTexture(String filename);
  
  public void disposeTexture(String filename);
  
  public TextureRegion getTextureRegion(String filename);
  
  public void disposeTextureRegion( String filename);

}
