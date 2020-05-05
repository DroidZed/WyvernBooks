package mini_projet;

public class Rectangle extends Forme{
	private int largeur ;
	private int longueur ;
	public int getLargeur(){
		return largeur ;
	}
	public void setLargeur (int larg) {
		this.largeur=larg;
	}
	public int getLongueur() {
		return longueur ;
	}
	public void setLongueur(int longueur) {
		this.longueur=longueur;
	}
	Rectangle (int largeur, int longueur) {
		this.largeur=largeur ;
		this.longueur=longueur;
	}
	public float  perimetre () {
	    float perimetre ;
	    perimetre = 2*(largeur+longueur);
	    return perimetre ;
	}
	public float surface () {
	    float surf ;
	    surf = largeur*longueur ;
	    return surf ;
	}
    public void ContenantCarre (float surf) {
  	  
   	 
  	  
  	 
  	  if (surface()>surf) {
  		  System.out.println("Cette forme peut contenir un carré de surface"+surf);
  	  }
  	  else {
  		  System.out.println("Cette forme ne peut pas contenir un carré de surface"+surf); 
  	  }
    }
	
}

