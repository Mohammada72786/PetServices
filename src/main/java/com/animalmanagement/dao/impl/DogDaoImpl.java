package com.animalmanagement.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.animalmanagement.util.connection.DbConnection;
import com.animalmanagement.util.connection.HibernateConnection;
import com.animalmanagement.util.constant.Gender;
import com.animalmanagement.util.exception.InvalidAnimalAgeException;
import com.animalmanagement.util.exception.AnimalManagementException;
import com.animalmanagement.model.Breed;
import com.animalmanagement.model.Dog;
import com.animalmanagement.model.Food;
import com.animalmanagement.dao.DogDao;
import com.animalmanagement.util.DateUtil;
import com.animalmanagement.util.PetLogger;

public class DogDaoImpl implements DogDao {
	
    /**
     * {@InheritDoc}
     *
     */
    public Dog insertDog(Dog dog) throws AnimalManagementException { 
    	Session session = null;
    	SessionFactory factory = null;
    	try {
		    factory = HibernateConnection.getConnection();
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(dog);
			transaction.commit();
    	}catch (HibernateException exception) {
    	   throw new AnimalManagementException("Error eccoured while inserting" + exception.getMessage());
       } finally {
    	   session.close();
       }
 	   return dog;
    }

    /**
     * {@InheritDoc}
     *
     */
    public Dog getDogByDogCode(String dogCode) throws AnimalManagementException {
        Dog dog = null;
	    Session session = null;
	    try {
	    	SessionFactory factory = HibernateConnection.getConnection();
		    session = factory.openSession();
		    Criteria criteria = session.createCriteria(Dog.class);
		    criteria.add(Restrictions.eq("dogCode", dogCode));
		    dog = (Dog) criteria.uniqueResult();
	    } catch(HibernateException exception) {
	    	//PetLogger.error(" Error occurred while inserting data in breed table"+exception.getMessage());
	    	throw new AnimalManagementException("Error occured while fetching data from dog database");
	    } finally {
		    session.close();
	    }
	    return dog;
    }

    /**
     * {@InheritDoc}
     *
     */
    public Dog updateDogByDogCode(Dog dog) throws AnimalManagementException{
    	System.out.println("Doa got called");
        SessionFactory factory = HibernateConnection.getConnection();
        Session session = factory.openSession();
        try {  
        	Transaction transaction = session.beginTransaction();
        	session.update(dog);
        	transaction.commit();
        } catch(HibernateException exception) { 
            PetLogger.error("Error occured while updating" + exception);
        } finally {
            session.close();
        } 
        return dog;
    }

    /**
     * {@InheritDoc}
     *
     */
    public int deleteDogByDogCode(String dogCode)  throws AnimalManagementException{
    	SessionFactory factory = HibernateConnection.getConnection();
    	Session session = factory.openSession();
    	int flag = 0;
    	try {
        	Transaction transaction = session.beginTransaction();  
        	Query<Dog> query  = session.createQuery(
        			"update Dog set is_deleted = 1 where dogCode = :dogCode and is_deleted = 0");
        	query.setParameter("dogCode",dogCode);
        	flag = query.executeUpdate();
        	transaction.commit();
    	} catch(HibernateException exception) {
    		//PetLogger.error("Error occurred while deleting data from dog" + exception.getMessage());
    		throw new AnimalManagementException("error occured while deleting dog"
    				+exception.getMessage());
    	} finally {
    		session.close();
    	}
    	return flag;
    }

    /**
     * {@InheritDoc}
     *
     */
    public List<Dog> getDogsByName(String name) throws AnimalManagementException{
    	List<Dog> dogs = null;
        SessionFactory factory = HibernateConnection.getConnection();
        Session session = factory.openSession();
        try {
        	Criteria criteria = session.createCriteria(Dog.class);
    		criteria.add(Restrictions.like("name","%"+name+"%"));
    		//criteria.add(Restrictions.eq("isDeleted", '0'));
    		dogs = criteria.list();        
        } catch (HibernateException exception) {
        	//PetLogger.error("Error occurred while fetching data by name from breed table"
        		//	+ exception.getMessage());
        	throw new AnimalManagementException("error occured while fetching data. Please check your input"
        			+exception.getMessage());
        } finally {
        	session.close();
        } 
        return dogs;
    }

    /**
     * {@InheritDoc}
     *
     */
    public String generateDogCode() throws AnimalManagementException{
        String dogCode = null;
        long x = 0;
        SessionFactory factory = HibernateConnection.getConnection();
        Session session = factory.openSession();
        try {  
            Query query = session.createQuery(
            		"select count(id) from Dog");
            x = (long)query.uniqueResult();
            dogCode ="DOG" +  x;  
        } catch(HibernateException exception) { 
            PetLogger.error(exception.toString());
        } finally {
           session.close();
        }
        return dogCode;
    }   

    /**
     * {@InheritDoc}
     *
     */
    public List<Dog> getDogsBetweenDogCodes(String startingId, String endingId)  throws AnimalManagementException{
        List<Dog> dogs = null;
        SessionFactory factory = HibernateConnection.getConnection();
        Session session = factory.openSession();
        try {
    		Criteria criteria = session.createCriteria(Dog.class);
    		criteria.add(Restrictions.between("DogCode", startingId, endingId));
    		dogs = criteria.list();
            return dogs;
        } catch(HibernateException exception) {
        	throw new AnimalManagementException(
        			"Error occurred while fetcing data from database"+exception.getMessage());
        } finally {
        	session.close();
        }
    } 

    /**
     * {@InheritDoc}
     *
     */
    public List<Dog> getDogsBetweenBirthDates(Date startingDateOfBirth,
    		Date endingDateOfBirth)  throws AnimalManagementException {
    	List<Dog> dogs = null;
    	Session session = null;
    	try {
    		SessionFactory factory = HibernateConnection.getConnection();
    		session = factory.openSession();
    		Criteria criteria = session.createCriteria(Dog.class);
    		criteria.add(Restrictions.between("dateOfBirth",startingDateOfBirth,endingDateOfBirth));
    		dogs = criteria.list();
    		return dogs;
    	} catch(HibernateException exception) {
    		throw new AnimalManagementException("Error occurred while fetching data" 
    				+exception.getMessage());
    	} finally {
    		session.close();
    	}
    	
    }
}