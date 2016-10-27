package it.alfasoft.martina.dao;

import it.alfasoft.martina.Studente;
import it.alfasoft.martina.db.DBesempio;

public class StudenteDao {
	
	DBesempio db = new DBesempio();
	public Studente getStudenteConMatricola(String mat){
		return db.getStudenti().get(mat);
	}

}
