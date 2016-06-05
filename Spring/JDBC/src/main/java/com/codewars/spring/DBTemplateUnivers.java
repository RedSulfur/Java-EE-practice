package com.codewars.spring;

/**
 * Created by sulfur on 18.02.16.
 */

import com.codewars.spring.model.Employee;
import com.codewars.spring.model.Eventplan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class DBTemplateUnivers {

    public static final Logger log = LoggerFactory.getLogger(DBTemplateUnivers.class);

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

//        DataSource dataSource = context.getBean("dataSource", DataSource.class);
//        log.info("dataSource class: {}", dataSource.getClass().getCanonicalName());
//
//        Connection connection = dataSource.getConnection();
//        log.info("connection class: {}", connection.getClass().getCanonicalName());
//        //.......
//
//        connection.close();
//
//        connection = dataSource.getConnection();
//        log.info("connection class2: {}", connection.getClass().getCanonicalName());
//        //.......
//
//        connection.close();

        JdbcTemplate jdbc = context.getBean("jdbcTemplate", JdbcTemplate.class);

//        queryForSimpleObject(jdbc);
//        queryForComplexObject(jdbc);
//        insertNewEmployee(jdbc);
//        queryForListComplexObjects(jdbc);
//        batchUpdate(jdbc);
//        insertConstructor(jdbc);
//        manyToOne(jdbc);
        oneToManyMultipleQueries(jdbc);


    }

    public static void separator(String title) {
        log.debug("\r\n\r\n\r\n\r\n");
        log.debug("================={}=================",title);
        log.debug("");
    }

   public static void queryForSimpleObject(JdbcTemplate jdbc) {
        separator("queryForSimpleObject");


        int countOfEmployees = jdbc.queryForObject("select count(*) from employee where empname = ?", new String[]{"Chuck Coordinator"}, Integer.class);
        log.debug("Number of employees: {}", countOfEmployees);

        String empPhone = jdbc.queryForObject("select phone from employee where empname = ?", new String[]{"Chuck Coordinator"}, String.class);
        log.debug("Employee's phone: {}", empPhone);

    }


    private static void queryForComplexObject(JdbcTemplate jdbc) {
        separator("queryForComplexObject");

        Employee employee = jdbc.queryForObject("select employee.empno, employee.empname from employee where department = ?", new String[]{"Football"}, new EmployeeMapper());
        log.debug("Employee:  {}", employee);
    }

    static class EmployeeMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Employee(resultSet.getInt("empno"), resultSet.getString("empname"));
        }
    }


    private static void insertNewEmployee(JdbcTemplate jdbc) {
        separator("insertNewRegion");
        // не задается поле ключа
        // keyHolder????
        PreparedStatementCreatorFactory creatorFactory =
                new PreparedStatementCreatorFactory("insert into employee(empname,department,email,phone) values (?,?,?,?)");
//        идентификатором (ключом) вставляемой записи будет колонка region_id
//        creatorFactory.setGeneratedKeysColumnNames("planno");
//        у нашего запроса будет параметр
        creatorFactory.setGeneratedKeysColumnNames("empno");

        creatorFactory.addParameter(new SqlParameter(Types.VARCHAR));
        creatorFactory.addParameter(new SqlParameter(Types.VARCHAR));
        creatorFactory.addParameter(new SqlParameter(Types.VARCHAR));
        creatorFactory.addParameter(new SqlParameter(Types.VARCHAR));

//        Date dateRepresentation = new Date(2013-1900,01,17);
        PreparedStatementCreator preparedStatementCreator =
                creatorFactory.newPreparedStatementCreator(new Object[]{"Paul Dirac","Theoretical Physics", "h/2@gmail.com","3-1298"});
//        получаем обратный идентификатор
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int insertCount = jdbc.update(preparedStatementCreator, keyHolder);

        log.debug("Insert count: {}", insertCount);
        log.debug("New employee's id: {}", keyHolder.getKey().longValue());
    }


    private static void queryForListComplexObjects(JdbcTemplate jdbc) {
        separator("queryForListComplexObjects");
        List<Employee> list = jdbc.query("SELECT employee.empno, employee.empname FROM employee",
                new RowMapper<Employee>() {
                    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Employee employee = new Employee();
                        employee.setEmpno(rs.getInt("empno"));
                        employee.setEmpname(rs.getString("empname"));
                        return employee;
                    }
                });
        for (Employee employee : list) {
            log.debug("Employee: Number: {}, Name: {}", employee.getEmpno(), employee.getEmpname());
        }
    }


    private static void batchUpdate(JdbcTemplate jdbc) {
        separator("batchUpdate");
        final List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(106,"desc1"));
        employees.add(new Employee(107,"desc2"));
        employees.add(new Employee(108,"desc3"));
        employees.add(new Employee(109,"desc4"));

        int[] ints = jdbc.batchUpdate("insert into employee (empname,department,email,phone) values (?,?,?,?)", new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {

                preparedStatement.setString(1, employees.get(i).getEmpname());
                preparedStatement.setString(2,  "Electronics");
                preparedStatement.setString(3, "Placeholder");
                preparedStatement.setString(4, "0000");
            }

            @Override
            public int getBatchSize() {
                return employees.size();
            }
        });

        for (int i : ints) {
            log.debug("Inserted: {} records", i);
        }
    }

    /*private static void batchUpdate(JdbcTemplate jdbc) {
        separator("batchUpdate");
        final List<Eventplan> eventplans = new ArrayList<Eventplan>();
        eventplans.add(new Eventplan(110,"desc1",null));
        eventplans.add(new Eventplan(111,"desc2",null));
        eventplans.add(new Eventplan(112,"desc3",null));
        eventplans.add(new Eventplan(113,"desc4",null));

        *//*
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1990);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, 4); // Assuming you wanted May 1st

        final java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
        *//*


        *//*
        String dateString = String.format("%d-%02d-%02d", 1993-1900, 01, 18);

        final java.sql.Date date = java.sql.Date.valueOf(dateString);
        *//*

        final Date date = new Date(2013-1900,01,17);

        int[] ints = jdbc.batchUpdate("insert into eventplan (planno, eventno, workdate, notes, activity, empno) values (?,?,?,?,?,?)", new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    preparedStatement.setInt(1, eventplans.get(i).getPlanno());
                    preparedStatement.setInt(2, i);
                    preparedStatement.setDate(3, date);
                    preparedStatement.setString(4, eventplans.get(i).getNotes());
                    preparedStatement.setString(5, "Placeholder");
                    preparedStatement.setInt(6, i);
            }

            @Override
            public int getBatchSize() {
                return eventplans.size();
            }
        });

        for (int i : ints) {
            log.debug("Inserted: {} records", i);
        }
    }*/

    private static void insertConstructor(JdbcTemplate jdbc) {
        separator("insertConstructor");
//        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbc).withSchemaName("public").withTableName("employee").usingGeneratedKeyColumns("empno");
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbc).withSchemaName("public").withTableName("employee").usingGeneratedKeyColumns("empno");

