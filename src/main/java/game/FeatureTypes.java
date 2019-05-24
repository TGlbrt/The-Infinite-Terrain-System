package game;

public enum FeatureTypes {
	GOOD(),BAD(),BLAND();
	
	public String getFeatureName() {
		if(this.equals(GOOD)) {
			return "chest";
		}else if(this.equals(BAD)) {
			return "monster";
		}else if(this.equals(BLAND)) {
			return "a small, sittable stone";
		}
		return "";
	}
	
	public String getFeatureEffect() {
		if(this.equals(GOOD)) {
			return "has some tresure in it, it wont eat you";
		}else if(this.equals(BAD)) {
			return "might kill you, in fact it will attempt to right now";
		}else if(this.equals(BLAND)) {
			return "can be sat upon";
		}
		return "";
	}
	
	
	
}
