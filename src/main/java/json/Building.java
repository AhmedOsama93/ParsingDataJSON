package json;

public class Building {
    @Override
    public String toString() {
        return "Building{" +
                "BlName='" + BlName + '\'' +
                ", city='" + city + '\'' +
                ", FoundationYear='" + FoundationYear + '\'' +
                '}';
    }

    public String getBlName() {
        return BlName;
    }

    public void setBlName(String blName) {
        BlName = blName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFoundationYear() {
        return FoundationYear;
    }

    public void setFoundationYear(String foundationYear) {
        FoundationYear = foundationYear;
    }

    public Building(String blName, String city, String foundationYear) {
        BlName = blName;
        this.city = city;
        FoundationYear = foundationYear;
    }

    public String BlName;
    public String city;
    public String FoundationYear;

}
