package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.HibernateUtil;
import domain.Patient;

public class PatientModel {

	public PatientModel(){
		
	}
	
	public List <Patient> findAll() throws Exception{
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			try{
				List<Patient> patients = new ArrayList<Patient>();
				patients = (List<Patient>) session.createQuery("from Patient").list();

				for (Iterator iter = patients.iterator(); iter.hasNext();) {
					   Patient element = (Patient) iter.next();
					   System.out.println(element.getPatientId());

					   Hibernate.initialize(element.getComptages());
				}
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
}
