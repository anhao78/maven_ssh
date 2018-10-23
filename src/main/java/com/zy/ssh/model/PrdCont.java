package com.zy.ssh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PRDCONT", catalog = "ma")
public class PrdCont {

	private int id;
	private String contentId;

	@Id
	@GeneratedValue(generator = "id")
	@GenericGenerator(name = "id", strategy = "native")
	// 自定义主键生成策略 generator = name
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CONTENT_ID")
	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	@Override
	public String toString() {
		return "PrdCont [id=" + id + ", contentId=" + contentId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contentId == null) ? 0 : contentId.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrdCont other = (PrdCont) obj;
		if (contentId == null) {
			if (other.contentId != null)
				return false;
		} else if (!contentId.equals(other.contentId))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
