package com.xebia.hr.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by rajeshkumar on 05/09/15.
 */
@Entity
@Table(name = "COURSE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(nullable = false, columnDefinition = "Varchar(30)", name = "NAME", unique=true)
    private String name;

    @Column(nullable = false, columnDefinition = "Varchar(300)", name = "DESCRIPTION")
    private String description;

    public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	@Column(columnDefinition = "Varchar(200)", name = "VIDEO_FILE_PATH")
    private String videoURL;

    @Column(columnDefinition = "Varchar(200)", name = "PDF_FILE_PATH")
    private String pdfPath;

    
    @ManyToMany(mappedBy = "courses")
    @JsonManagedReference
    private Set<Employee> employees = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(final Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", employees=" + employees + '}';
    }
}