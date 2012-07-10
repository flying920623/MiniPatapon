package game.minipatapon.effectpresent.background;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class PLParallaxLayer{
   public TextureRegion region ;
   public Vector2 parallaxRatio;
   public Vector2 startPosition;
   public Vector2 padding ;
   public Vector2 scale;
   public PLParallaxLayer(TextureRegion region,Vector2 parallaxRatio,Vector2 padding){
      this(region, parallaxRatio, new Vector2(0,0),padding);
      scale = new Vector2(1,1);
   }
   public PLParallaxLayer(TextureRegion region,Vector2 parallaxRatio,Vector2 startPosition,Vector2 padding,Vector2 _scale){
	      this.region  = region;
	      this.parallaxRatio = parallaxRatio;
	      this.startPosition = startPosition;
	      this.padding = padding;
	      scale = _scale;
	   }
   /**
    * @param region   the TextureRegion to draw , this can be any width/height
    * @param parallaxRatio   the relative speed of x,y {@link PLParallaxBackground#ParallaxBackground(PLParallaxLayer[], float, float, Vector2)}
    * @param startPosition the init position of x,y
    * @param padding  the padding of the region at x,y
    */
   public PLParallaxLayer(TextureRegion region,Vector2 parallaxRatio,Vector2 startPosition,Vector2 padding){
      this.region  = region;
      this.parallaxRatio = parallaxRatio;
      this.startPosition = startPosition;
      this.padding = padding;
      scale = new Vector2(1,1);
   }
}