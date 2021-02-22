package App.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String body;
    private  int balance;

    public Post(Long id, String title, String body, Date date) {
        super();
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public Post(){
        super();
    }

    public int getBalance() {
        return balance;
    }

    public int withdraw(int amt){
        balance = balance - amt;
        return balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date = new Date();

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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }



    @Override
    public String toString() {
        return "User{" + "id=" + id + ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", amount='" + balance + '\''+
                ", date='"+date+ '}';
    }
}
