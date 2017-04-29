package net.jc.beeerp.module.field.type;

import java.sql.Date;

import net.jc.beeerp.module.Entity;
import net.jc.beeerp.module.exception.InvalidDataValueException;
import net.jc.beeerp.module.field.Field;

public class FieldDate extends Field<Date> {

	public FieldDate(String name, Entity originalEntity) {
		super(name, originalEntity);
	}

	@Override
	public void setDataString(String data) {
		if (data == null || data.isEmpty() || "null".equals(data)) {
			setDataType(null);
			return;
		}

		try{
			setDataType(Date.valueOf(data));
		}catch(Exception e){
			throw new InvalidDataValueException(
					"Le format de donnée entrée ne correspond pas avec le type de champ (Date): "
							+ data, e);
		}
	}

	@Override
	protected Class<Date> getTypeArgument() {
		return Date.class;
	}
}
