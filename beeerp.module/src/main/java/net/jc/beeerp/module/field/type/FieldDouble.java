package net.jc.beeerp.module.field.type;

import net.jc.beeerp.module.Entity;
import net.jc.beeerp.module.exception.InvalidDataValueException;
import net.jc.beeerp.module.field.Field;

public class FieldDouble extends Field<Double> {

	public FieldDouble(String name, Entity originalEntity) {
		super(name, originalEntity);
	}

	@Override
	public void setDataStringInner(String data) {
		if (data == null || data.isEmpty() || "null".equals(data)) {
			setDataType(0.);
			return;
		}

		try{
			setDataType(Double.valueOf(data));
		}catch(Exception e){
			throw new InvalidDataValueException(
					"Le format de donnée entrée ne correspond pas avec le type de champ (double): "
							+ data, e);
		}
	}

	@Override
	protected Class<Double> getTypeArgument() {
		return Double.class;
	}
}
