package protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @Author virtual
 * @Date 2022/4/26 17:42
 * @description：
 */
public class Test {
    public static void main(String[] args) {

        StudentBook.Book book = StudentBook.Book.newBuilder().addStudent(0, StudentBook.Student.newBuilder().setName("张三").setAge(18).setId(123).build())
                .addStudent(1, StudentBook.Student.newBuilder().setName("李四").setAge(19).setId(456).build())
                .addStudent(2, StudentBook.Student.newBuilder().setName("王五").setAge(20).setId(789).build())
                .build();

        byte[] bytes = book.toByteArray();
        StudentBook.Book book2 = null;
        try {
            book2 = StudentBook.Book.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        System.out.println(book.toString());
        System.out.println(book.getStudentList().toString());

        System.out.println(book2.toString());
        System.out.println(book2.getStudentList().toString());


    }
}
