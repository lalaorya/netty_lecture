/**
 * Autogenerated by Thrift Compiler (0.16.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.16.0)", date = "2022-04-27")
public class BussinessException extends org.apache.thrift.TException implements org.apache.thrift.TBase<BussinessException, BussinessException._Fields>, java.io.Serializable, Cloneable, Comparable<BussinessException> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BussinessException");

  private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("message", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField CALL_STACK_FIELD_DESC = new org.apache.thrift.protocol.TField("callStack", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField HAPPEN_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("happenDate", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new BussinessExceptionStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new BussinessExceptionTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String message; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String callStack; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String happenDate; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MESSAGE((short)1, "message"),
    CALL_STACK((short)2, "callStack"),
    HAPPEN_DATE((short)3, "happenDate");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // MESSAGE
          return MESSAGE;
        case 2: // CALL_STACK
          return CALL_STACK;
        case 3: // HAPPEN_DATE
          return HAPPEN_DATE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.MESSAGE,_Fields.CALL_STACK,_Fields.HAPPEN_DATE};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("message", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.CALL_STACK, new org.apache.thrift.meta_data.FieldMetaData("callStack", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.HAPPEN_DATE, new org.apache.thrift.meta_data.FieldMetaData("happenDate", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BussinessException.class, metaDataMap);
  }

  public BussinessException() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BussinessException(BussinessException other) {
    if (other.isSetMessage()) {
      this.message = other.message;
    }
    if (other.isSetCallStack()) {
      this.callStack = other.callStack;
    }
    if (other.isSetHappenDate()) {
      this.happenDate = other.happenDate;
    }
  }

  public BussinessException deepCopy() {
    return new BussinessException(this);
  }

  @Override
  public void clear() {
    this.message = null;
    this.callStack = null;
    this.happenDate = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getMessage() {
    return this.message;
  }

  public BussinessException setMessage(@org.apache.thrift.annotation.Nullable java.lang.String message) {
    this.message = message;
    return this;
  }

  public void unsetMessage() {
    this.message = null;
  }

  /** Returns true if field message is set (has been assigned a value) and false otherwise */
  public boolean isSetMessage() {
    return this.message != null;
  }

  public void setMessageIsSet(boolean value) {
    if (!value) {
      this.message = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getCallStack() {
    return this.callStack;
  }

  public BussinessException setCallStack(@org.apache.thrift.annotation.Nullable java.lang.String callStack) {
    this.callStack = callStack;
    return this;
  }

  public void unsetCallStack() {
    this.callStack = null;
  }

  /** Returns true if field callStack is set (has been assigned a value) and false otherwise */
  public boolean isSetCallStack() {
    return this.callStack != null;
  }

  public void setCallStackIsSet(boolean value) {
    if (!value) {
      this.callStack = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getHappenDate() {
    return this.happenDate;
  }

  public BussinessException setHappenDate(@org.apache.thrift.annotation.Nullable java.lang.String happenDate) {
    this.happenDate = happenDate;
    return this;
  }

  public void unsetHappenDate() {
    this.happenDate = null;
  }

  /** Returns true if field happenDate is set (has been assigned a value) and false otherwise */
  public boolean isSetHappenDate() {
    return this.happenDate != null;
  }

  public void setHappenDateIsSet(boolean value) {
    if (!value) {
      this.happenDate = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case MESSAGE:
      if (value == null) {
        unsetMessage();
      } else {
        setMessage((java.lang.String)value);
      }
      break;

    case CALL_STACK:
      if (value == null) {
        unsetCallStack();
      } else {
        setCallStack((java.lang.String)value);
      }
      break;

    case HAPPEN_DATE:
      if (value == null) {
        unsetHappenDate();
      } else {
        setHappenDate((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case MESSAGE:
      return getMessage();

    case CALL_STACK:
      return getCallStack();

    case HAPPEN_DATE:
      return getHappenDate();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case MESSAGE:
      return isSetMessage();
    case CALL_STACK:
      return isSetCallStack();
    case HAPPEN_DATE:
      return isSetHappenDate();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof BussinessException)
      return this.equals((BussinessException)that);
    return false;
  }

  public boolean equals(BussinessException that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_message = true && this.isSetMessage();
    boolean that_present_message = true && that.isSetMessage();
    if (this_present_message || that_present_message) {
      if (!(this_present_message && that_present_message))
        return false;
      if (!this.message.equals(that.message))
        return false;
    }

    boolean this_present_callStack = true && this.isSetCallStack();
    boolean that_present_callStack = true && that.isSetCallStack();
    if (this_present_callStack || that_present_callStack) {
      if (!(this_present_callStack && that_present_callStack))
        return false;
      if (!this.callStack.equals(that.callStack))
        return false;
    }

    boolean this_present_happenDate = true && this.isSetHappenDate();
    boolean that_present_happenDate = true && that.isSetHappenDate();
    if (this_present_happenDate || that_present_happenDate) {
      if (!(this_present_happenDate && that_present_happenDate))
        return false;
      if (!this.happenDate.equals(that.happenDate))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetMessage()) ? 131071 : 524287);
    if (isSetMessage())
      hashCode = hashCode * 8191 + message.hashCode();

    hashCode = hashCode * 8191 + ((isSetCallStack()) ? 131071 : 524287);
    if (isSetCallStack())
      hashCode = hashCode * 8191 + callStack.hashCode();

    hashCode = hashCode * 8191 + ((isSetHappenDate()) ? 131071 : 524287);
    if (isSetHappenDate())
      hashCode = hashCode * 8191 + happenDate.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(BussinessException other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetMessage(), other.isSetMessage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.message, other.message);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetCallStack(), other.isSetCallStack());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCallStack()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.callStack, other.callStack);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetHappenDate(), other.isSetHappenDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHappenDate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.happenDate, other.happenDate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("BussinessException(");
    boolean first = true;

    if (isSetMessage()) {
      sb.append("message:");
      if (this.message == null) {
        sb.append("null");
      } else {
        sb.append(this.message);
      }
      first = false;
    }
    if (isSetCallStack()) {
      if (!first) sb.append(", ");
      sb.append("callStack:");
      if (this.callStack == null) {
        sb.append("null");
      } else {
        sb.append(this.callStack);
      }
      first = false;
    }
    if (isSetHappenDate()) {
      if (!first) sb.append(", ");
      sb.append("happenDate:");
      if (this.happenDate == null) {
        sb.append("null");
      } else {
        sb.append(this.happenDate);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BussinessExceptionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BussinessExceptionStandardScheme getScheme() {
      return new BussinessExceptionStandardScheme();
    }
  }

  private static class BussinessExceptionStandardScheme extends org.apache.thrift.scheme.StandardScheme<BussinessException> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BussinessException struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.message = iprot.readString();
              struct.setMessageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CALL_STACK
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.callStack = iprot.readString();
              struct.setCallStackIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // HAPPEN_DATE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.happenDate = iprot.readString();
              struct.setHappenDateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BussinessException struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.message != null) {
        if (struct.isSetMessage()) {
          oprot.writeFieldBegin(MESSAGE_FIELD_DESC);
          oprot.writeString(struct.message);
          oprot.writeFieldEnd();
        }
      }
      if (struct.callStack != null) {
        if (struct.isSetCallStack()) {
          oprot.writeFieldBegin(CALL_STACK_FIELD_DESC);
          oprot.writeString(struct.callStack);
          oprot.writeFieldEnd();
        }
      }
      if (struct.happenDate != null) {
        if (struct.isSetHappenDate()) {
          oprot.writeFieldBegin(HAPPEN_DATE_FIELD_DESC);
          oprot.writeString(struct.happenDate);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BussinessExceptionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BussinessExceptionTupleScheme getScheme() {
      return new BussinessExceptionTupleScheme();
    }
  }

  private static class BussinessExceptionTupleScheme extends org.apache.thrift.scheme.TupleScheme<BussinessException> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BussinessException struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetMessage()) {
        optionals.set(0);
      }
      if (struct.isSetCallStack()) {
        optionals.set(1);
      }
      if (struct.isSetHappenDate()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetMessage()) {
        oprot.writeString(struct.message);
      }
      if (struct.isSetCallStack()) {
        oprot.writeString(struct.callStack);
      }
      if (struct.isSetHappenDate()) {
        oprot.writeString(struct.happenDate);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BussinessException struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.message = iprot.readString();
        struct.setMessageIsSet(true);
      }
      if (incoming.get(1)) {
        struct.callStack = iprot.readString();
        struct.setCallStackIsSet(true);
      }
      if (incoming.get(2)) {
        struct.happenDate = iprot.readString();
        struct.setHappenDateIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
