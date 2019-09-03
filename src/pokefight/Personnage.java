package pokefight;

public class Personnage extends Entite {
	
	private int dmgMax;
	private int dmgMin;
	private int soin;
	private int dmgVamp;
	private int healVamp;
	private String comp1;
	private String comp2;
	private String comp3;
	

	public Personnage(String nom, int vieMax, Type type, String comp1, int dmgMin, int dmgMax, String comp2, int soin, String comp3, int vamp) {
		super(nom, vieMax, type);
		this.dmgMax = dmgMax;
		this.dmgMin = dmgMin;
		this.soin = soin;
		this.dmgVamp = vamp;
		this.healVamp = (int) (vamp * 0.5);
		this.comp1 = comp1;
		this.comp2 = comp2;
		this.comp3 = comp3;
		
	}
	
	public int attaque() {
		return (int) ((Math.random() * (this.dmgMax - this.dmgMin)) + this.dmgMin);
	}
	
	public void soin(int soin) {
		if((this.getVie() + soin) < this.getVieMax()) {
			this.setVie(this.getVie()+soin);
		} else {
			this.setFullVie();
		}	
	}
	
	public int getSoin() {
		return soin;
	}

	public int getDmgVamp() {
		return dmgVamp;
	}

	public int getHealVamp() {
		return healVamp;
	}

	public String getComp1() {
		return comp1;
	}

	public String getComp2() {
		return comp2;
	}

	public String getComp3() {
		return comp3;
	}
	
	
}
