package com.stiff.security.entity.base;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marketing_activity_type database table.
 * 
 */
@Entity
@Table(name="marketing_activity_type")
@NamedQuery(name="MarketingActivityType.findAll", query="SELECT m FROM MarketingActivityType m")
public class MarketingActivityType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=20)
	private String color;

	@Column(length=100)
	private String description;

	@Column(nullable=false, length=45)
	private String type;

	//bi-directional many-to-one association to Marketing
	@OneToMany(mappedBy="marketingActivityType")
	private List<Marketing> marketings;

	public MarketingActivityType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Marketing> getMarketings() {
		return this.marketings;
	}

	public void setMarketings(List<Marketing> marketings) {
		this.marketings = marketings;
	}

	public Marketing addMarketing(Marketing marketing) {
		getMarketings().add(marketing);
		marketing.setMarketingActivityType(this);

		return marketing;
	}

	public Marketing removeMarketing(Marketing marketing) {
		getMarketings().remove(marketing);
		marketing.setMarketingActivityType(null);

		return marketing;
	}

}