package samples.jsf;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="sample_jsf")
@NamedQuery(name=HelloMessage.findAll,query="SELECT hm from HelloMessage hm")
public class HelloMessage{
    public final static String findAll = "com.abien.leancomp.business.message.entity.HelloMessage.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEST_SEQ")
    private Long id;

    private String message;

    public HelloMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
