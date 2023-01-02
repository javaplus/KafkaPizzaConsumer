
package com.barry.kafkaconsumer.entities;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * PizzaOrderEvent
 * <p>
 * Represents the event when a Pizza order is submitted
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "size",
    "cheese",
    "toppings"
})
public class PizzaOrderEvent {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("size")
    private String size;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("cheese")
    private String cheese;
    /**
     * Toppings for Pizza
     * (Required)
     * 
     */
    @JsonProperty("toppings")
    @JsonPropertyDescription("Toppings for Pizza")
    private List<Topping> toppings = new ArrayList<Topping>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PizzaOrderEvent() {
    }

    /**
     * 
     * @param size
     * @param toppings
     * @param cheese
     */
    public PizzaOrderEvent(String size, String cheese, List<Topping> toppings) {
        super();
        this.size = size;
        this.cheese = cheese;
        this.toppings = toppings;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("cheese")
    public String getCheese() {
        return cheese;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("cheese")
    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    /**
     * Toppings for Pizza
     * (Required)
     * 
     */
    @JsonProperty("toppings")
    public List<Topping> getToppings() {
        return toppings;
    }

    /**
     * Toppings for Pizza
     * (Required)
     * 
     */
    @JsonProperty("toppings")
    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PizzaOrderEvent.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("size");
        sb.append('=');
        sb.append(((this.size == null)?"<null>":this.size));
        sb.append(',');
        sb.append("cheese");
        sb.append('=');
        sb.append(((this.cheese == null)?"<null>":this.cheese));
        sb.append(',');
        sb.append("toppings");
        sb.append('=');
        sb.append(((this.toppings == null)?"<null>":this.toppings));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.toppings == null)? 0 :this.toppings.hashCode()));
        result = ((result* 31)+((this.size == null)? 0 :this.size.hashCode()));
        result = ((result* 31)+((this.cheese == null)? 0 :this.cheese.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PizzaOrderEvent) == false) {
            return false;
        }
        PizzaOrderEvent rhs = ((PizzaOrderEvent) other);
        return ((((this.toppings == rhs.toppings)||((this.toppings!= null)&&this.toppings.equals(rhs.toppings)))&&((this.size == rhs.size)||((this.size!= null)&&this.size.equals(rhs.size))))&&((this.cheese == rhs.cheese)||((this.cheese!= null)&&this.cheese.equals(rhs.cheese))));
    }

}
