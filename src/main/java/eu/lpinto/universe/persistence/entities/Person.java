package eu.lpinto.universe.persistence.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * A person is a real person. This means it can represent an application user an animal owner or shelter worker...
 *
 * @author Luis Pinto <code>- mail@lpinto.eu</code>
 */
@Entity
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
             message = "Invalid email")
    private String email;

    private String phone;

    private String mobilePhone;

    private String street;
    private String town;
    private String country;
    private String zip;

    private String nif;

    @OneToMany
    private List<Organization> organizations;

    /*
     * Constructors
     */
    public Person() {
        super();
    }

    public Person(final Long id) {
        super(id);
    }

    public Person(String name) {
        super(name);
    }

    public Person(String email, String phone, String mobilePhone, String street, String town, String country, String zip, String nif, List<Organization> organizations, String name, User creator, Calendar created, User updater, Calendar updated, Long id) {
        super(name, creator, created, updater, updated, id);
        this.email = email;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.street = street;
        this.town = town;
        this.country = country;
        this.zip = zip;
        this.nif = nif;
        this.organizations = organizations;
    }


    /*
     * Getters/Setters
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(final String nif) {
        this.nif = nif;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

}
