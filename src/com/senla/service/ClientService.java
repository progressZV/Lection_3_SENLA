package com.senla.service;

import com.senla.dao.*;
import com.senla.entity.Client;
import com.senla.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
      private IClientDao clientService = new FileClientDao(new FileStreamWriter("Clients.txt"), new FileStreamReader("Clients.txt"), new Parser());
      private IRoomDao roomDao= new FileRoomDao(new FileStreamWriter("Rooms.txt"), new FileStreamReader("Rooms.txt"), new Parser());

    public boolean addClient(Integer roomId, Client client) {
        List<Room> rooms = roomDao.getRooms();
        var room = rooms.stream().filter(r -> r.getNumber() == roomId).findFirst().orElse(null);
        if (room == null) {
            System.out.println("Can't find the room.");
            return false;
        }

        if (room.getFreeStatus() && !room.getFixStatus()) {
            clientService.saveClient(client);
            room.setFreeStatus(false);
            System.out.println("Клиент " + client.getName() + " успешно заслелён в комнату №" + room.getNumber());
            return true;
        }
            System.out.println("Номер занят или не существует." + "\n");
        return false;
    }

    public boolean removeClient(String name, Integer roomID) {

        List<Room> rooms = roomDao.getRooms();
        var room = rooms.stream().filter(r -> r.getNumber() == roomID).findFirst().orElse(null);
        if (room == null) {
            System.out.println("Can't find the room.");
            return false;
        }

        List<Client> clients = clientService.getClients();
        Client client = clients.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);

        if(client == null){
            System.out.println("Can't find a client.");
            return false;
        }
        if(client.getAppsNumber() != room.getNumber()){
            System.out.println("Клиент не поселён в данном номере.");
            return false;
        }

        clients.remove(client);
        room.setFreeStatus(true);

        StringBuilder sb = new StringBuilder();
        for (Client client1 : clients) {
            sb.append(client1.convertToString());
        }

        clientService.removeClient(sb.toString());
        System.out.println("Client " + client.getName() + " was removed from room №" + client.getAppsNumber());
        return true;
    }

    public List<Client> getClients(){
        List<Client> clients = clientService.getClients();
        for(Client client : clients){
            System.out.println(client.convertToString());
        }
        return clients;
    }
}


