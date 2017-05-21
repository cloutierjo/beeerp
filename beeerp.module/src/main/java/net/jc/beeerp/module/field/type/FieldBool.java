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
	public void setDataStringInner(String data) {
		if ("on".equalsIgnoreCase(data) || "true".equalsIgnoreCase(data)
				|| "yes".equalsIgnoreCase(data)) {
			setDataType(Boolean.TRUE);
		} else {
			setDataType(Boolean.FALSE);
		}
	}

	@Override
	protected Class<Boolean> getTypeArgument() {
		return Boolean.class;
	}
}
