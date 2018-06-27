package Simulator;

import Aircrafts.AircraftFactory;
import Interfaces.IFlyable;
import Towers.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static WeatherTower weatherTower;
    private static List<IFlyable> flyableList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/william/Documents/projects/avaj-launcher/scenario.txt"));

            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();
                int simulation = Integer.parseInt(line.split(" ")[0]);
                if (simulation < 0) {
                    System.out.println("Simulation count cannot be 0 or less than 0");
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    String[] arr = line.split(" ");
                    if (arr.length == 5) {
                        IFlyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1], Integer.parseInt(line.split(" ")[2]),
                                Integer.parseInt(line.split(" ")[3]), Integer.parseInt(line.split(" ")[4]));
                        flyableList.add(flyable);
                    } else {
                        System.out.println("Invalid file format {Type Name Longitude Latitude Height}");
                    }
                }
                for (IFlyable flyable : flyableList) {
                    flyable.registerTower(weatherTower);

                }
                for (int i = 1; i <= simulation; i++) {
                    String simulationWrite = "Simulation: " + i;
//                    weatherTower.writeToFile("write", simulationWrite);
                    System.out.println(simulationWrite);
                    weatherTower.changeWeather();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception " + args[0]);
        } catch (IOException e) {
            System.out.println("There was an error while reading this file " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("File specification error");
        } catch (Exception e) {
            System.out.println("Unrecognised symbols in file" + e);
        }
    }
}
