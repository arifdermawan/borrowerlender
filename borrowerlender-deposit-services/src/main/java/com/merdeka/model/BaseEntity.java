package com.merdeka.model;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseEntity {
	
	 	@Column(updatable = false)
	    @CreationTimestamp
	    @ApiModelProperty(notes = "Created Datetime")
	    private LocalDateTime createdAt;
	    @UpdateTimestamp
	    @ApiModelProperty(notes = "Update Datetime")
	    private LocalDateTime updatedAt;
	 
}
