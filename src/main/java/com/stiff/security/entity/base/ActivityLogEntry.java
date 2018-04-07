/**
 * 
 */
package com.stiff.security.entity.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author asaga3
 *
 */
@Entity
@Table(name="audit_log")
public class ActivityLogEntry implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4851369569643252232L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getObjectType()
	{
		return objectType;
	}
	public void setObjectType(String objectType)
	{
		this.objectType = objectType;
	}
	public int getObjectId()
	{
		return objectId;
	}
	@Override
	public String toString()
	{
		return "ActivityLogEntry [id=" + id + ", objectType=" + objectType + ", objectId=" + objectId
				+ ", attributeName=" + attributeName + ", previousValue=" + previousValue + ", newValue=" + newValue
				+ ", operation=" + operation + ", author=" + author + ", activityTime=" + activityTime + "]";
	}
	public void setObjectId(int objectId)
	{
		this.objectId = objectId;
	}
	public String getAttributeName()
	{
		return attributeName;
	}
	public void setAttributeName(String attributeName)
	{
		this.attributeName = attributeName;
	}
	public String getPreviousValue()
	{
		return previousValue;
	}
	public void setPreviousValue(String previousValue)
	{
		this.previousValue = previousValue;
	}
	public String getNewValue()
	{
		return newValue;
	}
	public void setNewValue(String newValue)
	{
		this.newValue = newValue;
	}
	public String getOperation()
	{
		return operation;
	}
	public void setOperation(String operation)
	{
		this.operation = operation;
	}
	public int getAuthor()
	{
		return author;
	}
	public void setAuthor(int author)
	{
		this.author = author;
	}
	public Date getActivityTime()
	{
		return activityTime;
	}
	public void setActivityTime(Date activityTime)
	{
		this.activityTime = activityTime;
	}
	@Column(name="object_type")
	private String objectType;
	@Column(name="object_id")
	private int objectId;
	@Column(name="attribute_name")
	private String attributeName;
	@Column(name="previous_value")
	private String previousValue;
	@Column(name="new_value")
	private String newValue;
	@Column(name="operation")
	private String operation;
	@Column(name="author")
	private int author;
	@Column(name="activity_time")
	private Date activityTime;
	
}
