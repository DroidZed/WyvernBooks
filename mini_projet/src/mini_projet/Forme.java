package mini_projet;

public abstract class Forme {
	
	  
      abstract float  perimetre ();
      abstract float surface ();
      public void ContenantCarre (float surf) {
    	  
    	 
    	  
    	  
    	  if (surf>20) {
    		  System.out.println("Cette forme peut contenir un carré de surface"+surf);
    	  }
    	  else {
    		  System.out.println("Cette forme ne peut pas contenir un carré de surface"+surf); 
    	  }
      }
}
