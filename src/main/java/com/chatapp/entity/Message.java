package com.chatapp.entity;


public class Message {

   
    private Long id;
        private String content;
        private String sender;

        // Getters and setters
    

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
    // Constructors, getters, and setters
    
}
