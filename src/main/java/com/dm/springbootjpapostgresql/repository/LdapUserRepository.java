package com.dm.springbootjpapostgresql.repository;

import java.util.List;

import com.dm.springbootjpapostgresql.model.LdapUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ldap.NameAlreadyBoundException;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import javax.naming.Name;

import static org.springframework.ldap.query.LdapQueryBuilder.*;
@Repository
public class LdapUserRepository {
    
   public static String BASE_DN = "ou=People,dc=AadhaviTheera,dc=local";
   @Autowired
   private LdapTemplate ldapTemplate;

   public void addUser(LdapUser user) {
      try {
         DirContextAdapter context = new DirContextAdapter(buildDn(user));
         mapToContext(user, context);
         ldapTemplate.bind(context);
      } catch (NameAlreadyBoundException e) {
         throw new ResponseStatusException(
                 HttpStatus.CONFLICT, "User Already Exists", e);
      }
   }

   protected void mapToContext(LdapUser user, DirContextOperations context) {
      context.setAttributeValues("objectclass", new String[] { "inetOrgPerson", "posixAccount", "top" });
      context.setAttributeValue("cn", user.getCn());
      context.setAttributeValue("uid", user.getUid());
   }

   private Name buildDn(LdapUser user) {
      Name dn = LdapNameBuilder.newInstance(BASE_DN)
              .add("uid", user.getUid())
              .build();
      return dn;
   }

   public LdapUser getUser(String uid) {
      try {
         return ldapTemplate.findOne(query().base(BASE_DN).where("uid").is(uid), LdapUser.class);
      } catch (EmptyResultDataAccessException e) {
         throw new ResponseStatusException(
                 HttpStatus.NOT_FOUND, "User Not Found", e);
      }
   }

   public List<LdapUser> getUsers() {
      return ldapTemplate.find(query().base(BASE_DN).where("uid").isPresent(), LdapUser.class);
   }

   public void delete(String uid) {
      try {
         LdapUser user = ldapTemplate.findOne(query().base(BASE_DN).where("uid").is(uid), LdapUser.class);
         ldapTemplate.unbind(user.getId());
      } catch (EmptyResultDataAccessException e) {
         throw new ResponseStatusException(
                 HttpStatus.NOT_FOUND, "User Not Found", e);
      }
   }
}