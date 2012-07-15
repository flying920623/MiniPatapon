package game.minipatapon.effectpresent.actor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.OnActionCompleted;
import com.badlogic.gdx.scenes.scene2d.Stage;

import game.minipatapon.effectpresent.action.RotateTo;
import game.minipatapon.logger.DefaultLogger;

public class FlatImage extends Image implements
	OnActionCompleted{
	
	
	Stage stage = null;
	
	public int zorder = 0;
	
	
	HashMap<Action,Action> actionMap = new HashMap<Action,Action>();

	/**
	 * 
	 * @param texture
	 * @param x
	 * @param y
	 * @param stage
	 */
	public FlatImage( Texture texture, float x, float y, Stage stage ) {
		this("", texture, x, y, stage);		
	}

	/**
	 * 
	 * @param region
	 * @param x
	 * @param y
	 * @param stage
	 */
	public FlatImage(TextureRegion region, float x, float y, Stage stage) {
		this("", region, x, y, stage);

	}
	
	/**
	 * 
	 * @param texture
	 * @param x
	 * @param y
	 * @param stage
	 */
	public FlatImage(String name, Texture texture, float x, float y, Stage stage ) {
		super(name, texture);
		
		this.setPosition(x, y);
		
		if( stage!=null )
		{
			this.stage = stage;
			stage.addActor(this);	
		}
		
		
	}

	/**
	 * 
	 * @param region
	 * @param x
	 * @param y
	 * @param stage
	 */
	public FlatImage(String name, TextureRegion region, float x, float y, Stage stage) {
		super(name, region);
		
		this.setPosition(x, y);
		
		if( stage!=null )
		{
			this.stage = stage;
			stage.addActor(this);	
		}

	}
	
	public FlatImage(String name, TextureRegion region) {
		super(name, region);

	}


	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSize(float width, float height)
	{
		this.width = width;
		this.height = height;
	}
	
	public void setColor(float r, float g, float b, float a)
	{
		this.color.set(r, g, b, a);
	}
	
	public void setOrigin(float originX, float originY)
	{
		this.originX = originX;
		this.originY = originY;
	}
	
	public void setScale(float scaleX, float scaleY)
	{
		this.scaleX = scaleX;
		this.scaleY = scaleY;
	}
	
	public void setRegion(TextureRegion region)
	{
		this.region = region;
	}
	
	public float getScaledWidth()
	{
		return this.region.getRegionWidth() * this.scaleX;
	}
	
	public float getScaledHeight()
	{
		return this.region.getRegionHeight() * this.scaleY;
	}

	public void act (float delta) {
		actions.iter();
		Action action;

		while ((action = actions.next()) != null) {
			action.act(delta);
			if (action.isDone()) {
				action.finish();
				actions.remove();
			}
		}
		
		//DefaultLogger.getDefaultLogger().log("act");
	}

	@Override
	public void completed(Action action) {
		// TODO Auto-generated method stub
		
		if( actionMap.containsKey(action) )
		{
			this.action( actionMap.get( action ) );
		}
		
	}

	public void setActionOncompleted(Action firstAction, Action secondAction)
	{
		actionMap.put( firstAction, secondAction);
	}
	
	public void setZorder( int zorder )
	{
		this.zorder = zorder;

	}
	
	public void sortActor()
	{
		
		parent.sortChildren(new Comparator<Actor>(){

			@Override
			public int compare(Actor o1, Actor o2) {
				// TODO Auto-generated method stub
				
				FlatImage a1 = (FlatImage)o1;
				FlatImage a2 = (FlatImage)o2;
				
				return (a1.zorder < a2.zorder ? -1 : (a1.zorder == a2.zorder ? 0 : 1)); 
			}
			
		});
	}
	
	public void sortActor( int zorder )
	{
		this.setZorder(zorder);
		sortActor();
	}
	

	public boolean actionDone()
	{
		actions.iter();
		Action action;
		
		while ((action = actions.next()) != null) {
			if( !action.isDone() )
			{
				return false;
			}
		}

		DefaultLogger.getDefaultLogger().logWithSignature(this, "actions done");
		return true;
	}
	
	public ArrayList<Action> actions()
	{
		ArrayList<Action> as = new ArrayList<Action>();
		actions.iter();
		Action action;
		
		while ((action = actions.next()) != null) {
			as.add( action );
		}
		
		return as;
	}
	
	public void show()
	{
		super.color.a=1;
		DefaultLogger.getDefaultLogger().logWithSignature(this, "show image: %s, a:%f", this.name, super.color.a);
	}
	
	public void hide(){
		super.color.a=0;
	}
}
