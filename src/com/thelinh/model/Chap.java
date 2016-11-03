/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelinh.model;

/**
 *
 * @author Admin
 */
public class Chap {
    private String subjectId;
    private int chapter;
    private String chapterName;

    public Chap(String subjectId, int chapter, String chapterName) {
        this.subjectId = subjectId;
        this.chapter = chapter;
        this.chapterName = chapterName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
    
        
    
}
