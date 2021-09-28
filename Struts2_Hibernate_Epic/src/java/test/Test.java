/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.MemberDAO;

/**
 *
 * @author Sasitha Munasinghe
 */
public class Test {
    public static void main(String[]args){
    MemberDAO dao=new MemberDAO();
    System.out.println(dao.getAllMembers());
    }
    
    
}
