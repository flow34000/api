package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;
import domain.Comptage;
import domain.ComptageId;
import domain.JSONComptage;
import domain.JSONMatrix;
import domain.Patient;

public class ComptageModel extends AbstractModel<Comptage, Short> {

	public ComptageModel(){
		super(Comptage.class);
	}
	
	public JSONMatrix getComptagesFromPatient(String id) throws Exception{
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			try{
				//récupération de la liste des comptages
				Query query = session.createQuery("from Comptage where id.patientId = :id ");
				query.setParameter("id", id);
				List<Comptage> comptages = query.list();
				
				//création de la matrice JSON à envoyer
				JSONMatrix jsonMatrix = new JSONMatrix();
				jsonMatrix.setPatientId(comptages.get(0).getId().getPatientId());
				Set<JSONComptage> lines = new HashSet<JSONComptage>();
				
				//parcours de la liste des comptages et remplissage du set de gènes
				Iterator<Comptage> iter = comptages.iterator();
				while(iter.hasNext()){
					Comptage comptage = iter.next();
				
					JSONComptage row = new JSONComptage();
					row.setGeneId(comptage.getId().getGeneId());
					row.setLog2ratio(comptage.getLog2ratio());
					
					lines.add(row);
				}
				
				jsonMatrix.setComptages(lines);
				tx.commit();
				return jsonMatrix;
			}catch(Exception ex){
				tx.rollback();
				throw(ex);
			}
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	public Set<JSONMatrix> getComptagesFromMultiPatient(List<String> ids) throws Exception{
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			try{
				
				Set<JSONMatrix> result = new HashSet<JSONMatrix>();
				
				int size = ids.size();
				for(int i=0;i<size;i++){

					//récupération de la liste des comptages
					Query query = session.createQuery("from Comptage where id.patientId = :id ");
					query.setParameter("id", ids.get(i));
					List<Comptage> comptages = query.list();
					
					//création de la matrice JSON à envoyer
					JSONMatrix jsonMatrix = new JSONMatrix();
					jsonMatrix.setPatientId(comptages.get(0).getId().getPatientId());
					Set<JSONComptage> lines = new HashSet<JSONComptage>();
					
					//parcours de la liste des comptages et remplissage du set de gènes
					Iterator<Comptage> iter = comptages.iterator();
					while(iter.hasNext()){
						Comptage comptage = iter.next();
					
						JSONComptage row = new JSONComptage();
						row.setGeneId(comptage.getId().getGeneId());
						row.setLog2ratio(comptage.getLog2ratio());
						
						lines.add(row);
					}
					
					jsonMatrix.setComptages(lines);
					result.add(jsonMatrix);
				}
				
				tx.commit();
				return result;
			}catch(Exception ex){
				tx.rollback();
				throw(ex);
			}
		}finally{
			HibernateUtil.closeSession();
		}
	}
}
