package com.dm.springbootjpapostgresql.example.beans;

public class Pizza {
	 private PizzaStatus status;
	    public enum PizzaStatus {
	        ORDERED,
	        READY,
	        DELIVERED;
	    }

		public PizzaStatus getStatus() {
			return status;
		}

		public void setStatus(PizzaStatus status) {
			this.status = status;
		}
		
	    public boolean isDeliverable() {
	        if (getStatus() == PizzaStatus.READY) {
	            return true;
	        }
	        return false;
	    }	
	    
	    public int getDeliveryTimeInDays() {
	        switch (status) {
	            case ORDERED: return 5;
	            case READY: return 2;
	            case DELIVERED: return 0;
	        }
	        return 0;
	    }	    
}
