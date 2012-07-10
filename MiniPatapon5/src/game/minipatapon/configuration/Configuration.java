/**
 * 
 */
package game.minipatapon.configuration;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

/**
 * @author ZhangY
 * 
 */
public class Configuration
{
	public static final String CONFIGPATH = "data/configuration.xml";
	public static int mainVolume = 100;
	public static int musicVolume = 100;
	public static int soundVolume = 100;

	public static int getMainVolumeFromFile()
	{
		int volume = 0;
		XmlReader xmlReader = new XmlReader();
		try
		{
			Element config = xmlReader.parse(Gdx.files.internal(CONFIGPATH));
			volume = Integer.parseInt(config.getChildByName("volumes").getChild(0).get("data"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return volume;
	}

	public static int getMusicVolumeFromFile()
	{
		int volume = 0;
		XmlReader xmlReader = new XmlReader();
		try
		{
			Element config = xmlReader.parse(Gdx.files.internal(CONFIGPATH));
			volume = Integer.parseInt(config.getChildByName("volumes").getChild(1).get("data"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return volume;
	}

	public static int getSoundVolumeFromFile()
	{
		int volume = 0;
		XmlReader xmlReader = new XmlReader();
		try
		{
			Element config = xmlReader.parse(Gdx.files.internal(CONFIGPATH));
			volume = Integer.parseInt(config.getChildByName("volumes").getChild(2).get("data"));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return volume;
	}

}
