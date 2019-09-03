package pokefight;

public class Boss extends Entite {
	
	private int dmgMin;
	private int dmgMax;
	private String comp1;
	
	public Boss(String nom, int vie, Type type, String comp1, int dmgMin, int dmgMax) {
		super(nom, vie, type);
		this.dmgMin = dmgMin;
		this.dmgMax = dmgMax;
		this.comp1 = comp1;
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
	
	public String getComp1() {
		return this.comp1;
	}

}
