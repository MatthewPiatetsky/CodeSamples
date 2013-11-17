package photoshare;

import org.apache.commons.io.output.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * A simple Album class.
 *
 */
public class Album {
  private int album_id;
  private String album_name = "";
  private int user_id; 
  private String user_email;
  
  public Album() {
  }

  public int getAlbumId() {
    return album_id;
  }

  public void setAlbumId(int album_id) {
    this.album_id = album_id;
  }

  public int getUserId() {
    return user_id;
  }

  public void setUserId(int user_id) {
    this.user_id = user_id;
  }

  public String getAlbumName() {
    return album_name;
  }

  public void setAlbumName(String album_name) {
    this.album_name = album_name;
  }

    public String getUserEmail() {
	return user_email;
    }

    public void setUserEmail(String user_email) {
	this.user_email = user_email;
    }

}
