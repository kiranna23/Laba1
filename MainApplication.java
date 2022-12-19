package bsu.rfe.java.group8.lab1.Kirilenko.C;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;
public class MainApplication 
{
	public static void main(String[] args) {

        Food[] breakfast = new Food[6];
        boolean sort_needed = false;
        boolean calories_needed = false;
        int count_breakfast = 0;
        for (int itemIndex = 0; itemIndex < args.length; itemIndex++) {
            if (args[itemIndex].equals("-calories")) {
               calories_needed = true;
            } else if(args[itemIndex].equals("-sort")) {
                sort_needed = true;
            } else{
                String[] parts = args[itemIndex].split("/");
                String[] param = new String[parts.length -1];
                for(int i = 0; i< parts.length-1; i++)
                {
                    param[i] = parts[i+1];
                }
                try {
                    Class myClass = Class.forName("bsu.rfe.java.group8.lab1.Kirilenko.C." + parts[0]);
                    breakfast[count_breakfast] = (Food) myClass.getConstructor(myClass.getConstructors()[0].getParameterTypes()).newInstance(param);
                    count_breakfast++;
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException  ex) {
                    System.out.print(ex);
                } catch (ClassNotFoundException ex) {
                    System.out.println("класс не найден");
                } catch(NoSuchMethodException ex){
                    System.out.println("методы не найдены");
                } 
            }
        }
		
            int count = 0;
            Food[] breakfast_diff = new Food[count_breakfast];
            for (int i = 0; i < count_breakfast; i++) {
                count = 1;
                boolean to_continue = false;
                for(int j = 0; j < count_breakfast; j++)
                {
                    if(breakfast_diff[j] == null) continue;
                    if(breakfast_diff[j].equals(breakfast[i])){
                        to_continue = true;
                    }
                }
                if(to_continue) continue;
                for (int j = i + 1; j < count_breakfast; j++) {
                    if ((breakfast[j].equals(breakfast[i]))) {
                        count++;
                    }
                }
                breakfast_diff[i] = breakfast[i];
                breakfast[i].consume();
            }
            if(calories_needed){
                int calorii = 0;
                for (int i = 0; i < count_breakfast; i++) calorii += breakfast[i].calculateCalories();
                System.out.println("Калорийность завтрака: " + calorii);
            }

            if(sort_needed){
                Arrays.sort(breakfast, new Comparator(){
                    public int compare(Object f1, Object f2){
                        if(f1==null) return 1;
                        if(f2==null) return -1;
                        if(((Food)f1).calculateCalories()==((Food)f2).calculateCalories()) return 0;
                        if(((Food)f1).calculateCalories()>((Food)f2).calculateCalories()) return -1;
                        return 1;
                    }
                });
            }
          for (int i = 0; i < breakfast.length; i++) {
          if (breakfast[i] == null) break;
          breakfast[i].consume();
      }
 
                System.out.println("Количестов блюд завтрака: " + count_breakfast);
                System.out.println("Всего хорошего!");
    }

}
