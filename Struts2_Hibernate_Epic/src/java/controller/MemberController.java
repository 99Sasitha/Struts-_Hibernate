/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.MemberDAO;
import entity.Members;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class MemberController extends ActionSupport {

    private Members member = new Members();
    private MemberDAO dao = new MemberDAO();
    private List<Members> memberList;
    private String sm = "";
    private String em = "";

    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }

    public MemberDAO getDao() {
        return dao;
    }

    public void setDao(MemberDAO dao) {
        this.dao = dao;
    }

    public List<Members> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Members> memberList) {
        this.memberList = memberList;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public MemberController() {
    }

    //___________________Retrive DATA_______________________________________________________________________________
    public String findAllMembers() {
        memberList = dao.getAllMembers();
        return SUCCESS;

    }

    //________________________________INSERT Data____________________________________________________________________
    public String insertMember() {

        member.setName(member.getName());
        member.setEmail(member.getEmail());
        boolean status = dao.saveMember(member);
        if (status) {
            findAllMembers();
            setSm("Successfully Added");
            return SUCCESS;
        } else {
            setEm("Error");
            return "input";
        }

    }

    //__________________________________________EDIT___________________________________________________________________________________
    public String editMember() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));
        if (dao.getEditMember(id) != null) {
            Members m = dao.getEditMember(id);
            member.setId(m.getId());
            member.setName(m.getName());
            member.setEmail(m.getEmail());

            return SUCCESS;
        }
        return "input";
    }

    //____________________________________________UPDATE____________________________________________________________________________________
    public String updateMember() {
        member.setId(member.getId());
        member.setName(member.getName());
        member.setEmail(member.getEmail());

        boolean status = dao.updateMember(member);

        if (status) {
            findAllMembers();
            setSm("Successfully Update");
            return SUCCESS;
        } else {
            setEm("Error Update");
            return "input";
        }

    }
 //____________________________________________DELETE____________________________________________________________________________________
    public String deleteMember() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        int id = Integer.parseInt(request.getParameter("id"));

        boolean status = dao.deleteMember(id);

        if (status) {

            setSm("Successfully Deleted");
            findAllMembers();
            return SUCCESS;

        } else {
            setEm("Error Deleted");
            return "input";
        }

    }

}
