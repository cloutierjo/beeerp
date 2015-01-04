package net.jc.beeerp.module.field.type;

import net.jc.beeerp.module.Entity;
import net.jc.beeerp.module.field.Field;
import net.jc.beeerp.module.field.exception.InvalidDataValueException;

public class FieldDouble extends Field<Double> {

	public FieldDouble(String name, Entity originalEntity) {
		super(name, originalEntity);
	}

	@Override
	public void setDataString(String data) {
		if (data == null || data.isEmpty() || data.equals("null")) {
			setDataType(0.);
			return;
		}

		try{
			setDataType(Double.parseDouble(data));
		}catch(Exception e){
			throw new InvalidDataValueException(
					"Le format de donnée entrée ne correspond pas avec le type de champ (int): "
							+ data);
		}
	}

	@Override
	protected Class<Double> getTypeArgument() {
		return Double.class;
	}
}
