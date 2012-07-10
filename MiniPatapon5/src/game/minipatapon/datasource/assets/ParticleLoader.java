package game.minipatapon.datasource.assets;

//import java.util.HashMap;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
//import com.maple.eggsnake.logger.DefaultLogger;
import game.minipatapon.logger.Loggable;

class ParticleLoader {

	String baseDir;
	ParticleEffect defaultParticle;
	//Map<String, Map<String, ParticleEffect>> map;
	Loggable logger;

	public ParticleLoader(String baseDir, String defaultParticle,
			String defaultDir) {
		this.baseDir = baseDir;
//		logger = DefaultLogger.getDefaultLogger();
//		map = new HashMap<String, Map<String, ParticleEffect>>();
//		this.defaultParticle = this.directLoadParticle(defaultParticle,
//				defaultDir);
	}

	private String combinePath(String base, String relativePath) {
		if ((!base.endsWith("/") && (!base.endsWith("\\")))) {
			base = base + "/";
		}
		return base + relativePath;
	}

	public ParticleEffect loadParticle(String fileName, String bitmapName) {
//		ParticleEffect particle = null;
//		try {
//			if (map.containsKey(fileName)) {
//				Map<String, ParticleEffect> m = map.get(fileName);
//				if (m.containsKey(bitmapName)) {
//					particle = m.get(bitmapName);
//				} else {
//					particle = directLoadParticle(fileName, bitmapName);
//					m.put(bitmapName, particle);
//				}
//			} else {
//				particle = directLoadParticle(fileName, bitmapName);
//				Map<String, ParticleEffect> mNew = new HashMap<String, ParticleEffect>();
//				mNew.put(bitmapName, particle);
//				map.put(fileName, mNew);
//			}
//		} catch (Exception ex) {
//			logger.log("ParticleLoader loadParticle 加载粒子失败:$1%s",
//					ex.getMessage());
//			particle = this.defaultParticle;
//		}
//		return new ParticleEffect(particle);
//		
		
		return directLoadParticle(fileName, bitmapName);
	}

	public ParticleEffect directLoadParticle(String fileName, String bitmapName) {
		FileHandle particleFile = Gdx.files.internal(this.combinePath(
				this.baseDir, fileName));
		FileHandle bitmapFile = Gdx.files.internal(this.combinePath(
				this.baseDir, bitmapName));
		ParticleEffect effect = new ParticleEffect();
		effect.load(particleFile, bitmapFile);
		return effect;

	}
}
