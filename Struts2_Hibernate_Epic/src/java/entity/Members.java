package entity;
// Generated Sep 26, 2021 10:46:34 AM by Hibernate Tools 4.3.1



/**
 * Members generated by hbm2java
 */
public class Members  implements java.io.Serializable {


     private Integer id;
     private String name;
     private String email;

    public Members() {
    }

    public Members(String name, String email) {
       this.name = name;
       this.email = email;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Members{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }
    
    




}


