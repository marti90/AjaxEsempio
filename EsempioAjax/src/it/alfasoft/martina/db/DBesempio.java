package it.alfasoft.martina.db;

import java.util.HashMap;
import java.util.Map;

import it.alfasoft.martina.*;

public class DBesempio {
	
	Map<String,Studente> studenti = new HashMap<String,Studente>();
	
	public DBesempio(){
	
		
		Studente s1= new Studente("Martina","Debernardi","aaa");
		Studente s2= new Studente("Luca","Umoretto","bbb");
		Studente s3= new Studente("Irene","Aimone","ccc");
		
		studenti.put(s1.getMatricola(), s1);
		studenti.put(s2.getMatricola(), s2);
		studenti.put(s3.getMatricola(), s3);
	}

	public Map<String, Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(Map<String, Studente> studenti) {
		this.studenti = studenti;
	}
	
	

}
