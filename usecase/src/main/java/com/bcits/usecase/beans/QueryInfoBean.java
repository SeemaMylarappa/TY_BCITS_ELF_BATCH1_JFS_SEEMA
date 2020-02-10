package com.bcits.usecase.beans;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="query_info")
public class QueryInfoBean implements Serializable {
	
	@EmbeddedId
	private QueryInfoPK queryinfo;
	@Column
	private String support;
	@Column
	private String response;
	@Column
	private String region;

}
