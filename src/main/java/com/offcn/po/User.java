package com.offcn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="tb_user" )
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 200,nullable = true,name = "name")
    private String name;
    @Column(length = 4,nullable = true,name = "age")
    private Integer age;
}
