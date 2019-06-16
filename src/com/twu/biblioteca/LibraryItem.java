package com.twu.biblioteca;

public class LibraryItem {
    private String Id;
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
    public void checkOut(){
        this.isAvailable = false;
    }
    public void returnBack(){
        this.isAvailable = true;
    }


}
