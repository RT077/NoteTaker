package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NoteTaker;
import com.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveNoteServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			NoteTaker noteTaker = new NoteTaker(title, content, new Date());
			System.out.println(noteTaker.getId() + " " + noteTaker.getTitle());

			// hibernate : save();
			Session session = FactoryProvider.getFactory().openSession();
			Transaction txx = session.beginTransaction();

			session.save(noteTaker);
			txx.commit();
			session.close();

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<h1 style ='text-align:center;'>note is added sucssesfully</h1>");
			out.println("<h1 style ='text-align:center;'><a href='all_notes.jsp'>View All Notes</a></h1>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
