/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.stockexchange.server.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Client {

    private String clientId;
    private String clientName;
    private String phone;
    private List<Action> actions = new ArrayList<>();

    public Client(String clientId, String clientName, String phone) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.phone = phone;
    }

    public void addAction(Action myAction) {
        actions.add(myAction);
    }

    public void deleteAction(Action myAction) {
        actions.remove(myAction);
    }
}
