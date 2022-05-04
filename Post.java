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
public class Post {
    
    private int id;
    private int user_id;
    private String titre;
    private String content;
    private String image;
    private Date created_at;
    
    public Post(){
        
    }

    public Post(int user_id, String titre, String content, String image, Date created_at) {
        this.user_id = user_id;
        this.titre = titre;
        this.content = content;
        this.image = image;
        this.created_at = created_at;
    }

    public Post(int id, int user_id, String titre, String content, String image, Date created_at) {
        this.id = id;
        this.user_id = user_id;
        this.titre = titre;
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

    public String getTitre() {
        return titre;
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

    public void setTitre(String titre) {
        this.titre = titre;
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
        return "Post{" + "id=" + id + ", user_id=" + user_id + ", titre=" + titre + ", content=" + content + ", image=" + image + ", created_at=" + created_at + '}';
    }

    
    
}
