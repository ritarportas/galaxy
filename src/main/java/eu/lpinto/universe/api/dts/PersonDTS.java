package eu.lpinto.universe.api.dts;

import eu.lpinto.universe.persistence.entities.Person;

/**
 * Person DTO - Data Transformation Object
 *
 * @author Luis Pinto <code>- mail@lpinto.eu</code>
 */
public class PersonDTS extends AbstractDTS<Person, eu.lpinto.universe.api.dto.Person> {

    public static final PersonDTS T = new PersonDTS();

    @Override
    public eu.lpinto.universe.api.dto.Person toAPI(Person entity) {
        if (entity == null) {
            return null;

        } else if (entity.isFull()) {
            return new eu.lpinto.universe.api.dto.Person(
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
            return new eu.lpinto.universe.api.dto.Person(
                    entity.getEmail(),
                    entity.getPhone(),
                    entity.getMobilePhone(),
                    entity.getStreet(),
                    entity.getTown(),
                    entity.getCountry(),
                    entity.getZip(),
                    entity.getNif(),
                    null,
                    entity.getName(),
                    AbstractDTS.id(entity.getCreator()),
                    entity.getCreated(),
                    AbstractDTS.id(entity.getUpdater()),
                    entity.getUpdated(),
                    entity.getId());
        }
    }

    @Override
    public Person toDomain(Long id) {
        if (id == null) {
            return null;
        }

        return new Person(id);
    }

    @Override
    public Person toDomain(eu.lpinto.universe.api.dto.Person dto) {
        return new Person(
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
