package samples.jpa;

import java.util.List;

import javax.ejb.Remote;


@Remote
public interface SampleJPAServiceRemote {
	public List<SampleJPA> getAll();
}
