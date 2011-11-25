package samples.jsf;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 * http://www.adam-bien.com/roller/abien/entry/simplest_possible_jsf_2_ejb
 * @author java
 *
 */
@ManagedBean(name="messageview")
@SessionScoped
public class MessageView implements Serializable{
    @EJB
    MessageService messageService;

    private HelloMessage message;

    public MessageView() {
        this.message = new HelloMessage();
    }

    public HelloMessage getMessage() {
        return message;
    }

    public int getNumberOfMessages(){
        return messageService.getMessages().size();
    }


    public String save(){
        this.messageService.save(message);
        return "theend";
    }
}