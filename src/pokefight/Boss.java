package pokefight;

public class Boss extends Entite {
	
	private int dmgMin;
	private int dmgMax;
	
	public Boss(String nom, int vie, Type type, int dmgMin, int dmgMax) {
		super(nom, vie, type);
		this.dmgMin = dmgMin;
		this.dmgMax = dmgMax;
	}
	
	public int attaque() {
		return (int) ((Math.random() * (this.dmgMax - this.dmgMin)) + this.dmgMin);
	}

	public int getDmgMin() {
		return dmgMin;
	}

	public void setDmgMin(int dmgMin) {
		this.dmgMin = dmgMin;
	}

	public int getDmgMax() {
		return dmgMax;
	}

	public void setDmgMax(int dmgMax) {
		this.dmgMax = dmgMax;
	}
}
