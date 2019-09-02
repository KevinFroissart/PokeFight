package pokefight;

public abstract class Entite {
	private String nom;
	private int vie;
	private Type type;
	
	public Entite(String nom,int vie,Type type) {
		this.nom=nom;
		this.vie=vie;
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
	public void setVie(int vie) {
		this.vie = vie;
	}
	public Type getType() {
		return type;
	}
	
	
}
