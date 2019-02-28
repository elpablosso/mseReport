package airplanes.airplanescity;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Airplanes {

    public Airplane getAirplaneByIdNumber(int id){
        return airplanes.get(id-1);
    }

    List<Airplane> airplanes = Arrays.asList(
            new Airplane(1),
            new Airplane(2),
            new Airplane(3),
            new Airplane(4));

    class Airplane implements Runnable {

        public Airplane(int id) {
            this.id = id;
            this.locationX=0;
            this.locationY=0;
            this.isFlying=false;
        }

        private int id;

        /// LOCATION OF THE AIRPLANE ///
        private int locationX;
        private int locationY;

        /// STATUS OF THE AIRPLANE ///
        private boolean isFlying;
        private String targetCity;
        private String flyingFrom;

        /// FUEL STATUS ///

        public void flyToLocation(Cities.City city){
            isFlying=true;
            double stepX = getDeltaXDividedBy10(city);
            double stepY = getDeltaYDividedBy10(city);
            while(locationX!=city.getLocationX() && locationY!=city.getLocationY()){
                locationX+=stepX;
                locationY+=stepY;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("Airplane %d is flying...",id);
            }
            city.getFlyingOrder().add(this);
            isFlying=false;
        }

        public int getDeltaXDividedBy10(Cities.City city){
            return locationX > city.getLocationX() ? (locationX-city.getLocationX())/10 : (city.getLocationX()-locationX)/10;
        }
        public int getDeltaYDividedBy10(Cities.City city){
            return locationX > city.getLocationX() ? (locationX-city.getLocationX())/10 : (city.getLocationX()-locationX)/10;
        }

        public void printLocationInfo(){
            System.out.printf("Airplane location X:&d , Y:%d", getLocationX(), getLocationY());
        }

        @Override
        public void run() {

        }

        public int getLocationX() {
            return locationX;
        }

        public int getLocationY() {
            return locationY;
        }
    }
}
