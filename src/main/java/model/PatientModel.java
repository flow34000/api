package model;

import java.util.ArrayList;
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
				patients = (List<Patient>) session.createCriteria(Patient.class).setFetchMode("comptages",FetchMode.JOIN)
				  .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
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
