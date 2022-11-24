package com.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "college")
public class Ent {

    @Id
private String university;
private String name;
private String semester;
private String college;
private int id;
}