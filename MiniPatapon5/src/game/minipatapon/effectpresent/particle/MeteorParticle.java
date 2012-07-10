package game.minipatapon.effectpresent.particle;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;



public class MeteorParticle {
	
	Stage stage = null;
	
	public ParticleEffect particle;
	
	float destX = 0f;
	float destY = 0f;

	float startX = 0f;
	float startY = 0f;
	
	float time = 0f;
	
	int crateNewParticleTime = 6;
	
	float lifeTime = 5f;
	
	float startTime = 0f;
	
	float b = 0f;  //x=0 处位移
	
	public MeteorParticle( Stage stage )
	{
		this.stage = stage;
		
		//loadParticleFile();
	}
	
	public void loadParticleFile()
	{
		//particle = ResourceLoader.loadParticle("meteor2.p", "");
		particle.setPosition(100f, 100f);
		particle.start();
		//createNewParticle();
	}
	
	public void draw(SpriteBatch spriteBatch, float delta)
	{
//		time += delta;
//		
//		if( Math.floor( time ) % crateNewParticleTime == 0 )
//		{
//			
//			createNewParticle();
//		}
//		
//		setNextPoint();
//		
//		particle.draw(spriteBatch, delta);
	
	}
	
	protected void randomPoint()
	{
		destX = MathUtils.random(0, stage.width() + 100);	
		if( destX > stage.width() )
		{
			destY = MathUtils.random(-100, stage.height());	
		}
		else
		{
			destY = MathUtils.random(-100, -50);	
		}
		
		
		//DefaultLogger.getDefaultLogger().logWithSignature(this, "%f， %f" , destX, destY);
	}
	
	public void createNewParticle()
	{
		randomPoint();
		
		startX = 0f;
		startY = destX + destY;		
		
		b = startY;
		
		startTime = time;
		
		particle.start();
		//moveDistance = MathHelper.getDistance(new Vector2(startX, startY), new Vector2(destX, destY));
	}
	
	public void setNextPoint()
	{
		if( time - startTime < lifeTime )
		{
			float section = (time -  startTime) / lifeTime;
			
			particle.setPosition(startX + destX * section, startY - destX * section);
		}
	}
	
}
