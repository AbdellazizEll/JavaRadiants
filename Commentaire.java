/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.clutchers.entities;

import java.sql.Date;

/**
 *
 * @author aziza
 */
public class Commentaire {
    
    private int id;
    private int user_id ;
    private int post_id ;
    private String content;
    private String image;
    private Date created_at;
    
    public Commentaire(){
        
    }

    public Commentaire(int user_id, int post_id, String content, String image, Date created_at) {
        this.user_id = user_id;
        this.post_id = post_id;
        this.content = content;
        this.image = image;
        this.created_at = created_at;
    }

    public Commentaire(int id, int user_id, int post_id, String content, String image, Date created_at) {
        this.id = id;
        this.user_id = user_id;
        this.post_id = post_id;
        this.content = content;
        this.image = image;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", user_id=" + user_id + ", post_id=" + post_id + ", content=" + content + ", image=" + image + ", created_at=" + created_at + '}';
    }

    
    
    

   
    
    
    
}
