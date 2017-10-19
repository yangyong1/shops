package com.yang.framework.help;


import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class AutoIdModel implements Serializable {
    protected Long id;
    protected String createdAt;
    protected String updatedAt;

    public AutoIdModel(){

    }
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="createdat",length = 20)
    public String getCreatedAt() {
        if ( null != this.createdAt ) {
            return this.createdAt;
        } else {
            return null;
        }
    }
    public void setCreatedAt(String val) {
        if (val != null) {
            this.createdAt = val;
        } else {
            this.createdAt = null;
        }
    }

    @Column(name="updatedat",length = 20)
    public String getUpdatedAt() {
        if ( null != this.updatedAt ) {
            return this.updatedAt;
        } else {
            return null;
        }
    }
    public void setUpdatedAt(String val) {
        if (val != null) {
            this.updatedAt = val;
        } else {
            this.updatedAt = null;
        }
    }
}
