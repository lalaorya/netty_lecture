namespace java thrift

typedef i16 short
typedef i32 int
typedef i64 long
typedef string String
typedef bool boolean

// 定义一个strcut，相当于一个类
struct Person{
    1: optional String name,
    2: optional int age
}

// 自定义异常
exception BussinessException{
    1: optional String message;
    2: optional String callStack;
    3: optional String happenDate;
}


// 定义接口
service PersonService{
  Person getgPerson(1: optional String name) throws (1:BussinessException bussinessException);

  void savePerson(1:optional String name,2:optional int age) throws (1:BussinessException bussinessException);
}