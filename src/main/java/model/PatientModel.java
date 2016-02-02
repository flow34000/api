package model;

import java.util.ArrayList;
import java.util.List;

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
				
				/*int size = patients.size();
				for(int i=0;i<size;i++){
					Hibernate.initialize(patients.get(i).getComptages());
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
}
