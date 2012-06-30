package com.logilibre.beeerp.module;


/**
 * @author r3lemaypa, r3lacasgu, Jonatan Cloutier
 */
public class Entity {
	protected final Fields fields;

	/**
	 * Build an entity containing the specified fields.
	 * 
	 * @param fields the fields
	 */
	public Entity(Fields fields) {
		this.fields = fields;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		//TODO: use apache.commons.HashCodeBuilder
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		//TODO: use apache.commons.EqualsBuilder
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(!(obj instanceof Entity)){
			return false;
		}
		Entity other = (Entity) obj;
		if(fields == null){
			if(other.fields != null){
				return false;
			}
		}else if(!fields.equals(other.fields)){
			return false;
		}
		return true;
	}
	
	public Fields getFields() {
		return fields;
	}

	@Override
	public String toString() {
		return fields.toString();
	}

	/**
	 * Get the data from a specified field
	 * @param fieldName The field name 
	 * @return The data from the specified field
	 */
	public Object getData(String fieldName) {
		return null;//Fields.getField(fieldName).getData();
	}

	/**
	 * Set the data to the specified field
	 * @param fieldName The field name
	 * @param data the data to set
	 */
	public void setData(String fieldName, Object data) {
		//getFields().setData(fieldName, data);
	}
}
