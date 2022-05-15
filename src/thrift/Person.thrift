namespace java thrift

typedef i16 short
typedef i32 int
typedef i64 long
typedef string String
typedef bool boolean

// ����һ��strcut���൱��һ����
struct Person{
    1: optional String name,
    2: optional int age
}

// �Զ����쳣
exception BussinessException{
    1: optional String message;
    2: optional String callStack;
    3: optional String happenDate;
}


// ����ӿ�
service PersonService{
  Person getgPerson(1: optional String name) throws (1:BussinessException bussinessException);

  void savePerson(1:optional String name,2:optional int age) throws (1:BussinessException bussinessException);
}