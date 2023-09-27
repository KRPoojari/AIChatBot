package com.rest.entity;

import javax.persistence.*;

@Entity
@Table(name="company_details")
public class CompanyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="file_name")
    private String file_name;

    @Column(name="file_type")
    private String file_type;

    @Column(name="file_link")
    private String file_link;

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_link() {
        return file_link;
    }

    public void setFile_link(String file_link) {
        this.file_link = file_link;
    }
}
