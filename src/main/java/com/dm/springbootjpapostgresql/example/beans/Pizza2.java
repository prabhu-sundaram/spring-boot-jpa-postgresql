package com.dm.springbootjpapostgresql.example.beans;

//import static org.junit.Assert.assertTrue;

//import org.junit.Test;

public class Pizza2 {

    private PizzaStatus status;
    public PizzaStatus getStatus() {
		return status;
	}

	public void setStatus(PizzaStatus status) {
		this.status = status;
	}

	public enum PizzaStatus {
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " + 
          this.getStatus().getTimeToDelivery());
    }
    
    //@Test
    public void givenPizaOrder_whenReady_thenDeliverable() {
        Pizza2 testPz = new Pizza2();
        //testPz.setStatus(Pizza.PizzaStatus.READY);
        testPz.setStatus(Pizza2.PizzaStatus.ORDERED);
        testPz.printTimeToDeliver();
        //assertTrue(testPz.isDeliverable());
        testPz.printTimeToDeliver();
    }
    
}
