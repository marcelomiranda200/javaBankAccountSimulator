package model;

import java.util.Date;

import utils.Utils;


public class Holder {
	 private static int counter = 1;

	    private int holderNumber ;
	    private String name;
	    private Date accountCreationDate;

	    public Holder() { }

	    public Holder(String name) {
	        this.holderNumber = Holder.counter;
	        this.name = name;
	        this.accountCreationDate = new Date();
	        Holder.counter += 1;
	    }

	    public int getHolderNumber() {
	        return this.holderNumber;
	    }

	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public Date getAccountCreationDate() {
	        return this.accountCreationDate;
	    }

	    public String toString() {
	        return  "\nName: " + this.getName() +
	                "\nAccount Creation Date: " + Utils.dateToString(this.getAccountCreationDate());
	    }


}
