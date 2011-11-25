package samples;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
http://blog.xebia.com/2011/07/19/developing-a-jpa-application-on-jboss-as-7/
*/
@Stateless(mappedName="SampleJPAService",name="SampleJPAService")
public class SampleJPAService implements SampleJPAServiceRemote {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	@PersistenceUnit(unitName = "library")
    private EntityManagerFactory entityManagerFactory;

	@PersistenceContext(name="library")
    private EntityManager em;
	public List<SampleJPA> getAll() {
		if (em!=null){
	        CriteriaBuilder builder = em.getCriteriaBuilder();
	        CriteriaQuery<SampleJPA> query = builder.createQuery(SampleJPA.class);
	        Root<SampleJPA> root = query.from(SampleJPA.class);
	        query.orderBy(builder.asc(root.get("id")));
	        return em.createQuery(query).getResultList();
		} else if (entityManagerFactory!=null) {
			logger.warning("Factory isn't null!");
		} else {
			logger.warning("EM is null!");
		}
		return null;
    }
}
