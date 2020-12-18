package com.example.test.ui.Feedback;

public class FeedbackHelper {
    String name, email, feedback,spinner_cat, provider_name;
    Float rating;

    public FeedbackHelper() {
    }

    public FeedbackHelper(String name, String email, String feedback, String spinner_cat, String provider_name, Float rating) {
        this.name = name;
        this.email = email;
        this.feedback = feedback;
        this.spinner_cat = spinner_cat;
        this.provider_name = provider_name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getSpinner_cat() {
        return spinner_cat;
    }

    public void setSpinner_cat(String spinner_cat) {
        this.spinner_cat = spinner_cat;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
