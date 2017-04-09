package video;

import video.Entity.People;

import java.util.List;

import static video.dao.PeopleDao.getPeopleByMovieId;

/**
 * Created by Vinty on 09.04.2017.
 */
public class PeopleStarter {
    public static void main(String[] args) {
        List<People> people = getPeopleByMovieId(6L);
        people.stream().forEach(System.out::println);



    }


}
