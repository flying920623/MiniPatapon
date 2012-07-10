package game.minipatapon.effectpresent.spriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpriterFrame {
    public String name;
    public List<SpriterSprite> sprites;
    
    public SpriterSprite weapon;
    
    public SpriterFrame(){
      this.sprites = new ArrayList<SpriterSprite>();
    }
    
    public List<SpriterSprite> getSprites() {
      return Collections.unmodifiableList(sprites);
    }
    public void addSprite(SpriterSprite sprite) {
      this.sprites.add(sprite);
    }
    
    public SpriterSprite getSpriteByObjectPart(SpriterObjectPart objectPart){
    	for (int i = 0; i < sprites.size(); i++) {
    		SpriterSprite sprite = sprites.get(i);
    		if(sprite.objectPart.equals(objectPart)){
    			return sprite;
    		}
			
		}
    	return null;
    }
    
    public SpriterSprite getSpriteByObjectPartPath(SpriterObjectPart objectPart){
    	String searchPath = objectPart.textureName.substring(0, objectPart.textureName.indexOf("\\"));
    	for (int i = 0; i < sprites.size(); i++) {
    		SpriterSprite sprite = sprites.get(i);
    		String curPath = sprite.objectPart.textureName.substring(0, sprite.objectPart.textureName.indexOf("\\"));    		
    		if(curPath.equals(searchPath)){
    			return sprite;
    		}
			
		}
    	return null;
    }
    
    
    @Override
    public String toString() {
      return "SpriterFrame [name=" + name + ", sprites=" + sprites + "]";
    }
    
    
  
  
}
