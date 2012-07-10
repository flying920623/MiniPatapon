package game.minipatapon.effectpresent.actor;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.AnimationAction;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveTo;

import game.minipatapon.effectpresent.action.EasingCurve;
import game.minipatapon.effectpresent.action.EasingCurveType;
import game.minipatapon.logger.DefaultLogger;
import game.minipatapon.util.MathHelper;

public class PathViewGroup extends Group {

	Vector2 startPoint;
	Vector2 endPoint;
	
	float time = 0f;
	
	float startTime = 0f;
	float endTime = 0f;
	
	float moveDistance = 0f;
	float moveSpeed = 0f;
	float moveTime = 0f;
	
	Vector2 lastMovePoint = null;
	Vector2 lastLastMovePoint = null;
	
	float lastMoveTime = 0f;
	float lastLastMoveTime = 0f;
	
	float dragMoveDistance = 0f;

	int lastElapsed = 0;

	float lastDist = 0f;
	
	boolean horizontal = true;
	boolean mouseMove = false;
	
	Actor highLightActor = null;

	Stage stage = null;
	
	float resistance = 10f;
	float slideTime = 0f;
	
	float childSpace = 25f;
	
	float childWidth = Gdx.graphics.getHeight()/3;
	float childHeight = Gdx.graphics.getHeight()/3;
	
	Actor firstChild ;
	Actor lastChild ;
	
	int currentIndex = 0;
	
	int maxZorder = 50;
	
	HighlightItemChangeListener itemChangeListener = null;
	
	public PathViewGroup(Stage stage)
	{
		super();
		
		this.stage = stage;
	}
	
	public PathViewGroup(String arg, Stage stage)
	{
		super(arg);
		
		this.stage = stage;
	}
	
	

