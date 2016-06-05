package com.codewars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sulfur on 12.03.16.
 */

@Stateless
public class ActorEJB implements ActorEJBLocal,ActorEJBRemote {

    public Statement statement;
    public Connection connection;
    public ResultSet set;
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/DB-java-ee";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private final String query = "select * from films.actors";

    public static final Logger log = LoggerFactory.getLogger(ActorEJB.class);


    @Override
    public List<Actor> getActors() {

        log.trace("Inside EJB's getActors");
        List<Actor>actors = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            while(set.next()) {
                //Retrieve by column name
                Long id = set.getLong("actor_id");
                String name = set.getString("actor_name");
                actors.add(new Actor(id,name));
            }

            //out.println("</body></html>");
            set.close();
            statement.close();
            connection.close();

        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        log.debug("Returned actors: {}", actors);

        log.trace("getActors return");
        return actors;
    }
}
