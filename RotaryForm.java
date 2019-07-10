/*
   *************************************************************************************************
   Program: RotaryForm.java
   Repository Name: Rotary-Form
   Date Created: 08-Jul-19
   Program Description: This class represents a the pdf form that is being created.

   *************************************************************************************************
*/
import java.text.SimpleDateFormat;
import java.util.*;

public class RotaryForm extends RotaryFormTable {
    private String property_Name;
    private Date dateCreated;

    public RotaryForm() {
        dateCreated = new Date();
    }

    public RotaryForm(String property_Name) {
        this.property_Name = property_Name;
        dateCreated = new Date();
    }

    public String getFormName() {
        return getProperty_Name() + "-" + DateToString();
    }

    public String getProperty_Name() {
        return property_Name;
    }

    public void setProperty_Name(String property_Name) {
        this.property_Name = property_Name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String DateToString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(getDateCreated());
    }
}