	public PathViewGroup(boolean horizontal, String arg, Stage stage)
	{
		super(arg);
		this.horizontal = horizontal;	
		
		this.stage = stage;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean touchDown(float x, float y, int pointer) {


		List<Actor> items = this.children;
		if (items.size() <= 0)
			return false;

		Vector2 scenePoint = new Vector2(x, y);
		int idx = 0;
		for (; idx < items.size(); ++idx) {
			Rectangle rect = new Rectangle(items.get(idx).x, items.get(idx).y,
					items.get(idx).width, items.get(idx).height);
			
			if (MathHelper.isRectContainPoint(rect, scenePoint))
				DefaultLogger.getDefaultLogger().logWithSignature(this, "鍦ㄧ¬¬%d涓猘ctor鎸変笅", idx);
				break;
		}

		startPoint = new Vector2(x, y);
		
		lastMovePoint = startPoint;
		lastLastMovePoint = startPoint;
		
		lastMoveTime = time;
		lastLastMoveTime = time;
		
		startTime = time;
		
		moveChildren( 0f, 0f);
		
		DefaultLogger.getDefaultLogger().logWithSignature(this, "touchdown 时间： %f, point锛%f, %f", time, x, y);



		if (focusedActor[pointer] != null) {
			point.x = x;
			point.y = y;
			focusedActor[pointer].toLocalCoordinates(point);
			focusedActor[pointer].touchDown(point.x, point.y, pointer);
			//return true;
		}

		int len = children.size() - 1;
		for (int i = len; i >= 0; i--) {
			Actor child = children.get(i);
			if (!child.touchable) continue;

			toChildCoordinates(child, x, y, point);
			if (child.hit(point.x, point.y) == null) continue;
			if (child.touchDown(point.x, point.y, pointer)) {

				if (focusedActor[pointer] == null) {
					focus(child, pointer);
				}
				lastTouchedChild = child;
				return true;
			}
		}

		return this.touchable;
	}

	public void focus (Actor actor, int pointer) {
		Actor existingActor = focusedActor[pointer];
		if (existingActor != null) {
			// An actor already has focus. Remove the focus if it is not a child of this group, because the focused actor could be
			// further down in the hiearchy.
			focusedActor[pointer] = null;
			if (existingActor.parent != this) existingActor.parent.focus(null, pointer);
		}
		if (debug) Gdx.app.log("Group", "focus: " + (actor == null ? "null" : actor.name));
		focusedActor[pointer] = actor;
	}
	
	@Override
	public void touchDragged(float x, float y, int pointer) {
				
		mouseMove = true;
		
		Vector2 currentMovePoint = new Vector2(x, y);
		
		if( horizontal )
		{
			dragMoveDistance = currentMovePoint.x - lastMovePoint.x;
		}else{
			dragMoveDistance = currentMovePoint.y - lastMovePoint.y;
		}
		
		moveChildren( dragMoveDistance, 0f);
		
		lastLastMovePoint = lastMovePoint;
		lastMovePoint = currentMovePoint;
		
		lastLastMoveTime = lastMoveTime;
		lastMoveTime = time;
		
		//DefaultLogger.getDefaultLogger().logWithSignature(this, "touchdDrag 时间:%f, point：%f, %f", time, x, y);
	
		super.touchDragged(x, y, pointer);
		
	}
	
	@Override
	public void touchUp(float x, float y, int pointer) {
		
		if( !mouseMove )
		{
			super.touchUp(x, y, pointer);
			
		}
		
		endPoint = new Vector2(x, y);
		endTime = time;

		
		if( horizontal )
		{
//			moveDistance = endPoint.x - startPoint.x;
			moveDistance = endPoint.x - lastLastMovePoint.x;
		}
		else{
//			moveDistance = endPoint.y - startPoint.y;
			moveDistance = endPoint.y - lastLastMovePoint.y;
		}
		
		moveTime = endTime - lastLastMoveTime;
		
		if(moveTime == 0)
		{
			moveTime = 0.01f;
		}
		
		moveSpeed = moveDistance / moveTime/130;
		
		slideTime = Math.abs(moveSpeed / resistance);
		
		if( slideTime<1f )
		{
			slideTime = 1f;
		}
		
		float s = 0f;
		
		if( moveSpeed<=0 )
		{
			s = (- moveSpeed*moveSpeed) / 2*resistance;
		}
		else{
			s = ( moveSpeed*moveSpeed) / 2*resistance;
		}
		
		
		
		moveChildren( s,  slideTime, EasingCurveType.OutCubic);
		
		
		DefaultLogger.getDefaultLogger().logWithSignature(this, "移动速度%f, 移动距离：%f：移动时间:%f", moveSpeed, moveDistance, moveTime);

		
		mouseMove = false;
		
		DefaultLogger.getDefaultLogger().logWithSignature(this, "touchup时间 %f, point锛%f, %f", time, x, y);
	}

	

	public void moveChildren(float moveDistance, float duration, EasingCurveType easingType)
	{
		for(int i=0; i<children.size(); i++)
		{
			AnimationAction action;
			
			if( horizontal )
			{
				action = MoveTo.$(children.get(i).x + moveDistance, children.get(i).y, duration);
			}else{
				action = MoveTo.$(children.get(i).x, children.get(i).y + moveDistance, duration);
			}
			
			//Parallel.$(action);
			action.setInterpolator( new EasingCurve( easingType ) );
			
			children.get(i).clearActions();
			children.get(i).action( action );
		}
	}
	
	public void moveChildren(float moveDistance, float duration) {
		
		moveChildren(moveDistance, duration, EasingCurveType.Linear);		
		
	}

	
	public void act (float delta) {
		super.act(delta);
		
		time += delta;
		//DefaultLogger.getDefaultLogger().logWithSignature(this, "delta涓º%f", delta);
	}
	
	public void draw (SpriteBatch batch, float parentAlpha) {
		
		limitChildrenBound();
		
		Actor actor = getHighLightActor();
		
		this.calculateZorder();
		
		if( highLightActor != actor )
		{
			this.deDecorateHightLightActor( highLightActor );
			
			highLightActor = actor;
			
			this.decorateHightLightActor( highLightActor );
			
			if( this.itemChangeListener!=null )
			{
				this.itemChangeListener.onItemChange( highLightActor );
			}
		}
			
		super.draw(batch, parentAlpha);
		
	}
	
	
	public void limitChildrenBound()
	{		
		if( children.size()<=0 )
		{
			return;
		}
		
		if( horizontal )
		{
			if( lastChild.x < this.stage.width()/4-lastChild.width/2 )
			{
				moveChildren( this.stage.width()/2 - lastChild.width/2 - lastChild.x + 3, 0.7f );
				
				DefaultLogger.getDefaultLogger().logWithSignature(this, "firstChild:%s, %f, %f, %f", firstChild.toString(), firstChild.x , firstChild.width/2, this.stage.width());
				DefaultLogger.getDefaultLogger().logWithSignature(this, "lastChild:%s, %f, %f, %f", lastChild.toString(), lastChild.x , lastChild.width/2, this.stage.width());

			}
			else if( firstChild.x + firstChild.width/2 >  this.stage.width()*3/4 )
			{				
				DefaultLogger.getDefaultLogger().logWithSignature(this, "firstChild:%s, %f, %f, %f", firstChild.toString(), firstChild.x , firstChild.width/2, this.stage.width());
				DefaultLogger.getDefaultLogger().logWithSignature(this, "lastChild:%s, %f, %f, %f", lastChild.toString(), lastChild.x , lastChild.width/2, this.stage.width());

				moveChildren( this.stage.width()/2 - firstChild.width/2 -firstChild.x - 3 , 0.7f );
			}
		}else{
			if( firstChild.y < -firstChild.height/2 )
			{
				moveChildren( this.stage.height()-firstChild.height/2 - firstChild.y, 0.4f );
			}
			else if( lastChild.y + firstChild.height/2>  this.stage.width() )
			{
				moveChildren( this.stage.height()-firstChild.height/2 -lastChild.y , 0.4f );
			}
		}
	}
	
	protected Actor getHighLightActor()
	{
		Actor actor = null;
		for(int i=0; i<children.size(); i++)
		{
			actor = children.get(i);
			Rectangle rect = MathHelper.getActorRect(actor);
			Vector2 centralVector = new Vector2(stage.width()/2, stage.height()/2);
			
			if( MathHelper.isRectContainPoint(rect, centralVector) )
			{
				currentIndex = i;
				return actor;
			}
		}
		
		if( highLightActor==null && children.size()>0 )
		{
			actor = children.get(0);
			DefaultLogger.getDefaultLogger().logWithSignature(this, "鍒濆§嬭瘽highLightActor涓虹¬¬涓€涓猘ctor");
		}
		
		return actor;
	}
	
	protected void decorateHightLightActor(Actor actor)
	{
		if( actor!=null )
		{
			actor.scaleX = 1.2f;
			actor.scaleY = 1.2f;
			
//			FlatImage image = (FlatImage)actor;
//			image.action( ScaleTo.$(1.2f, 1.2f, 0.2f) );
		}
		
	}
	
	protected void deDecorateHightLightActor(Actor actor)
	{
		if( actor!=null )
		{
			actor.scaleX = 1f;
			actor.scaleY = 1f;

//			FlatImage image = (FlatImage)actor;
//			image.action( ScaleTo.$(1f, 1f, 0.2f) );
		}
		
	}
	
	public void addActor (Actor actor) {
		
		actor.width = childWidth;
		actor.height = childHeight;
		
		if( children.size()==0 )
		{
			actor.x = this.stage.width()/2 - actor.width/2;
			actor.y = this.stage.height()/2 - actor.height/2;
			
			actor.originX = actor.width/2;
			actor.originY = actor.height/2;
			
			firstChild = actor;
		}
		else{
			Actor lastActor = children.get( children.size()-1 );
			
			actor.x = lastActor.x + lastActor.width + childSpace;
			actor.y = this.stage.height()/2 - actor.height/2;
			
			actor.originX = actor.width/2;
			actor.originY = actor.height/2;
			
			lastChild = actor;
		}
		
		if( actor.parent!=null )
		{
			actor.remove();	
		}
		super.addActor(actor);
				
	}
	
//	public void addActor(String levelName)
//	{
//		Texture level = ResourceLoader.loadTexture("Level/"+levelName+".jpg");
//		Image levelImage = new FlatImage(levelName, level, 0f, 0f, null);
//		
//		this.addActor( levelImage );
//	}
	
	public void calculateZorder()
	{
		for(int i = currentIndex-1; i>=0; i--)
		{
			FlatImage child = (FlatImage)children.get( i );
			child.setZorder( maxZorder - currentIndex + i );
		}
		for(int i = currentIndex+1; i<children.size(); i++)
		{
			FlatImage child = (FlatImage)children.get( i );
			child.setZorder( maxZorder + currentIndex - i );
		}
		FlatImage child = (FlatImage)children.get( currentIndex );
		child.setZorder( maxZorder );
		
		child.sortActor();
	}
	
	public void setCurrentItemChangeListener(HighlightItemChangeListener listener)
	{
		this.itemChangeListener = listener;
	}
	
}