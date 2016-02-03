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
import domain.Gene;
import domain.JSONComptage;
import domain.JSONMatrix;
import domain.Patient;
import domain.Work;

public class WorkModel extends AbstractModel<Work, Short> {
	
	public WorkModel(){
		super(Work.class);
	}
	
	public Set<JSONMatrix> getComptages(Short id) throws Exception{
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			try{
				//récupération des works lié a l'id
				Query WorkQuery = session.createQuery("from Work where id.matrixId = :id and idType = :type");
				WorkQuery.setParameter("id", id);
				WorkQuery.setParameter("type", "p");
				List<Work> works = WorkQuery.list();
				
				Set<JSONMatrix> result = new HashSet<JSONMatrix>();
				int nb_patients = works.size();
				for(int i=0;i<nb_patients;i++){
					//récupération de la liste des comptages
					Query ComptageQuery = session.createQuery("from Comptage where id.patientId = :id ");
					ComptageQuery.setParameter("id", works.get(i).getId().getId());
					List<Comptage> comptages = ComptageQuery.list();
					
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
	
	public Set<Patient> getAllPatients(Short id) throws Exception{
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			try{
				//récupération des works lié a l'id
				Query WorkQuery = session.createQuery("from Work where id.matrixId = :id and idType = :type");
				WorkQuery.setParameter("id", id);
				WorkQuery.setParameter("type", "p");
				List<Work> works = WorkQuery.list();
				
				Set<Patient> result = new HashSet<Patient>();
				int nb_patients = works.size();
				for(int i=0;i<nb_patients;i++){
					//récupération des patients
					Query query = session.createQuery("from Patient where patientId = :id ");
					query.setParameter("id", works.get(i).getId().getId());
					Patient patient = (Patient) query.uniqueResult();
					
					result.add(patient);
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
	
	public Set<Gene> getAllGenes(Short id) throws Exception{
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			try{
				//récupération des works lié a l'id
				Query WorkQuery = session.createQuery("from Work where id.matrixId = :id and idType = :type");
				WorkQuery.setParameter("id", id);
				WorkQuery.setParameter("type", "g");
				List<Work> works = WorkQuery.list();
				
				Set<Gene> result = new HashSet<Gene>();
				int nb_genes = works.size();
				for(int i=0;i<nb_genes;i++){
					//récupération des genes
					Query query = session.createQuery("from Gene where geneId = :id ");
					query.setParameter("id", works.get(i).getId().getId());
					Gene gene = (Gene) query.uniqueResult();

					result.add(gene);
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
	
	public Set<JSONMatrix> getComptagesFromIdPatient(List<String> ids) throws Exception{
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
	
	public Set<JSONMatrix> getComptagesFromIdGene(List<String> ids) throws Exception{
		Session session = HibernateUtil.currentSession();
		try{
			Transaction tx = session.beginTransaction();
			try{
				
				Set<JSONMatrix> result = new HashSet<JSONMatrix>();
				
				int size = ids.size();
				for(int i=0;i<size;i++){

					//récupération de la liste des comptages
					Query query = session.createQuery("from Comptage where id.geneId = :id ");
					query.setParameter("id", ids.get(i));
					List<Comptage> comptages = query.list();
					
					int size2 = comptages.size();
					for(int j=0;j<size2;j++){
						JSONMatrix jsonMatrix = new JSONMatrix();
						jsonMatrix.setPatientId(comptages.get(j).getId().getPatientId());
						Set<JSONComptage> comptage = new HashSet<JSONComptage>();
						JSONComptage row = new JSONComptage();
						row.setGeneId(comptages.get(j).getId().getGeneId());
						row.setLog2ratio(comptages.get(j).getLog2ratio());
						
						comptage.add(row);
						jsonMatrix.setComptages(comptage);
						result.add(jsonMatrix);
					}
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
