package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements PHIAdminCompliant, PHICompliantUser {

    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    private Integer pin;

	@Override
	public boolean assignPin(int pin) {
		if (pin < 100000) {
			return false;			
		} else {
			return true;
		}
	}

	@Override
	public boolean isAuthorized(Integer confirmedAuthID) {
		newIncident("These are some notes...");
		return true;
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return this.securityIncidents;
	}
	
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

}
