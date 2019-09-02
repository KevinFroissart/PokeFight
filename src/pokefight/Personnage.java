package pokefight;

public class Personnage extends Entite {
	
	private int dmgMax;
	private int dmgMin;
	private int soin;
	private int dmgVamp;
	private int healVamp;
	

	public Personnage(String nom, int vieMax, Type type, int dmgMax, int dmgMin, int soin, int vamp) {
		super(nom, vieMax, type);
		this.dmgMax = dmgMax;
		this.dmgMin = dmgMin;
		this.soin = soin;
		this.dmgVamp = vamp;
		this.healVamp = (int) (vamp * 0.5);
		
	}
	
	public int attaque() {
		return (int) ((Math.random() * (this.dmgMax - this.dmgMin)) + this.dmgMin);
	}
	
}
