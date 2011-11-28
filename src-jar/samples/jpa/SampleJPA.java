package samples.jpa;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
@Entity()
@Table(name="Test")
@SequenceGenerator(name="TEST_SEQ", sequenceName="TEST_SEQ")
public class SampleJPA {
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEST_SEQ")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@FormParam("id")
    private Long id;
 
    @FormParam("title")
    private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
}
