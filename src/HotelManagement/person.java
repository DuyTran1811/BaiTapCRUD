package HotelManagement;

public class person {
    private String fullName;
    private String dateOfBirth;
    private String CMTND;

    public person() {
    }

    public person(String fullName, String dateOfBirth, String CMTND) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.CMTND = CMTND;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCMTND() {
        return CMTND;
    }

    public void setCMTND(String CMTND) {
        this.CMTND = CMTND;
    }
}
