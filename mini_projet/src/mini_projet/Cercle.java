package mini_projet;

public class Cercle extends Forme {
    
	
	private float rayon ;
	public float getRayon () {
		return rayon;
	}
	public void setRayon (float r) {
		this.rayon=r;
	}
	Cercle (float rayon){
		this.rayon = rayon ;
	}
	
	
	@Override
	public float perimetre() {
		float perimetre ;
		perimetre = (float) (2*3.14*rayon) ;
		return perimetre ;
	}

	@Override
	public float surface() {
		float surf ;
		surf = (float)(3.14*3.14*rayon);
		return surf;
	}
    public void ContenantCarre (float surf) {
  	  
   	 
  	  
  	 
  	  if (surface()>20) {
  		  System.out.println("Cette forme peut contenir un carré de surface"+surf);
  	  }
  	  else {
  		  System.out.println("Cette forme ne peut pas contenir un carré de surface"+surf); 
  	  }
    }
      
	
	
}
