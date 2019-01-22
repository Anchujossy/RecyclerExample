package com.example.admin.recyclerexample;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class UserDetails extends RealmObject {

  //  @Required
   private String userName;
 //   @Required
   private String userId;
   // @Required
   private String userAddress;
  //  @Required
    private String userEmail;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
