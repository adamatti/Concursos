package samples.jsf;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MessageService {
    @PersistenceContext(unitName = "library")
    EntityManager em;

    public void save(HelloMessage hm){    	
        this.em.persist(hm);
    }

    public List<HelloMessage> getMessages(){
        return this.em.createNamedQuery(HelloMessage.findAll).getResultList();
    }
}