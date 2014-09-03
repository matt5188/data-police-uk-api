package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    
    @Override
    public String toString(){
       return new ToStringBuilder(this)
       .append("email",email)
       .append("telephone", telephone)
       .append("mobile",mobile)
       .append("fax", fax)
       .append("web",web)
       .toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ContactDetails)){
            return false;
        }
        if(this == obj){
            return true;
        }
        ContactDetails c2 = (ContactDetails) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(c2.address, address)
        .append(c2.bebo, bebo)
        .append(c2.email, email)
        .append(c2.telephone, telephone)
        .append(c2.mobile, mobile)
        .append(c2.fax  , fax)
        .append(c2.web , web)
        .append(c2.address, address)
        .append(c2.facebook, facebook)
        .append(c2.twitter, twitter)
        .append(c2.youtube, youtube)
        .append(c2.myspace, myspace)
        .append(c2.bebo  , bebo)
        .append(c2.flickr, flickr)
        .append(c2.googlePlus, googlePlus)
        .append(c2.forum, googlePlus)
        .append(c2.emessaging, googlePlus)
        .append(c2.blog, googlePlus)
        .append(c2.rss, googlePlus);
        
        return eb.isEquals();
    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(email).append(telephone).append(mobile).append(fax).append(web).append(address);
        return hcb.hashCode();
    }
    
    
    

}
