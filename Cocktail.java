package bsu.rfe.java.group8.lab1.Kirilenko.C;

public class Cocktail extends Food
{ 
	private String drink;
	private String fruit;


    public void consume() {
        System.out.println(this + " выпит");
    }



    public Cocktail(String drink, String fruit) {
        super("Коктель");
        this.drink = drink;
        this.fruit = fruit;
    }

    public String getDrink()
    {
        return drink;
    }

    public String getFruit()
    {
        return fruit;
    }

    public int calculateCalories() {
        int calories = 0;
        if (drink.equals("кола")) {
            calories += 20;
        } else if (drink.equals("фанта")) {
            calories += 30;
        }else if(drink.equals("спрайт")){
            calories+=40;
        }else { calories+= 15;}
        if (fruit.equals("банан")) {
            calories += 55;
        } else if (fruit.equals("клубника")) {
            calories += 43;
        }else if(fruit.equals("киви")){
            calories+=22;
        }else {
            calories+= 15;
        }
        return calories;
    }

    public boolean equals(Object arg0) {
    	if (super.equals(arg0)) 
    	{ 
    	if (!(arg0 instanceof Cocktail)) return false;
    	return (drink.equals(((Cocktail) arg0).drink) && (fruit.equals(((Cocktail) arg0).fruit)));
    	} else
    	return false;
    	}

    public String toString() {
        return super.toString() + " c '" + drink.toUpperCase() + "'" + " и '" + fruit.toUpperCase() + "'";
    }




}
