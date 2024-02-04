package sample;



public class reportdata {

    String Incident;
    String Location;
    String AdditionalInfo;
    String Contact;

    public reportdata(String Incident,String Location,String AdditionalInfo,String Contact) {
        this.Incident = Incident;
        this.Location = Location;
        this.AdditionalInfo= AdditionalInfo;
        this.Contact = Contact;

    }

    public String getIncident() {
        return Incident;
    }

    public void setIncident(String incident) {
        Incident = incident;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getAdditionalInfo() {
        return AdditionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        AdditionalInfo = additionalInfo;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }
}