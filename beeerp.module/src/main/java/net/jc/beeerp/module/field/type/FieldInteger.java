package net.jc.beeerp.module.field.type;

import net.jc.beeerp.module.Entity;
import net.jc.beeerp.module.exception.InvalidDataValueException;
import net.jc.beeerp.module.field.Field;

public class FieldInteger extends Field<Integer> {

	public FieldInteger(String name,Entity originalEntity) {
		super(name, originalEntity);
	}

	@Override
	public void setDataStringInner(String data) {
		if (data == null || data.isEmpty() || "null".equals(data)) {
			setDataType(0);
			return;
		}

		try{
			setDataType(Integer.valueOf(data));
		}catch(Exception e){
			throw new InvalidDataValueException(
					"Le format de donnée entrée ne correspond pas avec le type de champ (int): "
							+ data, e);
		}
	}

	@Override
	protected Class<Integer> getTypeArgument() {
		return Integer.class;
	}
}
