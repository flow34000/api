package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.HibernateUtil;
import domain.Gene;
import domain.Patient;

public class PatientModel{

	public PatientModel(){
		
	}
	
	public List <Patient> findAll() throws Exception{
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			try{
				StringBuilder hqlQuery = new StringBuilder();
				hqlQuery.append("from Patient p");
				hqlQuery.append(" inner join fetch p.comptages");
				hqlQuery.append(" where p.patientId = :'CT.SI.7'");
				
				List<Patient> patients = new ArrayList<Patient>();
				patients = (List<Patient>) session.createQuery(hqlQuery.toString()).list();
				
				/*
				List<Patient> patients = new ArrayList<Patient>();
				patients = (List<Patient>) session.createQuery("from Patient").list();

				for (Iterator iter = patients.iterator(); iter.hasNext();) {
					   Patient element = (Patient) iter.next();
					   System.out.println(element.getPatientId());

					   Hibernate.initialize(element.getComptages());
				}*/
				tx.commit();
				return patients;
			}catch(Exception ex){
				tx.rollback();
				throw(ex);
			}
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
    public Patient get(String id) throws Exception {
    	Session session = HibernateUtil.currentSession();
    	try{
	        Transaction tx = session.beginTransaction();
	        try {
		        Patient element = (Patient) session.get(Patient.class, id);
		
		        tx.commit();
		        return element;
	        }catch (Exception ex){
	        	tx.rollback();
	        	throw ex;
	        }
    	}finally {
    		HibernateUtil.closeSession();
    	}
    }
}
