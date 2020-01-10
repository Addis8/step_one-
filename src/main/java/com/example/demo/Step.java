package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Step {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;


        @Size(min = 4)
        private String content;

        @NotNull
        @Size(min = 3)
        private String postedate;

        @NotNull
        @Size(min = 10)
        private String sentby;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPosteddate() {
            return postedate;
        }

        public void setPosteddate(String posteddate) {
            this.postedate = posteddate;
        }

        public String getSentby() {
            return sentby;
        }

        public void setSentby(String sentby) {
            this.sentby = sentby;
        }
    }

