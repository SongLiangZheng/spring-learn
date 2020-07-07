package com.hs.slz.spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {

    }

    public static List<String> getUsernames(int threshold) {
        String json="";
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
        try {
            JsonNode rootNode = mapper.readTree(json);
            JsonNode data = rootNode.get("data");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    static class Data
    {
        private int id;

        private String username;

        private String about;

        private int submitted;

        private String updated_at;

        private int submission_count;

        private int comment_count;

        private int created_at;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setUsername(String username){
            this.username = username;
        }
        public String getUsername(){
            return this.username;
        }
        public void setAbout(String about){
            this.about = about;
        }
        public String getAbout(){
            return this.about;
        }
        public void setSubmitted(int submitted){
            this.submitted = submitted;
        }
        public int getSubmitted(){
            return this.submitted;
        }
        public void setUpdated_at(String updated_at){
            this.updated_at = updated_at;
        }
        public String getUpdated_at(){
            return this.updated_at;
        }
        public void setSubmission_count(int submission_count){
            this.submission_count = submission_count;
        }
        public int getSubmission_count(){
            return this.submission_count;
        }
        public void setComment_count(int comment_count){
            this.comment_count = comment_count;
        }
        public int getComment_count(){
            return this.comment_count;
        }
        public void setCreated_at(int created_at){
            this.created_at = created_at;
        }
        public int getCreated_at(){
            return this.created_at;
        }
    }

    static class Root
    {
        private String page;

        private int per_page;

        private int total;

        private int total_pages;

        private List<Data> data;

        public void setPage(String page){
            this.page = page;
        }
        public String getPage(){
            return this.page;
        }
        public void setPer_page(int per_page){
            this.per_page = per_page;
        }
        public int getPer_page(){
            return this.per_page;
        }
        public void setTotal(int total){
            this.total = total;
        }
        public int getTotal(){
            return this.total;
        }
        public void setTotal_pages(int total_pages){
            this.total_pages = total_pages;
        }
        public int getTotal_pages(){
            return this.total_pages;
        }
        public void setData(List<Data> data){
            this.data = data;
        }
        public List<Data> getData(){
            return this.data;
        }
    }

}
