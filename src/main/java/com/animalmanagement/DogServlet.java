package com.animalmanagement;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.animalmanagement.controller.DogController;
import com.animalmanagement.dao.impl.DogDaoImpl;
import com.animalmanagement.model.Dog;
import com.animalmanagement.service.DogService;
import com.animalmanagement.service.impl.DogServiceImpl;
import com.animalmanagement.util.constant.Gender;
import com.animalmanagement.util.exception.AnimalManagementException;
import com.animalmanagement.util.Validator;

/**
 * Servlet implementation class DogServlet
 */

@WebServlet(value="/DogServlet")
public class DogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//DogService dogService;
	//DogController dogController;
       

    
    public void init() {
    	DogService dogService = new DogServiceImpl();
    	//dogController = new DogController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
        try {
    		String name = request.getParameter("name");
    		String colour = request.getParameter("colour");
    		Gender gender = Gender.valueOf(request.getParameter("gender"));
    		float weight = Float.parseFloat(request.getParameter("weight"));
            float speed = Float.parseFloat(request.getParameter("speed"));
            Date dateOfBirth = Validator.getDate(request.getParameter("dateofbirth"));
            pw.println(name+ System.getProperty("line.separator") + weight);
            pw.println(weight);
            pw.println(speed);
            pw.println(dateOfBirth);
            pw.println(colour);
            pw.println(gender);
    		//Dog dog = dogService.insertDog(name, weight, colour, gender, dateOfBirth, speed);
    	    //pw.println(dog);
        } catch(Exception exception) {
        	pw.println(exception.toString());
        }
	}
}
