package pl.coderslab.entity;

import javax.persistence.*;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String notes;
    private boolean mailingList;
    private List<String> programmingSkills;
    private List<String> hobbies;
}
