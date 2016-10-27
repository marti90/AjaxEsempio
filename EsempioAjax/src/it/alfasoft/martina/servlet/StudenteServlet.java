package it.alfasoft.martina.servlet;

import it.alfasoft.martina.Studente;
import it.alfasoft.martina.dao.StudenteDao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class StendteServlet
 */
@WebServlet({ "/StendteServlet", "/prendiStudente" })
public class StudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matricola= request.getParameter("matricola");
		
		//con questo writer riempio la response
		PrintWriter out= response.getWriter();
		
		//questi oggetti hanno metodi all'interno che prendono un oggetto di tipo java 
		//e lo convertono in json
		Gson gson = new Gson();
		JsonObject jobj= new JsonObject();
		
		Studente s= this.getStudente(matricola);
		
		//dobbiamo covertire s ad un elemento json, e lo facciamo con una funzione di gson
		//che già esiste
		JsonElement studenteJson= gson.toJsonTree(s);
		
		//voglio creare un oggetto di json di questo tipo
		/*
		 * [success: false,
		 * studente: {
		 * 
		 * }
		 */
		//a cui setto success e studente con nome,cognome e matricola
		
		//ora voglio controllare che lo studente che ho preso non sia null
		if(s==null){
			jobj.addProperty("success", false);
			
		} else{
			jobj.addProperty("success", true);
		}
		
		//qui aggiungo lo studenteJson che è lo studente Java che è stato modificato da gson
		jobj.add("studente", studenteJson);
		
		//scrivo nel PrintWriter
		out.println(jobj.toString());
		System.out.println(jobj);
		
		//chiudo il PrintWriter
		out.close();
	}
	
	public Studente getStudente(String matricola){
		
		StudenteDao sDao= new StudenteDao();
	    return sDao.getStudenteConMatricola(matricola);
	}

}
