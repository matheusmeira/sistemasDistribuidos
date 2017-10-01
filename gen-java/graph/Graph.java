/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package graph;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-10-01")
public class Graph implements org.apache.thrift.TBase<Graph, Graph._Fields>, java.io.Serializable, Cloneable, Comparable<Graph> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Graph");

  private static final org.apache.thrift.protocol.TField V_FIELD_DESC = new org.apache.thrift.protocol.TField("v", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField A_FIELD_DESC = new org.apache.thrift.protocol.TField("a", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new GraphStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new GraphTupleSchemeFactory();

  public java.util.List<Vertex> v; // required
  public java.util.List<Edge> a; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    V((short)1, "v"),
    A((short)2, "a");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // V
          return V;
        case 2: // A
          return A;
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.V, new org.apache.thrift.meta_data.FieldMetaData("v", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Vertex.class))));
    tmpMap.put(_Fields.A, new org.apache.thrift.meta_data.FieldMetaData("a", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Edge.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Graph.class, metaDataMap);
  }

  public Graph() {
  }

  public Graph(
    java.util.List<Vertex> v,
    java.util.List<Edge> a)
  {
    this();
    this.v = v;
    this.a = a;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Graph(Graph other) {
    if (other.isSetV()) {
      java.util.List<Vertex> __this__v = new java.util.ArrayList<Vertex>(other.v.size());
      for (Vertex other_element : other.v) {
        __this__v.add(new Vertex(other_element));
      }
      this.v = __this__v;
    }
    if (other.isSetA()) {
      java.util.List<Edge> __this__a = new java.util.ArrayList<Edge>(other.a.size());
      for (Edge other_element : other.a) {
        __this__a.add(new Edge(other_element));
      }
      this.a = __this__a;
    }
  }

  public Graph deepCopy() {
    return new Graph(this);
  }

  @Override
  public void clear() {
    this.v = null;
    this.a = null;
  }

  public int getVSize() {
    return (this.v == null) ? 0 : this.v.size();
  }

  public java.util.Iterator<Vertex> getVIterator() {
    return (this.v == null) ? null : this.v.iterator();
  }

  public void addToV(Vertex elem) {
    if (this.v == null) {
      this.v = new java.util.ArrayList<Vertex>();
    }
    this.v.add(elem);
  }

  public java.util.List<Vertex> getV() {
    return this.v;
  }

  public Graph setV(java.util.List<Vertex> v) {
    this.v = v;
    return this;
  }

  public void unsetV() {
    this.v = null;
  }

  /** Returns true if field v is set (has been assigned a value) and false otherwise */
  public boolean isSetV() {
    return this.v != null;
  }

  public void setVIsSet(boolean value) {
    if (!value) {
      this.v = null;
    }
  }

  public int getASize() {
    return (this.a == null) ? 0 : this.a.size();
  }

  public java.util.Iterator<Edge> getAIterator() {
    return (this.a == null) ? null : this.a.iterator();
  }

  public void addToA(Edge elem) {
    if (this.a == null) {
      this.a = new java.util.ArrayList<Edge>();
    }
    this.a.add(elem);
  }

  public java.util.List<Edge> getA() {
    return this.a;
  }

  public Graph setA(java.util.List<Edge> a) {
    this.a = a;
    return this;
  }

  public void unsetA() {
    this.a = null;
  }

  /** Returns true if field a is set (has been assigned a value) and false otherwise */
  public boolean isSetA() {
    return this.a != null;
  }

  public void setAIsSet(boolean value) {
    if (!value) {
      this.a = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case V:
      if (value == null) {
        unsetV();
      } else {
        setV((java.util.List<Vertex>)value);
      }
      break;

    case A:
      if (value == null) {
        unsetA();
      } else {
        setA((java.util.List<Edge>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case V:
      return getV();

    case A:
      return getA();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case V:
      return isSetV();
    case A:
      return isSetA();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Graph)
      return this.equals((Graph)that);
    return false;
  }

  public boolean equals(Graph that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_v = true && this.isSetV();
    boolean that_present_v = true && that.isSetV();
    if (this_present_v || that_present_v) {
      if (!(this_present_v && that_present_v))
        return false;
      if (!this.v.equals(that.v))
        return false;
    }

    boolean this_present_a = true && this.isSetA();
    boolean that_present_a = true && that.isSetA();
    if (this_present_a || that_present_a) {
      if (!(this_present_a && that_present_a))
        return false;
      if (!this.a.equals(that.a))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetV()) ? 131071 : 524287);
    if (isSetV())
      hashCode = hashCode * 8191 + v.hashCode();

    hashCode = hashCode * 8191 + ((isSetA()) ? 131071 : 524287);
    if (isSetA())
      hashCode = hashCode * 8191 + a.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(Graph other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetV()).compareTo(other.isSetV());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetV()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.v, other.v);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetA()).compareTo(other.isSetA());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetA()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.a, other.a);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Graph(");
    boolean first = true;

    sb.append("v:");
    if (this.v == null) {
      sb.append("null");
    } else {
      sb.append(this.v);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("a:");
    if (this.a == null) {
      sb.append("null");
    } else {
      sb.append(this.a);
    }
    first = false;
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

  private static class GraphStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public GraphStandardScheme getScheme() {
      return new GraphStandardScheme();
    }
  }

  private static class GraphStandardScheme extends org.apache.thrift.scheme.StandardScheme<Graph> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Graph struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // V
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.v = new java.util.ArrayList<Vertex>(_list0.size);
                Vertex _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new Vertex();
                  _elem1.read(iprot);
                  struct.v.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setVIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // A
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list3 = iprot.readListBegin();
                struct.a = new java.util.ArrayList<Edge>(_list3.size);
                Edge _elem4;
                for (int _i5 = 0; _i5 < _list3.size; ++_i5)
                {
                  _elem4 = new Edge();
                  _elem4.read(iprot);
                  struct.a.add(_elem4);
                }
                iprot.readListEnd();
              }
              struct.setAIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Graph struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.v != null) {
        oprot.writeFieldBegin(V_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.v.size()));
          for (Vertex _iter6 : struct.v)
          {
            _iter6.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.a != null) {
        oprot.writeFieldBegin(A_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.a.size()));
          for (Edge _iter7 : struct.a)
          {
            _iter7.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class GraphTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public GraphTupleScheme getScheme() {
      return new GraphTupleScheme();
    }
  }

  private static class GraphTupleScheme extends org.apache.thrift.scheme.TupleScheme<Graph> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Graph struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetV()) {
        optionals.set(0);
      }
      if (struct.isSetA()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetV()) {
        {
          oprot.writeI32(struct.v.size());
          for (Vertex _iter8 : struct.v)
          {
            _iter8.write(oprot);
          }
        }
      }
      if (struct.isSetA()) {
        {
          oprot.writeI32(struct.a.size());
          for (Edge _iter9 : struct.a)
          {
            _iter9.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Graph struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list10 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.v = new java.util.ArrayList<Vertex>(_list10.size);
          Vertex _elem11;
          for (int _i12 = 0; _i12 < _list10.size; ++_i12)
          {
            _elem11 = new Vertex();
            _elem11.read(iprot);
            struct.v.add(_elem11);
          }
        }
        struct.setVIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list13 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.a = new java.util.ArrayList<Edge>(_list13.size);
          Edge _elem14;
          for (int _i15 = 0; _i15 < _list13.size; ++_i15)
          {
            _elem14 = new Edge();
            _elem14.read(iprot);
            struct.a.add(_elem14);
          }
        }
        struct.setAIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

