package pokefight;

public abstract class Entite {
	private String nom;
	private int vie;
	private Type type;
	private int vieMax;
	
	public Entite(String nom,int vieMax,Type type) {
		this.nom=nom;
		this.vieMax=vieMax;
		this.vie=vieMax;
		this.type=type;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getVie() {
		return vie;
	}
	
	public int getVieMax() {
		return this.vieMax;
	}
	public void setFullVie() {
		this.vie = vieMax;
	}
	public Type getType() {
		return type;
	}
	
	public void vieRestante(int dmg) {
		this.vie = this.vie - dmg;
	}
	
}
