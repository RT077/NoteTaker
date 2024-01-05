package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.NoteTaker;
import com.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String title = request.getParameter("title");
			String content = request.getParameter("content");

			int noteId = Integer.parseInt(request.getParameter("noteId").trim());

			Session session = FactoryProvider.getFactory().openSession();
			Transaction transaction = session.beginTransaction();

			NoteTaker noteTaker = session.get(NoteTaker.class, noteId);

			noteTaker.setTitle(title);
			noteTaker.setConten(content);
			noteTaker.setAddesDate(new Date());

			// session.update(noteTaker);
			transaction.commit();
			session.close();

			response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
