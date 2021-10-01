package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Date;

public class ClinicalScheduler implements PHIAdminCompliant {

    private ArrayList<AdminUser> adminUsers; 
    private HashSet<Physician> doctors;
    private ArrayList<Appointment> appointments;
    private ArrayList<String> ePHIBreaches; // this class's version of security incidents
    
    public ClinicalScheduler(ArrayList<AdminUser> adminUsers, HashSet<Physician> doctors,
			ArrayList<Appointment> appointments, ArrayList<String> ePHIBreaches) {
		super();
		this.adminUsers = adminUsers;
		this.doctors = doctors;
		this.appointments = appointments;
		this.ePHIBreaches = ePHIBreaches;
	}
    
	@Override
	public ArrayList<String> reportSecurityIncidents() {
		return this.ePHIBreaches;
	}
	
    public void newIncident(Date incidentDate, Integer userID, String notes) {
        String report = String.format(
            "Datetime: %s \n,  Reported By Clinical Scheduler, User ID: %s\n %s \n", 
            incidentDate, userID, notes
        );
        ePHIBreaches.add(report);
    }
    
    public boolean bookAppointmentFor(Patient patient, Physician doctor, Date apptDate) {
        boolean success = false;
        return success;
    }
    
    public ArrayList<Appointment> openAppointmentsByPCP(Physician doctor, Date startRange, Date endRange){
        ArrayList<Appointment> openAppointments = new ArrayList<Appointment>();
        return openAppointments;
    }

	public ArrayList<AdminUser> getAdminUsers() {
		return adminUsers;
	}

	public void setAdminUsers(ArrayList<AdminUser> adminUsers) {
		this.adminUsers = adminUsers;
	}

	public HashSet<Physician> getDoctors() {
		return doctors;
	}

	public void setDoctors(HashSet<Physician> doctors) {
		this.doctors = doctors;
	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}

	public ArrayList<String> getePHIBreaches() {
		return ePHIBreaches;
	}

	public void setePHIBreaches(ArrayList<String> ePHIBreaches) {
		this.ePHIBreaches = ePHIBreaches;
	}

}
