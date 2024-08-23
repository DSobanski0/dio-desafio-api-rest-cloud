package me.dio.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GamesOnLibrary> gamesOnLibrary;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GamesOnStore> gamesOnStore;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    @OneToOne(cascade = CascadeType.ALL)
    private Plan plan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GamesOnLibrary> getGamesOnLibrary() {
        return gamesOnLibrary;
    }

    public void setGamesOnLibrary(List<GamesOnLibrary> gamesOnLibrary) {
        this.gamesOnLibrary = gamesOnLibrary;
    }

    public List<GamesOnStore> getGamesOnStore() {
        return gamesOnStore;
    }

    public void setGamesOnStore(List<GamesOnStore> gamesOnStore) {
        this.gamesOnStore = gamesOnStore;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
