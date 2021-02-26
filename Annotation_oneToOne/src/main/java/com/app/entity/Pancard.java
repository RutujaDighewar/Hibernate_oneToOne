package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Pancard {

	@Id
	@GeneratedValue(generator="abc")
	@GenericGenerator(name="abc" , strategy= "foreign" , parameters = @Parameter(name = "property" , value="person"))
	private int id;
	
	private String pancardno;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Person person;

	@Override
	public String toString() {
		return "Pancard [id=" + id + ", pancardno=" + pancardno + "]";
	}
	
	
	
}
