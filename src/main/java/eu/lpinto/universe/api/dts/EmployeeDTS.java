package eu.lpinto.universe.api.dts;

import eu.lpinto.universe.persistence.entities.Employee;
import eu.lpinto.universe.persistence.entities.WorkerProfile;

/**
 *
 * @author Luis Pinto <code>- mail@lpinto.eu</code>
 */
public class EmployeeDTS extends AbstractDTS<Employee, eu.lpinto.universe.api.dto.Employee> {

    public static final EmployeeDTS T = new EmployeeDTS();

    @Override
    public eu.lpinto.universe.api.dto.Employee toAPI(Employee entity) {
        if (entity == null) {
            return null;

        } else if (entity.isFull()) {
            return new eu.lpinto.universe.api.dto.Employee(
                    entity.getExternalID(),
                    OrganizationDTS.id(entity.getOrganization()),
                    entity.getProfile() == null ? null : entity.getProfile().ordinal(),
                    entity.getEmail(),
                    entity.getPhone(),
                    entity.getMobilePhone(),
                    entity.getStreet(),
                    entity.getTown(),
                    entity.getCountry(),
                    entity.getZip(),
                    entity.getNif(),
                    AbstractDTS.abstractIDs(entity.getOrganizations()),
                    entity.getName(),
                    AbstractDTS.id(entity.getCreator()),
                    entity.getCreated(),
                    AbstractDTS.id(entity.getUpdater()),
                    entity.getUpdated(),
                    entity.getId());

        } else {
            return new eu.lpinto.universe.api.dto.Employee(
                    entity.getExternalID(),
                    OrganizationDTS.id(entity.getOrganization()),
                    entity.getProfile() == null ? null : entity.getProfile().ordinal(),
                    entity.getEmail(),
                    entity.getPhone(),
                    entity.getMobilePhone(),
                    entity.getStreet(),
                    entity.getTown(),
                    entity.getCountry(),
                    entity.getZip(),
                    entity.getNif(),
                    AbstractDTS.abstractIDs(entity.getOrganizations()),
                    entity.getName(),
                    AbstractDTS.id(entity.getCreator()),
                    entity.getCreated(),
                    AbstractDTS.id(entity.getUpdater()),
                    entity.getUpdated(),
                    entity.getId());
        }
    }

    @Override
    public Employee toDomain(Long id) {
        if (id == null) {
            return null;
        }

        return new Employee(id);
    }

    @Override
    public Employee toDomain(eu.lpinto.universe.api.dto.Employee dto) {
        return new Employee(
                dto.getExternalID(),
                OrganizationDTS.T.toDomain(dto.getOrganization()),
                dto.getRole() == null ? null : WorkerProfile.values()[dto.getRole()],
                dto.getEmail(),
                dto.getPhone(),
                dto.getMobilePhone(),
                dto.getStreet(),
                dto.getTown(),
                dto.getCountry(),
                dto.getZip(),
                dto.getNif(),
                OrganizationDTS.T.toDomainIDs(dto.getOrganizations()),
                dto.getName(),
                UserDTS.T.toDomain(dto.getCreator()),
                dto.getCreated(),
                UserDTS.T.toDomain(dto.getUpdater()),
                dto.getUpdated(),
                dto.getId());
    }
}
