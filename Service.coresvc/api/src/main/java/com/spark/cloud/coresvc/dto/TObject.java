/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.spark.cloud.coresvc.dto;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.protocol.TProtocolException;

/**
 * TObject
 */
public class TObject extends org.apache.thrift.TUnion<TObject, TObject._Fields>
{
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TObject");
    private static final org.apache.thrift.protocol.TField BOOL_VAL_FIELD_DESC = new org.apache.thrift.protocol.TField("boolVal",
            org.apache.thrift.protocol.TType.BOOL, (short) 1);
    private static final org.apache.thrift.protocol.TField INT_VAL_FIELD_DESC = new org.apache.thrift.protocol.TField("intVal",
            org.apache.thrift.protocol.TType.I32, (short) 2);
    private static final org.apache.thrift.protocol.TField LONG_VAL_FIELD_DESC = new org.apache.thrift.protocol.TField("longVal",
            org.apache.thrift.protocol.TType.I64, (short) 3);
    private static final org.apache.thrift.protocol.TField STR_VAL_FIELD_DESC = new org.apache.thrift.protocol.TField("strVal",
            org.apache.thrift.protocol.TType.STRING, (short) 4);

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum
    {
        BOOL_VAL((short) 1, "boolVal"), INT_VAL((short) 2, "intVal"), LONG_VAL((short) 3, "longVal"), STR_VAL((short) 4, "strVal");

        private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

        static
        {
            for (_Fields field : EnumSet.allOf(_Fields.class))
            {
                byName.put(field.getFieldName(), field);
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
         */
        public static _Fields findByThriftId(int fieldId)
        {
            switch (fieldId)
            {
                case 1: // BOOL_VAL
                    return BOOL_VAL;
                case 2: // INT_VAL
                    return INT_VAL;
                case 3: // LONG_VAL
                    return LONG_VAL;
                case 4: // STR_VAL
                    return STR_VAL;
                default:
                    return null;
            }
        }

        /**
         * Find the _Fields constant that matches fieldId, throwing an exception if it is not found.
         */
        public static _Fields findByThriftIdOrThrow(int fieldId)
        {
            _Fields fields = findByThriftId(fieldId);
            if (fields == null)
                throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            return fields;
        }

        /**
         * Find the _Fields constant that matches name, or null if its not found.
         */
        public static _Fields findByName(String name)
        {
            return byName.get(name);
        }

        private final short _thriftId;
        private final String _fieldName;

        _Fields(short thriftId, String fieldName)
        {
            _thriftId = thriftId;
            _fieldName = fieldName;
        }

        public short getThriftFieldId()
        {
            return _thriftId;
        }

        public String getFieldName()
        {
            return _fieldName;
        }
    }

    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static
    {
        Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(
                _Fields.class);
        tmpMap.put(_Fields.BOOL_VAL, new org.apache.thrift.meta_data.FieldMetaData("boolVal", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
        tmpMap.put(_Fields.INT_VAL, new org.apache.thrift.meta_data.FieldMetaData("intVal", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
        tmpMap.put(_Fields.LONG_VAL, new org.apache.thrift.meta_data.FieldMetaData("longVal", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
        tmpMap.put(_Fields.STR_VAL, new org.apache.thrift.meta_data.FieldMetaData("strVal", org.apache.thrift.TFieldRequirementType.DEFAULT,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
        metaDataMap = Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TObject.class, metaDataMap);
    }

    public TObject()
    {
        super();
    }

    public TObject(_Fields setField, Object value)
    {
        super(setField, value);
    }

    public TObject(TObject other)
    {
        super(other);
    }

    public TObject deepCopy()
    {
        return new TObject(this);
    }

    public static TObject boolVal(boolean value)
    {
        TObject x = new TObject();
        x.setBoolVal(value);
        return x;
    }

    public static TObject intVal(int value)
    {
        TObject x = new TObject();
        x.setIntVal(value);
        return x;
    }

    public static TObject longVal(long value)
    {
        TObject x = new TObject();
        x.setLongVal(value);
        return x;
    }

    public static TObject strVal(String value)
    {
        TObject x = new TObject();
        x.setStrVal(value);
        return x;
    }

    @Override
    protected void checkType(_Fields setField, Object value) throws ClassCastException
    {
        switch (setField)
        {
            case BOOL_VAL:
                if (value instanceof Boolean)
                {
                    break;
                }
                throw new ClassCastException("Was expecting value of type Boolean for field 'boolVal', but got " + value.getClass().getSimpleName());
            case INT_VAL:
                if (value instanceof Integer)
                {
                    break;
                }
                throw new ClassCastException("Was expecting value of type Integer for field 'intVal', but got " + value.getClass().getSimpleName());
            case LONG_VAL:
                if (value instanceof Long)
                {
                    break;
                }
                throw new ClassCastException("Was expecting value of type Long for field 'longVal', but got " + value.getClass().getSimpleName());
            case STR_VAL:
                if (value instanceof String)
                {
                    break;
                }
                throw new ClassCastException("Was expecting value of type String for field 'strVal', but got " + value.getClass().getSimpleName());
            default:
                throw new IllegalArgumentException("Unknown field id " + setField);
        }
    }

    @Override
    protected Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field)
            throws org.apache.thrift.TException
    {
        _Fields setField = _Fields.findByThriftId(field.id);
        if (setField != null)
        {
            switch (setField)
            {
                case BOOL_VAL:
                    if (field.type == BOOL_VAL_FIELD_DESC.type)
                    {
                        Boolean boolVal;
                        boolVal = iprot.readBool();
                        return boolVal;
                    }
                    else
                    {
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
                        return null;
                    }
                case INT_VAL:
                    if (field.type == INT_VAL_FIELD_DESC.type)
                    {
                        Integer intVal;
                        intVal = iprot.readI32();
                        return intVal;
                    }
                    else
                    {
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
                        return null;
                    }
                case LONG_VAL:
                    if (field.type == LONG_VAL_FIELD_DESC.type)
                    {
                        Long longVal;
                        longVal = iprot.readI64();
                        return longVal;
                    }
                    else
                    {
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
                        return null;
                    }
                case STR_VAL:
                    if (field.type == STR_VAL_FIELD_DESC.type)
                    {
                        String strVal;
                        strVal = iprot.readString();
                        return strVal;
                    }
                    else
                    {
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
                        return null;
                    }
                default:
                    throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
            }
        }
        else
        {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
        }
    }

    @Override
    protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException
    {
        switch (setField_)
        {
            case BOOL_VAL:
                Boolean boolVal = (Boolean) value_;
                oprot.writeBool(boolVal);
                return;
            case INT_VAL:
                Integer intVal = (Integer) value_;
                oprot.writeI32(intVal);
                return;
            case LONG_VAL:
                Long longVal = (Long) value_;
                oprot.writeI64(longVal);
                return;
            case STR_VAL:
                String strVal = (String) value_;
                oprot.writeString(strVal);
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + setField_);
        }
    }

    @Override
    protected Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID) throws org.apache.thrift.TException
    {
        _Fields setField = _Fields.findByThriftId(fieldID);
        if (setField != null)
        {
            switch (setField)
            {
                case BOOL_VAL:
                    Boolean boolVal;
                    boolVal = iprot.readBool();
                    return boolVal;
                case INT_VAL:
                    Integer intVal;
                    intVal = iprot.readI32();
                    return intVal;
                case LONG_VAL:
                    Long longVal;
                    longVal = iprot.readI64();
                    return longVal;
                case STR_VAL:
                    String strVal;
                    strVal = iprot.readString();
                    return strVal;
                default:
                    throw new IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
            }
        }
        else
        {
            throw new TProtocolException("Couldn't find a field with field id " + fieldID);
        }
    }

    @Override
    protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException
    {
        switch (setField_)
        {
            case BOOL_VAL:
                Boolean boolVal = (Boolean) value_;
                oprot.writeBool(boolVal);
                return;
            case INT_VAL:
                Integer intVal = (Integer) value_;
                oprot.writeI32(intVal);
                return;
            case LONG_VAL:
                Long longVal = (Long) value_;
                oprot.writeI64(longVal);
                return;
            case STR_VAL:
                String strVal = (String) value_;
                oprot.writeString(strVal);
                return;
            default:
                throw new IllegalStateException("Cannot write union with unknown field " + setField_);
        }
    }

    @Override
    protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField)
    {
        switch (setField)
        {
            case BOOL_VAL:
                return BOOL_VAL_FIELD_DESC;
            case INT_VAL:
                return INT_VAL_FIELD_DESC;
            case LONG_VAL:
                return LONG_VAL_FIELD_DESC;
            case STR_VAL:
                return STR_VAL_FIELD_DESC;
            default:
                throw new IllegalArgumentException("Unknown field id " + setField);
        }
    }

    @Override
    protected org.apache.thrift.protocol.TStruct getStructDesc()
    {
        return STRUCT_DESC;
    }

    @Override
    protected _Fields enumForId(short id)
    {
        return _Fields.findByThriftIdOrThrow(id);
    }

    public _Fields fieldForId(int fieldId)
    {
        return _Fields.findByThriftId(fieldId);
    }

    public boolean getBoolVal()
    {
        if (getSetField() == _Fields.BOOL_VAL)
        {
            return (Boolean) getFieldValue();
        }
        else
        {
            throw new RuntimeException("Cannot get field 'boolVal' because union is currently set to " + getFieldDesc(getSetField()).name);
        }
    }

    public void setBoolVal(boolean value)
    {
        setField_ = _Fields.BOOL_VAL;
        value_ = value;
    }

    public int getIntVal()
    {
        if (getSetField() == _Fields.INT_VAL)
        {
            return (Integer) getFieldValue();
        }
        else
        {
            throw new RuntimeException("Cannot get field 'intVal' because union is currently set to " + getFieldDesc(getSetField()).name);
        }
    }

    public void setIntVal(int value)
    {
        setField_ = _Fields.INT_VAL;
        value_ = value;
    }

    public long getLongVal()
    {
        if (getSetField() == _Fields.LONG_VAL)
        {
            return (Long) getFieldValue();
        }
        else
        {
            throw new RuntimeException("Cannot get field 'longVal' because union is currently set to " + getFieldDesc(getSetField()).name);
        }
    }

    public void setLongVal(long value)
    {
        setField_ = _Fields.LONG_VAL;
        value_ = value;
    }

    public String getStrVal()
    {
        if (getSetField() == _Fields.STR_VAL)
        {
            return (String) getFieldValue();
        }
        else
        {
            throw new RuntimeException("Cannot get field 'strVal' because union is currently set to " + getFieldDesc(getSetField()).name);
        }
    }

    public void setStrVal(String value)
    {
        if (value == null)
            throw new NullPointerException();
        setField_ = _Fields.STR_VAL;
        value_ = value;
    }

    public boolean isSetBoolVal()
    {
        return setField_ == _Fields.BOOL_VAL;
    }

    public boolean isSetIntVal()
    {
        return setField_ == _Fields.INT_VAL;
    }

    public boolean isSetLongVal()
    {
        return setField_ == _Fields.LONG_VAL;
    }

    public boolean isSetStrVal()
    {
        return setField_ == _Fields.STR_VAL;
    }

    public boolean equals(Object other)
    {
        if (other instanceof TObject)
        {
            return equals((TObject) other);
        }
        else
        {
            return false;
        }
    }

    public boolean equals(TObject other)
    {
        return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
    }

    @Override
    public int compareTo(TObject other)
    {
        int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
        if (lastComparison == 0)
        {
            return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
        }
        return lastComparison;
    }

    /**
     * If you'd like this to perform more respectably, use the hashcode generator option.
     */
    @Override
    public int hashCode()
    {
        return 0;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException
    {
        try
        {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        }
        catch (org.apache.thrift.TException te)
        {
            throw new java.io.IOException(te);
        }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException
    {
        try
        {
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        }
        catch (org.apache.thrift.TException te)
        {
            throw new java.io.IOException(te);
        }
    }

}
