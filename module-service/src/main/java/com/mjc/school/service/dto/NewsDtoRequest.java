package com.mjc.school.service.dto;

import org.springframework.stereotype.Component;

@Component
public class NewsDtoRequest {

    private Long id;
    private String title;
    private String content;
    private long authorId;

    public NewsDtoRequest() {
    }

    public NewsDtoRequest(Long id, String title, String content, long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "NewsDtoRequest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
