package com.klu.HibernateCRUD;

import javax.persistence.Column;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "s13student")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "thirdsem", discriminatorType = DiscriminatorType.STRING )
@DiscriminatorValue("student")
public class Student {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;
  @Column(name = "stu_name")
  String name;
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

}