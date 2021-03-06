/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.controller;

import com.thelinh.model.Admin;
import com.thelinh.model.AdminSql;
import com.thelinh.model.Answer;
import com.thelinh.model.AnswerSql;
import com.thelinh.model.Chap;
import com.thelinh.model.ChapSql;
import com.thelinh.model.Question;
import com.thelinh.model.QuestionSql;
import com.thelinh.model.Result;
import com.thelinh.model.ResultSql;
import com.thelinh.model.Subject;
import com.thelinh.model.SubjectSql;
import com.thelinh.model.User;
import com.thelinh.model.UserSql;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Controller {
    private static User currentUser;
    private static Admin currentAdmin;
    
    //Amin
    public static Admin signIn(String adminId,String password){ // Admin
        currentAdmin = AdminSql.signIn(adminId, password);
        return currentAdmin;
    }
    
    public static Admin getCurrentAdmin() {
        return currentAdmin;
    }
    
    //Answer
    public static void insertAnswer(Answer as){
        AnswerSql.insertAnswer(as);
    }
    
    public static boolean updateAnswer(Answer as){
        return AnswerSql.updateAnswer(as);
    }
    
    public static boolean deleteAnswer(String questionId,int number){
        return AnswerSql.deleteAnswer(questionId, number);
    }
    
    //Chap
    public static void insertChap(Chap c){
        ChapSql.insertChap(c);
    }
    
    public static boolean updateChap(Chap c){
        return ChapSql.updateChap(c);
    }
    
    public static boolean deleteChap(String subjectId, int chapter){
        return ChapSql.deleteChap(subjectId, chapter);
    }
    
    //Question
    public static void insertQuestion(Question qt){
        QuestionSql.insertQuestion(qt);
    }
    
    public static boolean updateQuestion(Question qt){
        return QuestionSql.updateQuestion(qt);
    }
    
    public static boolean deleteQuestion(String questionId){
        return QuestionSql.deleteQuestion(questionId);
    }
    
    //Subject
    public static void insertSubject(Subject sj){
        SubjectSql.insertSubject(sj);
    }
    
    public static boolean updateSubject(Subject sj){
        return SubjectSql.updateSubject(sj);
    }
    
    public static boolean deleteSubject(String subjectId){
        return SubjectSql.deleteSubject(subjectId);
    }
    
     //User
     public static User signInUser(String userId, String password){
         currentUser = UserSql.signIn(userId, password);
         return currentUser;
     }
     
     public static void insertUser(User user){
         UserSql.insertUser(user);
     }
     
     public static boolean updateUser(User user){
         return UserSql.updateUser(user);
     }
     
     public static boolean deleteUser(String userId){
         return UserSql.deleteUser(userId);
     }
 
     public static User getCurrentUser(){
         return currentUser;
     }
     
     public static void logout() {
         currentUser = null;
         currentAdmin = null;
     }
     
}
