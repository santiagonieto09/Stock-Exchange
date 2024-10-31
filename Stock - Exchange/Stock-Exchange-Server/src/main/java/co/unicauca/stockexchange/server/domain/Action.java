/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.stockexchange.server.domain;

import lombok.Data;

@Data
public class Action {

    private String actionId;
    private String actionName;
    private double previusPrice;
    private double currentPrice;
    private double lowerThreshold;
    private double upperThreshold;

    public Action(String actionId, String actionName, double previusPrice, double currentPrice) {
        this.actionId = actionId;
        this.actionName = actionName;
        this.previusPrice = previusPrice;
        this.currentPrice = currentPrice;
        this.lowerThreshold = 0.0;
        this.upperThreshold = 0.0;
    }
    public Action(Action original) {
        this.actionId = original.actionId;
        this.actionName = original.actionName;
        this.previusPrice = original.previusPrice;
        this.currentPrice = original.currentPrice;
        this.lowerThreshold = original.lowerThreshold;
        this.upperThreshold = original.upperThreshold;
    }
}
