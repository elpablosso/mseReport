package airplanes.airplanescity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

@Component
public class Cities {

    List<City> cities = Arrays.asList(
            new City(100,100,"Krakow",1),
            new City(300,300,"Warsaw",2),
            new City(800,800,"Berlin",3),
            new City(1400,1400,"London",4)
    );

    public class City {

        /// LOCATION OF THE CITY ///
        private int locationX;
        private int locationY;

        /// INFORMATION ABOUT CITY ///
        private String name;
        private int id;

        /// TANKING SERVICE ///
        private ArrayBlockingQueue tankingQueue;
        private ExecutorService tankingService = Executors.newFixedThreadPool(1);
        /// POSSIBLY TO SEND INTO OTHER CLASS RESPONSIBILITY

        /// FLYING ORDER ///
        private ArrayBlockingQueue flyingOrder;
        /// DO I NEED THIS ??


        public City(int locationX, int locationY, String name, int id) {
            this.id=id;
            this.locationX = locationX;
            this.locationY = locationY;
            this.name = name;
            this.tankingQueue = new ArrayBlockingQueue<Airplanes.Airplane>(10);
            this.flyingOrder = new ArrayBlockingQueue<Airplanes.Airplane>(10);
        }

        public BlockingQueue<Airplanes.Airplane> getTankingQueue() {
            return tankingQueue;
        }

        public BlockingQueue<Airplanes.Airplane> getFlyingOrder() {
            return flyingOrder;
        }

        public int getLocationX() {
            return locationX;
        }

        public int getLocationY() {
            return locationY;
        }
    }
}