//        USAGE????
        Map<String,Object> parameters = new HashMap<String, Object>();

        parameters.put("empname", "John Doe");
        parameters.put("department", "Undefined");
        parameters.put("email", "corpse@gmail.com");
        parameters.put("phone", "1-3333");

        insert.execute(parameters);


    /*    Number number = insertActor.executeAndReturnKey(parameters);
        log.debug("Inserted employee number: {}", number.longValue());
    */
    }


    private static void manyToOne(JdbcTemplate jdbc) {
        separator("manyToOne");

        List<Eventplan> eventplans = jdbc.query("SELECT employee.empno as resEmpno,empname as resEmpname,planno as resPlanno,notes as resNotes FROM eventplan INNER JOIN employee ON eventplan.empno = employee.empno;", new RowMapper<Eventplan>() {
            @Override
            public Eventplan mapRow(ResultSet rs, int i) throws SQLException {
                Employee employee = new Employee(rs.getInt("resEmpno"), rs.getString("resEmpname"));
                Eventplan eventplan = new Eventplan(rs.getInt("resPlanno"), rs.getString("resNotes"), employee);
                return eventplan;
            }
        });

        for (Eventplan eventplan : eventplans) {
            log.debug("Eventplan: {}, employee: {}", eventplan, eventplan.getEmployee());
        }
    }

    private static void oneToManyMultipleQueries(JdbcTemplate jdbc) {
        separator("oneToManyMultipleQueries");

        List<Employee> employeeList = jdbc.query("select employee.empno,employee.empname from employee", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int i) throws SQLException {
                return new Employee(rs.getInt("empno"), rs.getString("empname"));
            }
        });
        for (final Employee employee : employeeList) {
            List<Eventplan> eventplanList = jdbc.query("select eventplan.planno, eventplan.notes" +
                    " from eventplan where empno = ?", new Integer[]{employee.getEmpno()}, new RowMapper<Eventplan>() {
                @Override
                public Eventplan mapRow(ResultSet rs, int i) throws SQLException {
                    return new Eventplan(rs.getInt("planno"), rs.getString("notes"), employee);
                }
            });
            employee.setEventplans(eventplanList);
        }

        for (Employee employee : employeeList) {
            log.debug("Employee: {}", employee);
        }
    }

}
