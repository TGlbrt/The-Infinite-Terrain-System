package game;

import java.util.Random;

public class Feature {
	private FeatureTypes type;
	
	public Feature() {
		Random rand = new Random();
		int randomValue = rand.nextInt(10);
		//System.out.println(randomValue);
		if(randomValue > 9) {
			type = FeatureTypes.VERYGOOD;
		}else if(randomValue > 8) {
			type = FeatureTypes.GOOD;
		}else if(randomValue <=1) {
			type = FeatureTypes.OHDEARGODWHY;
		}else if(randomValue <=3) {
			type = FeatureTypes.BAD;
		}else {
			type = FeatureTypes.BLAND;
		}
	}
	
	public FeatureTypes getType() {
		return type;
	}
	
	public String getEffect() {
		return type.getFeatureEffect();
	}
	
	public String getName() {
		return type.getFeatureName();
	}
	
	
}
