package kr.personal;

public class CovidStatus {
    private String category;
    private String confirmed;
    private String dead;
    private String rate;

    public CovidStatus() {
    }

    public CovidStatus(String category, String confirmed, String dead, String rate) {
        this.category = category;
        this.confirmed = confirmed;
        this.dead = dead;
        this.rate = rate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDead() {
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "CovidStatus{" +
                "category='" + category + '\'' +
                ", confirmed=" + confirmed +
                ", dead=" + dead +
                ", rate=" + rate +
                '}';
    }
}
