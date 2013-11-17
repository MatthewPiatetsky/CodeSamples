package photoshare;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.sql.Date;

/**
 * A bean that handles new comment data
 */

public class NewTagBean {
    private String tag_id = "";
    private String tag_text = "";
    private String user_id = "";
    private Date tag_date;

    public String getTagText() {
        return tag_text;
    }

    public String getUserId() {
        return user_id;
    }

    public Date getTagDate() {
        return tag_date;
    }
  
    public void setTagText(String tag_text) {
        this.tag_text=tag_text;
    }

    public void setUserId(String user_id) {
        this.user_id=user_id;
    }

    public void setTagDate(Date tag_date) {
        this.tag_date=tag_date;
    }
}