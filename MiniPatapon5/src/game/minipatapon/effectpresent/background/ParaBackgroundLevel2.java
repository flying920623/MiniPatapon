package game.minipatapon.effectpresent.background;

import game.minipatapon.datasource.assets.TextureAssets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class ParaBackgroundLevel2 extends ParaBackground{
	
	public ParaBackgroundLevel2()
	{
		create();

	}
	
	public PLParallaxBackground rbg;

	public TextureRegion bg1 = TextureAssets.GetTextureRegionFromPacker(TextureAssets.Level2Layer1Img);
	public TextureRegion bg2 = TextureAssets.GetTextureRegionFromPacker(TextureAssets.Level2Layer2Img);
	public TextureRegion bg3 = TextureAssets.GetTextureRegionFromPacker(TextureAssets.Level2Layer3Img);
//	TextureRegion bg1;
//	TextureRegion bg2;
//	TextureRegion bg3;
//	TextureRegion bg4;
//	TextureRegion bg5;
	//public SpriteBatch m_spriteBatch;
	
	
  
    public void create() { 
    	
//		texture1=new Texture(Gdx.files.internal("data/images/GameGround1_1024_512.png"));
//		texture2=new Texture(Gdx.files.internal("data/images/GameGround2_512_256.png"));
//		texture3=new Texture(Gdx.files.internal("data/images/GameGround3_1024_1024.png"));
//		
//        bg1=new TextureRegion(texture1,4,2,410,139);
//        bg4=new TextureRegion(texture2,0,0,511,169);
//        
//        bg2=new TextureRegion(texture2,1,173,355,29);
//        bg3=new TextureRegion(texture2,1,203,470,52);
//        bg5=new TextureRegion(texture3,0,0,483,315);
//        
       bg1.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
       bg2.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
       bg3.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
       
       int width = Gdx.graphics.getWidth();
       int height = Gdx.graphics.getHeight();
       
       Vector2 bg1Score = new Vector2(width/bg1.getRegionWidth(), 1.1f*height/bg1.getRegionHeight());
        
		rbg = new PLParallaxBackground(new PLParallaxLayer[]{
				new PLParallaxLayer(bg1,new Vector2(1.5f,0f),new Vector2(0,0),new Vector2(0,800), bg1Score),
				new PLParallaxLayer(bg2,new Vector2(3f,0f),new Vector2(0,-0.5f*bg2.getRegionHeight()/5f),new Vector2(0,800),new Vector2(1.5f, 2f)),
				new PLParallaxLayer(bg3,new Vector2(4f,0f),new Vector2(0,-2f*bg3.getRegionHeight()/4f),new Vector2(0,800),new Vector2(1.5f, 2f)),
	            
	      },Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),new Vector2(10,0));
       // b.setActive(true);
        //b.setAwake(true);
        //b.setLinearVelocity(30f, 10f);
    }
 
  
    public void dispose() {       
        //renderer.dispose(); 
        //world.dispose();
 
        //renderer = null; 
        //world = null; 
    }
 
   
    public void pause() { 
        // TODO Auto-generated method stub
 
    }
 
   
    public void render() { 
        //world.step(0.015f, 8, 10); 
  //      GL10 gl = Gdx.app.getGraphics().getGL10(); 
  //      gl.glClear(GL10.GL_COLOR_BUFFER_BIT); 
        
    //    m_spriteBatch.begin();
        
        //m_spriteBatch.draw(bg1,10,20, 415, 145);
        //m_spriteBatch.draw(bg3,10,20, 483, 318);
   //     m_spriteBatch.draw(bg5,0,bg1.getRegionHeight(),bg5.getRegionWidth(), bg5.getRegionHeight());
   //     m_spriteBatch.draw(bg4,0,bg1.getRegionHeight(),bg4.getRegionWidth(), bg4.getRegionHeight());
   //     m_spriteBatch.draw(bg3,0,bg1.getRegionHeight(),bg3.getRegionWidth(), bg3.getRegionHeight());
   //     m_spriteBatch.draw(bg2,0,bg1.getRegionHeight(),bg2.getRegionWidth(), bg2.getRegionHeight());
   //     m_spriteBatch.draw(bg1,0,0,bg1.getRegionWidth(), bg1.getRegionHeight());
   //     m_spriteBatch.end();
        //camera.update(); 
        //camera.apply(gl); 
        /*count++;
        if(count==1){
        	world.getBodies().next().setLinearVelocity(30f, 10f);
        }*/
        rbg.render(Gdx.app.getGraphics().getDeltaTime());
        //renderer.render(world, camera.combined); 
    }
 
  
    public void resize(int width, int height) { 
        // TODO Auto-generated method stub
 
    }
 
    public void resume() { 
        // TODO Auto-generated method stub
 
    }
}
