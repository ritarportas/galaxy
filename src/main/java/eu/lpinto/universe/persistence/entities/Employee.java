package eu.lpinto.universe.persistence.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Luis Pinto <code>- mail@lpinto.eu</code>
 */
@Entity
@Table(name = "Organization_Person")
public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long externalID;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Organization organization;

    @Enumerated(EnumType.ORDINAL)
    private WorkerProfile profile;

    /*
     * Constructors
     */
    public Employee() {
        super();
    }

    public Employee(final Long id) {
        super(id);
    }

    public Employee(final Long externalID, final Organization organization, final WorkerProfile profile) {
        super();
        this.externalID = externalID;
        this.organization = organization;
        this.profile = profile;
    }

    public Employee(final Long externalID, final Organization organization, final WorkerProfile profile,
                    final Long id, final String name, final Calendar created, final Calendar updated) {
        this.externalID = externalID;
        this.organization = organization;
        this.profile = profile;
    }

    public Employee(Long externalID, Organization organization, WorkerProfile profile, String email, String phone, String mobilePhone, String street, String town, String country, String zip, String nif, List<Organization> organizations, String name, User creator, Calendar created, User updater, Calendar updated, Long id) {
        super(email, phone, mobilePhone, street, town, country, zip, nif, organizations, name, creator, created, updater, updated, id);
        this.externalID = externalID;
        this.organization = organization;
        this.profile = profile;
    }

    /*
     * Getters/Setters
     */
    public Long getExternalID() {
        return externalID;
    }

    public void setExternalID(Long externalID) {
        this.externalID = externalID;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(final Organization organization) {
        assertNotNull(organization);

        this.organization = organization;
    }

    public WorkerProfile getProfile() {
        return profile;
    }

    public void setProfile(final WorkerProfile profile) {
        assertNotNull(profile);

        this.profile = profile;
    }
}
