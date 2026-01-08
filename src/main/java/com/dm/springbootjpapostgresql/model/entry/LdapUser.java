package com.dm.springbootjpapostgresql.model.entry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;
import jakarta.validation.constraints.NotBlank;
import java.util.Formatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entry(
        objectClasses = { "inetOrgPerson", "posixAccount", "top" },
        base = "ou=People,dc=AadhaviTheera,dc=local")
public class LdapUser implements Comparable<LdapUser> {

    @Id
    @JsonIgnore
    private Name id;

    @Schema(description = "unique id")
    @Attribute(name="uid")
    @NotBlank
    private String uid;

    @Schema(description = "Common name")
    @Attribute(name="cn")
    @NotBlank
    private String cn;

    @Override
    public int compareTo(LdapUser o) {
        boolean allAttributesEqual = getUid().equals(o.getUid())
                && getCn().equals(o.getCn());
        return allAttributesEqual ? 0 : 1;
    }

    @Override
    public String toString() {
        return new Formatter().format("{\"cn\": \"%s\", \"uid\": \"%s\"}",
                cn, uid).toString();
    }
}