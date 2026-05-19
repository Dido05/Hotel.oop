package bg.tu_varna.sit.f24621715.model;

import bg.tu_varna.sit.f24621715.comand.CommandConroller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Aplicattion {
    static void main(String[] args) throws IOException, ParseException {
        Scanner scanner=new Scanner(System.in);
        CommandConroller conroller=new CommandConroller();
        Reservation reservation=new Reservation();
//      reservation.addData();
//
//reservation.getRooms().get(107).reserve(new Date(),new Date(),4,"");
//        reservation.getRooms().get(107).reserve(new Date(),new Date(),5,"");
reservation.setFilepath("test.txt");
     while(true){
         String input=scanner.nextLine();
         if(input.equalsIgnoreCase("exit"))
         {
             break;
         }
         conroller.start(input,reservation);

     }
scanner.close();
    }

}
