package net.jc.beeerp.module.field.type;

import net.jc.beeerp.module.Entity;
import net.jc.beeerp.module.field.Field;

public class FieldBool extends Field<Boolean> {

	public FieldBool(String name, Entity originalEntity) {
		super(name, originalEntity);
	}

	@Override
	public String getDataString() {
		if (getData() == null) {
			return "";
		}

		if (getData()) {
			return "True";
		}
		return "False";
	}

	@Override
	public void setDataString(String data) {
		if (data.equalsIgnoreCase("on") || data.equalsIgnoreCase("true")
				|| data.equalsIgnoreCase("yes")) {
			setDataType(true);
		} else {
			setDataType(false);
		}
	}

	@Override
	protected Class<Boolean> getTypeArgument() {
		return Boolean.class;
	}
}
