package organizerpro.pl.binClasses;

import entity.TEmployee;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;

@ManagedBean
@SessionScoped
public class LoggedUsersBin {

    private TEmployee loggedUser;
    private TimelineModel timelineModel;

    public TimelineModel getTimelineModel() {
        return timelineModel;
    }

    public void setTimelineModel(TimelineModel timelineModel) {
        this.timelineModel = timelineModel;
    }

    public TEmployee getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(TEmployee loggedUSer) {
        this.loggedUser = loggedUSer;
    }

    public boolean isLoggedIn() {
        return loggedUser != null;
    }

    public void createTimeLine() {
        timelineModel = new TimelineModel();
        for (int i = 0; i < loggedUser.getTask().size(); i++) {
            timelineModel.add(new TimelineEvent(loggedUser.getTask().get(i).getTaskName(),
                    loggedUser.getTask().get(i).getStartDate(), loggedUser.getTask().get(i).getEndDate()));
        }
    }

}
