/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Members;
import static java.lang.System.out;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Sasitha Munasinghe
 */
public class MemberDAO {
    
    
//__________________________SELECT DATA_________________________________________________________________________    
    public List<Members> getAllMembers(){
     Session sesssion=HibernateUtil.getSessionFactory().openSession();
        Transaction t=null;
        try {
            t=sesssion.beginTransaction();
            List<Members> list=sesssion.createQuery("from Members").list();
            t.commit();
            return list;
            
        } catch (Exception e) {
            if(t!=null){
            t.rollback();
            }
        }
        finally{
        sesssion.close();
                }
        return null;
    }
    
    //______________________________________________SELECT DATA FOR EDIT_____________________________________________________________________
    
    public  Members getEditMember(int id){
     Session sesssion=HibernateUtil.getSessionFactory().openSession();
        Transaction t=null;
        Members member=null;
        
        try {
            t=sesssion.beginTransaction();
            member=(Members) sesssion.get(Members.class, id);
            t.commit();
            return member;
            
        } catch (Exception e) {
            if(t!=null){
            t.rollback();
            }
        }
        finally{
        sesssion.close();
                }
        return null;
    }
    
    
    
 //___________________________INSERT DATA______________________________________________________________________________________________________
  public boolean saveMember(Members member){
  Session sesssion=HibernateUtil.getSessionFactory().openSession();
        Transaction t=null;
       try {
            t=sesssion.beginTransaction();
            sesssion.save(member);
            t.commit();
            return true;
            
        } catch (Exception e) {
            if(t!=null){
            t.rollback();
            }
        }
        finally{
        sesssion.close();
                }
        return false; 
  
  }
 //__________________________________UPDATE_____________________________________________________________________________
  public boolean updateMember(Members member){
  Session sesssion=HibernateUtil.getSessionFactory().openSession();
        Transaction t=null;
       try {
            t=sesssion.beginTransaction();
            sesssion.update(member);
            t.commit();
            return true;
            
        } catch (Exception e) {
            if(t!=null){
            t.rollback();
            }
        }
        finally{
        sesssion.close();
                }
        return false; 
  
  }
  
//______________________________________________DELETE__________________________________________________________________________

public boolean deleteMember(int id){
    String sql="DELETE FROM members WHERE id=:id";
  Session sesssion=HibernateUtil.getSessionFactory().openSession();
        Transaction t=null;
       try {
            t=sesssion.beginTransaction();
            Query query=sesssion.createSQLQuery(sql);
            query.setInteger("id",id);
            query.executeUpdate();
            t.commit();
            return true;
            
        } catch (Exception e) {
            if(t!=null){
            t.rollback();
            out.println(e);
            }
        }
        finally{
        sesssion.close();
                }
        return false; 
  
  }  




}
