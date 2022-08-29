package com.codeforcessubmissiondownloader.entities;

public class Submission {

    private long id;
    private long contestId;
    private String verdict;
    private String index;
    private String name;
    private String programmingLanguage;

    public Submission(long id, long contestId, String verdict, String index, String name, String programmingLanguage) {
        this.id = id;
        this.contestId = contestId;
        this.verdict = verdict;
        this.index = index;
        this.name = name;
        this.programmingLanguage = programmingLanguage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContestId() {
        return contestId;
    }

    public void setContestId(long contestId) {
        this.contestId = contestId;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    
    
}
