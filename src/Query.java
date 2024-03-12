public class Query {
    static String insert = "insert into students(id, fname, lname, email) values(?,?,?,?)";
    static String select = "select * from students";
    static String update = "update students set fname =? where id =?";
    static String delete = "delete from students where id =?";
}
