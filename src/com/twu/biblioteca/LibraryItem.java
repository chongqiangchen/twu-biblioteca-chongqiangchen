package com.twu.biblioteca;

public class LibraryItem {
    private String Id;
    private String ownerId;
    private boolean isAvailable;

    public LibraryItem(String Id){
        this.Id = Id;
        this.isAvailable = true;
    }
    public boolean isAvailable(){
        return this.isAvailable;
    }
    public Object getId() {
        return this.Id;
    }
    public void checkOut(User user){
        this.ownerId = user.getUserName();
        this.isAvailable = false;
    }
    public void returnBack(){
        this.ownerId = null;
        this.isAvailable = true;
    }


}
