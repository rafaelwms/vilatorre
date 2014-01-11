

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("GerarTabelas");

	      factory.close();
	    }
		
	}


