package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Cryptocycles type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Cryptocycles", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Cryptocycles implements Model {
  public static final QueryField ID = field("id");
  public static final QueryField USERNAME = field( "username");
  public static final QueryField PASSWORD = field( "password");
  public static final QueryField CYCLESTATUS = field("cyclestatus");
  public static final QueryField TESTFIELD = field( "testfield");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String username;
  private final @ModelField(targetType="Int") Integer password;
  private final @ModelField(targetType="Boolean") Boolean cyclestatus;
  private final @ModelField(targetType="String") String testfield;

  public String getId() {
      return id;
  }
  
  public String getUsername() {
      return username;
  }
  
  public Integer getPassword() {
      return password;
  }
  
  public Boolean getCyclestatus() {
      return cyclestatus;
  }
  
  public String getTestfield() {
      return testfield;
  }
  

  
  private Cryptocycles(String id, String username, Integer password, Boolean cyclestatus, String testfield) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.cyclestatus = cyclestatus;
    this.testfield = testfield;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Cryptocycles cryptocycles = (Cryptocycles) obj;
      return ObjectsCompat.equals(getId(), cryptocycles.getId()) &&
              ObjectsCompat.equals(getUsername(), cryptocycles.getUsername()) &&
              ObjectsCompat.equals(getPassword(), cryptocycles.getPassword()) &&
              ObjectsCompat.equals(getCyclestatus(), cryptocycles.getCyclestatus()) &&
              ObjectsCompat.equals(getTestfield(), cryptocycles.getTestfield());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUsername())
      .append(getPassword())
      .append(getCyclestatus())
      .append(getTestfield())

      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Cryptocycles {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("username=" + String.valueOf(getUsername()) + ", ")
      .append("password=" + String.valueOf(getPassword()) + ", ")
      .append("cyclestatus=" + String.valueOf(getCyclestatus()) + ", ")
      .append("testfield=" + String.valueOf(getTestfield()) + ", ")

      .append("}")
      .toString();
  }
  
  public static UsernameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Cryptocycles justId(String id) {
    return new Cryptocycles(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      username,
      password,
      cyclestatus,
      testfield);
  }
  public interface UsernameStep {
    BuildStep username(String username);
  }
  

  public interface BuildStep {
    Cryptocycles build();
    BuildStep id(String id);
    BuildStep password(Integer password);
    BuildStep cyclestatus(Boolean cyclestatus);
    BuildStep testfield(String testfield);
  }
  

  public static class Builder implements UsernameStep, BuildStep {
    private String id;
    private String username;
    private Integer password;
    private Boolean cyclestatus;
    private String testfield;
    @Override
     public Cryptocycles build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Cryptocycles(
          id,
          username,
          password,
          cyclestatus,
          testfield);
    }
    
    @Override
     public BuildStep username(String username) {
        Objects.requireNonNull(username);
        this.username = username;
        return this;
    }
    
    @Override
     public BuildStep password(Integer password) {
        this.password = password;
        return this;
    }
    
    @Override
     public BuildStep cyclestatus(Boolean cyclestatus) {
        this.cyclestatus = cyclestatus;
        return this;
    }
    
    @Override
     public BuildStep testfield(String testfield) {
        this.testfield = testfield;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String username, Integer password, Boolean cyclestatus, String testfield) {
      super.id(id);
      super.username(username)
        .password(password)
        .cyclestatus(cyclestatus)
        .testfield(testfield);
    }
    
    @Override
     public CopyOfBuilder username(String username) {
      return (CopyOfBuilder) super.username(username);
    }
    
    @Override
     public CopyOfBuilder password(Integer password) {
      return (CopyOfBuilder) super.password(password);
    }
    
    @Override
     public CopyOfBuilder cyclestatus(Boolean cyclestatus) {
      return (CopyOfBuilder) super.cyclestatus(cyclestatus);
    }
    
    @Override
     public CopyOfBuilder testfield(String testfield) {
      return (CopyOfBuilder) super.testfield(testfield);
    }
  }
  
}
