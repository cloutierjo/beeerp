package net.jc.beeerp.module;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import net.jc.beeerp.module.field.Field;
import net.jc.beeerp.module.field.Fields;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FieldsTest {
	private Fields fields;
	@Mock
	private Field<Integer> field1;
	@Mock
	private Field<Integer> field2;

	private static final String FIELD_1_NAME = "field 1";
	private static final String FIELD_2_NAME = "field 2";
	private static final int FIELD_1_VALUE = 123;
	private static final int FIELD_2_VALUE = 231;
	private static final int FIELD_1_NEW_VALUE = 345;
	private static final int FIELD_2_NEW_VALUE = 678;
	
	@Before
	public void setUp() throws Exception {
		fields = new Fields();

		when(field1.getName()).thenReturn(FIELD_1_NAME);
		when(field1.getData()).thenReturn(FIELD_1_VALUE);
		when(field1.getDataString()).thenReturn("" + FIELD_1_VALUE);
		fields.addField(field1);

		when(field2.getName()).thenReturn(FIELD_2_NAME);
		when(field2.getData()).thenReturn(FIELD_2_VALUE);
		when(field2.getDataString()).thenReturn("" + FIELD_2_VALUE);
		fields.addField(field2);
	}

	@Test
	public final void constructorWork() {
		assertNotNull(fields);
	}

	@Test
	public final void getFieldReturnTheOriginalField() {
		assertSame(field1, fields.getField(FIELD_1_NAME));
		assertNotSame(field2, fields.getField(FIELD_1_NAME));
		assertSame(field2, fields.getField(FIELD_2_NAME));
		assertNotSame(field1, fields.getField(FIELD_2_NAME));
	}

	@Test
	public final void getFieldDataReturnTheOriginalFieldData() {
		assertEquals(FIELD_1_VALUE, fields.getData(FIELD_1_NAME));
		assertEquals(FIELD_2_VALUE, fields.getData(FIELD_2_NAME));
	}

	@Test
	public final void getFieldDataStringReturnTheOriginalFieldDataInString() {
		assertEquals("" + FIELD_1_VALUE, fields.getDataString(FIELD_1_NAME));
		assertEquals("" + FIELD_2_VALUE, fields.getDataString(FIELD_2_NAME));
	}

	@Test
	public final void setFieldDataReturnTheOriginalFieldData() {
		fields.setData(FIELD_1_NAME, FIELD_1_NEW_VALUE);
		fields.setData(FIELD_2_NAME, FIELD_2_NEW_VALUE);

		verify(field1).setData(FIELD_1_NEW_VALUE);
		verify(field2).setData(FIELD_2_NEW_VALUE);
	}

	@Test
	public final void setFieldDataStringReturnTheOriginalFieldDataInString() {
		fields.setDataString(FIELD_1_NAME, "" + FIELD_1_NEW_VALUE);
		fields.setDataString(FIELD_2_NAME, "" + FIELD_2_NEW_VALUE);

		verify(field1).setDataString("" + FIELD_1_NEW_VALUE);
		verify(field2).setDataString("" + FIELD_2_NEW_VALUE);
	}
}
