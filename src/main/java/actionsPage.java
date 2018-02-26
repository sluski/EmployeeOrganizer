
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class actionsPage {

    private List<String> images;

    public actionsPage(){
        images = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            images.add("banner" + i + ".jpg");
        }
    }
    
    public java.util.Date getCurrentDate() {
        Date date = new Date();
        return date;
    }

    public List<String> getImages() {
        return images;
    }

    @PostConstruct
    public void init() {
       
    }
}
