import java.util.ArrayList;
import java.util.List;

// Main class to demonstrate Composition
public class CompanyAndDepartment {
    public static void main(String[] args) {
        // Creating a business
        Business techFirm = new Business("Amazon");

        // Creating divisions
        Division softwareDivision = new Division("Software");
        Division marketingDivision = new Division("Marketing");

        // Assigning staff to divisions
        softwareDivision.addStaff("Harman", "Software Developer");
        softwareDivision.addStaff("Bharat", "Data Scientist");
        marketingDivision.addStaff("Harsh", "Marketing Director");
        marketingDivision.addStaff("Divyansh", "SEO Specialist");

        // Adding divisions to the business
        techFirm.addDivision(softwareDivision);
        techFirm.addDivision(marketingDivision);

        // Displaying business details
        techFirm.displayBusinessDetails();

        // Shutting down the business (removes all divisions and staff)
        techFirm.shutdownBusiness();
    }
}

// Staff class (Exists within a Division)
class Staff {
    private String fullName;
    private String jobTitle;

    public Staff(String fullName, String jobTitle) {
        this.fullName = fullName;
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Staff{name='" + fullName + "', position='" + jobTitle + "'}";
    }
}

// Division class (Exists within a Business)
class Division {
    private String divisionName;
    private List<Staff> staffList;

    public Division(String divisionName) {
        this.divisionName = divisionName;
        this.staffList = new ArrayList<>();
    }

    public void addStaff(String fullName, String jobTitle) {
        staffList.add(new Staff(fullName, jobTitle));
    }

    public void displayStaff() {
        System.out.println("\nDivision: " + divisionName);
        if (staffList.isEmpty()) {
            System.out.println("No staff assigned to this division.");
        } else {
            for (Staff member : staffList) {
                System.out.println(member);
            }
        }
    }
}

// Business class (Contains Divisions and Staff)
class Business {
    private String companyName;
    private List<Division> divisions;

    public Business(String companyName) {
        this.companyName = companyName;
        this.divisions = new ArrayList<>();
    }

    public void addDivision(Division division) {
        divisions.add(division);
    }

    public void displayBusinessDetails() {
        System.out.println("\nBusiness: " + companyName);
        for (Division div : divisions) {
            div.displayStaff();
        }
    }

    // When Business object is deleted, Divisions and Staff are also removed
    public void shutdownBusiness() {
        System.out.println("\nShutting down business: " + companyName);
        divisions.clear(); // All divisions and staff are removed
        System.out.println("All divisions and staff have been removed.");
    }
}
//output
// Business: Amazon
// Division: Software
// Staff{name='Harman', position='Software Developer'}
// Staff{name='Bharat', position='Data Scientist'}
//
// Division: Marketing
// Staff{name='Harsh', position='Marketing Director'}
// Staff{name='Divyansh', position='SEO Specialist'}
//
// Shutting down business: Amazon
// All divisions and staff have been removed.