package net.jc.beeerp.module;

import java.lang.reflect.Modifier;
import java.util.Map;

import net.jc.beeerp.module.field.Field;
import net.jc.beeerp.module.field.Fields;
import net.jc.beeerp.module.field.type.FieldBool;
import net.jc.beeerp.module.field.type.FieldDate;
import net.jc.beeerp.module.field.type.FieldDouble;
import net.jc.beeerp.module.field.type.FieldInteger;

/**
 *	Represent a simple entity that contain fields
 */
public class Entity {

	private final Fields fields;

	/**
	 * Build an entity containing the specified fields. **For unitTest purpose**
	 */
	protected Entity(Fields fields) {
		this.fields = fields;
	}

	/**
	 * Build an entity containing the fields based on the entity member.
	 */
	public Entity() {
		this.fields = generateFields();
	}

	public Integer getId() {
		throw new UnsupportedOperationException("the getId method must be reimplemented");
	}

	private Fields generateFields() {
		Fields newFields = new Fields();
		for (java.lang.reflect.Field field : this.getClass()
				.getDeclaredFields()) {
			int modifiers = field.getModifiers();
			if (Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers)
					|| Modifier.isTransient(modifiers)
					|| Modifier.isVolatile(modifiers)){
				continue;
			}
			newFields.addField(newField(field.getType(), field.getName()));
		}
		return newFields;
	}

	private Field<?> newField(Class<?> fieldType, String fieldName)
	{
		Field<?> field;

		switch (fieldType.getCanonicalName()) {
		case "java.lang.Boolean":
		case "boolean":
			field = new FieldBool(fieldName, this);
			break;
			// case CURRENCY:
			// field = new FieldCurrency(fieldName);
			// break;
		case "java.sql.Date":
			field = new FieldDate(fieldName, this);
			break;
			// case DATE_TIME:
			// field = new FieldDateTime(fieldName);
			// break;
		case "java.lang.Double":
		case "double":
			field = new FieldDouble(fieldName, this);
			break;
		case "java.lang.Integer":
		case "int":
			field = new FieldInteger(fieldName, this);
			break;
			// case STRING:
			// field = new FieldString(fieldName);
			// break;
			// case TEXT:
			// field = new FieldText(fieldName);
			// break;
			// case TIME:
			// field = new FieldTime(fieldName);
			// break;
		default:
			throw new UnsupportedOperationException("The field type " + fieldType.getCanonicalName() + " isn't managed");
		}

		return field;
	}

	public Fields getFields() {
		return fields;
	}

	@Override
	public String toString() {
		return fields.toString();
	}

	public void setDefaultValue() {
		// default implementation do nothing
	}

	public boolean isValid() {
		return fields.isValid();
	}

	public Map<String, InputError> getErrors() {
		return fields.getErrors();
	}
}
