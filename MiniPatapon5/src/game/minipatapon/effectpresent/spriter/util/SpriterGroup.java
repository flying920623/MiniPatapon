package game.minipatapon.effectpresent.spriter.util;

import game.minipatapon.effectpresent.spriter.SpriterObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.ObjectMap;

public class SpriterGroup extends Group{
	
	protected final List<SpriterObject> children;
	protected final List<SpriterObject> immutableChildren;
	protected final ObjectMap<String, SpriterObject> namesToActors;
	
	public SpriterGroup(){
		children = new ArrayList<SpriterObject>();
		immutableChildren = Collections.unmodifiableList(children);
		namesToActors = new ObjectMap<String, SpriterObject>();
	}
	
	public void draw(SpriteBatch batch)
	{
		for(int i =0; i<children.size();i++)
		{
			children.get(i).draw(batch, 1);
		}
	}
	
	public void addSpriterObject(SpriterObject spriterObject)
	{
		children.add(spriterObject);
		if( spriterObject.name!=null )
			namesToActors.put(spriterObject.name, spriterObject);
	}
	
	public void removeSpriterObject (SpriterObject spriterObject) {
		children.remove(spriterObject);
		if (spriterObject.name != null) namesToActors.remove(spriterObject.name);
	}
	
	public SpriterObject findSpriterObject (String name) {
		SpriterObject spriterObject = namesToActors.get(name);
		return spriterObject;
	}

	public List<SpriterObject> getSpriterObjects() {
		// TODO Auto-generated method stub
		return immutableChildren;
	}

	
}
