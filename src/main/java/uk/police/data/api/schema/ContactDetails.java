package uk.police.data.api.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactDetails {
    
    private String email;
    private String telephone;
    private String mobile;
    private String fax;
    private String web;
    private String address;
    private String facebook;
    private String twitter;
    private String youtube;
    private String myspace;
    private String bebo;
    private String flickr;
    @JsonProperty(value = "google-plus")
    private String googlePlus;
    private String forum;
    @JsonProperty(value = "e-messaging")
    private String emessaging;
    private String blog;
    private String rss;

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFax() {
        return fax;
    }

    public String getWeb() {
        return web;
    }

    public String getAddress() {
        return address;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getYoutube() {
        return youtube;
    }

    public String getMyspace() {
        return myspace;
    }

    public String getBebo() {
        return bebo;
    }

    public String getFlickr() {
        return flickr;
    }

    public String getGooglePlus() {
        return googlePlus;
    }

    public String getForum() {
        return forum;
    }

    public String getEmessaging() {
        return emessaging;
    }

    public String getBlog() {
        return blog;
    }

    public String getRss() {
        return rss;
    }

}
