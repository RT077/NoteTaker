package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NoteTaker;
import com.helper.FactoryProvider;

public class DeleteServlet_D extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet_D() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int noteId = Integer.parseInt(request.getParameter("note_ID").trim());
			
			Session session = FactoryProvider.getFactory().openSession();
			Transaction transaction = session.beginTransaction();
			
			NoteTaker noteTaker = (NoteTaker) session.get(NoteTaker.class, noteId);

			session.delete(noteTaker);
			
			transaction.commit();
			session.close();
			
			response.sendRedirect("all_notes.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
