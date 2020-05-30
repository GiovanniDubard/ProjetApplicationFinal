package com.example.projetapplicationfinal.presentataion.model;

import java.util.List;

public class RestRickAndMortyResponse {

    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
    private List<Characters> results;

    public Integer getCount() {
        return count;
    }

    public Integer getPages() {
        return pages;
    }

    public String getNext() {
        return next;
    }

    public List<Characters> getResults() {
        return results;
    }
}
